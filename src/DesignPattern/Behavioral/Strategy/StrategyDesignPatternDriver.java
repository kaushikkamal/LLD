package DesignPattern.Behavioral.Strategy;

import DesignPattern.Behavioral.Strategy.Context.PassengerVehicle;
import DesignPattern.Behavioral.Strategy.Context.SportsVehicle;
import DesignPattern.Behavioral.Strategy.Context.Vehicle;

public class StrategyDesignPatternDriver {
    public static void execute() {
        Vehicle v1 = new SportsVehicle();
        v1.drive();

        Vehicle v2 = new PassengerVehicle();
        v2.drive();
    }
}
