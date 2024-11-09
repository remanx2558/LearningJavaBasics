package ParkingSystem.Entitiy.ParkingSpot.Manager;

import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Strategy.Parking.ParkingStrategy;

import java.util.List;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager {
    public TwoWheelerParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingStrategy parkingStrategy) {
        super(parkingSpots, parkingStrategy);
    }
}
