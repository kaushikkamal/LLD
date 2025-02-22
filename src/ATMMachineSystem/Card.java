package ATMMachineSystem;

public class Card {
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private String holderName;
    private int pinNumber = 112211;
    //    static int PIN_NUMBER = 112211;
    private UserBankAccount bankAccount;

    public Card() {
    }

    public Card(int cardNumber, int cvv, String holderName, int pinNumber, UserBankAccount bankAccount) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.holderName = holderName;
        this.pinNumber = pinNumber;
        this.bankAccount = bankAccount;
    }

    public boolean isCorrectPINEntered(int pin) {
        return this.pinNumber == pin;
    }


//    public static int getPinNumber() {
//        return PIN_NUMBER;
//    }
//
//    public static void setPinNumber(int pinNumber) {
//        PIN_NUMBER = pinNumber;
//    }


    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public UserBankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(UserBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
