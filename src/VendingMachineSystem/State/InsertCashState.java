package VendingMachineSystem.State;

import VendingMachineSystem.Cash;
import VendingMachineSystem.Inventory.Item.Item;
import VendingMachineSystem.VendingMachine;

import java.util.List;

public class InsertCashState implements State {

    public InsertCashState() {
        System.out.println("Vending Machine State -> InsertCash");
    }

    @Override
    public void changedStateToInsertCaseState(VendingMachine machine) throws Exception {
        System.out.println("Already in insert cash state");
    }

    @Override
    public void changedStateToProductSelectState(VendingMachine machine) throws Exception {
        machine.setState(new ProductSelectState());
    }

    @Override
    public void insertCash(VendingMachine machine, List<Cash> cashList) throws Exception {
        machine.setCashList(cashList);
    }

    @Override
    public void chooseProduct(VendingMachine machine, List<Integer> itemCodeList) throws Exception {
        throw new Exception("Action revoked! choose product is not allowed in insert cash state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Action revoked! get change is not allowed in insert cash state");
    }

    @Override
    public List<Item> dispenseProduct(VendingMachine machine, List<Item> selectedItemByUser) throws Exception {
        throw new Exception("Action revoked! dispense product is not allowed in insert cash state");
    }

    @Override
    public List<Cash> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Refund all the money from Insert Cash State");
        return machine.getCashList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Action revoked! update inventory is not allowed in insert cash state");
    }
}
