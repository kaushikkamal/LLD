package DesignPattern.Behavioral.Strategy.Context;

import DesignPattern.Behavioral.Strategy.Context.Vehicle;
import DesignPattern.Behavioral.Strategy.Strategy.SpeedDriveStrategy;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SpeedDriveStrategy());
    }
}
