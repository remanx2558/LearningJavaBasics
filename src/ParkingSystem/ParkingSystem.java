package ParkingSystem;

import ParkingSystem.Entitiy.Gate.EntryGate;
import ParkingSystem.Entitiy.Gate.ExitGate;
import ParkingSystem.Entitiy.ParkingSpot.FourWheelerParkingSpot;
import ParkingSystem.Entitiy.ParkingSpot.Manager.ParkingSpotManagerFactory;
import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.ParkingSpot.TwoWheelerParkingSpot;
import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.Entitiy.Vehicle.Vehicle;
import ParkingSystem.Exception.ParkingSystemException;
import ParkingSystem.Strategy.Payment.PaymentStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ParkingSystem {
    private static final Logger logger = Logger.getLogger(ParkingSystem.class.getName());
    private ParkingSpotManagerFactory parkingSpotManagerFactory;
    private List<EntryGate> entryGateList;
    private List<ExitGate> exitGateList;

    public ParkingSystem() {
        initializeGates();
        initializeParkingSpots();
    }

    public EntryGate getEntryGate(int gId) throws ParkingSystemException {
        return entryGateList.stream()
                .filter(gate -> gate.getId() == gId)
                .findFirst()
                .orElseThrow(() -> new ParkingSystemException("Entry Gate with ID " + gId + " not found."));
    }

    public ExitGate getExitGate(int gId) throws ParkingSystemException {
        return exitGateList.stream()
                .filter(gate -> gate.getId() == gId)
                .findFirst()
                .orElseThrow(() -> new ParkingSystemException("Exit Gate with ID " + gId + " not found."));
    }

    private void initializeGates() {
        entryGateList = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            entryGateList.add(new EntryGate(i, "North-Gate" + i));
        }

        exitGateList=new ArrayList<>();
        for(int i=4;i<=6;i++){
            exitGateList.add(new ExitGate(i,"South-Gate"+i));
        }


    }

    private void initializeParkingSpots() {
        // Initialize two-wheeler and four-wheeler spots (example data)
        List<ParkingSpot> twoWheelerSpots = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            twoWheelerSpots.add(new TwoWheelerParkingSpot(i));
        }

        List<ParkingSpot> fourWheelerSpots = new ArrayList<>();
        for (int i = 11; i <= 20; i++) {
            fourWheelerSpots.add(new FourWheelerParkingSpot(i));
        }

        parkingSpotManagerFactory =new ParkingSpotManagerFactory(twoWheelerSpots,fourWheelerSpots);

    }

    public Ticket vehicleEntry(Vehicle vehicle, EntryGate entryGate) {
        if (vehicle == null || entryGate == null) {
            logger.warning("Invalid vehicle or entry gate for vehicle entry.");
            return null;
        }
        Ticket ticket = entryGate.findSpaceAndGenerateTicket(vehicle);
        if (ticket != null) {
            ticket.setEntryGate(entryGate);
            logger.info("Ticket generated for vehicle number: " + vehicle.getVehicleNumber());
        } else {
            logger.warning("No available parking space for vehicle number: " + vehicle.getVehicleNumber());
        }
        return ticket;
    }

    public int vehicleExit(Ticket ticket, ExitGate exitGate, PaymentStrategy paymentStrategy) {
        if (ticket == null || exitGate == null) {
            logger.warning("Invalid ticket or exit gate for vehicle exit.");
            return 0;
        }
        int parkingCharges = exitGate.exitVehicleAndMakePayment(ticket, paymentStrategy);
        ticket.setExitGate(exitGate);
        logger.info("Exit processed for vehicle number: " + ticket.getVehicle().getVehicleNumber() + ", Parking charges: " + parkingCharges);
        return parkingCharges;
    }

}
