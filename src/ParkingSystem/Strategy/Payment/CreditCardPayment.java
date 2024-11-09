package ParkingSystem.Strategy.Payment;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(int amount) {
        // Logic to process credit card payment
        System.out.println("Processing credit card payment of amount: " + amount);
    }
}

