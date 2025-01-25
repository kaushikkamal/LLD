package ParkingLotSystem.Vehicle;

public class Vehicle {
    private int vehicleNumber;
    private VehicleType vehicleType;

    public Vehicle() {
    }

    public Vehicle(int vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber=" + vehicleNumber +
                ", vehicleType=" + vehicleType +
                '}';
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
