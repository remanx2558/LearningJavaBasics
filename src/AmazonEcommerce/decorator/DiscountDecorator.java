package AmazonEcommerce.decorator;

import AmazonEcommerce.Stategies.PaymentStrategy;
import AmazonEcommerce.UserAccount;
import AmazonEcommerce.enums.PaymentStatus;


public class DiscountDecorator implements PaymentStrategy {

    private double discountRate=0.0;
    private PaymentStrategy wrappedDiscountStrategy;

    public DiscountDecorator(PaymentStrategy strategy) {
        wrappedDiscountStrategy=strategy;
    }

    @Override
    public PaymentStatus pay(UserAccount sender, UserAccount receiver, int amount) {
        // Check the discount from the service
        int discountedAmount = (int) (amount * (1 - discountRate));

        System.out.println("[DiscountDecorator] Original: " + amount
                + ", Discount Rate: " + discountRate
                + ", Final: " + discountedAmount);

        // Now pay using the wrapped strategy
        return wrappedDiscountStrategy.pay(sender, receiver, discountedAmount);
    }
}
