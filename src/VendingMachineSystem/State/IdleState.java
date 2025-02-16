package VendingMachineSystem.State;

import VendingMachineSystem.Cash;
import VendingMachineSystem.Inventory.Item.Item;
import VendingMachineSystem.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Vending Machine State -> Idle");
    }

    public IdleState(VendingMachine machine) {
        System.out.println("Vending Machine State -> Idle");
        // resetting the available cash for next user
        machine.setCashList(new ArrayList<>());
    }

    @Override
    public void changedStateToInsertCaseState(VendingMachine machine) throws Exception {
        machine.setState(new InsertCashState());
    }

    @Override
    public void changedStateToProductSelectState(VendingMachine machine) throws Exception {
        throw new Exception("Action revoked! click on product select button is not allowed in idle state");
    }

    @Override
    public void insertCash(VendingMachine machine, List<Cash> cashList) throws Exception {
        throw new Exception("Action revoked! insert cash is not allowed in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, List<Integer> itemCodeList) throws Exception {
        throw new Exception("Action revoked! choose product is not allowed in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Action revoked! get change is not allowed in idle state");
    }

    @Override
    public List<Item> dispenseProduct(VendingMachine machine, List<Item> selectedItemByUser) throws Exception {
        throw new Exception("Action revoked! dispense product is not allowed in idle state");
    }

    @Override
    public List<Cash> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("Action revoked! refund full money is not allowed in idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        //
    }
}
