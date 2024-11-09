package ParkingSystem.Strategy.CC;

import ParkingSystem.Entitiy.Ticket;
import ParkingSystem.Strategy.Pricing.PricingStrategy;

public class CostComputation {
    private final PricingStrategy pricingStrategy;
    int []rates;

    public CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
        rates=new int[2];
        rates[0]=1;
        rates[1]=50;
    }
    public void setRates(int []rates){
        this.rates=rates;
    }

    public int computePrice(Ticket ticket) {
        return pricingStrategy.calculatePrice(ticket,rates);
    }
}
