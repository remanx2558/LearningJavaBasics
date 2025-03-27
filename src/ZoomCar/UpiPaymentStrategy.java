package ZoomCar;

import ZoomCar.exceptions.PaymentException;

/** Concrete payment strategy: UPI */
public class UpiPaymentStrategy implements PaymentStrategy {
    private String upiId;

    public UpiPaymentStrategy(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) throws PaymentException {
        // Validate UPI, process transaction
        System.out.println("Payment of " + amount + " done by UPI: " + upiId);
    }
}
