package ParkingSystem.Strategy.Parking;

import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.Ticket;

import java.util.List;

public class NearToExitParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot search(List<ParkingSpot> parkingSpots, Ticket ticket) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isAvailable()) {
                return parkingSpot;
            }
        }
        return null;
    }
}

