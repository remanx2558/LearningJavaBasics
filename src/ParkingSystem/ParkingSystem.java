package ParkingSystem;

import ParkingSystem.Entitiy.Gate.EntryGate;
import ParkingSystem.Entitiy.Gate.ExitGate;
import ParkingSystem.Entitiy.Location;
import ParkingSystem.Entitiy.ParkingSpot.FourWheelerParkingSpot;
import ParkingSystem.Entitiy.ParkingSpot.Manager.ParkingSpotManagerFactory;
import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.ParkingSpot.TwoWheelerParkingSpot;
import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.Entitiy.Vehicle.Vehicle;
import ParkingSystem.Exception.InvalidGateException;
import ParkingSystem.Exception.NoAvailableParkingSpotException;
import ParkingSystem.Exception.ParkingSystemException;
import ParkingSystem.Services.PaymentService;
import ParkingSystem.Services.TicketService;
import ParkingSystem.Strategy.CC.CostComputationFactory;
import ParkingSystem.Strategy.Parking.NearToEntranceParkingStrategy;
import ParkingSystem.Strategy.Payment.CreditCardPayment;
import ParkingSystem.Strategy.Payment.PaymentStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ParkingSystem {
    private static final Logger logger = Logger.getLogger(ParkingSystem.class.getName());
    private ParkingSpotManagerFactory spotManagerFactory;
    private List<EntryGate> entryGateList;
    private List<ExitGate> exitGateList;
    private TicketService ticketService;
    private PaymentService paymentService;

    public ParkingSystem() {

        initializeParkingSpots();


        CostComputationFactory costFactory = new CostComputationFactory();
        this.ticketService = new TicketService(spotManagerFactory);
        this.paymentService = new PaymentService(costFactory, new CreditCardPayment());

        initializeGates();

    }

    public EntryGate getEntryGate(int gId) throws InvalidGateException {
        return entryGateList.stream()
                .filter(gate -> gate.getId() == gId)
                .findFirst()
                .orElseThrow(() -> new InvalidGateException("Entry Gate with ID " + gId + " not found."));
    }

    public ExitGate getExitGate(int gId) throws InvalidGateException {
        return exitGateList.stream()
                .filter(gate -> gate.getId() == gId)
                .findFirst()
                .orElseThrow(() -> new InvalidGateException("Exit Gate with ID " + gId + " not found."));
    }


    private void initializeGates() {
        entryGateList = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            entryGateList.add(new EntryGate(i, new Location(1,i,i), new NearToEntranceParkingStrategy(), ticketService));
        }

        exitGateList=new ArrayList<>();
        for(int i=4;i<=6;i++){
            exitGateList.add(new ExitGate(i, new Location(1,i,i), paymentService));
        }


    }

    private void initializeParkingSpots() {
        // Initialize two-wheeler and four-wheeler spots (example data)
        List<ParkingSpot> twoWheelerSpots = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            twoWheelerSpots.add(new TwoWheelerParkingSpot(i, new Location(1,i,i+1)));
        }

        List<ParkingSpot> fourWheelerSpots = new ArrayList<>();
        for (int i = 11; i <= 20; i++) {
            fourWheelerSpots.add(new FourWheelerParkingSpot(i, new Location(1,i,i+4)));
        }

        spotManagerFactory =new ParkingSpotManagerFactory(twoWheelerSpots,fourWheelerSpots);

    }

    public Ticket vehicleEntry(Vehicle vehicle, int entryGateId) {
        try {
            EntryGate gate = getEntryGate(entryGateId);
            return gate.processVehicleEntry(vehicle);
        } catch (NoAvailableParkingSpotException | InvalidGateException e) {
            logger.severe(e.getMessage());
            return null;
        }
    }

    public int vehicleExit(Ticket ticket, ExitGate exitGate, PaymentStrategy paymentStrategy) {
        if (ticket == null || exitGate == null) {
            logger.warning("Invalid ticket or exit gate for vehicle exit.");
            return 0;
        }
        int parkingCharges = exitGate.processVehicleExit(ticket, paymentStrategy);
        ticket.setExitGate(exitGate);
        logger.info("Exit processed for vehicle number: " + ticket.getVehicle().getVehicleNumber() + ", Parking charges: " + parkingCharges);
        return parkingCharges;
    }
    public int vehicleExit(Ticket ticket, int exitGateId) {
        try {
            ExitGate exitGate = getExitGate(exitGateId);
            return exitGate.processVehicleExit(ticket);
        } catch (InvalidGateException e) {
            logger.severe(e.getMessage());
            return 0;
        }
    }

}
