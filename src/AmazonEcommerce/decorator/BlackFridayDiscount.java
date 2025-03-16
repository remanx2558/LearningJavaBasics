package AmazonEcommerce.decorator;

import AmazonEcommerce.Stategies.PaymentStrategy;

public class BlackFridayDiscount extends DiscountDecorator {
    private double discountRate=0.25;
    public BlackFridayDiscount(PaymentStrategy strategy) {
        super(strategy);
    }
}
