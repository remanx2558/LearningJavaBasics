package ParkingSystem.Entitiy.Gate;

import ParkingSystem.Entitiy.ParkingSpot.Manager.ParkingSpotManager;
import ParkingSystem.Entitiy.ParkingSpot.Manager.ParkingSpotManagerFactory;
import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.Strategy.CC.CostComputation;
import ParkingSystem.Strategy.CC.CostComputationFactory;
import ParkingSystem.Strategy.Payment.PaymentStrategy;

import java.time.LocalDateTime;

public class ExitGate extends Gate {
    private CostComputationFactory costComputationFactory;


    public ExitGate(int i, String s) {
        super(i, s);
        costComputationFactory=new CostComputationFactory();
    }

    public int exitVehicleAndMakePayment(Ticket ticket, PaymentStrategy paymentStrategy) {
        ParkingSpotManager manager = ParkingSpotManagerFactory.getManager(ticket.getVehicle().getType());
        if (ticket == null) {
            System.out.println("No ticket found for vehicle number " + ticket.getVehicle().getVehicleNumber());
            return 0;
        }
       // ticket.setExitTime(LocalDateTime.now().plusHours(1));
        ticket.setExitTime(LocalDateTime.now());
        ticket.getParkingSpot().removeVehicle();
        CostComputation costComputation=costComputationFactory.getManager(ticket.getVehicle().getType());
        int parkingCharges= costComputation.computePrice(ticket);
        System.out.println("pc"+parkingCharges);
        ticket.setTotalParkingChages(parkingCharges);
        paymentStrategy.processPayment(parkingCharges);
        return parkingCharges;
    }

}

