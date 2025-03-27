package ZoomCar;

/**
 * Concrete Bike class
 */
public class Bike extends Vehicle {
    public Bike(String vehicleId, String brand, String model, int engineCC,
                boolean isElectric, double hourlyRate, double kmRate) {
        super(vehicleId, brand, model, engineCC, isElectric, hourlyRate, kmRate, VehicleType.BIKE);
    }
}
