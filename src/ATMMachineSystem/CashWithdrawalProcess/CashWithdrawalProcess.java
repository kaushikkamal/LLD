package ATMMachineSystem.CashWithdrawalProcess;

import ATMMachineSystem.ATM;

public abstract class CashWithdrawalProcess {
    CashWithdrawalProcess nextCashWithdrawalProcess;

    public CashWithdrawalProcess(CashWithdrawalProcess nextCashWithdrawalProcess) {
        this.nextCashWithdrawalProcess = nextCashWithdrawalProcess;
    }

    public void withdraw(ATM atm, int remainingAmount) throws Exception {
        if (nextCashWithdrawalProcess == null) {
            throw new Exception("Cannot fulfill the amount");
        }
        nextCashWithdrawalProcess.withdraw(atm, remainingAmount);
    }
}
