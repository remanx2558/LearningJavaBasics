package AmazonEcommerce.decorator;

import AmazonEcommerce.DiscountService;
import AmazonEcommerce.Stategies.PaymentStrategy;
import AmazonEcommerce.UserAccount;
import AmazonEcommerce.enums.PaymentStatus;


public class DiscountDecorator extends PaymentStrategyDecorator {
    public DiscountDecorator(PaymentStrategy strategy) {
        super(strategy);
    }

    @Override
    public PaymentStatus pay(UserAccount sender, UserAccount receiver, int amount) {
        // Check the discount from the service
        double discountRate = DiscountService.getDiscountRate();
        int discountedAmount = (int) (amount * (1 - discountRate));

        System.out.println("[DiscountDecorator] Original: " + amount
                + ", Discount Rate: " + discountRate
                + ", Final: " + discountedAmount);

        // Now pay using the wrapped strategy
        return wrappedPaymentStrategy.pay(sender, receiver, discountedAmount);
    }
}
