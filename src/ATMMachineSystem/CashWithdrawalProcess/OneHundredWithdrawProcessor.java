package ATMMachineSystem.CashWithdrawalProcess;

import ATMMachineSystem.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawalProcess {
    private static final int AMOUNT = 100;

    public OneHundredWithdrawProcessor(CashWithdrawalProcess nextCashWithdrawalProcess) {
        super(nextCashWithdrawalProcess);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) throws Exception {
        int required = remainingAmount / AMOUNT;
        int balance = remainingAmount % AMOUNT;

        if (atm.getNoOfOneHundredNotes() < required) {
            balance += (required - atm.getNoOfOneHundredNotes()) * AMOUNT;
            atm.setPickedNoOfOneHundredNotes(atm.getNoOfOneHundredNotes()); // store the number of one hundred notes to be removed later for successful transaction.
//            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
        } else {
            atm.setPickedNoOfOneHundredNotes(required);// store the number of one hundred notes to be removed later for successful transaction.
//            atm.deductOneHundredNotes(required);
        }
        if (balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
