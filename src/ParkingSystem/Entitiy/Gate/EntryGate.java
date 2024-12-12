package ParkingSystem.Entitiy.Gate;

import ParkingSystem.Entitiy.Location;
import ParkingSystem.Entitiy.ParkingSpot.Manager.ParkingSpotManagerFactory;
import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.ParkingSpot.Manager.ParkingSpotManager;
import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.Entitiy.Vehicle.Vehicle;
import ParkingSystem.Exception.NoAvailableParkingSpotException;
import ParkingSystem.Services.TicketService;
import ParkingSystem.Strategy.Parking.ParkingStrategy;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class EntryGate extends Gate {

    private static final Logger logger = Logger.getLogger(EntryGate.class.getName());
    private ParkingStrategy parkingStrategy;
    private TicketService ticketService;

    public void setParkingStrateg(ParkingStrategy ps){
        this.parkingStrategy =ps;
    }

    public EntryGate(int id, Location location, ParkingStrategy parkingStrategy, TicketService ticketService) {
        super(id, location);
        this.parkingStrategy = parkingStrategy;
        this.ticketService = ticketService;
    }

    //Template Method
    public Ticket processVehicleEntry(Vehicle vehicle) throws NoAvailableParkingSpotException {

        //Step1: Generate Ticket (Vehicle): with Vehicle and Entry Time
        Ticket ticket=ticketService.createTicket(vehicle, this);
        //Step2: Get the ParkingSpot
        ticketService.assignParkingSpot(ticket, parkingStrategy);
        logger.info("Ticket generated for vehicle: " + vehicle.getVehicleNumber() + " at gate " + getId());
        return ticket;
       // ParkingSpot parkingSpot=getParkingSpot(ticket);
//        //Step3: Open Gates or keep it closed
//        if (parkingSpot == null) {
//            System.out.println("No available spot for vehicle type: " + vehicle.getType());
//            return null;
//        }
//        return ticket;
    }


}
