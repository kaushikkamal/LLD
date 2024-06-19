package DesignPattern.Behavioral.Strategy.Context;

import DesignPattern.Behavioral.Strategy.Context.Vehicle;
import DesignPattern.Behavioral.Strategy.Strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {

    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}