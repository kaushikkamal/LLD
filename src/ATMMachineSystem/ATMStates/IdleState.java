package ATMMachineSystem.ATMStates;

import ATMMachineSystem.ATM;
import ATMMachineSystem.Card;

public class IdleState extends ATMState {
    public IdleState() {
        System.out.println("ATM in Idle State");
    }

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
