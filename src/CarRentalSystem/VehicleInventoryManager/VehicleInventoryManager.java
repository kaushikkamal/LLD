package CarRentalSystem.VehicleInventoryManager;

import CarRentalSystem.Vehicle.Vehicle;
import CarRentalSystem.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public abstract class VehicleInventoryManager implements VehicleInventoryManagerInterface {
    private final List<Vehicle> vehicleList;

    public VehicleInventoryManager() {
        vehicleList = new ArrayList<>();
    }

    @Override
    public boolean addVehicle(Vehicle newVehicle) {
        return vehicleList.add(newVehicle);
    }

    @Override
    public boolean removeVehicle(Vehicle vehicle) {
        return vehicleList.remove(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleList;
    }

    @Override
    public List<Vehicle> getAllVehiclesWithParticularVehicleType(VehicleType vehicleType) {
        return vehicleList.stream().filter((Vehicle vehicle) -> vehicle.getVehicleType().equals(vehicleType)).toList();
    }
}
