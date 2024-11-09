package ParkingSystem.Entitiy.ParkingSpot;

public class FourWheelerParkingSpot extends ParkingSpot {
    public FourWheelerParkingSpot(int psId){
        super(psId);
    }
    @Override
    public int getPrice(){
        return 40;
    }
}
