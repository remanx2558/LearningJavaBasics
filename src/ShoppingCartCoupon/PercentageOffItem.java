package ShoppingCartCoupon;

/**
 * Applies a percentage discount to the item price.
 * This can be added to each CartItem (like a global item-level discount).
 */
public class PercentageOffItem implements IItemCoupon {
    private double percentOff; // e.g. 10 means 10%

    public PercentageOffItem(double percentOff) {
        this.percentOff = percentOff;
    }

    @Override
    public double applyDiscount(double originalPrice, Cart cart, CartItem item) {
        double discount = originalPrice * (percentOff / 100.0);
        return originalPrice - discount;
    }
}