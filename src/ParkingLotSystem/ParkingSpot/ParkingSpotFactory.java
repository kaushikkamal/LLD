package ParkingLotSystem.ParkingSpot;

public class ParkingSpotFactory {
    public ParkingSpotFactory() {
    }

    public ParkingSpotInterface getParkingSpot(ParkingSpotType parkingSpotType) {
        ParkingSpotInterface parkingSpot;
        switch (parkingSpotType) {
            case TWO_WHEELER_PARKING_SPOT -> {
                parkingSpot = new TwoWheelerParkingSpot();
                return parkingSpot;
            }
            case FOUR_WHEELER_PARKING_SPOT -> {
                parkingSpot = new FourWheelerParkingSpot();
                return parkingSpot;
            }
            default -> {
                parkingSpot = null;
                return parkingSpot;
            }
        }
    }
}
