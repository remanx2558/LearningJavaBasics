package ParkingSystem.Entitiy.Vehicle;

import ParkingSystem.Enum.VehicleType;

public class TwoWheelerVehicle extends Vehicle {
    public TwoWheelerVehicle(int vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TWO_WHEELER;
    }
}