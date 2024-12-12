package Elevator.state;
import Elevator.Elevator;
import Elevator.TravelRequest;
import Elevator.Direction;

public class MovingDownState implements ElevatorState {

    @Override
    public void onRequest(Elevator elevator, TravelRequest request) {
        // If a request is in the downward direction and below current floor, add to downList
        // Otherwise, handle when direction changes or after current requests are complete
        elevator.queueRequest(request);
    }

    @Override
    public void move(Elevator elevator) throws InterruptedException {
        elevator.processNextFloor();
        // If no more down requests, switch to idle
        if (!elevator.hasPendingRequests()) {
            elevator.setDirection(Direction.STOP);
            elevator.setState(new IdleState());
        }
    }
}
