package ParkingSystem.Services;

import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.Strategy.CC.CostComputation;
import ParkingSystem.Strategy.CC.CostComputationFactory;
import ParkingSystem.Strategy.Payment.PaymentStrategy;

import java.time.LocalDateTime;

public class PaymentService {
    private final CostComputationFactory costComputationFactory;
    private final PaymentStrategy paymentStrategy;

    public PaymentService(CostComputationFactory costComputationFactory, PaymentStrategy paymentStrategy) {
        this.costComputationFactory = costComputationFactory;
        this.paymentStrategy = paymentStrategy;
    }

    public int processPayment(Ticket ticket) {
        // update exit time
        if (ticket.getExitTime() == null) {
            ticket.setExitTime(LocalDateTime.now());
        }
        // vacate spot
        if (ticket.getParkingSpot() != null) {
            ticket.getParkingSpot().removeVehicle();
        }
        CostComputation costComputer=CostComputationFactory.getManager(ticket.getVehicle().getType());
        int charges = costComputer.computePrice(ticket);

        ticket.setTotalParkingChages(charges);
        this.paymentStrategy.processPayment(charges);
        return charges;
    }

    public int processPayment(Ticket ticket, PaymentStrategy paymentStrategy) {
        // update exit time
        if (ticket.getExitTime() == null) {
            ticket.setExitTime(LocalDateTime.now());
        }
        // vacate spot
        if (ticket.getParkingSpot() != null) {
            ticket.getParkingSpot().removeVehicle();
        }
        CostComputation costComputer=CostComputationFactory.getManager(ticket.getVehicle().getType());
        int charges = costComputer.computePrice(ticket);

        ticket.setTotalParkingChages(charges);
        paymentStrategy.processPayment(charges);
        return charges;
    }
}

