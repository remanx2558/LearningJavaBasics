package ZoomCar;

/**
 * Concrete observer for the Customer side.
 */
public class CustomerNotificationObserver implements NotificationObserver {
    @Override
    public void update(Reservation reservation, String message) {
        System.out.println("[Customer Notification] ReservationID " + reservation.getReservationId()
                + ": " + message + " to Customer " + reservation.getCustomer().getEmail());
    }
}