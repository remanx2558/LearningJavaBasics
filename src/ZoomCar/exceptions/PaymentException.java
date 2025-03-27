package ZoomCar.exceptions;


/**
 * Thrown when payment is invalid or fails for any reason.
 */
public class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}
