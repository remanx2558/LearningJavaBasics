package Common.entities;
import Common.enums.VehicleType;
import Common.util.IdGenerator;


public abstract class Vehicle {
    private final String vehicleNumber;
    private final String id;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.id= IdGenerator.generateId();
    }

    //Methords

    //Getter - Setter

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getId() {
        return id;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
