package ParkingSystem.Entitiy;

import ParkingSystem.Entitiy.Gate.Gate;
import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Entitiy.Vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private int ticketNumber;
    private int totalParkingChages;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    public Gate entryGate;
    public Gate exitGate;

    private ParkingSpot parkingSpot;
    private Vehicle vehicle;

    // Getters and Setters
    public void setTotalParkingChages(int price){
        this.totalParkingChages=price;
    }
    public LocalDateTime getEntryTime() { return entryTime; }
    public void setEntryTime(LocalDateTime entryTime) { this.entryTime = entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public void setExitTime(LocalDateTime exitTime) { this.exitTime = exitTime; }
    public ParkingSpot getParkingSpot() { return parkingSpot; }
    public void setParkingSpot(ParkingSpot parkingSpot) { this.parkingSpot = parkingSpot; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public void setEntryGate(Gate entryGate) { this.entryGate = entryGate; }
    public void setExitGate(Gate exitGate) { this.exitGate = exitGate; }

}