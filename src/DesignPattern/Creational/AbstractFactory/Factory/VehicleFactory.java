package DesignPattern.Creational.AbstractFactory.Factory;

import DesignPattern.Creational.AbstractFactory.Vehicle.Vehicle;
import DesignPattern.Creational.AbstractFactory.Vehicle.VehicleTypeEnum;

public interface VehicleFactory {
    public Vehicle getVehicle(VehicleTypeEnum vehicleType);
}
