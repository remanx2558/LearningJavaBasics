package ParkingSystem.Entitiy.ParkingSpot.Manager;

import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.Entitiy.Vehicle.Vehicle;
import ParkingSystem.Strategy.Parking.ParkingStrategy;

import java.util.List;

public abstract class ParkingSpotManager {
    List<ParkingSpot> parkingSpotList;
    ParkingStrategy parkingStrategy;


    public ParkingSpotManager(List<ParkingSpot> parkingSpotList, ParkingStrategy parkingStrategy){
        this.parkingSpotList = parkingSpotList;
        this.parkingStrategy=parkingStrategy;
    }

    public ParkingSpot findAvailableParkingSpot(Ticket ticket){
        return parkingStrategy.search(parkingSpotList,ticket);
    }
}
