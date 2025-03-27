package ZoomCar;

import java.util.ArrayList;
import java.util.List;

/**
 * Owner extends User.
 */
public class Owner extends User {
    private List<Store> stores;

    public Owner(String userId, String name, String email) {
        super(userId, name, email);
        this.stores = new ArrayList<>();
    }

    public List<Store> getStores() {
        return stores;
    }

    public void addStore(Store store) {
        stores.add(store);
    }
}