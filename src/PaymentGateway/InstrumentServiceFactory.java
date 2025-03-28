package PaymentGateway;

public class InstrumentServiceFactory {

    InstrumentService getInstrumentService(InstrumentType instrumentType){
        if(instrumentType==InstrumentType.CARD){
            CardService.getInstance();
        }
        //else its bank
        return BankService.getInstance();
    }

}
