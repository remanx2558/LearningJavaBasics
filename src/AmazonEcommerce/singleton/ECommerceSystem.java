package AmazonEcommerce.singleton;

import AmazonEcommerce.UserAccount;
import java.util.ArrayList;
import java.util.List;

public class ECommerceSystem {
    //singleton Instance
    private static final ECommerceSystem INSTANCE = new ECommerceSystem();
    public static ECommerceSystem getInstance() {
        return INSTANCE;
    }



    //List of Accounts
    private static List<UserAccount> accounts=new ArrayList<>();
    public static void deleteAccount(UserAccount account){
        accounts.remove(account);
    }
    public static void addAccount(UserAccount account){
        accounts.add(account);
    }




}
