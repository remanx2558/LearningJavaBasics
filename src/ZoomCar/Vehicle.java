package ZoomCar;

/**
 * Base vehicle class.
 * The same can be extended or specialized by Car or Bike if needed.
 */
public abstract class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected int engineCC;
    protected boolean isElectric;
    protected boolean isAvailable; // can be toggled to false if under reservation or broken
    protected VehicleType vehicleType;

    // For advanced logic, track how the vehicle is billed, possibly rates, etc.
    protected double hourlyRate;
    protected double kmRate;

    public Vehicle(String vehicleId, String brand, String model, int engineCC,
                   boolean isElectric, double hourlyRate, double kmRate, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.engineCC = engineCC;
        this.isElectric = isElectric;
        this.isAvailable = true; // default available
        this.hourlyRate = hourlyRate;
        this.kmRate = kmRate;
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getEngineCC() {
        return engineCC;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getKmRate() {
        return kmRate;
    }
}

