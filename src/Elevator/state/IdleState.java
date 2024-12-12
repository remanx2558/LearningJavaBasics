package Elevator.state;

import Elevator.TravelRequest;
import Elevator.Elevator;
import Elevator.Direction;


public class IdleState implements ElevatorState {
    @Override
    public void onRequest(Elevator elevator, TravelRequest request) {
        // Decide direction based on request
        if (request.getDirection() == Direction.UP) {
            elevator.setDirection(Direction.UP);
        } else if (request.getDirection() == Direction.DOWN) {
            elevator.setDirection(Direction.DOWN);
        } else {
            elevator.setDirection(Direction.STOP);
        }
        elevator.queueRequest(request);
    }

    @Override
    public void move(Elevator elevator) throws InterruptedException {
        // If idle, there's no movement until a request arrives
        if (!elevator.hasPendingRequests()) {
            return;
        }
        // Transition to appropriate moving state based on direction
        if (elevator.getDirection() == Direction.UP) {
            elevator.setState(new MovingUpState());
        } else if (elevator.getDirection() == Direction.DOWN) {
            elevator.setState(new MovingDownState());
        } else {
            elevator.setDirection(Direction.STOP);
        }
    }
}
