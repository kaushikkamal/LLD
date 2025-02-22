package ATMMachineSystem.CashWithdrawalProcess;

import ATMMachineSystem.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawalProcess {
    private static final int AMOUNT = 500;

    public FiveHundredWithdrawProcessor(CashWithdrawalProcess nextCashWithdrawalProcess) {
        super(nextCashWithdrawalProcess);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) throws Exception {
        int required = remainingAmount / AMOUNT;
        int balance = remainingAmount % AMOUNT;

        if (atm.getNoOfFiveHundredNotes() <= required) {
            balance += (required - atm.getNoOfFiveHundredNotes()) * AMOUNT;
            atm.setPickedNoOfFiveHundredNotes(atm.getNoOfFiveHundredNotes()); // store the number of five hundred notes to be removed later for successful transaction.
//            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
        } else {
            atm.setPickedNoOfFiveHundredNotes(required);// store the number of five hundred notes to be removed later for successful transaction.
//            atm.deductFiveHundredNotes(required);
        }

        if (balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
