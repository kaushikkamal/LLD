package ElevatorSystem;

public class ElevatorDrive {
    public static void execute() {
        ElevatorController controller = new ElevatorController(3); // 3 elevators
        controller.requestElevator(6, Direction.UP);
        controller.requestElevator(4, Direction.UP);
        controller.requestElevator(7, Direction.DOWN);
        controller.requestElevator(8, Direction.DOWN);
        controller.requestElevator(2, Direction.UP);

        // Simulate some delay for demonstration
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        controller.shutdown();
    }
}
