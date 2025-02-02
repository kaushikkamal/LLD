package CarRentalSystem.Reservation;

import CarRentalSystem.Location;
import CarRentalSystem.User;
import CarRentalSystem.Vehicle.Vehicle;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private User user;
    private Vehicle vehicle;
    private Date bookingDate;
    private Date dateBookedFrom;
    private Date dateBookedTo;
    private Long fromTimeStamp;
    private Long toTimeStamp;
    private Location pickUpLocation;
    private Location dropLocation;
    private ReservationType reservationType;
    private ReservationStatus reservationStatus;
    private Location location;

    public Reservation() {
    }

    public int createReserve(User user, Vehicle vehicle) {
        //generate new id
        reservationId = 12232;
        this.user = user;
        this.vehicle = vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;
        return reservationId;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", user=" + user +
                ", vehicle=" + vehicle +
                ", reservationType=" + reservationType +
                ", reservationStatus=" + reservationStatus +
                '}';
    }

    public Reservation(int reservationId, User user, Vehicle vehicle, Date bookingDate, Date dateBookedFrom, Date dateBookedTo, Long fromTimeStamp, Long toTimeStamp, Location pickUpLocation, Location dropLocation, ReservationType reservationType, ReservationStatus reservationStatus, Location location) {
        this.reservationId = reservationId;
        this.user = user;
        this.vehicle = vehicle;
        this.bookingDate = bookingDate;
        this.dateBookedFrom = dateBookedFrom;
        this.dateBookedTo = dateBookedTo;
        this.fromTimeStamp = fromTimeStamp;
        this.toTimeStamp = toTimeStamp;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
        this.reservationType = reservationType;
        this.reservationStatus = reservationStatus;
        this.location = location;
    }

    public int getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Date getDateBookedFrom() {
        return dateBookedFrom;
    }

    public Date getDateBookedTo() {
        return dateBookedTo;
    }

    public Long getFromTimeStamp() {
        return fromTimeStamp;
    }

    public Long getToTimeStamp() {
        return toTimeStamp;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public Location getLocation() {
        return location;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setDateBookedFrom(Date dateBookedFrom) {
        this.dateBookedFrom = dateBookedFrom;
    }

    public void setDateBookedTo(Date dateBookedTo) {
        this.dateBookedTo = dateBookedTo;
    }

    public void setFromTimeStamp(Long fromTimeStamp) {
        this.fromTimeStamp = fromTimeStamp;
    }

    public void setToTimeStamp(Long toTimeStamp) {
        this.toTimeStamp = toTimeStamp;
    }

    public void setPickUpLocation(Location pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
