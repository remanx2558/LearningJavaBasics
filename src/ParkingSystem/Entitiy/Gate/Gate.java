package ParkingSystem.Entitiy.Gate;

public abstract class Gate {
    private final int id;
    private final String location;

    public Gate(int id, String location) {
        this.id = id;
        this.location = location;
    }

    public int getId() { return id; }
    public String getLocation() { return location; }
}
