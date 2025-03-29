package ShoppingCartCoupon;

public class PPercentOffOnNextItem extends CouponedItem {

    double pPercent;
    PPercentOffOnNextItem(CouponedItem basItem, double pPercent) {
        super(basItem);
        this.pPercent=pPercent;
    }
}


//sequence of item added in cart matters: seems to
//Nth item of Type T has D% off: seems to be an effect on cart, tracking items of each type and order
//Coupouns are related to products
//List itema have


//seems to be related to list of items of chart
// final price using an function
