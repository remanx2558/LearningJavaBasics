package ParkingSystem.Strategy.CC;

import ParkingSystem.Entitiy.ParkingSpot.Manager.FourWheelerParkingSpotManager;
import ParkingSystem.Entitiy.ParkingSpot.Manager.ParkingSpotManager;
import ParkingSystem.Entitiy.ParkingSpot.Manager.TwoWheelerParkingSpotManager;
import ParkingSystem.Entitiy.ParkingSpot.ParkingSpot;
import ParkingSystem.Enum.VehicleType;
import ParkingSystem.Strategy.Parking.NearToEntranceParkingStrategy;
import ParkingSystem.Strategy.Parking.NearToExitParkingStrategy;
import ParkingSystem.Strategy.Pricing.HourlyPricingStrategy;
import ParkingSystem.Strategy.Pricing.MinutelyPricingStrategy;

import java.util.List;

public class CostComputationFactory {
    private static TwoWheelerCostComputation twoWheelerCostComputation;
    private static FourWheelerCostComputation fourWheelerCostComputation;

    private static List<ParkingSpot> twoWheelerParkingSpots;
    private static List<ParkingSpot> fourWheelerParkingSpots;


    public static CostComputation getManager(VehicleType type) {
        if (type == VehicleType.TWO_WHEELER) {
            if (twoWheelerCostComputation == null) {
                twoWheelerCostComputation = new TwoWheelerCostComputation(new HourlyPricingStrategy());
            }
            return twoWheelerCostComputation;
        } else {
            if (fourWheelerCostComputation == null) {
                fourWheelerCostComputation = new FourWheelerCostComputation(new MinutelyPricingStrategy());
            }
            return fourWheelerCostComputation;
        }
    }
}
