package ParkingSystem.Entitiy.Gate;

import ParkingSystem.Entitiy.Location;

public abstract class Gate {
    private final int id;
    private final Location location;

    public Gate(int id, Location location) {
        this.id = id;
        this.location = location;
    }

    public int getId() { return id; }
    public Location getLocation() { return location; }
}
