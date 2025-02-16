package VendingMachineSystem.State;

import VendingMachineSystem.Cash;
import VendingMachineSystem.Inventory.Item.Item;
import VendingMachineSystem.VendingMachine;

import java.util.List;

public interface State {
    public void changedStateToInsertCaseState(VendingMachine machine) throws Exception;

    public void changedStateToProductSelectState(VendingMachine machine) throws Exception;

    public void insertCash(VendingMachine machine, List<Cash> cashList) throws Exception;

    public void chooseProduct(VendingMachine machine, List<Integer> itemCodeList) throws Exception;

    public int getChange(int returnChangeMoney) throws Exception;

    public List<Item> dispenseProduct(VendingMachine machine, List<Item> selectedItemByUser) throws Exception;

    public List<Cash> refundFullMoney(VendingMachine machine) throws Exception;

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;
}
