package ParkingSystem.Strategy.Parking;

import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.ParkingSystemClient;
import ParkingSystem.Util;

import java.util.List;
import java.util.logging.Logger;

public class NearToEntranceParkingStrategy implements ParkingStrategy {
    private static final Logger logger = Logger.getLogger(NearToEntranceParkingStrategy.class.getName());

    @Override
    public ParkingSpot search(List<ParkingSpot> parkingSpots, Ticket ticket) {

        ParkingSpot ps=null;
        int distance=Integer.MAX_VALUE;
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isAvailable()) {
               int localDistance= Util.distanceCalculator(parkingSpot.getLocation(),ticket.entryGate.getLocation());
               if(localDistance<distance){
                   distance=localDistance;
                   ps=parkingSpot;
               }
            }
        }
        return ps;
    }
}
