package ParkingSystem.Strategy.CC;

import ParkingSystem.Strategy.Pricing.PricingStrategy;

public class FourWheelerCostComputation extends CostComputation {
    FourWheelerCostComputation(PricingStrategy pricingStrategy){
        super(pricingStrategy);
        this.setRates(new int[]{2,30});
    }
}
