package ParkingLotSystem.ParkingSpot;

public class ParkingSpotFactory {
    public ParkingSpotFactory() {
    }

    public ParkingSpot getParkingSpot(ParkingSpotType parkingSpotType) {
        ParkingSpot parkingSpot;
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
