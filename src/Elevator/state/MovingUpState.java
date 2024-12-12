package Elevator.state;
import Elevator.Elevator;
import Elevator.TravelRequest;
import Elevator.Direction;

public class MovingUpState  implements ElevatorState {

    @Override
    public void onRequest(Elevator elevator, TravelRequest request) {
        // If a request is in the upward direction and above current floor, add to upList
        // Otherwise, it may need to be handled later or when direction changes
        elevator.queueRequest(request);
    }

    @Override
    public void move(Elevator elevator) throws InterruptedException {
        elevator.processNextFloor();
        // If no more up requests, switch to idle or opposite direction if needed
        if (!elevator.hasPendingRequests()) {
            elevator.setDirection(Direction.STOP);
            elevator.setState(new IdleState());
        }
    }
}