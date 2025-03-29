package PaymentGateway.Services;

import PaymentGateway.DTO.InstrumentDTO;
import PaymentGateway.Entities.Instrument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {
    static Map<String, List<Instrument>> userInstruments;

    InstrumentService(){
        userInstruments=new HashMap<>();
    }

    //add instrument
    public abstract InstrumentDTO addInstrument(InstrumentDTO instrumentDO);

    public abstract Instrument getInstrument(String userId, String instrumentId);

    public abstract List<Instrument> getAllInstrument(String userId);
}
