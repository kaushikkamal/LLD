package ElevatorCar;

import ElevatorCar.Button.Button;
import ElevatorCar.Button.InternalButton;

public class Elevator {
    private final int id;
    private int currentFloor;
    private Direction currentDirection;
    private Status status;
    private Button internalButton;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.currentDirection = Direction.UP;
        this.status = Status.IDLE;
        internalButton = new InternalButton();
    }

    public void move(int destinationFloor) {
        this.setStatus(Status.MOVING);
        System.out.printf("Elevator with id %s is moving %s from Floor: %s -> %s\n", this.id, currentDirection, currentFloor, destinationFloor);
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public Status getStatus() {
        return status;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
