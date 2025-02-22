package ATMMachineSystem;

public class ATMDriver {
    public static void execute() {
        ATMRoom atmRoom = new ATMRoom();
        try {
            atmRoom.startTransactions();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
