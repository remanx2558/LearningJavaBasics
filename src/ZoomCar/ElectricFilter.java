package ZoomCar;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter for electric or non-electric.
 */
public class ElectricFilter implements VehicleFilter {
    private boolean onlyElectric;

    public ElectricFilter(boolean onlyElectric) {
        this.onlyElectric = onlyElectric;
    }

    @Override
    public List<Vehicle> filter(List<Vehicle> vehicles) {
        return vehicles.stream()
                .filter(v -> v.isElectric() == onlyElectric)
                .collect(Collectors.toList());
    }
}