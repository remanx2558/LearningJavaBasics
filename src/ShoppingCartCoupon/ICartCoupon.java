package ShoppingCartCoupon;

// Marker interface for cart-level coupon logic
public interface ICartCoupon {
    /**
     * Applies cart-level discount logic and returns a discounted total
     * for the entire cart.
     */
    double applyDiscount(double originalTotal, Cart cart);
}
