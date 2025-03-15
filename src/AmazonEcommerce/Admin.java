package AmazonEcommerce;

import AmazonEcommerce.Stategies.PaymentStrategy;
import AmazonEcommerce.enums.OrderStatus;
import AmazonEcommerce.enums.ProductCategory;
import AmazonEcommerce.singleton.ECommerceSystem;


public class Admin extends UserAccount {
    public Admin(String name, String password) {
        super(name, password);
    }
    //add remove Product Category

    //block unblock delete Account
    public void blockAccount(UserAccount account){
        account.isBlocked=true;
    }
    public void unBlockAccount(UserAccount account){
        account.isBlocked=false;
    }
    public void deleteAccount(UserAccount account){
        ECommerceSystem.deleteAccount(account);
    }
    //add remove Product
    public void removeProduct(Product product){
        CatalogService.removeProduct(product);
    }
    public void addProduct(Product product){
        CatalogService.addProduct(product);
    }
    //add remove ProductCategory
    public void removeProductCategory(ProductCategory pc){
        CatalogService.removeProductCategory(pc);
    }
    public void addProductCategory(ProductCategory pc){
        CatalogService.addProductCategory(pc);
    }
    //refund Order
    public boolean refundPayment(Order order, PaymentStrategy paymentStrategy){
        if(paymentStrategy==null){return false;}
        if(!paymentStrategy.pay(order.getCustomer(),order.getMerchant(), order.getPrice())){return false;}
        order.setStatus(OrderStatus.REFUNDED);
        return true;

    }
}
