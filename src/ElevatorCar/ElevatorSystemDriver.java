package ElevatorCar;

public class ElevatorSystemDriver {
    public static void execute() {
        ElevatorController controller = new ElevatorController(3);

        controller.requestElevator(2, 7);
        controller.requestElevator(1, 5);
        controller.requestElevator(6, 2);
        controller.requestElevator(1, 7);
    }
}
