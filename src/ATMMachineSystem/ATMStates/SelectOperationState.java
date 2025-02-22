package ATMMachineSystem.ATMStates;

import ATMMachineSystem.ATM;
import ATMMachineSystem.Card;
import ATMMachineSystem.TransactionType;

public class SelectOperationState extends ATMState {
    public SelectOperationState() {
        System.out.println("ATM in SelectOperation State");
//        showOperations();
    }

    private void showOperations() {
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        switch (txnType) {
            case WITHDRAWAL: {
                atm.setCurrentATMState(new CashWithdrawalState());
                break;
            }
            case BALANCE_CHECK: {
                atm.setCurrentATMState(new CheckBalanceState());
                break;
            }
            default: {
                System.out.println("Invalid Option");
                exit(atm);
            }
        }
    }
}
