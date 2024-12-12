package Elevator;

public class ElevatorManager {

    Elevator[] elevators;
    Scheduler scheduler;

    public ElevatorManager(int numberOfElevators, Scheduler scheduler){
        this.scheduler = scheduler;
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
        Elevator elevator=scheduler.selectElevator(elevators, request);
        System.out.println("Request: " + request.currFloor.floorNumber + "->" + request.destinationFloor.floorNumber
                + " assigned to Elevator: " + elevator.elevatorNumber);

        elevator.handleRequest(request);
//        elevator.queueRequest(request);
//        elevator.start();
    }



}
