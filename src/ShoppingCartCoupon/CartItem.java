package ShoppingCartCoupon;

import java.util.ArrayList;
import java.util.List;

public class CartItem {
    private Product product;
    private int quantity;
    private List<IItemCoupon> appliedCoupons = new ArrayList<>();

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public void addItemCoupon(IItemCoupon coupon) {
        appliedCoupons.add(coupon);
    }

    public void removeItemCoupon(IItemCoupon coupon) {
        appliedCoupons.remove(coupon);
    }

    /**
     * Calculates the final cost of this CartItem,
     * after applying all item-level coupons in sequence.
     */
    public double calculateItemCost(Cart cart) {
        double basePrice = product.getPrice() * quantity;
        double discountedPrice = basePrice;

        for (IItemCoupon coupon : appliedCoupons) {
            discountedPrice = coupon.applyDiscount(discountedPrice, cart, this);
        }
        return discountedPrice;
    }
}