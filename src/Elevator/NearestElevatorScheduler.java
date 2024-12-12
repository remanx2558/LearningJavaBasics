package Elevator;

public class NearestElevatorScheduler implements Scheduler {

    @Override
   public Elevator selectElevator(Elevator[] elevators,TravelRequest request){
        Elevator serveElevator=null;
        int distance=Integer.MAX_VALUE;


        for(Elevator elevator: elevators){

            int localDistance=Integer.MAX_VALUE;

            Floor lastFloor=elevator.getDestinationFloor();
            int eleToLast=0;
            int LastToRes=0;
            if(lastFloor!=null){
                eleToLast=Math.abs(elevator.currFloor.floorNumber-lastFloor.floorNumber);
                LastToRes=Math.abs(lastFloor.floorNumber - request.currFloor.floorNumber);
            }


            if(elevator.getDirection()==Direction.STOP){
                localDistance=Math.abs(elevator.currFloor.floorNumber-request.currFloor.floorNumber);
            }
            else if(elevator.getDirection()!=request.direction){
                localDistance=eleToLast+LastToRes;
            }
            else if(elevator.getDirection()==request.direction){

                localDistance=eleToLast+LastToRes+200;

            }

            if(elevator.getDirection()==request.direction && elevator.getDirection()==Direction.UP && elevator.currFloor.floorNumber<=request.currFloor.floorNumber){
                localDistance=Math.abs(elevator.currFloor.floorNumber-request.currFloor.floorNumber);
            }
            else if(elevator.getDirection()==request.direction && elevator.getDirection()==Direction.DOWN && elevator.currFloor.floorNumber>=request.currFloor.floorNumber){
                localDistance=Math.abs(elevator.currFloor.floorNumber-request.currFloor.floorNumber);
            }


            //
            if(localDistance<distance){
                distance=localDistance;
                serveElevator=elevator;
            }
        }
        return serveElevator;
    }
}