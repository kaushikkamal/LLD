package CarRentalSystem.StoreManager;

import CarRentalSystem.Reservation.Reservation;
import CarRentalSystem.Reservation.ReservationStatus;
import CarRentalSystem.Store;
import CarRentalSystem.User;
import CarRentalSystem.Vehicle.Vehicle;
import CarRentalSystem.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class StoreManager implements StoreManagerInterface {
    private final List<Store> storeList;
    private final List<Reservation> reservationList;

    public StoreManager() {
        this.storeList = new ArrayList<>();
        this.reservationList = new ArrayList<>();
    }

    @Override
    public boolean addStore(Store newStore) {
        return storeList.add(newStore);
    }

    @Override
    public boolean removeStore(Store store) {
        return storeList.remove(store);
    }

    @Override
    public List<Store> searchForStores(String pinCode, VehicleType userPreferenceVehicleType) {
        List<Store> list = storeList.stream().filter((Store each) -> each.getStoreLocation().getPinCode().equals(pinCode)).filter((Store eachStore) -> eachStore.getInventoryManager().getAllVehicles().stream().anyMatch((Vehicle v) -> v.getVehicleType() == userPreferenceVehicleType))
//                .<Store>mapMulti((eachStore, consumer) -> {
//                    for (Vehicle eachVehicle : eachStore.getInventoryManager().getAllVehicles()) {
//                        if (eachVehicle.getVehicleType() == userPreferenceVehicleType) {
//                            consumer.accept(eachStore);
//                        }
//                    }
//                })
                .toList();
        return list;
    }

    @Override
    public Reservation createReservation(User user, Vehicle vehicle) {
        Reservation reservation = new Reservation();
        reservation.createReserve(user, vehicle);
        reservationList.add(reservation);
        return reservation;
    }

    @Override
    public boolean completeReservation(int reservationID) {
        Reservation particularReservation = reservationList.stream().filter(reservation -> reservation.getReservationId() == reservationID).toList().get(0);
        if (particularReservation != null) {
            particularReservation.setReservationStatus(ReservationStatus.COMPLETED);
            return true;
        }
        return false;
    }
}
