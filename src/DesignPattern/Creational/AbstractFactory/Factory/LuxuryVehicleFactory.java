package DesignPattern.Creational.AbstractFactory.Factory;

import DesignPattern.Creational.AbstractFactory.Vehicle.BMWVehicle;
import DesignPattern.Creational.AbstractFactory.Vehicle.TataVehicle;
import DesignPattern.Creational.AbstractFactory.Vehicle.Vehicle;
import DesignPattern.Creational.AbstractFactory.Vehicle.VehicleTypeEnum;

public class LuxuryVehicleFactory implements VehicleFactory {

    Vehicle vehicle;

    @Override
    public Vehicle getVehicle(VehicleTypeEnum vehicleType) {

        switch (vehicleType) {
            case BMW -> {
                this.vehicle = new BMWVehicle();
                return this.vehicle;
            }
            case MERCEDES -> {
                this.vehicle = new TataVehicle();
                return this.vehicle;
            }
            default -> {
                this.vehicle = null;
                return this.vehicle;
            }
        }
    }
}
