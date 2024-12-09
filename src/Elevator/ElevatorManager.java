package Elevator;

public class ElevatorManager {
    Floor[] floors;
    Elevator[]elevators;

    public ElevatorManager(){

        //12
    }
    public void initialiseElevators(int n){
        elevators=new Elevator[n];
        for(int i=0;i<n;i++){
            elevators[i]=new Elevator(i);
        }
    }

    public void initialiseFloors(int n){
        floors=new Floor[n];
        for(int i=0;i<n;i++){
            floors[i]=new Floor(i);
        }
    }


}
