package ParkingSystem.Strategy.CC;

import ParkingSystem.Strategy.Pricing.PricingStrategy;

public class TwoWheelerCostComputation extends CostComputation {
    TwoWheelerCostComputation(PricingStrategy pricingStrategy){
        super(pricingStrategy);
        this.setRates(new int[]{1,10});
    }
}
