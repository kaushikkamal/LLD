package ParkingLotSystem.Gate;

import ParkingLotSystem.ParkingSpot.ParkingSpotFactory;
import ParkingLotSystem.ParkingSpot.ParkingSpotType;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManager;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManagerFactory;
import ParkingLotSystem.Ticket.Ticket;
import ParkingLotSystem.Vehicle.Vehicle;

public class ExitGate {
    ParkingSpotFactory parkingSpotFactory;
    ParkingSpotManagerFactory parkingSpotManagerFactory;


    public void makePayment() {
    }

    public void exitVehicle(Vehicle vehicle) {
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
                parkingSpotManager.removeVehicle(vehicle);
                calculatePrice(vehicle.getTicket());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void calculatePrice(Ticket ticket) {
        long entryTime = ticket.getEntryTime();
        long exitTime = System.currentTimeMillis();
//        long differenceInSecond = (exitTime - entryTime) / 1000;
        long differenceInSecond = 1240;

        long s = (differenceInSecond) % 60;
        long m = (differenceInSecond / 60) % 60;
        long h = (differenceInSecond / (60 * 60)) % 24;

        // calculate cost with strategy
    }
}
