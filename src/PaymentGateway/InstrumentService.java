package PaymentGateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {
    static Map<String, List<Instrument>> userInstruments;

    InstrumentService(){
        userInstruments=new HashMap<>();
    }

    //add instrument
    abstract InstrumentDTO addInstrument(InstrumentDTO instrumentDO);

    abstract Instrument getInstrument(String userId, String instrumentId);

    abstract List<Instrument> getAllInstrument(String userId);
}
