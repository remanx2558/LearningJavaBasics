package ZoomCar;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Strategy: cost is based on how many hours the vehicle is reserved/used.
 * Uses the vehicle's hourly rate.
 */
public class CostByHourStrategy implements CostCalculationStrategy {
    @Override
    public double calculateCost(Reservation reservation) {
        Vehicle vehicle = reservation.getVehicle();

        // Calculate total hours between startTime and endTime
        LocalDateTime start = reservation.getStartTime();
        LocalDateTime end   = reservation.getEndTime();

        // Fallback if end is before start, or if the user drops early
        if (end.isBefore(start)) {
            end = start;
        }

        long hours = Duration.between(start, end).toHours();
        if (hours <= 0) {
            hours = 1; // minimum 1 hour if the user used it at all
        }

        // Multiply by vehicle's hourlyRate
        return hours * vehicle.getHourlyRate();
    }
}
