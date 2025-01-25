package ParkingLotSystem.ParkingSpotManager;

import ParkingLotSystem.ParkingSpot.ParkingSpot;
import ParkingLotSystem.Vehicle.Vehicle;

public interface ParkingSpotManagerInterface {

    public void findParkingSpace();

    public void addParkingSpace(ParkingSpot parkingSpot);

    public void removeParkingSpace();

    public ParkingSpot parkVehicle(Vehicle vehicle);

    public void removeVehicle(Vehicle vehicle);
}
