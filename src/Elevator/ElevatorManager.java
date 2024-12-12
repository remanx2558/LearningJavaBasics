package Elevator;

public class ElevatorManager {

    Elevator[]elevators;

    public ElevatorManager(int numberOfElevators){
        initialiseElevators(numberOfElevators);
    }
    public void initialiseElevators(int n){
        elevators=new Elevator[n];
        for(int i=0;i<n;i++){
            elevators[i]=new Elevator(i);
        }
    }
    public void pressButtonOutSide(TravelRequest request) throws InterruptedException {

        //find best elevator
        Elevator elevator=findElevator(request);
        elevator.stop();
        System.out.println(request.currFloor.floorNumber+"->"+request.destinationFloor.floorNumber+"*"+elevator.elevatorNumber+":"+elevator.currFloor.floorNumber+" ");

        //add request into that
        elevator.queueRequest(request);
        elevator.start();
    }



    Elevator findElevator(TravelRequest request){
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


            if(elevator.direction==Direction.STOP){
                localDistance=Math.abs(elevator.currFloor.floorNumber-request.currFloor.floorNumber);
            }
            else if(elevator.direction!=request.direction){
                localDistance=eleToLast+LastToRes;
            }
            else if(elevator.direction==request.direction){

                localDistance=eleToLast+LastToRes+200;

            }

            if(elevator.direction==request.direction && elevator.direction==Direction.UP && elevator.currFloor.floorNumber<=request.currFloor.floorNumber){
                localDistance=Math.abs(elevator.currFloor.floorNumber-request.currFloor.floorNumber);
            }
            else if(elevator.direction==request.direction && elevator.direction==Direction.DOWN && elevator.currFloor.floorNumber>=request.currFloor.floorNumber){
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
