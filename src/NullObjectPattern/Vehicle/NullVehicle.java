package NullObjectPattern.Vehicle;

public class NullVehicle implements Vehicle {
    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public int getCapacity() {
        return 0;
    }
}
