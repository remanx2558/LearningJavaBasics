package ParkingSystem.Entitiy.ParkingSpot.Manager;

import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Enum.VehicleType;
import ParkingSystem.Strategy.Parking.NearToEntranceParkingStrategy;
import ParkingSystem.Strategy.Parking.NearToExitParkingStrategy;

import java.util.List;

public class ParkingSpotManagerFactory {
    private static TwoWheelerParkingSpotManager twoWheelerManager;
    private static FourWheelerParkingSpotManager fourWheelerManager;

    private static List<ParkingSpot> twoWheelerParkingSpots;
    private static List<ParkingSpot> fourWheelerParkingSpots;

    public ParkingSpotManagerFactory( List<ParkingSpot> twoWheelerParkingSpots,  List<ParkingSpot> fourWheelerParkingSpots){
        this.twoWheelerParkingSpots=twoWheelerParkingSpots;
        this.fourWheelerParkingSpots=fourWheelerParkingSpots;
    }

    public static ParkingSpotManager getManager(VehicleType type) {
        if (type == VehicleType.TWO_WHEELER) {
            if (twoWheelerManager == null) {
                twoWheelerManager = new TwoWheelerParkingSpotManager(twoWheelerParkingSpots,new NearToExitParkingStrategy());
            }
            return twoWheelerManager;
        } else {
            if (fourWheelerManager == null) {
                fourWheelerManager = new FourWheelerParkingSpotManager(fourWheelerParkingSpots,new NearToEntranceParkingStrategy());
            }
            return fourWheelerManager;
        }
    }
}