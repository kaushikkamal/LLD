package CarRentalSystem;

import CarRentalSystem.Reservation.Reservation;

public class Bill {
    private final Reservation reservation;
    private final double totalBillAmount;
    private final boolean isBillPaid;

    @Override
    public String toString() {
        return "Bill{" +
                "reservation=" + reservation +
                ", totalBillAmount=" + totalBillAmount +
                ", isBillPaid=" + isBillPaid +
                '}';
    }

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.totalBillAmount = computeBillAmount();
        this.isBillPaid = false;
    }

    private double computeBillAmount() {
        return 100.0;
    }

}
