package AmazonEcommerce;

import AmazonEcommerce.Stategies.PaymentStrategy;
import AmazonEcommerce.enums.AccountType;

import java.util.ArrayList;
import java.util.List;

public class Customer extends UserAccount {
    private final Cart cart=new Cart();
    private final List<Order> orders=new ArrayList<>();
    private WishList wishList = new WishList();


    public  Customer(String name, String password) {
        super(name, password);
        accountType= AccountType.CUSTOMER;
    }

    //add or remove from Cart
    public void addItemToCart(Item item){
        cart.getItems().add(item);
    }
    public void removeItemFromCart(Item item){
        cart.getItems().remove(item);
    }

    //----- NEW: WISHLIST METHODS -----
    public WishList getWishList() {
        return wishList;
    }

    // Only add if logged in
    public void addToWishList(Item item) {
        if (isValidSession()) {
            wishList.addItem(item);
            System.out.println("Product added to wishlist successfully.");
        } else {
            System.out.println("You must be logged in to add products to your wishlist.");
        }
    }

    public void moveFromWishListToCart(Item item, Merchant merchant) {
        if (isValidSession()) {
            wishList.moveToCart(item, cart, merchant);
            System.out.println("Product moved from wishlist to cart.");
        } else {
            System.out.println("You must be logged in to move products from wishlist to cart.");
        }
    }

    //place order
    public Order placeOrder(PaymentStrategy paymentStrategy){
        Order newOrder=new Order(this,paymentStrategy);
        orders.add(newOrder);
        cart.getItems().clear();
        return newOrder;
    }
    //view order
    public List<Order> viewOrder(){
        return orders;
    }
    //view Cart
    public Cart viewCart(){
        return cart;
    }

    //CancelOder
    public boolean cancelOrder(Order order){
        return order.cancelOrder();
    }

    public Cart getCart(){
        return cart;
    }

}
