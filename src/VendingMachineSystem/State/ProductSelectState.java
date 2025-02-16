package VendingMachineSystem.State;

import VendingMachineSystem.Cash;
import VendingMachineSystem.Inventory.Item.Item;
import VendingMachineSystem.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class ProductSelectState implements State {
    public ProductSelectState() {
        System.out.println("Vending Machine State -> ProductSelect");
    }

    @Override
    public void changedStateToInsertCaseState(VendingMachine machine) throws Exception {
        throw new Exception("Action revoked! click on insert cash button is not allowed in product select state");
    }

    @Override
    public void changedStateToProductSelectState(VendingMachine machine) throws Exception {
        System.out.println("Already in product select state");
    }

    @Override
    public void insertCash(VendingMachine machine, List<Cash> cashList) throws Exception {
        throw new Exception("Action revoked! insert cash is not allowed in product select state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, List<Integer> itemCodeList) throws Exception {
        int cashInsertedByUser = machine.totalCashInsertedByUser();
        List<Item> selectedItemByUser = new ArrayList<>();
        int totalItemCost = 0;

        for (int eachItemCode : itemCodeList) {
            try {
                Item item = machine.getInventory().getItemFromCode(eachItemCode);
                selectedItemByUser.add(item);
                totalItemCost += item.getPrice();
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }

        if (cashInsertedByUser < totalItemCost) {
            System.out.println("Insufficient Amount, Products you selected is of price: " + totalItemCost + " and you paid: " + cashInsertedByUser);
            refundFullMoney(machine);
            throw new Exception("insufficient cash");
        }

        if (cashInsertedByUser > totalItemCost) {
            getChange(cashInsertedByUser - totalItemCost);
        }
        machine.setState(new DispenseState(machine, selectedItemByUser));
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returned the change in the Cash Dispense Tray: " + returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public List<Item> dispenseProduct(VendingMachine machine, List<Item> selectedItemByUser) throws Exception {
        throw new Exception("Action revoked! dispense product is not allowed in product select state");
    }

    @Override
    public List<Cash> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back: " + machine.getCashList());
        machine.setState(new IdleState(machine));
        return machine.getCashList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Action revoked! update inventory is not allowed in product select state");
    }
}
