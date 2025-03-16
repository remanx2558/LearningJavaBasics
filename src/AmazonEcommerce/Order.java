package AmazonEcommerce;

import AmazonEcommerce.Stategies.PaymentStrategy;
import AmazonEcommerce.enums.OrderStatus;
import AmazonEcommerce.enums.PaymentStatus;
import AmazonEcommerce.observer.NotificationService;
import AmazonEcommerce.util.IdGenerator;

import java.util.Date;
import java.util.List;


public class Order {
    private final String id;
    private final Customer customer;
    private final List<Item> orderItems;
    private OrderStatus status;
    private Date orderDate;
    private Date shipmentDate;
    private PaymentStatus paymentStatus;
    private Date expectedDeliveryDate;
    private Address deliveryAddress;
    private int price;
    private Merchant merchant;
    private int deliveryPartnerId;


    Order(Customer customer, PaymentStrategy paymentStrategy){

        //meta data

        id= IdGenerator.generateId();
        price=customer.getCart().getTotalPrice();
        this.customer =customer;
        merchant =customer.getCart().getItems().getFirst().merchant;
        deliveryAddress=customer.getAddress();
        orderDate=new Date();
        orderItems=customer.viewCart().getItems();
        status=OrderStatus.PLACED;
        //payment
        paymentStatus=makePayment(paymentStrategy);
        //notification
        NotificationService.notify(customer, "Order placed: " + id);
    }
    //make Payment
    public PaymentStatus makePayment(PaymentStrategy paymentStrategy){
        if(paymentStrategy==null){return PaymentStatus.PENDING;}
        return paymentStrategy.pay(customer,merchant, price);
    }


    //cancel order
    public boolean cancelOrder(){
        if(!isCancellable()){
            status=OrderStatus.CANCELLED;
            NotificationService.notify(customer,"Order " + id + " was cancelled.");
            return true;
        }
        return false;
    }

    public void shipOrder() {
        if (status == OrderStatus.PLACED) {
            status = OrderStatus.SHIPPED;
            shipmentDate = new Date();
            NotificationService.notify(customer,
                    "Order " + id + " shipped!");
        }
    }

    public void deliverOrder() {
        if (status == OrderStatus.SHIPPED) {
            status = OrderStatus.DELIVERED;
            NotificationService.notify(customer,
                    "Order " + id + " delivered!");
        }
    }

    public Merchant getMerchant() {return merchant;}

    public int getPrice() { return price;}

    public void setStatus(OrderStatus status) {this.status = status;}

    //check is Order Cancelleable
    private boolean isCancellable(){
        if(status==OrderStatus.SHIPPED){return false;}
        return true;
    }

    public OrderStatus getStatus() {return status;}
    public Customer getCustomer(){return customer;}
}
