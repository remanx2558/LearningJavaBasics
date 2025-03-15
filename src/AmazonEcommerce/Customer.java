package AmazonEcommerce;

import AmazonEcommerce.Stategies.PaymentStrategy;
import AmazonEcommerce.enums.AccountType;

import java.util.ArrayList;
import java.util.List;

public class Customer extends UserAccount {
    private final Cart cart=new Cart();
    private final List<Order> orders=new ArrayList<>();


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
