package ZoomCar;


import ZoomCar.exceptions.PaymentException;
import ZoomCar.exceptions.VehicleNotAvailableException;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ZoomCarSystemDemo {
    public static void main(String[] args) {

        /* -----------------------------------------------------------
         *  SETUP: OWNERS, STORES, VEHICLES
         * ----------------------------------------------------------- */
        Owner owner = new Owner("owner1", "Alice", "alice@zoomcar.com");
        Store store1 = new Store("store1", new Location("Noida", "Sector 18"));
        Store store2 = new Store("store2", new Location("Delhi", "Connaught Place"));
        owner.addStore(store1);
        owner.addStore(store2);

        // Create vehicles
        Vehicle car1 = new Car("CAR001", "Hyundai", "i20", 1200, false, 100.0, 8.0);
        Vehicle car2 = new Car("CAR002", "Tesla", "Model 3", 0, true, 200.0, 10.0);
        Vehicle bike1 = new Bike("BIKE001", "Honda", "Shine", 125, false, 50.0, 3.0);

        // Add them to store1
        store1.addVehicle(car1);
        store1.addVehicle(car2);
        store1.addVehicle(bike1);

        // Another vehicle in store2
        Vehicle bike2 = new Bike("BIKE002", "RoyalEnfield", "Classic", 350, false, 80.0, 4.0);
        store2.addVehicle(bike2);

        // Notification service + observers
        NotificationService notificationService = new NotificationService();
        notificationService.addObserver(new CustomerNotificationObserver());
        notificationService.addObserver(new OwnerNotificationObserver());

        // Payment & Reservation services
        PaymentService paymentService = new PaymentService();
        ReservationService reservationService = new ReservationService(notificationService, paymentService);

        // For searching
        SearchService searchService = new SearchService();
        List<Store> allStores = new ArrayList<>();
        allStores.add(store1);
        allStores.add(store2);

        // For store owners to manage vehicles if needed
        VehicleManagementService vehicleMgmtService = new VehicleManagementService();

        // A sample customer
        Customer customer = new Customer("cust1", "Bob", "bob@example.com");

        /* -----------------------------------------------------------
         *  USE CASE #1: Search for a Bike but do NOT pick any
         * ----------------------------------------------------------- */
        System.out.println("\n=== USE CASE 1: Searching for a Bike, not reserving ===");
        // Simple approach: search store by location, then filter
        List<Vehicle> vehiclesInNoida = searchService.searchByLocation(allStores, "Noida");
        System.out.println("Vehicles found in Noida: " + vehiclesInNoida.size());

        // Let's filter only bikes
        List<Vehicle> bikesInNoida = new ArrayList<>();
        for (Vehicle v : vehiclesInNoida) {
            if (v.getVehicleType() == VehicleType.BIKE) {
                bikesInNoida.add(v);
            }
        }

        if (!bikesInNoida.isEmpty()) {
            System.out.println("List of bikes in Noida:");
            for (Vehicle bike : bikesInNoida) {
                System.out.println("- " + bike.getVehicleId() + " : " + bike.getBrand() + " " + bike.getModel());
            }
            // The user does NOT reserve any bike
            System.out.println("User decided NOT to reserve a bike.");
        } else {
            System.out.println("No bikes found in Noida location.");
        }

        /* -----------------------------------------------------------
         *  USE CASE #2: Search for a Car and actually pick (reserve)
         * ----------------------------------------------------------- */
        System.out.println("\n=== USE CASE 2: Search for Car in Noida, pick one ===");
        List<Vehicle> carsInNoida = new ArrayList<>();
        for (Vehicle v : vehiclesInNoida) {
            if (v.getVehicleType() == VehicleType.CAR) {
                carsInNoida.add(v);
            }
        }
        if (carsInNoida.isEmpty()) {
            System.out.println("No cars found in Noida store!");
        } else {
            System.out.println("Cars in Noida: ");
            for (Vehicle c : carsInNoida) {
                System.out.println(" - " + c.getVehicleId() + " : " + c.getBrand() + " " + c.getModel());
            }
        }

        // We'll pick car1 for demonstration: Hourly cost strategy
        try {
            Reservation hourlyReservation = reservationService.reserveVehicle(
                    car1,
                    customer,
                    LocalDateTime.now().plusHours(1),    // Start in 1 hour
                    LocalDateTime.now().plusHours(5),    // End in 5 hours
                    5000.0,                              // startOdometer
                    new CostByHourStrategy(),
                    null // do not pay now
            );
            System.out.println("\nReserved Car1 (Hourly). Reservation ID: " + hourlyReservation.getReservationId());

            // Pick it up
            reservationService.pickUpVehicle(hourlyReservation.getReservationId());

            // Drop off at the exact time
            reservationService.dropOffVehicle(
                    hourlyReservation.getReservationId(),
                    5100.0, // endOdometer (won't matter for hourly)
                    new CashPaymentStrategy()
            );

        } catch (VehicleNotAvailableException | PaymentException e) {
            System.out.println("Exception while reserving or paying for car1: " + e.getMessage());
        }

        /* -----------------------------------------------------------
         *  USE CASE #3: Reserve a vehicle that's already UNAVAILABLE
         * ----------------------------------------------------------- */
        System.out.println("\n=== USE CASE 3: Attempt to reserve an unavailable vehicle ===");
        // Let's forcibly make car2 "unavailable" to simulate the scenario
        car2.setAvailable(false);
        try {
            Reservation res = reservationService.reserveVehicle(
                    car2,
                    customer,
                    LocalDateTime.now().plusHours(2),
                    LocalDateTime.now().plusHours(3),
                    10000.0,
                    new CostByKmStrategy(),
                    null
            );
            System.out.println("Reservation succeeded? Should not happen here if vehicle is forced unavailable!");
        } catch (VehicleNotAvailableException e) {
            System.out.println("Expected failure: " + e.getMessage());
        } catch (PaymentException e) {
            e.printStackTrace();
        }
        // Mark it available again for future scenarios
        car2.setAvailable(true);

        /* -----------------------------------------------------------
         *  USE CASE #4: Cancel a reservation BEFORE the start time
         * ----------------------------------------------------------- */
        System.out.println("\n=== USE CASE 4: Reserve and then cancel BEFORE start time ===");
        Reservation cancelableReservation = null;
        try {
            cancelableReservation = reservationService.reserveVehicle(
                    car2,
                    customer,
                    LocalDateTime.now().plusHours(2),
                    LocalDateTime.now().plusHours(6),
                    10000.0,
                    new CostByKmStrategy(),
                    null
            );
            System.out.println("Created reservation for Car2. ID: " + cancelableReservation.getReservationId());

            // Cancel it before the start
            reservationService.cancelReservation(cancelableReservation.getReservationId());
            System.out.println("Reservation canceled successfully.");

            // Attempt to pick up the canceled reservation
            reservationService.pickUpVehicle(cancelableReservation.getReservationId());
            System.out.println("If you see this, picking up a canceled reservation was allowed? Check the code logic!");
        } catch (VehicleNotAvailableException | PaymentException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        /* -----------------------------------------------------------
         *  USE CASE #5: Drop off the vehicle EARLY
         * ----------------------------------------------------------- */
        System.out.println("\n=== USE CASE 5: Reserve and drop off early ===");
        try {
            // Re-reserve car2
            Reservation earlyDropReservation = reservationService.reserveVehicle(
                    car2,
                    customer,
                    LocalDateTime.now().plusHours(1),
                    LocalDateTime.now().plusHours(10),   // big end-time
                    12000.0,
                    new CostByHourStrategy(),
                    null
            );
            System.out.println("Reserved Car2 with endTime in 10 hours. ID: "
                    + earlyDropReservation.getReservationId());

            // Pretend 2 hours pass, now drop off (i.e., early)
            // We do it right away so effectively it is early.
            reservationService.dropOffVehicle(
                    earlyDropReservation.getReservationId(),
                    12500.0,
                    new CashPaymentStrategy()
            );
            System.out.println("Dropped off Car2 early; user still pays for total hours so far (or min hour).");

        } catch (VehicleNotAvailableException | PaymentException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        /* -----------------------------------------------------------
         *  USE CASE #6: Pay partially at reservation time, then top-up at drop-off
         *               for a KMs-based strategy
         * ----------------------------------------------------------- */
        System.out.println("\n=== USE CASE 6: Partial payment at reservation & final payment at drop-off (KM-based) ===");
        try {
            // Reserve bike1 with KMs-based strategy, pay partially at reservation
            Reservation bikeReservation = reservationService.reserveVehicle(
                    bike1,
                    customer,
                    LocalDateTime.now().plusMinutes(30), // start in 30 min
                    LocalDateTime.now().plusHours(3),
                    20000.0, // odometer start
                    new CostByKmStrategy(),
                    new CardPaymentStrategy("1234-xxxx-xxxx-9999") // pay now
            );
            System.out.println("Reserved Bike1 (KMs-based). ID: " + bikeReservation.getReservationId());

            // Pick up the bike
            reservationService.pickUpVehicle(bikeReservation.getReservationId());

            // Suppose user drives 80 km total
            reservationService.dropOffVehicle(
                    bikeReservation.getReservationId(),
                    20080.0,
                    new UpiPaymentStrategy("bob@upi") // final top-up
            );
            System.out.println("User dropped off the bike. Paid final cost.");

        } catch (VehicleNotAvailableException e) {
            System.out.println("Vehicle not available: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Payment exception: " + e.getMessage());
        }

        /* -----------------------------------------------------------
         *  USE CASE #7: Attempt invalid payment details
         * ----------------------------------------------------------- */
        System.out.println("\n=== USE CASE 7: Attempt to pay with invalid payment details ===");
        try {
            // We directly call PaymentService to show how a PaymentException might be thrown
            paymentService.payAmount(500.0, new CardPaymentStrategy("INVALID-CARD"));
            System.out.println("Payment went through with invalid card? Check your PaymentStrategy logic!");
        } catch (PaymentException e) {
            System.out.println("Expected payment failure: " + e.getMessage());
        }

        /* -----------------------------------------------------------
         *  USE CASE #8: Searching by filter (e.g., brand = "Hyundai")
         * ----------------------------------------------------------- */
        System.out.println("\n=== USE CASE 8: Searching by brand filter (Hyundai) in Noida ===");
        // Use the applyFilters approach
        List<VehicleFilter> filters = new ArrayList<>();
        filters.add(new BrandFilter("Hyundai"));
        List<Vehicle> hyundaiVehicles = searchService.applyFilters(vehiclesInNoida, filters);

        if (hyundaiVehicles.isEmpty()) {
            System.out.println("No Hyundai vehicles found in Noida!");
        } else {
            System.out.println("Found these Hyundai vehicles in Noida:");
            for (Vehicle v : hyundaiVehicles) {
                System.out.println("- " + v.getVehicleId() + " : " + v.getBrand() + " " + v.getModel());
            }
        }

        /* -----------------------------------------------------------
         *  USE CASE #9: Owner modifies a vehicle
         * ----------------------------------------------------------- */
        System.out.println("\n=== USE CASE 9: Owner modifies a vehicle's details ===");
        vehicleMgmtService.modifyVehicle(
                bike1,
                "Honda-New",
                "CBR125",
                125,
                true // electric
        );
        System.out.println("Bike1 is now electric? (Pretend the code has updated all relevant fields).");

        /* -----------------------------------------------------------
         *  USE CASE #10: Search in location with no results
         * ----------------------------------------------------------- */
        System.out.println("\n=== USE CASE 10: Search in unknown location (e.g., Gurugram) ===");
        List<Vehicle> gurugramVehicles = searchService.searchByLocation(allStores, "Gurugram");
        if (gurugramVehicles.isEmpty()) {
            System.out.println("No vehicles found in Gurugram!");
        } else {
            System.out.println("Found vehicles in Gurugram? " + gurugramVehicles.size());
        }

        System.out.println("\n=== END OF DEMO ===");
    }
}
