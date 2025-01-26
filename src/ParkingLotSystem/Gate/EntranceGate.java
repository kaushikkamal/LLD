package ParkingLotSystem.Gate;

import ParkingLotSystem.ParkingSpot.ParkingSpot;
import ParkingLotSystem.ParkingSpot.ParkingSpotFactory;
import ParkingLotSystem.ParkingSpot.ParkingSpotType;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManager;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManagerFactory;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManagerInterface;
import ParkingLotSystem.Ticket.Ticket;
import ParkingLotSystem.Vehicle.Vehicle;

public class EntranceGate {

    public void findParkingSpaceAndBook(Vehicle vehicle) {
        ParkingSpotManagerInterface parkingSpotManager = null;
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

    public void generateTicket(Vehicle vehicle, ParkingSpot parkedSpot) {
        Ticket ticket1 = new Ticket(vehicle, parkedSpot);
        parkedSpot.getVehicle().setTicket(ticket1);
        System.out.println("### Ticket Generated - Vehicle " + vehicle.getVehicleNumber() + " is parked at " + parkedSpot.getParkingId() + " ###");
    }
}
