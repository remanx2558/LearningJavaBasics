package ParkingSystem.Exception;

public class ParkingSystemException extends Exception {
    public ParkingSystemException(String message) {
        super(message);
    }

    public ParkingSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}