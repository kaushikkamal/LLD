package CarRentalSystem.StoreManager;

import CarRentalSystem.Reservation.Reservation;
import CarRentalSystem.Store;
import CarRentalSystem.User;
import CarRentalSystem.Vehicle.Vehicle;
import CarRentalSystem.Vehicle.VehicleType;

import java.util.List;

public interface StoreManagerInterface {
    public boolean addStore(Store newStore);

    public boolean removeStore(Store store);

    public List<Store> searchForStores(String pinCode, VehicleType vehicleType);

    public Reservation createReservation(User user, Vehicle vehicle);

    public boolean completeReservation(int reservationID);
}
