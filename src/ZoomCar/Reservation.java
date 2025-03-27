package ZoomCar;

import java.time.LocalDateTime;

public class Reservation {
    private String reservationId;
    private Customer customer;
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isActive;

    // Odometer readings for KMs-based billing
    private double startOdometerReading;
    private double endOdometerReading;

    // Strategy for computing cost
    private CostCalculationStrategy costCalculationStrategy;

    // Optionally store final cost (once calculated) or re-calc on demand.
    private Double finalCost;

    public Reservation(String reservationId,
                       Customer customer,
                       Vehicle vehicle,
                       LocalDateTime startTime,
                       LocalDateTime endTime,
                       double startOdometerReading,
                       CostCalculationStrategy costCalculationStrategy) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isActive = true; // set active on creation
        this.startOdometerReading = startOdometerReading;
        this.endOdometerReading = startOdometerReading;  // initially same
        this.costCalculationStrategy = costCalculationStrategy;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getStartOdometerReading() {
        return startOdometerReading;
    }

    public double getEndOdometerReading() {
        return endOdometerReading;
    }

    public void setEndOdometerReading(double endOdometerReading) {
        this.endOdometerReading = endOdometerReading;
    }

    public void cancel() {
        this.isActive = false;
    }

    /**
     * Let the user choose to shorten the end time if they drop early
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Calculate cost based on the chosen strategy.
     */
    public double calculateCost() {
        if (costCalculationStrategy == null) {
            // fallback or default cost
            return 0.0;
        }
        double cost = costCalculationStrategy.calculateCost(this);
        this.finalCost = cost;
        return cost;
    }

    public Double getFinalCost() {
        return finalCost;
    }
}