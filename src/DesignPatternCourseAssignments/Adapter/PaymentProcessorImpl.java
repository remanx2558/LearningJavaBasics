package DesignPatternCourseAssignments.Adapter;

public class PaymentProcessorImpl implements PayementProcessor {
    @Override
    public void pay(double dollar) {
        System.out.println("paid in dollars: "+dollar);
    }
}
