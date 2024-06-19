package DesignPattern.Behavioral.Strategy.Context;

import DesignPattern.Behavioral.Strategy.Context.Vehicle;
import DesignPattern.Behavioral.Strategy.Strategy.SpeedDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SpeedDriveStrategy());
    }
}
