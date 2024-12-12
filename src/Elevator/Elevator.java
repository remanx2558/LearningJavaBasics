package Elevator;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Elevator {
    int elevatorNumber;
    Direction direction;
    Status status;

    //max floor can go
    //min floor can go

    PriorityQueue<Floor> upList;
    PriorityQueue<Floor> downList;

    Floor currFloor;

    public Elevator(int elevatorNumber){
        this.elevatorNumber = elevatorNumber;
        direction = Direction.UP;
        status=Status.ACTIVE;

        upList=new PriorityQueue<Floor>((a,b)->a.floorNumber-b.floorNumber);//min-heap
        downList=new PriorityQueue<Floor>((a,b)->b.floorNumber-a.floorNumber);//max-heap
        currFloor=new Floor(0);
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

    public void queueRequest(TravelRequest req){
        //now we have to add it in here
        if(req.destinationFloor.floorNumber>currFloor.floorNumber){
            upList.add(new Floor(req.destinationFloor.floorNumber));
        }
        else if(req.destinationFloor.floorNumber<currFloor.floorNumber){
            downList.add(new Floor(req.destinationFloor.floorNumber));
        }
        else{
            //throw exception ki same floor ki bachodi
        }

    }

    public void stop(){
        status=Status.INACTIVE;
    }

    public void start() throws InterruptedException {
        status=Status.ACTIVE;

        moveLift();
        direction=direction==Direction.UP?Direction.DOWN:Direction.UP;
        moveLift();
        direction=direction==Direction.UP?Direction.DOWN:Direction.UP;

    }

    private void moveLift() throws InterruptedException {

        PriorityQueue<Floor> currList=direction==Direction.UP?upList:downList;
        //iterate it
        while(!currList.isEmpty() && status==Status.ACTIVE){
            Floor currFloor=currList.poll();
            this.currFloor=currFloor;
            System.out.println("Curr Floor:"+currFloor.floorNumber);
            Thread.sleep(1000);
        }
    }

}
