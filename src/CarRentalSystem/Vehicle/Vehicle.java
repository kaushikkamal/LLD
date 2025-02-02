package CarRentalSystem.Vehicle;

public class Vehicle {
    private int vehicleId;
    private int vehicleNumber;
    private VehicleType vehicleType;

    // price
    public Vehicle(int vehicleId, int vehicleNumber, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleNumber=" + vehicleNumber +
                ", vehicleType=" + vehicleType +
                '}';
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
