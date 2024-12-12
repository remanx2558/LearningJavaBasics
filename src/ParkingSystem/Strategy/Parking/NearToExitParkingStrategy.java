package ParkingSystem.Strategy.Parking;

import ParkingSystem.Entitiy.Gate.ExitGate;
import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.Util;

import java.util.List;

public class NearToExitParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot search(List<ParkingSpot> parkingSpots, Ticket ticket) {
        //Currently Not Supported : For Future : Right Now
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

