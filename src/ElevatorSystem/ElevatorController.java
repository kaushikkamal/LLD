package ElevatorSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorController {
    private List<Elevator> elevators;
    private ExecutorService executor;

    public ElevatorController(int numElevators) {
        elevators = new ArrayList<>();
        executor = Executors.newFixedThreadPool(numElevators);
        for (int i = 0; i < numElevators; i++) {
            Elevator elevator = new Elevator(i + 1);
            elevators.add(elevator);
            executor.submit(elevator);
        }
    }

    public void requestElevator(int floor, Direction direction) {
        Elevator bestElevator = findBestElevator(floor, direction);

        if (bestElevator != null) {
            System.out.println("Floor: " + floor);
            System.out.println(bestElevator.toString());
            bestElevator.addTask(floor, direction);
        } else {
            System.out.println("No elevators available for the request to floor " + floor);
        }
    }

    private Elevator findBestElevator(int floor, Direction direction) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
//            if (elevator.isIdle() || elevator.getDirection() == direction) {
            if (elevator.isIdle() || elevator.getDirection() == direction) {
                int distance = Math.abs(elevator.getCurrentFloor() - floor);
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }
        return bestElevator;
    }

    public void shutdown() {
        for (Elevator elevator : elevators) {
            elevator.shutdown();
        }
        executor.shutdown();
    }
}
