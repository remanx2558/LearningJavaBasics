package ZoomCar;

import ZoomCar.exceptions.PaymentException;
import ZoomCar.exceptions.VehicleNotAvailableException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ReservationService {
    private Map<String, Reservation> reservationMap;
    private NotificationService notificationService;
    private PaymentService paymentService; // if we want to pay at reservation time

    public ReservationService(NotificationService notificationService,
                              PaymentService paymentService) {
        this.reservationMap = new HashMap<>();
        this.notificationService = notificationService;
        this.paymentService = paymentService;
    }

    /**
     * Reserve a vehicle for a given time range.
     * Optionally pay now if a payment strategy is provided.
     */
    public Reservation reserveVehicle(Vehicle vehicle,
                                      Customer customer,
                                      LocalDateTime startTime,
                                      LocalDateTime endTime,
                                      double startOdometerReading,
                                      CostCalculationStrategy costCalculationStrategy,
                                      PaymentStrategy payNowStrategy)
            throws VehicleNotAvailableException, PaymentException {

        if (!vehicle.isAvailable()) {
            throw new VehicleNotAvailableException("Vehicle " + vehicle.getVehicleId() + " is not available.");
        }

        // Mark vehicle unavailable, create reservation
        vehicle.setAvailable(false);
        String reservationId = UUID.randomUUID().toString();

        Reservation reservation = new Reservation(
                reservationId,
                customer,
                vehicle,
                startTime,
                endTime,
                startOdometerReading,
                costCalculationStrategy
        );
        reservationMap.put(reservationId, reservation);

        // Notify
        notificationService.notifyAll(reservation, "Vehicle reserved from " + startTime + " to " + endTime);

        // If user wants to pay at reservation time
        if (payNowStrategy != null) {
            // We do a preliminary cost calculation (endTime and endOdometer are not final yet).
            double cost = reservation.calculateCost();
            paymentService.payAmount(cost, payNowStrategy);
            // The user paid a preliminary or estimated cost upfront
            notificationService.notifyAll(reservation,
                    "Payment of " + cost + " done at reservation time.");
        }

        return reservation;
    }

    public void cancelReservation(String reservationId) {
        Reservation reservation = reservationMap.get(reservationId);
        if (reservation != null && reservation.isActive()) {
            reservation.cancel();
            reservation.getVehicle().setAvailable(true);
            notificationService.notifyAll(reservation, "Reservation has been canceled.");
        }
    }

    public void pickUpVehicle(String reservationId) {
        Reservation reservation = reservationMap.get(reservationId);
        if (reservation != null && reservation.isActive()) {
            notificationService.notifyAll(reservation, "Customer has picked up the vehicle.");
        }
    }

    /**
     * On drop-off, set end odometer reading (for KM-based strategy),
     * recalc cost if needed, pay final if not already done, and release vehicle.
     */
    public void dropOffVehicle(String reservationId,
                               double endOdometerReading,
                               PaymentStrategy dropOffPaymentStrategy)
            throws PaymentException {
        Reservation reservation = reservationMap.get(reservationId);
        if (reservation != null && reservation.isActive()) {
            // set final odometer reading
            reservation.setEndOdometerReading(endOdometerReading);

            // If user is dropping early, you might also set endTime = LocalDateTime.now()
            reservation.setEndTime(java.time.LocalDateTime.now());

            // Re-calc final cost
            double finalCost = reservation.calculateCost();

            // If the user hasn't already fully paid, pay now
            // (In a real system, you'd store partial or advanced payments,
            //  but we'll keep it simple.)
            if (dropOffPaymentStrategy != null) {
                paymentService.payAmount(finalCost, dropOffPaymentStrategy);
                notificationService.notifyAll(reservation,
                        "Paid final cost of " + finalCost + " at drop-off.");
            }

            // Mark vehicle free
            reservation.getVehicle().setAvailable(true);
            reservation.cancel(); // effectively ends the reservation

            notificationService.notifyAll(reservation, "Vehicle has been dropped off.");
        }
    }
}
