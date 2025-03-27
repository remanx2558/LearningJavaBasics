package PaymentGateway;

public class InstrumentServiceFactory {

    InstrumentService getInstrumentService(InstrumentType instrumentType){
        if(instrumentType==InstrumentType.CARD){
            CardService.getInstance();
        }
        return BankService.getInstance();
    }

}
