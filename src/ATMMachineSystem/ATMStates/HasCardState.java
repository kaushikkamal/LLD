package ATMMachineSystem.ATMStates;

import ATMMachineSystem.ATM;
import ATMMachineSystem.Card;

public class HasCardState extends ATMState {
    public HasCardState() {
        System.out.println("ATM in HasCard State");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        boolean isCorrectPinEntered = card.isCorrectPINEntered(pin);

        if (isCorrectPinEntered) {
            System.out.println("PIN Number is correct");
            atm.setCurrentATMState(new SelectOperationState());
        } else {
            System.out.println("Invalid PIN Number");
            exit(atm);
        }
    }
}
