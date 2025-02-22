package ATMMachineSystem;

import ATMMachineSystem.ATMStates.ATMState;

public class ATMRoom {
    private ATM atm;
    private User user;

    public ATMRoom() {
        atm = new ATM();
        atm.setAtmBalance(3500, 0, 6, 5);

        UserBankAccount bankAccount = new UserBankAccount(4000);
        Card card = new Card(1234, 123, "KKB", 5555, bankAccount);

        user = new User(card, bankAccount);
    }

    public void startTransactions() throws Exception {
        atm.printCurrentATMStatus();

        ATMState state = atm.getCurrentATMState(); // IDLE

        state.insertCard(atm, user.getCard());

        state = atm.getCurrentATMState(); // Has Card State
        state.authenticatePin(atm, user.getCard(), 5555);

        state = atm.getCurrentATMState(); // Select Operation State
        state.selectOperation(atm, user.getCard(), TransactionType.WITHDRAWAL);
//        state.selectOperation(atm, user.getCard(), TransactionType.BALANCE_CHECK);

        state = atm.getCurrentATMState(); // Check Balance State
        try {
            state.cashWithdrawal(atm, user.getCard(), 1900);
        } catch (Exception e) {
            throw new Exception(e);
        }

        atm.printCurrentATMStatus();
    }
}
