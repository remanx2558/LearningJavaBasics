package AmazonEcommerce.Stategies;

import AmazonEcommerce.UserAccount;
import AmazonEcommerce.enums.PaymentStatus;

public class CashOnDeliveryPayment implements PaymentStrategy{

    boolean moneyProvided;
    CashOnDeliveryPayment(boolean moneyProvided){
        this.moneyProvided=moneyProvided;
    }
    private boolean checksOnCOD(){
        return moneyProvided;
    }
    @Override
    public PaymentStatus pay(UserAccount sender, UserAccount receiver, int amount) {
        if(moneyProvided){ return PaymentStatus.SUCCESS;}
        return PaymentStatus.FAILED;
    }
}
