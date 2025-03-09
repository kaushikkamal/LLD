package InventoryOrderManagementSystem.Warehouse;

import InventoryOrderManagementSystem.Warehouse.WarehouseSelectionStrategy.WarehouseSelectionStrategy;

import java.util.List;

public class WarehouseController {
    private List<Warehouse> warehouseList;
    private WarehouseSelectionStrategy warehouseSelectionStrategy;

    public WarehouseController(List<Warehouse> warehouseList, WarehouseSelectionStrategy warehouseSelectionStrategy) {
        this.warehouseList = warehouseList;
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
    }

    //add new warehouse
    public void addNewWarehouse(Warehouse warehouse) {
        warehouseList.add(warehouse);
    }

    //remove warehouse
    public void removeWarehouse(Warehouse warehouse) {
        warehouseList.remove(warehouse);
    }

    public Warehouse selectWarehouse(WarehouseSelectionStrategy selectionStrategy) {
        this.warehouseSelectionStrategy = selectionStrategy;
        return warehouseSelectionStrategy.selectWarehouse(warehouseList);
    }
}
