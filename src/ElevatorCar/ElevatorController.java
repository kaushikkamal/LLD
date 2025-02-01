package ElevatorCar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorController {
    private final List<Elevator> elevatorList;
    private Queue<Request> pendingRequests;

    public ElevatorController(int numElevators) {
        elevatorList = new ArrayList<>();
        pendingRequests = new LinkedList<>();

        for (int i = 1; i <= numElevators; i++) {
            Elevator elevator = new Elevator(i);
            elevatorList.add(elevator);
            new Thread(() -> {
                System.out.printf("Elevation with id %s is initialized.\n", elevator.getId());
                processRequests();
            }).start();
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor) {
        addRequest(new Request(sourceFloor, destinationFloor));
    }

    private synchronized void addRequest(Request request) {
        pendingRequests.offer(request);
        notifyAll();
    }

    private synchronized Request getNextRequest() {
        while (pendingRequests.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return pendingRequests.poll();
    }

    private synchronized void processRequests() {
        while (true) {
            while (!pendingRequests.isEmpty()) {
                Request request = getNextRequest();
                processRequest(request);
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void processRequest(Request request) {
        int startFloor = request.getSourceFloor();
        int endFloor = request.getDestinationFloor();

        Elevator optimalElevator = findOptimalElevator(startFloor, endFloor);
        startFloor = optimalElevator.getCurrentFloor();

        if (startFloor < endFloor) {
            optimalElevator.setCurrentDirection(Direction.UP);
            for (int i = startFloor; i <= endFloor; i++) {
                optimalElevator.setCurrentFloor(i);

                try {
                    optimalElevator.move(endFloor);
                    Thread.sleep(1000); // Simulating elevator movement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (startFloor > endFloor) {
            optimalElevator.setCurrentDirection(Direction.DOWN);
            for (int i = startFloor; i >= endFloor; i--) {
                optimalElevator.setCurrentFloor(i);

                try {
                    optimalElevator.move(endFloor);
                    Thread.sleep(1000); // Simulating elevator movement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public void run() {
//        processRequests();
//    }


    private Elevator findOptimalElevator(int sourceFloor, int destinationFloor) {
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevatorList) {
            if (elevator.getStatus() == Status.UNDER_MAINTENANCE) {
                continue;
            }
            int distance = Math.abs(sourceFloor - elevator.getCurrentFloor());
            if (distance < minDistance) {
                minDistance = distance;
                optimalElevator = elevator;
            }
        }

        return optimalElevator;
    }
}
