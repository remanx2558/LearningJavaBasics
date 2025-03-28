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




    //add instrument
    InstrumentDTO addInstrument(InstrumentDTO instrumentDTO){
        if(!userInstruments.containsKey(instrumentDTO.getUserId())){userInstruments.put(instrumentDTO.getUserId(),new ArrayList<Instrument>());}

        CardInstrument cardInstrument=new CardInstrument(instrumentDTO.getUserId());
        cardInstrument.setCardNumber(instrumentDTO.getCardNumber());
        cardInstrument.setCvvNumber(instrumentDTO.getCvvNumber());
        cardInstrument.setInstrumentType(InstrumentType.CARD);
        userInstruments.get(instrumentDTO.getUserId()).add(cardInstrument);

        instrumentDTO.setInstrumentId(cardInstrument.instrumentId);
        return instrumentDTO;
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
