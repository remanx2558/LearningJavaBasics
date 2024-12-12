package Elevator;

public class ElevatorClient {
    public static void main(String []args) throws InterruptedException {

        ElevatorManager elevatorManager=new ElevatorManager(12);

        elevatorManager.pressButtonOutSide(new TravelRequest(new Floor(0),new Floor(5)));
        elevatorManager.pressButtonOutSide(new TravelRequest(new Floor(0),new Floor(6)));
        elevatorManager.pressButtonOutSide(new TravelRequest(new Floor(0),new Floor(1)));
        elevatorManager.pressButtonOutSide(new TravelRequest(new Floor(0),new Floor(2)));
        elevatorManager.pressButtonOutSide(new TravelRequest(new Floor(0),new Floor(2)));
        elevatorManager.pressButtonOutSide(new TravelRequest(new Floor(0),new Floor(5)));
        elevatorManager.pressButtonOutSide(new TravelRequest(new Floor(2),new Floor(5)));
        elevatorManager.pressButtonOutSide(new TravelRequest(new Floor(1),new Floor(5)));

    }
}
