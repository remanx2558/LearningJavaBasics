package ZoomCar;

import ZoomCar.exceptions.PaymentException;

public interface PaymentStrategy {
    void pay(double amount) throws PaymentException;
}