package AmazonEcommerce.factory;

import AmazonEcommerce.*;

public class UserFactory {
    private UserFactory() {}

    public static UserAccount createGuest() {
        // Guest has no password, or you can leave it blank
        return new Guest("Guest", "");
    }

    public static UserAccount createCustomer(String name, String password) {
        return new Customer(name, password);
    }

    public static UserAccount createAdmin(String name, String password) {
        return new Admin(name, password);
    }

    public static UserAccount createMerchant(String name, String password) {
        return new Merchant(name, password);
    }
}
