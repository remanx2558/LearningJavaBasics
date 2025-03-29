package ShoppingCartCoupon;

public abstract class Coupen {
    String id;
    abstract void apply(CoupedCart cart);
    abstract void remove(CoupedCart cart);
}
