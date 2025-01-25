package ParkingLotSystem.ParkingSpotManager;

import ParkingLotSystem.ParkingSpot.ParkingSpot;
import ParkingLotSystem.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManager implements ParkingSpotManagerInterface {
    private List<ParkingSpot> parkingSpotList;

    public ParkingSpotManager() {
        this.parkingSpotList = new ArrayList<>();
    }

    public ParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    @Override
    public void findParkingSpace() {

    }

    @Override
    public void addParkingSpace(ParkingSpot parkingSpot) {
        this.parkingSpotList.add(parkingSpot);
    }

    @Override
    public void removeParkingSpace() {

    }

    @Override
    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot assignedParkingSpot = null;
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if (parkingSpot.isAvailable()) {
                parkingSpot.setVehicle(vehicle);
                assignedParkingSpot = parkingSpot;
                break;
            }
        }
        if (assignedParkingSpot == null) {
            throw new RuntimeException("No parking spot is found for vehicle: " + vehicle.toString());
        }

        return assignedParkingSpot;
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        ParkingSpot vehicleParkingSpot = null;
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if (parkingSpot.getVehicle().getVehicleNumber() == vehicle.getVehicleNumber()) {
                vehicleParkingSpot = parkingSpot;
                break;
            }
        }
        if (vehicleParkingSpot == null) {
            throw new RuntimeException("The vehicle is not present in the Parking Lot");
        }

        vehicleParkingSpot.removeVehicle();
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }
}
