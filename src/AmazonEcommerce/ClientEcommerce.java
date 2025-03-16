package AmazonEcommerce;

import AmazonEcommerce.Stategies.CardPayment;
import AmazonEcommerce.Stategies.PaymentStrategy;
import AmazonEcommerce.Stategies.SearchItemOnProductCategory;
import AmazonEcommerce.decorator.BlackFridayDiscount;
import AmazonEcommerce.decorator.ChristmanDiscount;
import AmazonEcommerce.decorator.DiscountDecorator;
import AmazonEcommerce.enums.ProductCategory;
import AmazonEcommerce.singleton.ECommerceSystem;

public class ClientEcommerce {
    public static void main(String[] args) {
        Admin admin = new Admin("AdminUser", "admin123");
        ECommerceSystem.getInstance().addAccount(admin);
        Merchant merchant = new Merchant("BestMerchant", "mPass");
        ECommerceSystem.getInstance().addAccount(merchant);
        Customer customer = new Customer("Alice", "alice123");
        ECommerceSystem.getInstance().addAccount(customer);
        Guest guest = new Guest();
        ProductCategory electronics = ProductCategory.valueOf("ELECTRONICS");
        ProductCategory books = ProductCategory.valueOf("BOOKS");
        admin.addProductCategory(electronics);
        admin.addProductCategory(books);
        Product phone = new Product(electronics,20,15000);
        merchant.addProduct(phone);
        Product novel = new Product(books,10,500);

        novel.setProductCategory(books);
        merchant.addProduct(novel);
        guest.searchProduct(new SearchItemOnProductCategory(), phone);
        guest.searchProduct(new SearchItemOnProductCategory(), novel);
        customer.logIn(1, "alice123");
        Address address = new Address();
        Item phoneItem = new Item(phone,15000,merchant);
        customer.addItemToCart(phoneItem);
        Item novelItem = new Item(novel,500,merchant);

        customer.addItemToCart(novelItem);
        PaymentStrategy paymentStrategy = new CardPayment("1267");
        paymentStrategy = new DiscountDecorator(paymentStrategy);
        paymentStrategy = new BlackFridayDiscount(paymentStrategy);
        paymentStrategy = new ChristmanDiscount(paymentStrategy);

        Order order = customer.placeOrder(paymentStrategy);
        order.getStatus();
        customer.cancelOrder(order);
        admin.blockAccount(customer);
        admin.removeProductCategory(books);
        admin.removeProduct(novel);
    }
}
