package ParkingSystem.Entitiy;


public class Location {
    private final int floor;
    private final int xCoordinate;
    private final int yCoordinate;

    public Location(int f, int x, int y){
        floor=f;
        xCoordinate=x;
        yCoordinate=y;
    }
   public  int getFloor(){
        return floor;
    }
    public int getXCoordinate(){
        return xCoordinate;
    }
   public  int getYCoordinate(){
        return yCoordinate;
    }
}
