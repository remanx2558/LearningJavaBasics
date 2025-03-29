package PaymentGateway;

import PaymentGateway.Entities.Instrument;

public class Processor {
    public void processPayment(Instrument senderInstrument, Instrument receiverInstrument, double amount){
        //some bussiness logic
        System.out.println("Payment happened");

    }
}
