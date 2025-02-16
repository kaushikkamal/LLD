package VendingMachineSystem;

import VendingMachineSystem.State.State;

import java.util.List;

public class VendingMachineDriver {

    public static void execute() {
        VendingMachine vendingMachine = new VendingMachine();
        try {
            vendingMachine.fillInventory();
            vendingMachine.displayInventory();

            State vendingMachineState = vendingMachine.getState(); // IDLE state

            vendingMachineState.changedStateToInsertCaseState(vendingMachine); // IDLE -> Insert Cash

            vendingMachineState = vendingMachine.getState(); // Insert Cash state
            vendingMachineState.insertCash(vendingMachine, List.of(Cash.TEN, Cash.FIFTY));

            vendingMachineState.changedStateToProductSelectState(vendingMachine); // Insert Cash -> Product Select
            vendingMachineState = vendingMachine.getState(); // Product Select state

            vendingMachineState.chooseProduct(vendingMachine, List.of(100));

            vendingMachine.displayInventory();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
