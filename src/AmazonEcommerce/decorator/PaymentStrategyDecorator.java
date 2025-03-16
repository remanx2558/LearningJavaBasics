package AmazonEcommerce.decorator;

import AmazonEcommerce.UserAccount;
import AmazonEcommerce.Stategies.PaymentStrategy;
import AmazonEcommerce.enums.PaymentStatus;

public abstract class PaymentStrategyDecorator implements PaymentStrategy {
    protected PaymentStrategy wrappedPaymentStrategy;

    public PaymentStrategyDecorator(PaymentStrategy strategy) {
        this.wrappedPaymentStrategy = strategy;
    }

    // Delegate pay by default
    @Override
    public PaymentStatus pay(UserAccount sender, UserAccount receiver, int amount) {
        return wrappedPaymentStrategy.pay(sender, receiver, amount);
    }
}