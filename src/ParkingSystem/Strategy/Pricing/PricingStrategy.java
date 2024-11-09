package ParkingSystem.Strategy.Pricing;

import ParkingSystem.Entitiy.Ticket;

public interface PricingStrategy {
    int calculatePrice(Ticket ticket,int []rates);
}
