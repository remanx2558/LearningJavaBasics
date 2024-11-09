package ParkingSystem.Entitiy.ParkingSpot.Manager;

import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.Vehicle.Vehicle;
import ParkingSystem.Strategy.Parking.ParkingStrategy;

import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager {

    public FourWheelerParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingStrategy parkingStrategy) {
        super(parkingSpots, parkingStrategy);
    }

    public void parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot) {
        if (parkingSpot.isAvailable()) {
            parkingSpot.parkVehicle(vehicle);
        }
    }

    public void removeVehicle(Vehicle vehicle, ParkingSpot parkingSpot) {

        parkingSpot.removeVehicle();
    }
}

