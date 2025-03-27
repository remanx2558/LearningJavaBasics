package ZoomCar;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a physical location (city, address, or coordinates).
 */
public class Location {
    private String city;
    private String address;

    public Location(String city, String address) {
        this.city = city;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}