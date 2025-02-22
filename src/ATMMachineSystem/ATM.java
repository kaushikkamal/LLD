package ATMMachineSystem;

import ATMMachineSystem.ATMStates.ATMState;
import ATMMachineSystem.ATMStates.IdleState;

public class ATM {

    //    private static ATM atmObject = new ATM(); // Singleton: eager initialization
//    private ATM atmObject; // Singleton: eager initialization
    private ATMState currentATMState;
    private int atmBalance;
    private int noOfTwoThousandNotes;
    private int pickedNoOfTwoThousandNotes;
    private int noOfFiveHundredNotes;
    private int pickedNoOfFiveHundredNotes;
    private int noOfOneHundredNotes;
    private int pickedNoOfOneHundredNotes;

    public ATM() {
        this.currentATMState = new IdleState();
        this.pickedNoOfTwoThousandNotes = 0;
        this.pickedNoOfFiveHundredNotes = 0;
        this.pickedNoOfOneHundredNotes = 0;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public void printCurrentATMStatus() {
        System.out.println("Balance: " + atmBalance);
        System.out.println("2000 Notes: " + noOfTwoThousandNotes);
        System.out.println("500 Notes: " + noOfFiveHundredNotes);
        System.out.println("100 Notes: " + noOfOneHundredNotes);
    }

    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    //    public static ATM getAtmObject() {
//        return atmObject;
//    }
//
//    public static void setAtmObject(ATM atmObject) {
//        ATM.atmObject = atmObject;
//    }

    public ATMState getCurrentATMState() {
        return currentATMState;
    }

    public void setCurrentATMState(ATMState currentATMState) {
        this.currentATMState = currentATMState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public void setNoOfTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public int getPickedNoOfTwoThousandNotes() {
        return pickedNoOfTwoThousandNotes;
    }

    public void setPickedNoOfTwoThousandNotes(int pickedNoOfTwoThousandNotes) {
        this.pickedNoOfTwoThousandNotes = pickedNoOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public int getPickedNoOfFiveHundredNotes() {
        return this.pickedNoOfFiveHundredNotes;
    }

    public void setPickedNoOfFiveHundredNotes(int pickedNoOfFiveHundredNotes) {
        this.pickedNoOfFiveHundredNotes = pickedNoOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void setNoOfOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public int getPickedNoOfOneHundredNotes() {
        return pickedNoOfOneHundredNotes;
    }

    public void setPickedNoOfOneHundredNotes(int pickedNoOfOneHundredNotes) {
        this.pickedNoOfOneHundredNotes = pickedNoOfOneHundredNotes;
    }
}
