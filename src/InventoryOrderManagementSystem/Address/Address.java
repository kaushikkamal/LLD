package InventoryOrderManagementSystem.Address;

public class Address {
    private int addressId;
    private int pinCode;
    private String city;
    private String state;

    public Address(int addressId, int pinCode, String city, String state) {
        this.addressId = addressId;
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
    }

    public int getAddressId() {
        return addressId;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
