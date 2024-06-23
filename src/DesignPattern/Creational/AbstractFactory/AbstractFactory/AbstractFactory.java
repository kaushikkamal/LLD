package DesignPattern.Creational.AbstractFactory.AbstractFactory;

import DesignPattern.Creational.AbstractFactory.Factory.FactoryTypeEnum;
import DesignPattern.Creational.AbstractFactory.Factory.VehicleFactory;

public interface AbstractFactory {
    VehicleFactory getVehicleFactory(FactoryTypeEnum factoryType);

}
