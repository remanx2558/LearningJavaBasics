package Elevator;

public class TravelRequest {
    Floor currFloor;
    Floor destinationFloor;
    Direction direction;

    TravelRequest(Floor curr, Floor dest){
        currFloor=curr;
        destinationFloor=dest;

        if(curr.floorNumber>dest.floorNumber){
            direction=Direction.DOWN;
        }
        else{
            direction=Direction.UP;
        }
    }

    public Floor getCurrentFloor() {
        return currFloor;
    }

    public Floor getDestinationFloor() {
        return destinationFloor;
    }

    public Direction getDirection() {
        return direction;
    }
}
