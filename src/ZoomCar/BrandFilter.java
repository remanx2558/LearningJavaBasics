package ZoomCar;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Concrete filter example: Filter by brand.
 */
public class BrandFilter implements VehicleFilter {
    private String brand;

    public BrandFilter(String brand) {
        this.brand = brand;
    }

    @Override
    public List<Vehicle> filter(List<Vehicle> vehicles) {
        return vehicles.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }
}
