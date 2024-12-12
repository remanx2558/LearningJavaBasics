package ParkingSystem.Entitiy.Gate;

import ParkingSystem.Entitiy.Location;
import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.Services.PaymentService;
import ParkingSystem.Strategy.CC.CostComputation;
import ParkingSystem.Strategy.CC.CostComputationFactory;
import ParkingSystem.Strategy.Payment.PaymentStrategy;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class ExitGate extends Gate {

    private static final Logger logger = Logger.getLogger(ExitGate.class.getName());
    private PaymentService paymentService;

    public ExitGate(int id, Location location, PaymentService paymentService) {
        super(id, location);
        this.paymentService = paymentService;
    }

    public int processVehicleExit(Ticket ticket) {
        int charges = paymentService.processPayment(ticket);
        ticket.setExitGate(this);
        logger.info("Vehicle " + ticket.getVehicle().getVehicleNumber() + " exited via gate " + getId() + ", charges: " + charges);
        return charges;
    }

    public int processVehicleExit(Ticket ticket,PaymentStrategy paymentStrategy) {
        int charges = paymentService.processPayment(ticket,paymentStrategy);
        ticket.setExitGate(this);
        logger.info("Vehicle " + ticket.getVehicle().getVehicleNumber() + " exited via gate " + getId() + ", charges: " + charges);
        return charges;
    }

}

