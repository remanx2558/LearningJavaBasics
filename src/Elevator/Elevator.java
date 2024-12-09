package Elevator;

public class Elevator {
    int id;
    Movement movement;
    Floor currFloor;
    Floor DestinationFloor;
    public Elevator(int id){
        this.id=id;
        movement=Movement.STOP;
    }

}
