package Elevator;

public interface Scheduler {
    Elevator selectElevator(Elevator[] elevators, TravelRequest request);
}
