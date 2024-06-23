package DesignPattern.Creational.AbstractFactory.Factory;

import DesignPattern.Creational.AbstractFactory.Vehicle.TataVehicle;
import DesignPattern.Creational.AbstractFactory.Vehicle.HyundaiVehicle;
import DesignPattern.Creational.AbstractFactory.Vehicle.Vehicle;
import DesignPattern.Creational.AbstractFactory.Vehicle.VehicleTypeEnum;

public class OrdinaryVehicleFactory implements VehicleFactory {

    Vehicle vehicle;

    @Override
    public Vehicle getVehicle(VehicleTypeEnum vehicleType) {
        switch (vehicleType) {
            case TATA -> {
                this.vehicle = new TataVehicle();
                return this.vehicle;
            }
            case HYUNDAI -> {
                this.vehicle = new HyundaiVehicle();
                return this.vehicle;
            }
            default -> {
                this.vehicle = null;
                return this.vehicle;
            }
        }
    }
}
