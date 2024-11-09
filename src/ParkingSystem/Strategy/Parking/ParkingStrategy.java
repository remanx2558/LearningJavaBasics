package ParkingSystem.Strategy.Parking;

import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.Ticket;

import java.util.List;

public interface ParkingStrategy {
    public ParkingSpot search(List<ParkingSpot> parkingSpotList, Ticket ticket);
}
