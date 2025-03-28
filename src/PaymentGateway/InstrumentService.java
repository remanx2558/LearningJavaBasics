package PaymentGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {
    Map<String, List<Instrument>> userInstruments;

    //add instrument
    abstract void addInstrument(String userId, InstrumentDO instrumentDO);

    abstract Instrument getInstrument(String userId, String instrumentId);

    abstract List<Instrument> getAllInstrument(String userId);
}
