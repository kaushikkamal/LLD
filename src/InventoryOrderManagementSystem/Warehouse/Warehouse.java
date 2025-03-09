package InventoryOrderManagementSystem.Warehouse;

import InventoryOrderManagementSystem.Address.Address;
import InventoryOrderManagementSystem.Inventory.Inventory;

import java.util.Map;

public class Warehouse {
    private Inventory inventory;
    private Address address;

    public void addItemToInventory(Map<Integer, Integer> productCategoryAndCountMap) {
        //it will update the items in the inventory based upon product category.
    }

    //update inventory
    public void removeItemFromInventory(Map<Integer, Integer> productCategoryAndCountMap) {
        //it will update the items in the inventory based upon product category.
        inventory.removeItems(productCategoryAndCountMap);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Address getAddress() {
        return address;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
