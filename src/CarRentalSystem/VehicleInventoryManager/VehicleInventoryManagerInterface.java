package CarRentalSystem.VehicleInventoryManager;

import CarRentalSystem.Vehicle.Vehicle;
import CarRentalSystem.Vehicle.VehicleType;

import java.util.List;

public interface VehicleInventoryManagerInterface {
    public boolean addVehicle(Vehicle newVehicle);

    public boolean removeVehicle(Vehicle newVehicle);

    public List<Vehicle> getAllVehicles();

    public List<Vehicle> getAllVehiclesWithParticularVehicleType(VehicleType vehicleType);
}
