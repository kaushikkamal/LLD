package CarRentalSystem;

import CarRentalSystem.VehicleInventoryManager.CarVehicleInventoryManager;
import CarRentalSystem.VehicleInventoryManager.VehicleInventoryManagerInterface;

public class Store {
    private int storeId;
    private Location storeLocation;
    private VehicleInventoryManagerInterface inventoryManager;


    public Store(int storeId, Location storeLocation) {
        this.storeId = storeId;
        this.storeLocation = storeLocation;
        inventoryManager = new CarVehicleInventoryManager();
    }

    public int getStoreId() {
        return storeId;
    }

    public Location getStoreLocation() {
        return storeLocation;
    }

    public VehicleInventoryManagerInterface getInventoryManager() {
        return inventoryManager;
    }

    @Override
    public String toString() {
        return "Store{" + "storeId=" + storeId + ", storeLocation=" + storeLocation + ", inventoryManager=" + inventoryManager + '}';
    }
}
