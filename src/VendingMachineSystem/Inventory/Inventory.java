package VendingMachineSystem.Inventory;

import VendingMachineSystem.Inventory.Item.Item;
import VendingMachineSystem.Inventory.Item.ItemShelf;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<ItemShelf> itemShelfList;
    private int inventorySize;

    public Inventory(int inventorySize) {
        this.inventorySize = inventorySize;
        this.itemShelfList = new ArrayList<>();
        initialEmptyInventory();
    }

    private void initialEmptyInventory() {
        int startCode = 100;

        for (int i = 0; i < this.inventorySize; i++) {
            ItemShelf itemShelf = new ItemShelf();
            itemShelf.setCode(startCode);

            itemShelfList.add(itemShelf);
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber, int itemQuantity) throws Exception {
        for (ItemShelf eachItemShelf : itemShelfList) {
            if (eachItemShelf.getCode() == codeNumber) {
                eachItemShelf.setItem(item);
                eachItemShelf.setAvailableQuantity(itemQuantity);
                return;
            }
        }

        throw new Exception("Wrong code for item shelf");
    }

    public Item getItemFromCode(int code) throws Exception {
        for (ItemShelf eachShelf : itemShelfList) {
            if (eachShelf.getCode() == code) {
                if (eachShelf.getAvailableQuantity() > 0) {
                    return eachShelf.getItem();
                }
                throw new Exception("Item Out of Stock");
            }
        }

        throw new Exception("Invalid item code");
    }

    public Inventory(List<ItemShelf> inventory) {
        this.itemShelfList = inventory;
    }

    public List<ItemShelf> getItemShelfList() {
        return itemShelfList;
    }

    public void setItemShelfList(List<ItemShelf> itemShelfList) {
        this.itemShelfList = itemShelfList;
    }
}
