package ZoomCar;

import java.util.ArrayList;
import java.util.List;

/**
 * NotificationService that maintains a list of observers
 * and notifies them when required.
 */
public class NotificationService {
    private List<NotificationObserver> observers;

    public NotificationService() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    public void notifyAll(Reservation reservation, String message) {
        for (NotificationObserver observer : observers) {
            observer.update(reservation, message);
        }
    }
}