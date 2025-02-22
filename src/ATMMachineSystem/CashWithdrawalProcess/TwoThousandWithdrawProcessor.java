package ATMMachineSystem.CashWithdrawalProcess;

import ATMMachineSystem.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawalProcess {

    private static final int AMOUNT = 2000;

    public TwoThousandWithdrawProcessor(CashWithdrawalProcess nextCashWithdrawalProcess) {
        super(nextCashWithdrawalProcess);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) throws Exception {
        int required = remainingAmount / AMOUNT;
        int balance = remainingAmount % AMOUNT;

        if (atm.getNoOfTwoThousandNotes() < required) {
            balance += (required - atm.getNoOfTwoThousandNotes()) * AMOUNT;
            atm.setPickedNoOfTwoThousandNotes(atm.getNoOfTwoThousandNotes()); // store the number of two thousand notes to be removed later for successful transaction.
//            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
        } else {
            atm.setPickedNoOfTwoThousandNotes(required); // store the number of two thousand notes to be removed later for successful transaction.
//            atm.deductTwoThousandNotes(required);
        }
        if (balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
