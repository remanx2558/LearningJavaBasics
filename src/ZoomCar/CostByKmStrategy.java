package ZoomCar;

/**
 * Strategy: cost is based on how many kilometers the vehicle traveled.
 * Uses the vehicle's kilometer rate.
 */
public class CostByKmStrategy implements CostCalculationStrategy {
    @Override
    public double calculateCost(Reservation reservation) {
        Vehicle vehicle = reservation.getVehicle();

        // The reservation holds the start and end odometer readings
        double distanceTraveled = reservation.getEndOdometerReading() - reservation.getStartOdometerReading();
        if (distanceTraveled < 0) {
            distanceTraveled = 0; // if for any reason end is less than start, fallback
        }

        // Multiply by vehicle's kmRate
        return distanceTraveled * vehicle.getKmRate();
    }
}