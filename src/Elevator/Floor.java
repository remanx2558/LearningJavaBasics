package Elevator;

public class Floor {
    int floorNumber;
    public Floor(int floorNumber){
        this.floorNumber = floorNumber;
    }
    @Override
    public String toString() {
        return "Floor " + floorNumber;
    }
}
