package ZoomCar;

/**
 * Concrete Car class
 */
public class Car extends Vehicle {
    public Car(String vehicleId, String brand, String model, int engineCC,
               boolean isElectric, double hourlyRate, double kmRate) {
        super(vehicleId, brand, model, engineCC, isElectric, hourlyRate, kmRate, VehicleType.CAR);
    }
}