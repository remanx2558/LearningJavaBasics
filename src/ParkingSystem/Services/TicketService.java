package ParkingSystem.Services;

import ParkingSystem.Entitiy.Gate.EntryGate;
import ParkingSystem.Entitiy.ParkingSpot.Manager.ParkingSpotManager;
import ParkingSystem.Entitiy.ParkingSpot.Manager.ParkingSpotManagerFactory;
import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.Entitiy.Vehicle.Vehicle;
import ParkingSystem.Exception.NoAvailableParkingSpotException;
import ParkingSystem.Strategy.Parking.ParkingStrategy;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class TicketService {
    private static final Logger logger = Logger.getLogger(TicketService.class.getName());
    private final ParkingSpotManagerFactory parkingSpotManagerFactory;

    public TicketService(ParkingSpotManagerFactory factory) {
        this.parkingSpotManagerFactory = factory;
    }

    public Ticket createTicket(Vehicle vehicle, EntryGate entryGate) {
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setEntryGate(entryGate);
        return ticket;
    }

    public void assignParkingSpot(Ticket ticket, ParkingStrategy strategy) throws NoAvailableParkingSpotException {
        ParkingSpotManager psManager = ParkingSpotManagerFactory.getManager(ticket.getVehicle().getType());

        ParkingSpot spot = psManager
                .findAvailableParkingSpot(ticket, strategy);

        if (spot == null) {
            logger.warning("No available spot for vehicle type: " + ticket.getVehicle().getType());
            throw new NoAvailableParkingSpotException("No available parking spot for vehicle type: " + ticket.getVehicle().getType());
        }
        ticket.setParkingSpot(spot);
        spot.parkVehicle(ticket.getVehicle());
    }
}