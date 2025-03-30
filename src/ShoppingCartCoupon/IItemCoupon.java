package ShoppingCartCoupon;

// Marker interface for item-level coupon logic
public interface IItemCoupon {
    /**
     * Applies item-level discount logic and returns the discounted price
     * for this specific item.
     */
    double applyDiscount(double originalPrice, Cart cart, CartItem item);
}