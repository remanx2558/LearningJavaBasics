package AmazonEcommerce.Stategies;

import AmazonEcommerce.UserAccount;

public class CashOnDeliveryPayment implements PaymentStrategy{
    @Override
    public boolean pay(UserAccount sender, UserAccount receiver, int amount) {
        return true;
    }
}
