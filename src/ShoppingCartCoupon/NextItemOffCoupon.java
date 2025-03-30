package ShoppingCartCoupon;

/**
 * This coupon is triggered once for the next item added to the cart.
 * Then it might remove itself or remain (depending on business logic).
 */
public class NextItemOffCoupon implements IItemCoupon {
    private double percentOff;

    public NextItemOffCoupon(double percentOff) {
        this.percentOff = percentOff;
    }

    @Override
    public double applyDiscount(double originalPrice, Cart cart, CartItem item) {
        double discount = originalPrice * (percentOff / 100.0);
        return originalPrice - discount;
    }

    // Additional logic can be added if the coupon is single-use:
    // e.g., once applied, remove it from the cart’s list or from the item’s list.
}