package ParkingSystem.Strategy.Parking;

import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.ParkingSystemClient;

import java.util.List;
import java.util.logging.Logger;

public class NearToEntranceParkingStrategy implements ParkingStrategy {
    private static final Logger logger = Logger.getLogger(NearToEntranceParkingStrategy.class.getName());

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
