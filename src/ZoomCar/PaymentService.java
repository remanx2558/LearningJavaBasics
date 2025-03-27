package ZoomCar;

import ZoomCar.exceptions.PaymentException;

public class PaymentService {

    /**
     * Pay an arbitrary amount using the provided PaymentStrategy.
     * Could keep track of total paid, partial payments, etc.
     */
    public void payAmount(double amount, PaymentStrategy paymentStrategy) throws PaymentException {
        if (amount < 0) {
            throw new PaymentException("Invalid payment amount: " + amount);
        }
        paymentStrategy.pay(amount);
    }
}
