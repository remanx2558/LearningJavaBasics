package ZoomCar;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Another filter: Filter by engine CC range.
 */
public class EngineCCFilter implements VehicleFilter {
    private int minCC;
    private int maxCC;

    public EngineCCFilter(int minCC, int maxCC) {
        this.minCC = minCC;
        this.maxCC = maxCC;
    }

    @Override
    public List<Vehicle> filter(List<Vehicle> vehicles) {
        return vehicles.stream()
                .filter(v -> v.getEngineCC() >= minCC && v.getEngineCC() <= maxCC)
                .collect(Collectors.toList());
    }
}