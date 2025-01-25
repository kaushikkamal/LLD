package ParkingLotSystem.ParkingSpotManager;

import ParkingLotSystem.ParkingSpot.ParkingSpot;
import ParkingLotSystem.ParkingSpot.ParkingSpotType;

import java.util.List;

public class ParkingSpotManagerFactory {

    private static volatile ParkingSpotManager twoWheelerParkingSpotManger;
    private static volatile ParkingSpotManager fourWheelerParkingSpotManger;

    private ParkingSpotManagerFactory() {
    }

//    public static ParkingSpotManager getParkingSpotManager(ParkingSpotType parkingSpotType, List<ParkingSpot> parkingSpotList) {
//        ParkingSpotManager parkingSpotManager;
//        switch (parkingSpotType) {
//            case TWO_WHEELER_PARKING_SPOT -> {
//                parkingSpotManager = new TwoWheelerParkingSpotManager(parkingSpotList);
//                return parkingSpotManager;
//            }
//            case FOUR_WHEELER_PARKING_SPOT -> {
//                parkingSpotManager = new FourWheelerParkingSpotManager(parkingSpotList);
//                return parkingSpotManager;
//            }
//            default -> {
//                parkingSpotManager = null;
//                return parkingSpotManager;
//            }
//        }
//    }

    public static ParkingSpotManager getParkingSpotManager(ParkingSpotType parkingSpotType) {
        switch (parkingSpotType) {
            case TWO_WHEELER_PARKING_SPOT -> {
//                parkingSpotManager = new TwoWheelerParkingSpotManager(parkingSpotList);

                if (twoWheelerParkingSpotManger == null) {
                    synchronized (ParkingSpotManagerFactory.class) {
                        if (twoWheelerParkingSpotManger == null) {
                            twoWheelerParkingSpotManger = new TwoWheelerParkingSpotManager();
                        }
                    }
                }
                return twoWheelerParkingSpotManger;
            }
            case FOUR_WHEELER_PARKING_SPOT -> {
//                parkingSpotManager = new FourWheelerParkingSpotManager(parkingSpotList);
                if (fourWheelerParkingSpotManger == null) {
                    synchronized (ParkingSpotManagerFactory.class) {
                        if (fourWheelerParkingSpotManger == null) {
                            fourWheelerParkingSpotManger = new FourWheelerParkingSpotManager();
                        }
                    }
                }
                return fourWheelerParkingSpotManger;
            }
            default -> {
                twoWheelerParkingSpotManger = null;
                fourWheelerParkingSpotManger = null;
                return null;
            }
        }
    }
}
