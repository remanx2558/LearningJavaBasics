package AmazonEcommerce.decorator;

import AmazonEcommerce.Stategies.PaymentStrategy;

public class ChristmanDiscount extends DiscountDecorator {
    private double discountRate=0.35;
    public ChristmanDiscount (PaymentStrategy strategy) {
        super(strategy);
    }
}