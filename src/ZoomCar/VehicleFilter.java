package ZoomCar;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Base interface for vehicle filters.
 */
public interface VehicleFilter {
    List<Vehicle> filter(List<Vehicle> vehicles);
}