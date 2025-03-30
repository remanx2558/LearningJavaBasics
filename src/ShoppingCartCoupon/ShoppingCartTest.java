package ShoppingCartCoupon;

public class ShoppingCartTest {
    public static void main(String[] args) {
        // Create some products
        Product apple = new Product("apple", "Fresh Apple", 2.0);
        Product banana = new Product("banana", "Banana", 1.0);

        // Create cart items
        CartItem apples = new CartItem(apple, 5);  // 5 apples
        CartItem bananas = new CartItem(banana, 10); // 10 bananas

        // Create the cart
        Cart cart = new Cart();
        cart.addItem(apples);
        cart.addItem(bananas);

        // Add an item-level coupon (C1: 10% off item)
        IItemCoupon tenPercentOffItem = new PercentageOffItem(10.0);
        apples.addItemCoupon(tenPercentOffItem);
        bananas.addItemCoupon(tenPercentOffItem);

        // Add a cart-level coupon (C3: 20% off the 2nd item of type banana)
        ICartCoupon discountOnSecondBanana = new DiscountOnNthItemOfType("banana", 2, 20.0);
        cart.addCartCoupon(discountOnSecondBanana);

        // Calculate initial total
        double total1 = cart.calculateTotal();
        System.out.println("Total after applying C1 and C3: " + total1);

        // Remove cart-level coupon
        cart.removeCartCoupon(discountOnSecondBanana);

        // Add item-level coupon: (C2) 50% off next item added
        // In practice, you might do it differently. For demonstration:
        IItemCoupon halfOffNextItem = new NextItemOffCoupon(50);
        // Let's add a new product (orange)
        Product orange = new Product("orange", "Sweet Orange", 3.0);
        CartItem oranges = new CartItem(orange, 4);

        // Attach the coupon explicitly to the item
        // (Alternatively, logic in addItem(...) could attach it automatically)
        oranges.addItemCoupon(halfOffNextItem);
        cart.addItem(oranges);

        double total2 = cart.calculateTotal();
        System.out.println("Total after removing C3 and adding C2 (on oranges): " + total2);
    }
}
