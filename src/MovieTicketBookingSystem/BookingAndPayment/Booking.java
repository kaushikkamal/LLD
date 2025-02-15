package MovieTicketBookingSystem.BookingAndPayment;

import MovieTicketBookingSystem.Theatre.Seat;
import MovieTicketBookingSystem.Theatre.Show;

import java.util.List;

public class Booking {
    private int bookingId;
    private Show bookedShow;
    private List<Seat> bookedSeats;
    private Payment payment;

    public Booking() {
    }

    public Booking(int bookingId, List<Seat> bookedSeats, Payment payment) {
        this.bookingId = bookingId;
        this.bookedSeats = bookedSeats;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookedShow=" + bookedShow +
                ", bookedSeats=" + bookedSeats +
                ", payment=" + payment +
                '}';
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Show getBookedShow() {
        return bookedShow;
    }

    public void setBookedShow(Show bookedShow) {
        this.bookedShow = bookedShow;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
