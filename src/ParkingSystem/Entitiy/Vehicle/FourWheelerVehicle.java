package ParkingSystem.Entitiy.Vehicle;

import ParkingSystem.Enum.VehicleType;

public class FourWheelerVehicle extends Vehicle {
    public FourWheelerVehicle(int vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.FOUR_WHEELER;
    }
}