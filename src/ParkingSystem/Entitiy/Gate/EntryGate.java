package ParkingSystem.Entitiy.Gate;

import ParkingSystem.Entitiy.ParkingSpot.Manager.ParkingSpotManagerFactory;
import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.ParkingSpot.Manager.ParkingSpotManager;
import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.Entitiy.Vehicle.Vehicle;

import java.time.LocalDateTime;

public class EntryGate extends Gate {

    public EntryGate(int i, String s) {
        super(i,s);
    }

    public Ticket findSpaceAndGenerateTicket(Vehicle vehicle) {
        ParkingSpotManager manager = ParkingSpotManagerFactory.getManager(vehicle.getType());
        Ticket ticket=new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(LocalDateTime.now());
        ParkingSpot spot = manager.findAvailableParkingSpot(ticket);

        if (spot == null) {
            System.out.println("No available spot for vehicle type: " + vehicle.getType());
            return null;
        }
        ticket.setParkingSpot(spot);
        spot.parkVehicle(vehicle);
        return ticket;
    }
}
