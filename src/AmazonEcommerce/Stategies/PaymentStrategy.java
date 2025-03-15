package AmazonEcommerce.Stategies;

import AmazonEcommerce.UserAccount;

public interface PaymentStrategy {
    public boolean pay(UserAccount sender, UserAccount receiver, int amount);
}
