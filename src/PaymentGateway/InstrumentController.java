package PaymentGateway;

import java.util.ArrayList;
import java.util.List;

public class InstrumentController {
    InstrumentServiceFactory instrumentServiceFactory;
    InstrumentController(){
        instrumentServiceFactory=new InstrumentServiceFactory();
    }

    void addInstrument(InstrumentDTO instrumentDTO){
        InstrumentService instrumentService=instrumentServiceFactory.getInstrumentService(instrumentDTO.getType());
        instrumentService.addInstrument(instrumentDTO);
    }

    Instrument getInstrument(InstrumentType type, String userId, String instrumentId){
        InstrumentService instrumentService=instrumentServiceFactory.getInstrumentService(type);
        return instrumentService.getInstrument(userId,instrumentId);
    }

    List<Instrument> getAllInstrument(String userId){
        List<Instrument> instrumentList=new ArrayList<>(instrumentServiceFactory.getInstrumentService(InstrumentType.BANK).getAllInstrument(userId));
        instrumentList.addAll(instrumentServiceFactory.getInstrumentService(InstrumentType.CARD).getAllInstrument(userId));
        return instrumentList;
    }
}
