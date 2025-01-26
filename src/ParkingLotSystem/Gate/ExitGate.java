package ParkingLotSystem.Gate;

import ParkingLotSystem.CostComputation.CostComputation;
import ParkingLotSystem.CostComputation.CostComputationFactory;
import ParkingLotSystem.ParkingSpot.ParkingSpotFactory;
import ParkingLotSystem.ParkingSpot.ParkingSpotType;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManager;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManagerFactory;
import ParkingLotSystem.PricingStrategy.HourlyPricingStrategy;
import ParkingLotSystem.PricingStrategy.PricingStrategy;
import ParkingLotSystem.Ticket.Ticket;
import ParkingLotSystem.Vehicle.Vehicle;
import ParkingLotSystem.Vehicle.VehicleType;

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
                calculatePrice(vehicle.getTicket(), vehicle);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void calculatePrice(Ticket ticket, Vehicle vehicle) {
        /*
         * Explicitly add sleep to test for multiple duration
         *   try {
         *   Thread.sleep(2000);
         *   } catch (Exception e) {
         *    }
         */
        long entryTime = ticket.getEntryTime();
        long exitTime = System.currentTimeMillis();
        long differenceInSecond = (exitTime - entryTime) / 1000;

        long seconds = (differenceInSecond) % 60;
        long minutes = (differenceInSecond / 60) % 60;
        long hours = (differenceInSecond / (60 * 60)) % 24;

        System.out.println("### Bill for " + vehicle.getVehicleNumber() + " Start ###");

        System.out.println(String.format("Hour: %d, Minute: %d, Seconds: %d", hours, minutes, seconds));

        // calculate cost with strategy
        CostComputation cost = CostComputationFactory.getCostComputation(vehicle.getVehicleType(), hours, minutes, seconds);

        System.out.printf("Total Cost: %f%n", cost.calculateTotalPrice());
        System.out.println("### Bill for " + vehicle.getVehicleNumber() + " End ###");
        System.out.println();
    }
}
