package ATMMachineSystem;

public class UserBankAccount {
    private int balance;

    public UserBankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdrawMoney(int amount) {
        this.balance -= amount;
    }
}
