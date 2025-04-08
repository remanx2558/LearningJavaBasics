package DesignPatternCourseAssignments.Adapter;

public class PaymentProcessorAdapter {
    PayementProcessor payementProcessor=new PaymentProcessorImpl();
    double DOLLAR_TO_RUPEE_CONVERSION_RATE=80;
    public void pay(double rupee){
        payementProcessor.pay(rupee/DOLLAR_TO_RUPEE_CONVERSION_RATE);
    }
}
