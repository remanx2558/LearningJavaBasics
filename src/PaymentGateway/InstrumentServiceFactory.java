package PaymentGateway;

import PaymentGateway.Services.BankService;
import PaymentGateway.Services.CardService;
import PaymentGateway.Services.InstrumentService;
import PaymentGateway.enums.InstrumentType;

public class InstrumentServiceFactory {

    public InstrumentService getInstrumentService(InstrumentType instrumentType){
        if(instrumentType==InstrumentType.CARD){
            CardService.getInstance();
        }
        //else its bank
        return BankService.getInstance();
    }

}
