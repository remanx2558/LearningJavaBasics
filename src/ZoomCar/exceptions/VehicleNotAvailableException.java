package ZoomCar.exceptions;

/**
 * Thrown when a user tries to book a vehicle that isn't available
 * for the specified time range or is otherwise not in AVAILABLE state.
 */
public class VehicleNotAvailableException extends ZoomCarException {
    public VehicleNotAvailableException(String message) {
        super(message);
    }

    public VehicleNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
