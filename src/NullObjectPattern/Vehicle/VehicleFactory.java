package NullObjectPattern.Vehicle;

public class VehicleFactory {
    private static final String OBJECT = "CAR";

    public static Vehicle getVehicleObject(String typeOfVehicle) {
        if (OBJECT.equals(typeOfVehicle)) {
            return new SportVehicle();
        }
        return new NullVehicle();
    }
}
