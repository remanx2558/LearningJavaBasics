package ShoppingCartCoupon;

/**
 * If the cart has 'n' items of a certain type 'T',
 * discount the price of that nth item by 'd'%.
 */
public class DiscountOnNthItemOfType implements ICartCoupon {
    private String type;      // Could be product category or product ID
    private int nth;
    private double percentOff;

    public DiscountOnNthItemOfType(String type, int nth, double percentOff) {
        this.type = type;
        this.nth = nth;
        this.percentOff = percentOff;
    }

    @Override
    public double applyDiscount(double originalTotal, Cart cart) {
        // Identify the nth item in the cart that matches "type"
        // Then apply a discount to that item’s portion of cost
        double totalAfterDiscount = originalTotal;
        int matchingItemCount = 0;

        for (CartItem item : cart.getItems()) {
            // Suppose "type" matches product ID or some category
            if (item.getProduct().getId().equals(type)) {
                matchingItemCount += item.getQuantity();

                // If the nth item is within this CartItem
                // (e.g., if item quantity > 1), we discount for 1 unit
                if (matchingItemCount >= nth) {
                    // Figure out cost for single unit, discount it
                    double itemBasePrice = item.getProduct().getPrice();
                    double discountAmount = itemBasePrice * (percentOff / 100.0);

                    // Subtract from total
                    totalAfterDiscount -= discountAmount;
                    break;
                }
            }
        }
        return totalAfterDiscount;
    }
}
