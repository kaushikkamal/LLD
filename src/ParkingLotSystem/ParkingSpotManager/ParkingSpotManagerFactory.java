package ParkingLotSystem.ParkingSpotManager;

import ParkingLotSystem.ParkingSpot.ParkingSpotType;

public class ParkingSpotManagerFactory {
    /*
     * Only one object of particular ParkingSpotManager will be created.
     * One object for twoWheelerParkingSpotManger and one for fourWheelerParkingSpotManger
     */
    private static volatile ParkingSpotManager twoWheelerParkingSpotManger;
    private static volatile ParkingSpotManager fourWheelerParkingSpotManger;

    private ParkingSpotManagerFactory() {
    }

    public static ParkingSpotManager getParkingSpotManager(ParkingSpotType parkingSpotType) {
        switch (parkingSpotType) {
            case TWO_WHEELER_PARKING_SPOT -> {
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
