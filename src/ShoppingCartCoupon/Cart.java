package ShoppingCartCoupon;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    private List<ICartCoupon> cartCoupons = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
        // Optionally notify or attach "NextItemOffCoupon" if needed
    }

    public void removeItem(CartItem item) {
        items.remove(item);
    }

    public List<CartItem> getItems() {
        return items;
    }

    // Cart-level coupons
    public void addCartCoupon(ICartCoupon coupon) {
        cartCoupons.add(coupon);
    }

    public void removeCartCoupon(ICartCoupon coupon) {
        cartCoupons.remove(coupon);
    }

    /**
     * 1. Compute sum of item costs (each item might have item-level coupons)
     * 2. Apply all cart-level coupons in sequence
     */
    public double calculateTotal() {
        double itemSubtotal = 0.0;
        for (CartItem item : items) {
            itemSubtotal += item.calculateItemCost(this);
        }

        double totalAfterCartCoupons = itemSubtotal;
        for (ICartCoupon coupon : cartCoupons) {
            totalAfterCartCoupons = coupon.applyDiscount(totalAfterCartCoupons, this);
        }
        return totalAfterCartCoupons;
    }
}
