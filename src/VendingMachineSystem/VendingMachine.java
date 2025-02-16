package VendingMachineSystem;

import VendingMachineSystem.Inventory.Inventory;
import VendingMachineSystem.Inventory.Item.Item;
import VendingMachineSystem.Inventory.Item.ItemShelf;
import VendingMachineSystem.Inventory.Item.ItemType;
import VendingMachineSystem.State.IdleState;
import VendingMachineSystem.State.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private Inventory inventory;
    private State state;
    private List<Cash> cashList;
    private List<Integer> selectedItemCodeList;

    public VendingMachine() {
        inventory = new Inventory(10);
        state = new IdleState();
        cashList = new ArrayList<>();
        selectedItemCodeList = new ArrayList<>();
    }

    public void fillInventory() {
        List<ItemShelf> itemShelfList = inventory.getItemShelfList();

        for (int i = 0; i < itemShelfList.size(); i++) {
            Item newItem = new Item();
            if (i < 3) {
                newItem.setItemType(ItemType.CHIPS);
                newItem.setPrice(20);
            } else if (i < 5) {
                newItem.setItemType(ItemType.DRINKS);
                newItem.setPrice(30);
            } else {
                newItem.setItemType(ItemType.CHOCOLATE);
                newItem.setPrice(50);
            }

            itemShelfList.get(i).setItem(newItem);
            itemShelfList.get(i).setAvailableQuantity(10);
        }
    }

    public void displayInventory() {
        System.out.println("### Inventory ###");
        List<ItemShelf> itemShelfList = inventory.getItemShelfList();

        for (ItemShelf itemShelf : itemShelfList) {
            System.out.println("ItemShelf Code: " + itemShelf.getCode());
            System.out.println(itemShelf.getItem());
            System.out.println("Quantity: " + itemShelf.getAvailableQuantity());
            System.out.println();
        }
        System.out.println("### Inventory ###");
    }

    public int totalCashInsertedByUser() {
        return cashList.stream().mapToInt(Cash::getValue).sum();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Cash> getCashList() {
        return cashList;
    }

    public void setCashList(List<Cash> cashList) {
        this.cashList = cashList;
    }

    public List<Integer> getSelectedItemCodeList() {
        return selectedItemCodeList;
    }

    public void setSelectedItemCodeList(List<Integer> selectedItemCodeList) {
        this.selectedItemCodeList = selectedItemCodeList;
    }


}
