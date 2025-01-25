package ParkingLotSystem.ParkingSpot;

import ParkingLotSystem.Vehicle.Vehicle;

public class ParkingSpot implements ParkingSpotInterface {
    private int parkingId;
    private Vehicle vehicle;

//    private int price;

    public ParkingSpot() {

    }

    public ParkingSpot(int parkingId) {
        this.parkingId = parkingId;
        this.vehicle = null;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" + "parkingId=" + parkingId + ", vehicle=" + vehicle + '}';
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void removeVehicle() {
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(ParkingLotSystem.Vehicle.Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return this.vehicle == null;
    }

//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
}
