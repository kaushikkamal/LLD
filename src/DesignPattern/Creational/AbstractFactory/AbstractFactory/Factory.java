package DesignPattern.Creational.AbstractFactory.AbstractFactory;

import DesignPattern.Creational.AbstractFactory.Factory.FactoryTypeEnum;
import DesignPattern.Creational.AbstractFactory.Factory.LuxuryVehicleFactory;
import DesignPattern.Creational.AbstractFactory.Factory.OrdinaryVehicleFactory;
import DesignPattern.Creational.AbstractFactory.Factory.VehicleFactory;

public class Factory implements AbstractFactory {
    VehicleFactory vehicleFactory;

    @Override
    public VehicleFactory getVehicleFactory(FactoryTypeEnum factoryType) {
        switch (factoryType) {
            case LUXURY -> {
                this.vehicleFactory = new LuxuryVehicleFactory();
                return this.vehicleFactory;
            }

            case ORDINARY -> {
                this.vehicleFactory = new OrdinaryVehicleFactory();
                return this.vehicleFactory;
            }

            default -> {
                this.vehicleFactory = null;
                return this.vehicleFactory;
            }
        }
    }
}