package NullObjectPattern.Vehicle;

public class SportVehicle implements Vehicle {
    @Override
    public int getSpeed() {
        return 200;
    }

    @Override
    public int getCapacity() {
        return 2;
    }
}
