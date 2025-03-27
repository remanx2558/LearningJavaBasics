package ZoomCar.exceptions;


/**
 * Base custom exception for the ZoomCar system.
 */
public class ZoomCarException extends RuntimeException {
    public ZoomCarException(String message) {
        super(message);
    }

    public ZoomCarException(String message, Throwable cause) {
        super(message, cause);
    }
}
