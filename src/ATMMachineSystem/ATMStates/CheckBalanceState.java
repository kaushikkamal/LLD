package ATMMachineSystem.ATMStates;

import ATMMachineSystem.ATM;
import ATMMachineSystem.Card;

public class CheckBalanceState extends ATMState {
    public CheckBalanceState() {
        System.out.println("ATM in CheckBalance State");
    }

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your Balance is: " + card.getBankAccount().getBalance());
        super.exit(atm);
    }
}
