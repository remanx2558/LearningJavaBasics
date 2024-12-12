package Elevator.state;
import Elevator.Elevator;
import Elevator.TravelRequest;

public class StoppedState  implements ElevatorState {

    @Override
    public void onRequest(Elevator elevator, TravelRequest request) {
        // If stopped/inactive, ignore or queue the request but don't process
        // Possibly log or handle differently
    }

    @Override
    public void move(Elevator elevator) throws InterruptedException {
        // Do nothing, elevator is inactive
    }
}