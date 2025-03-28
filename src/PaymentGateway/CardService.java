package PaymentGateway;

import java.util.ArrayList;
import java.util.List;

public class CardService extends InstrumentService{

    static CardService instance;

    static CardService getInstance(){
        if(instance==null){
            synchronized (CardService.class){
                if(instance==null){
                    instance=new CardService();
                }
            }
        }
        return instance;
    }

    /// /


    //add instrument
    InstrumentDO addInstrument(InstrumentDO instrumentDO){
        if(!userInstruments.containsKey(instrumentDO.getUserId())){userInstruments.put(instrumentDO.getUserId(),new ArrayList<Instrument>());}

        CardInstrument cardInstrument=new CardInstrument(instrumentDO.getUserId());
        cardInstrument.setCardNumber(instrumentDO.getCardNumber());
        cardInstrument.setCvvNumber(instrumentDO.getCvvNumber());
        cardInstrument.setInstrumentType(InstrumentType.CARD);
        userInstruments.get(instrumentDO.getUserId()).add(cardInstrument);

        instrumentDO.setInstrumentId(cardInstrument.instrumentId);
        return instrumentDO;
    }
    //get Instrument

    Instrument getInstrument(String userId, String instrumentId){
        List<Instrument> instrumentList=userInstruments.get(userId);
        if(instrumentList!=null){
            for(Instrument instrument:instrumentList){
                if(instrument.getInstrumentId().equals(instrumentId)){return instrument;}
            }
        }
        return null;
    }

    List<Instrument> getAllInstrument(String userId){
        List<Instrument> instrumentList=userInstruments.get(userId);
        return instrumentList;
    }
}
