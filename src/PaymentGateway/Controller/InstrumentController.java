package PaymentGateway.Controller;

import PaymentGateway.DTO.InstrumentDTO;
import PaymentGateway.Entities.Instrument;
import PaymentGateway.Services.InstrumentService;
import PaymentGateway.InstrumentServiceFactory;
import PaymentGateway.enums.InstrumentType;

import java.util.ArrayList;
import java.util.List;

public class InstrumentController {
    InstrumentServiceFactory instrumentServiceFactory;
    public InstrumentController(){
        instrumentServiceFactory=new InstrumentServiceFactory();
    }

    public void addInstrument(InstrumentDTO instrumentDTO){
        InstrumentService instrumentService=instrumentServiceFactory.getInstrumentService(instrumentDTO.getType());
        instrumentService.addInstrument(instrumentDTO);
    }

    public Instrument getInstrument(InstrumentType type, String userId, String instrumentId){
        InstrumentService instrumentService=instrumentServiceFactory.getInstrumentService(type);
        return instrumentService.getInstrument(userId,instrumentId);
    }

    public List<Instrument> getAllInstrument(String userId){
        List<Instrument> instrumentList=new ArrayList<>(instrumentServiceFactory.getInstrumentService(InstrumentType.BANK).getAllInstrument(userId));
        instrumentList.addAll(instrumentServiceFactory.getInstrumentService(InstrumentType.CARD).getAllInstrument(userId));
        return instrumentList;
    }
}
