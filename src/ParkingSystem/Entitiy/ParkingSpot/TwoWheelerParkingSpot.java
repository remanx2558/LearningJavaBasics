package ParkingSystem.Entitiy.ParkingSpot;

public class TwoWheelerParkingSpot extends ParkingSpot {
    public TwoWheelerParkingSpot(int psId){
        super(psId);
    }
    @Override
    public int getPrice(){
        return 20;
    }
}
