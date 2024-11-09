package ParkingSystem.Strategy.Pricing;

import ParkingSystem.Entitiy.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy {

    @Override
    public int calculatePrice(Ticket ticket, int[] rates) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = ticket.getExitTime();
        long hours = Duration.between(entryTime, exitTime).toHours();
        return (int) (hours * rates[1]);
    }
}