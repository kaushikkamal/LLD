package NullObjectPattern;

import NullObjectPattern.Vehicle.Vehicle;
import NullObjectPattern.Vehicle.VehicleFactory;

public class NullObjectPatternDriver {
    public static void execute() {
        Vehicle v = VehicleFactory.getVehicleObject("CAR");
        System.out.println(v.getSpeed());
    }
}
