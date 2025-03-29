package PaymentGateway.Services;

import PaymentGateway.DTO.InstrumentDTO;
import PaymentGateway.Entities.CardInstrument;
import PaymentGateway.Entities.Instrument;
import PaymentGateway.enums.InstrumentType;

import java.util.ArrayList;
import java.util.List;

public class CardService extends InstrumentService {

    static CardService instance;

   public static CardService getInstance(){
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
    public InstrumentDTO addInstrument(InstrumentDTO instrumentDTO){
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

    public Instrument getInstrument(String userId, String instrumentId){
        List<Instrument> instrumentList=userInstruments.get(userId);
        if(instrumentList!=null){
            for(Instrument instrument:instrumentList){
                if(instrument.getInstrumentId().equals(instrumentId)){return instrument;}
            }
        }
        return null;
    }

    public List<Instrument> getAllInstrument(String userId){
        List<Instrument> instrumentList=userInstruments.get(userId);
        return instrumentList;
    }
}
