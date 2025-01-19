package ElevatorSystem;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator implements Runnable {
    private int id;
    private int currentFloor;
    private Direction direction;
    private PriorityQueue<Integer> upRequest;
    private PriorityQueue<Integer> downRequest;
    private Queue<Integer> pendingRequest;
    private boolean active;
    private final Object lock = new Object();

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0; // Start at ground floor
        this.direction = Direction.IDLE;
//        this.upRequest = new PriorityQueue<>((a, b) -> {
//            if (direction == Direction.UP) return a - b;
//            else return b - a;
//        });

        this.upRequest = new PriorityQueue<>();
        this.downRequest = new PriorityQueue<>((a, b) -> b - a);
        this.pendingRequest = new LinkedList<>();
        this.active = true;
    }

    public void addTask(int floor, Direction direction) {
        synchronized (lock) {
//            tasks.offer(floor);

            if (direction == Direction.UP) {
                if (floor > this.currentFloor && direction == this.direction) {
                    upRequest.offer(floor);
                } else {
                    pendingRequest.offer(floor);
                }
            } else {
                if (floor > this.currentFloor && direction == this.direction) {
                    downRequest.offer(floor);
                } else {
                    pendingRequest.offer(floor);
                }
            }

            lock.notify(); // Notify the elevator thread about new tasks
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isIdle() {
        return upRequest.isEmpty() && downRequest.isEmpty() && pendingRequest.isEmpty();
    }

    @Override
    public void run() {
        while (active) {
            synchronized (lock) {
                while (upRequest.isEmpty() && downRequest.isEmpty() && pendingRequest.isEmpty()) {
                    try {
                        lock.wait(); // Wait for new tasks
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
            processTasks();
        }
    }

    private void processTasks() {
        if (upRequest.size() >= downRequest.size()) {
            // up requests
            while (!upRequest.isEmpty()) {
                Integer targetFloor = upRequest.poll();
                if (targetFloor == null) continue;
                moveToFloor(targetFloor);
            }

            while (!pendingRequest.isEmpty()) {
                upRequest.offer(pendingRequest.poll());
            }

            this.direction = Direction.DOWN;

            // down requests
            while (!downRequest.isEmpty()) {
                Integer targetFloor = downRequest.poll();
                if (targetFloor == null) continue;
                moveToFloor(targetFloor);
            }

            while (!pendingRequest.isEmpty()) {
                downRequest.offer(pendingRequest.poll());
            }

            this.direction = Direction.UP;


        } else {
            // down requests
            while (!downRequest.isEmpty()) {
                Integer targetFloor = downRequest.poll();
                if (targetFloor == null) continue;
                moveToFloor(targetFloor);
            }

            while (!pendingRequest.isEmpty()) {
                downRequest.offer(pendingRequest.poll());
            }

            this.direction = Direction.UP;

            // up requests
            while (!upRequest.isEmpty()) {
                Integer targetFloor = upRequest.poll();
                if (targetFloor == null) continue;
                moveToFloor(targetFloor);
            }

            while (!pendingRequest.isEmpty()) {
                upRequest.offer(pendingRequest.poll());
            }

            this.direction = Direction.DOWN;
        }

        this.direction = Direction.IDLE; // Set to IDLE when all tasks are done
    }

    private void moveToFloor(int targetFloor) {
        System.out.println("Elevator " + id + " moving from floor " + currentFloor + " to floor " + targetFloor);
        try {
            Thread.sleep(Math.abs(targetFloor - currentFloor) * 1000); // Simulate time taken to move
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        currentFloor = targetFloor;
        System.out.println("Elevator " + id + " arrived at floor " + targetFloor);
    }

    public void shutdown() {
        active = false;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "id=" + id +
                ", currentFloor=" + currentFloor +
                ", direction=" + direction +
                '}';
    }
}
