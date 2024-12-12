package ParkingSystem.Entitiy.ParkingSpot;

import ParkingSystem.Entitiy.Location;
import ParkingSystem.Entitiy.Vehicle.Vehicle;
import ParkingSystem.ParkingSystem;

public class ParkingSpot {
    public boolean isEmpty;
    Vehicle vehicle;
    int psId;
    Location location;

    ParkingSpot(int psId, Location location){
        this.psId=psId;
        this.isEmpty=true;
        this.location=location;
    }

    public Location getLocation(){
        return location;
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
