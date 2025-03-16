package AmazonEcommerce;

import java.util.ArrayList;
import java.util.List;

public class WishList {
    private List<Item> items = new ArrayList<>();

    // Add product to wish list
    public void addItem(Item item) {
        items.add(item);
    }

    // Remove product from wish list
    public void removeItem(Item item) {
        items.remove(item);
    }

    // Check if product is in stock
    public boolean isItemAvailable(Item item) {
        return item.isAvailable();
    }

    // Move product from wishlist to a user’s cart
    public void moveToCart(Item item, Cart cart, Merchant merchant) {
        if (items.contains(item)) {
            items.remove(item);
            // Create a new Item and add it to the cart
            cart.addItem(item);
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
