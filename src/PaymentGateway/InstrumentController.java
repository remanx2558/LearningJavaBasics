package PaymentGateway;

import java.util.ArrayList;
import java.util.List;

public class InstrumentController {
    InstrumentServiceFactory instrumentServiceFactory;
    InstrumentController(){
        instrumentServiceFactory=new InstrumentServiceFactory();
    }

    void addInstrument(InstrumentDO instrumentDO){
        InstrumentService instrumentService=instrumentServiceFactory.getInstrumentService(instrumentDO.getType());
        instrumentService.addInstrument(instrumentDO.getUserId(),instrumentDO);
    }

    Instrument getInstrument(InstrumentType type, String userId, String instrumentId){
        InstrumentService instrumentService=instrumentServiceFactory.getInstrumentService(type);
        return instrumentService.getInstrument(userId,instrumentId);
    }

    List<Instrument> getAllInstrument(String userId){
        List<Instrument> instrumentList=new ArrayList<>();


        return instrumentList;
    }
}
