package DesignPattern.Creational.AbstractFactory;

import DesignPattern.Creational.AbstractFactory.AbstractFactory.Factory;
import DesignPattern.Creational.AbstractFactory.Factory.FactoryTypeEnum;
import DesignPattern.Creational.AbstractFactory.Factory.VehicleFactory;
import DesignPattern.Creational.AbstractFactory.Vehicle.Vehicle;
import DesignPattern.Creational.AbstractFactory.Vehicle.VehicleTypeEnum;

public class AbstractFactoryDesignPatternDriver {
    public static void execute() {
        Factory factory = new Factory();
        VehicleFactory luxuryVehicleFactory = factory.getVehicleFactory(FactoryTypeEnum.LUXURY);
        Vehicle vehicle = luxuryVehicleFactory.getVehicle(VehicleTypeEnum.BMW);

        vehicle.drive(); // op: Driving BMW

        Vehicle v = new Factory().getVehicleFactory(FactoryTypeEnum.ORDINARY).getVehicle(VehicleTypeEnum.HYUNDAI);
        v.drive(); // op: Driving Hyundai
    }
}
