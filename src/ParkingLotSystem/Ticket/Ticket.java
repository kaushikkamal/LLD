package ParkingLotSystem.Ticket;

import ParkingLotSystem.ParkingSpot.ParkingSpot;
import ParkingLotSystem.Vehicle.Vehicle;

public class Ticket {
    private long entryTime;
    Vehicle vehicle;
    ParkingSpot parkingSpot;

    public Ticket() {
    }

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entryTime = System.currentTimeMillis();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "entryTime=" + entryTime +
                ", vehicle=" + vehicle +
                ", parkingSpot=" + parkingSpot +
                '}';
    }


    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
