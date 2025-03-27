package ZoomCar.exceptions;

/**
 * Thrown when a payment process fails or
 * the status is marked as PaymentStatus.FAILED.
 */
public class PaymentFailedException extends ZoomCarException {
    public PaymentFailedException(String message) {
        super(message);
    }

    public PaymentFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
