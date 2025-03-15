package AmazonEcommerce;

import AmazonEcommerce.enums.AccountType;

import java.util.ArrayList;
import java.util.List;

public class Merchant extends UserAccount {
    private final List<Store> stores= new ArrayList<>();;

    public  Merchant(String name, String password) {
        super(name, password);
        accountType= AccountType.MERCHANT;

    }

    public void addStore(){
        stores.add(new Store());
    }
    public void removeStore(Store store){
        stores.remove(store);
    }

    //add remove Product
    public void removeProduct(Store store,Product product){
        store.removeProduct(product);
        CatalogService.removeProduct(product);
    }
    public void addProduct(Store store,Product product){
        store.addProduct(product);
        CatalogService.addProduct(product);
    }

    public void addProduct(Product product){
        stores.add(new Store());
        stores.getFirst().addProduct(product);
        CatalogService.addProduct(product);
    }

}
