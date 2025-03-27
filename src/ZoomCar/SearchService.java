package ZoomCar;

import java.util.ArrayList;
import java.util.List;

public class SearchService {

    /**
     * Search vehicles by location (city-based).
     */
    public List<Vehicle> searchByLocation(List<Store> allStores, String city) {
        List<Vehicle> result = new ArrayList<>();
        for (Store store : allStores) {
            if (store.getLocation().getCity().equalsIgnoreCase(city)) {
                result.addAll(store.getVehicles());
            }
        }
        return result;
    }

    /**
     * Search vehicles by store.
     */
    public List<Vehicle> searchByStore(Store store) {
        return new ArrayList<>(store.getVehicles());
    }

    /**
     * Apply multiple filters to a given list of vehicles.
     */
    public List<Vehicle> applyFilters(List<Vehicle> vehicles, List<VehicleFilter> filters) {
        List<Vehicle> filteredVehicles = vehicles;
        for (VehicleFilter filter : filters) {
            filteredVehicles = filter.filter(filteredVehicles);
        }
        return filteredVehicles;
    }
}