package AmazonEcommerce.Stategies;

import AmazonEcommerce.UserAccount;
import AmazonEcommerce.enums.PaymentStatus;

public class CardPayment implements PaymentStrategy{

    String cardNumber;
    public CardPayment(String number){cardNumber=number;}

    @Override
    public PaymentStatus pay(UserAccount sender, UserAccount receiver, int amount) {
        //some card logic
        return PaymentStatus.SUCCESS;
    }
}
