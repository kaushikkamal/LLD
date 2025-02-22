package ATMMachineSystem.ATMStates;

import ATMMachineSystem.ATM;
import ATMMachineSystem.Card;
import ATMMachineSystem.CashWithdrawalProcess.CashWithdrawalProcess;
import ATMMachineSystem.CashWithdrawalProcess.FiveHundredWithdrawProcessor;
import ATMMachineSystem.CashWithdrawalProcess.OneHundredWithdrawProcessor;
import ATMMachineSystem.CashWithdrawalProcess.TwoThousandWithdrawProcessor;

public class CashWithdrawalState extends ATMState {
    public CashWithdrawalState() {
        System.out.println("ATM in CashWithdrawal State");
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) throws Exception {
        if (atm.getAtmBalance() < withdrawAmount) {
            System.out.println("Insufficient fund in the ATM Machine");
            super.exit(atm);
        } else if (card.getBankAccount().getBalance() < withdrawAmount) {
            System.out.println("Insufficient fund in your Back account");
            super.exit(atm);
        } else {
            // withdraw amount
            CashWithdrawalProcess withdrawProcessor = new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
            try {
                withdrawProcessor.withdraw(atm, withdrawAmount);

                // successful transaction, so decrement the amounts
                card.getBankAccount().withdrawMoney(withdrawAmount); // deduct money from user's account
                atm.deductATMBalance(withdrawAmount); // deduct money from atm

                atm.deductTwoThousandNotes(atm.getPickedNoOfTwoThousandNotes()); // deduct picked number of 2000 note from atm
                atm.deductFiveHundredNotes(atm.getPickedNoOfFiveHundredNotes()); // deduct picked number of 500 note from atm
                atm.deductOneHundredNotes(atm.getPickedNoOfOneHundredNotes()); // deduct picked number of 100 note from atm

                System.out.println("Transaction successful");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                super.exit(atm);
            }
        }
    }
}
