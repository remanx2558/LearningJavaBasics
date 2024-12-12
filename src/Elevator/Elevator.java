package Elevator;

import Elevator.state.ElevatorState;
import Elevator.state.IdleState;
import Elevator.state.StoppedState;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Elevator {
    int elevatorNumber;
    private Direction direction;
    private Status status;
    private ElevatorState state;

    //max floor can go
    //min floor can go

    PriorityQueue<Floor> upList;
    PriorityQueue<Floor> downList;

    Floor currFloor;

    public Elevator(int elevatorNumber){
        this.elevatorNumber = elevatorNumber;
        direction = Direction.UP;
        status= Status.INACTIVE;
        this.state = new IdleState();
        upList=new PriorityQueue<Floor>((a,b)->a.floorNumber-b.floorNumber);//min-heap
        downList=new PriorityQueue<Floor>((a,b)->b.floorNumber-a.floorNumber);//max-heap
        currFloor=new Floor(0);
    }
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public Floor getCurrentFloor() {
        return currFloor;
    }


    public Floor getDestinationFloor(){
        PriorityQueue<Floor> currList=null;
        if(direction==Direction.UP){
            currList=upList;
        }
        else if(direction==Direction.DOWN){
           currList=downList;
        }
        else{
            return currFloor;
        }


        Floor lastElement = null;
        Iterator<Floor> iterator = currList.iterator();
        while (iterator.hasNext()) {
            lastElement = iterator.next();
        }
        return lastElement;
    }

    public boolean hasPendingRequests() {
        return !upList.isEmpty() || !downList.isEmpty();
    }

    public void queueRequest(TravelRequest req){
        //now we have to add it in here
        if(req.destinationFloor.floorNumber>currFloor.floorNumber){
            upList.add(new Floor(req.destinationFloor.floorNumber));
        }
        else if(req.destinationFloor.floorNumber<currFloor.floorNumber){
            downList.add(new Floor(req.destinationFloor.floorNumber));
        }
        else{
            if (req.getDirection() == Direction.UP) {
                upList.add(req.getDestinationFloor());
            } else if (req.getDirection() == Direction.DOWN) {
                downList.add(req.getDestinationFloor());
            }
        }

    }



    public void start() throws InterruptedException {
        this.status = Status.ACTIVE;
        if (this.direction == Direction.STOP) {
            // If no direction, elevator is idle
            setState(new IdleState());
        }
        // Let the state handle movement
        while (this.status == Status.ACTIVE && (hasPendingRequests() || this.direction != Direction.STOP)) {
            state.move(this);
        }
    }
    public void stop() {
        this.status = Status.INACTIVE;
        this.setState(new StoppedState());
    }

    private void moveLift() throws InterruptedException {

        PriorityQueue<Floor> currList=direction==Direction.UP?upList:downList;
        //iterate it
        while(true){
            //have requests
            //direction man
            processNextFloor();
        }
    }

    public void handleRequest(TravelRequest request) throws InterruptedException {
        state.onRequest(this, request);
        if (this.status == Status.INACTIVE) {
            this.status = Status.ACTIVE;
            start();
        }
    }

    public void processNextFloor() throws InterruptedException {
        PriorityQueue<Floor> currList = (direction == Direction.UP) ? upList : downList;
        if (!currList.isEmpty()) {
            Floor nextFloor = currList.poll();
            // Simulate travel time
            simulateTravelTime();
            currFloor = nextFloor;
            System.out.println("Elevator " + elevatorNumber + " is now at Floor: " + currFloor.floorNumber);
        } else {
            // No floors in the current direction queue
            direction = Direction.STOP;
        }
    }

    private void simulateTravelTime() throws InterruptedException {
        Thread.sleep(500);
    }

}
