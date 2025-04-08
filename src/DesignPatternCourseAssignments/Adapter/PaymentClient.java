package DesignPatternCourseAssignments.Adapter;

public class PaymentClient {

    public static void main(String args[]){
        PaymentProcessorAdapter adapter=new PaymentProcessorAdapter();
        adapter.pay(160);
    }
}
