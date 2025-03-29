package ShoppingCartCoupon;

public class XDecreaseCoupen extends Coupen{

    double xpercent;
    XDecreaseCoupen(double xpercent){
        this.xpercent=xpercent;
    }


    @Override
    void apply(CoupedCart cart) {
        cart.allPercentDecrease= cart.allPercentDecrease+xpercent;
    }

    @Override
    void remove(CoupedCart cart) {
        cart.allPercentDecrease= cart.allPercentDecrease-xpercent;
    }
}
