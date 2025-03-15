package AmazonEcommerce;

import AmazonEcommerce.enums.AccountType;
import AmazonEcommerce.singleton.ECommerceSystem;

public class Guest extends UserAccount{
    public  Guest(String name, String password) {
        super(name, password);
    }

    public  Guest() {
        super("Guest", "pwd");
        accountType= AccountType.GUEST;
    }

    public void crateAccount(String name, String password){
        UserAccount account=new UserAccount(name,password);
        ECommerceSystem.addAccount(account);
    }
}
