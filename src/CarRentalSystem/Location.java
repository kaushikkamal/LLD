package CarRentalSystem;

public class Location {
    private int locationId;
//    private long longitude;
//    private long latitude;

    private String address;
    private String pinCode;

    public Location(int locationId, String address, String pinCode) {
        this.locationId = locationId;
        this.address = address;
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", address='" + address + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }

    public int getLocationId() {
        return locationId;
    }

    public String getAddress() {
        return address;
    }

    public String getPinCode() {
        return pinCode;
    }
}
