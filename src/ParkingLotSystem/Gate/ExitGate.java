package ParkingLotSystem.Gate;

import ParkingLotSystem.ParkingSpot.ParkingSpot;
import ParkingLotSystem.ParkingSpot.ParkingSpotFactory;
import ParkingLotSystem.ParkingSpot.ParkingSpotType;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManager;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManagerFactory;
import ParkingLotSystem.Vehicle.Vehicle;

public class ExitGate {
    ParkingSpotFactory parkingSpotFactory;
    ParkingSpotManagerFactory parkingSpotManagerFactory;

    public void calculatePrice() {
    }

    public void makePayment() {
    }

    public void exitVehicle(Vehicle vehicle) {
        ParkingSpotManager parkingSpotManager;
        switch (vehicle.getVehicleType()) {
            case TWO_WHEELER: {
                parkingSpotManager = ParkingSpotManagerFactory.getParkingSpotManager(ParkingSpotType.TWO_WHEELER_PARKING_SPOT);
                try {
                    parkingSpotManager.removeVehicle(vehicle);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case FOUR_WHEELER: {
                parkingSpotManager = ParkingSpotManagerFactory.getParkingSpotManager(ParkingSpotType.FOUR_WHEELER_PARKING_SPOT);
                try {
                    parkingSpotManager.removeVehicle(vehicle);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            default: {
                System.out.println("No vehicle found");
                break;
            }
        }
    }
}
