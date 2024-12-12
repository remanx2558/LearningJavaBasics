package ParkingSystem;

import ParkingSystem.Entitiy.Location;

public  class Util {
    public static int distanceCalculator(Location l1, Location l2){
        int x=Math.abs(l1. getXCoordinate()-l2.getXCoordinate());
        int y=Math.abs(l1. getYCoordinate()-l2.getYCoordinate());
        int f=Math.abs(l1. getFloor()-l2.getFloor())*10;

        return x+y+f;
    }

}
