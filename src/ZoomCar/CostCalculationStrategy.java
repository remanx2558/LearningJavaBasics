package ZoomCar;

/**
 * Strategy for calculating the cost of a reservation.
 */
public interface CostCalculationStrategy {
    /**
     * @param reservation The reservation whose cost we need to compute.
     * @return The computed cost for that reservation.
     */
    double calculateCost(Reservation reservation);
}