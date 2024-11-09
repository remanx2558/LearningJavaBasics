package ParkingSystem.Strategy.Pricing;

import ParkingSystem.Entitiy.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class MinutelyPricingStrategy implements PricingStrategy {


    @Override
    public int calculatePrice(Ticket ticket, int[]rates) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = ticket.getExitTime();
        long minutes = Duration.between(entryTime, exitTime).toMinutes();
        return (int) (minutes * rates[0]);
    }
}