package ParkingSystem.Entitiy.ParkingSpot;

import ParkingSystem.Entitiy.Vehicle.Vehicle;
import ParkingSystem.ParkingSystem;

public class ParkingSpot {
    public boolean isEmpty;
    Vehicle vehicle;
    int psId;

    ParkingSpot(int psId){
        this.psId=psId;
        this.isEmpty=true;
    }


    public void parkVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
        isEmpty=false;

    }

    public void removeVehicle(){
        vehicle=null;
        isEmpty=true;
    }

    public boolean isAvailable(){
        return isEmpty;
    }
}
