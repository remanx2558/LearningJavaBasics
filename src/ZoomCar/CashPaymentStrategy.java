package ZoomCar;


import ZoomCar.exceptions.PaymentException;

/** Concrete payment strategy: Cash */
public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) throws PaymentException {
        // In a real system, you'd track it as "paid via cash"
        System.out.println("Payment of " + amount + " done by Cash.");
    }
}