package ZoomCar;

import ZoomCar.exceptions.PaymentException;

/** Concrete payment strategy: Card */
public class CardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;

    public CardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) throws PaymentException {
        // Validate card info, process transaction
        System.out.println("Payment of " + amount + " done by Card: " + cardNumber);
    }
}
