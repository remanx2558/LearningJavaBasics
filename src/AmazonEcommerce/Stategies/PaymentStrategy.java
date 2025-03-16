package AmazonEcommerce.Stategies;

import AmazonEcommerce.UserAccount;
import AmazonEcommerce.enums.PaymentStatus;

public interface PaymentStrategy {
    public PaymentStatus pay(UserAccount sender, UserAccount receiver, int amount);
}
