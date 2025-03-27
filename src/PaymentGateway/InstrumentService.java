package PaymentGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {
    Map<String, List<InstrumentDO>> userInstruments;

    //add instrument
    void addInstrument(String userId, InstrumentDO instrumentDO){
        if(!userInstruments.containsKey(userId)){userInstruments.put(userId,new ArrayList<InstrumentDO>());}
        userInstruments.get(userId).add(instrumentDO);
    }
    //get Instrument

    InstrumentDO getInstrument(String userId, String instrumentId){
        List<InstrumentDO> instrumentDOList=userInstruments.get(userId);
        if(instrumentDOList!=null){
            for(InstrumentDO instrumentDO:instrumentDOList){
                if(instrumentDO.getInstrumentId().equals(instrumentId)){return instrumentDO;}
            }
        }
        return null;
    }
}
