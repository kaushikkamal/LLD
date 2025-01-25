package ParkingLotSystem.Gate;

import ParkingLotSystem.ParkingSpot.ParkingSpot;
import ParkingLotSystem.ParkingSpot.ParkingSpotFactory;
import ParkingLotSystem.ParkingSpot.ParkingSpotType;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManager;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManagerFactory;
import ParkingLotSystem.Ticket.Ticket;
import ParkingLotSystem.Vehicle.Vehicle;

public class EntranceGate {
    ParkingSpotFactory parkingSpotFactory;
    ParkingSpotManagerFactory parkingSpotManagerFactory;


    Ticket ticket;

    public void findParkingSpace(Vehicle vehicle) {
        ParkingSpotManager parkingSpotManager = null;
        switch (vehicle.getVehicleType()) {
            case TWO_WHEELER: {
                parkingSpotManager = ParkingSpotManagerFactory.getParkingSpotManager(ParkingSpotType.TWO_WHEELER_PARKING_SPOT);
                break;
            }
            case FOUR_WHEELER: {
                parkingSpotManager = ParkingSpotManagerFactory.getParkingSpotManager(ParkingSpotType.FOUR_WHEELER_PARKING_SPOT);
                break;
            }
            default: {
                parkingSpotManager = null;
                System.out.println("No vehicle found");
                break;
            }
        }
        if (parkingSpotManager != null) {
            try {
                ParkingSpot parkedSpot = parkingSpotManager.parkVehicle(vehicle);
                generateTicket(vehicle, parkedSpot);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void bookParkingSpot(Vehicle vehicle) {

    }

    public void generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        Ticket ticket1 = new Ticket(vehicle, parkingSpot);
        parkingSpot.getVehicle().setTicket(ticket1);
    }
}
