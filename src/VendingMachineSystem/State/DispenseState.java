package VendingMachineSystem.State;

import VendingMachineSystem.Cash;
import VendingMachineSystem.Inventory.Item.Item;
import VendingMachineSystem.VendingMachine;

import java.util.List;

public class DispenseState implements State {
    public DispenseState(VendingMachine machine, List<Item> selectedItemByUser) {
        System.out.println("Vending Machine State -> Dispense");
        try {
            dispenseProduct(machine, selectedItemByUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void changedStateToInsertCaseState(VendingMachine machine) throws Exception {
        throw new Exception("Action revoked! click on insert cash button is not allowed in dispense state");
    }

    @Override
    public void changedStateToProductSelectState(VendingMachine machine) throws Exception {
        throw new Exception("Action revoked! click on product select button is not allowed in dispense state");
    }

    @Override
    public void insertCash(VendingMachine machine, List<Cash> cashList) throws Exception {
        throw new Exception("Action revoked! insert cash is not allowed in dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, List<Integer> itemCodeList) throws Exception {
        throw new Exception("Action revoked! choose product is not allowed in dispense state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Action revoked! get change is not allowed in dispense state");
    }

    @Override
    public List<Item> dispenseProduct(VendingMachine machine, List<Item> selectedItemByUser) throws Exception {
        System.out.println("Products has been dispensed: " + selectedItemByUser);
        return selectedItemByUser;
    }

    @Override
    public List<Cash> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("Action revoked! refund full money is not allowed in dispense state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Action revoked! update inventory is not allowed in dispense state");
    }
}
