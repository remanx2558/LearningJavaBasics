package Elevator.state;

import Elevator.TravelRequest;
import Elevator.Elevator;

public interface ElevatorState {
    void onRequest(Elevator elevator, TravelRequest request);
    void move(Elevator elevator) throws InterruptedException;
}