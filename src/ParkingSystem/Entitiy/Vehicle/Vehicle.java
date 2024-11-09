package ParkingSystem.Entitiy.Vehicle;

import ParkingSystem.Enum.VehicleType;

public abstract class Vehicle {
    private final int vehicleNumber;

    public Vehicle(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public abstract VehicleType getType();
}
