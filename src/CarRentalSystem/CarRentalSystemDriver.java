package CarRentalSystem;

import CarRentalSystem.Reservation.Reservation;
import CarRentalSystem.StoreManager.StoreManager;
import CarRentalSystem.StoreManager.StoreManagerInterface;
import CarRentalSystem.Vehicle.Vehicle;
import CarRentalSystem.Vehicle.VehicleType;

import java.util.List;

public class CarRentalSystemDriver {
    public static void execute() {
        // Vehicle create
        Vehicle v1 = new Vehicle(1, 1234, VehicleType.BIKE);
        Vehicle v2 = new Vehicle(2, 9876, VehicleType.CAR);
        Vehicle v3 = new Vehicle(3, 5656, VehicleType.CAR);

        // Store create
        StoreManagerInterface storeManager = new StoreManager();
        Store s1 = new Store(1, new Location(1, "Bengaluru", "500501"));
        s1.getInventoryManager().addVehicle(v1);
        s1.getInventoryManager().addVehicle(v2);

        Store s2 = new Store(2, new Location(2, "Kolkata", "700100"));
        s2.getInventoryManager().addVehicle(v3);

        storeManager.addStore(s1);
        storeManager.addStore(s2);

        // user comes to search with location
        User u1 = new User(1, "KKB", "1234");

        // get All vehicles you are interested in (based upon different filters)
//        String userPinCode = "1234";
        String userPinCode = "500501";
        VehicleType userCarPreference = VehicleType.CAR;
        List<Store> filteredStoreList = storeManager.searchForStores(userPinCode, userCarPreference);
        System.out.println("filteredStoreList: " + filteredStoreList);
        if (filteredStoreList.isEmpty()) {
            System.out.println("No store available");
            return;
        }

//        System.out.println(filteredStoreList);

        //reserving the particular vehicle
        Vehicle selectedVehicle = filteredStoreList.get(0).getInventoryManager().getAllVehicles().get(0);
        Reservation reservation = storeManager.createReservation(u1, selectedVehicle);

        //generate the bill
        Bill bill = new Bill(reservation);

        System.out.println(bill);

        // payment
        Payment payment = new Payment();
        payment.payBill(bill);

//        trip completed, submit the vehicle and close the reservation
        storeManager.completeReservation(reservation.getReservationId());
    }
}
