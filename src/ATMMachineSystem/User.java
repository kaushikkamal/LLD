package ATMMachineSystem;

public class User {
    private Card card;
    private UserBankAccount bankAccount;

    public User(Card card, UserBankAccount bankAccount) {
        this.card = card;
        this.bankAccount = bankAccount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
