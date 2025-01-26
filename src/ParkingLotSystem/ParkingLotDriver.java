package ParkingLotSystem;

import ParkingLotSystem.Gate.EntranceGate;
import ParkingLotSystem.Gate.ExitGate;
import ParkingLotSystem.ParkingSpot.ParkingSpot;
import ParkingLotSystem.ParkingSpot.ParkingSpotType;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManagerFactory;
import ParkingLotSystem.ParkingSpotManager.ParkingSpotManagerInterface;
import ParkingLotSystem.Vehicle.Vehicle;
import ParkingLotSystem.Vehicle.VehicleType;

public class ParkingLotDriver {
    public static void execute() {
        // Vehicles
        Vehicle v1 = new Vehicle(111, VehicleType.TWO_WHEELER);
        Vehicle v2 = new Vehicle(555, VehicleType.TWO_WHEELER);
        Vehicle v3 = new Vehicle(999, VehicleType.TWO_WHEELER);
        Vehicle v4 = new Vehicle(1234, VehicleType.FOUR_WHEELER);
        Vehicle v5 = new Vehicle(34343, VehicleType.FOUR_WHEELER);
        Vehicle v6 = new Vehicle(56565, VehicleType.FOUR_WHEELER);

        ParkingSpotManagerInterface twoWheelerParkingSpotManger = ParkingSpotManagerFactory.getParkingSpotManager(ParkingSpotType.TWO_WHEELER_PARKING_SPOT);
        ParkingSpotManagerInterface fourWheelerParkingSpotManger = ParkingSpotManagerFactory.getParkingSpotManager(ParkingSpotType.FOUR_WHEELER_PARKING_SPOT);

        for (int i = 1; i <= 2; ++i) {
            twoWheelerParkingSpotManger.addParkingSpace(new ParkingSpot(i));
        }

        for (int i = 3; i <= 4; ++i) {
            fourWheelerParkingSpotManger.addParkingSpace(new ParkingSpot(i));
        }

        EntranceGate entranceGate = new EntranceGate();
        entranceGate.findParkingSpaceAndBook(v1);
        entranceGate.findParkingSpaceAndBook(v2);
        entranceGate.findParkingSpaceAndBook(v3);
        entranceGate.findParkingSpaceAndBook(v4);
        entranceGate.findParkingSpaceAndBook(v5);
        entranceGate.findParkingSpaceAndBook(v6);

        ExitGate exitGate = new ExitGate();
        exitGate.exitVehicle(v1);
        exitGate.exitVehicle(v4);

        entranceGate.findParkingSpaceAndBook(v3);
        entranceGate.findParkingSpaceAndBook(v6);

        exitGate.exitVehicle(v1);
        exitGate.exitVehicle(v4);
    }
}
