package ZoomCar;

public class OwnerNotificationObserver implements NotificationObserver {
    @Override
    public void update(Reservation reservation, String message) {
        // Typically you'd figure out which store/owner is relevant
        System.out.println("[Owner Notification] ReservationID " + reservation.getReservationId()
                + ": " + message + " to Owner of Vehicle " + reservation.getVehicle().getVehicleId());
    }
}