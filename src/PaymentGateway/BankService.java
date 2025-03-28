package PaymentGateway;

import java.util.ArrayList;
import java.util.List;

public class BankService extends InstrumentService{
    static BankService instance;

    static BankService getInstance(){
        if(instance==null){
            synchronized (BankService.class){
                if(instance==null){
                    instance=new BankService();
                }
            }
        }
        return instance;
    }


    /// /

    //add instrument
    InstrumentDTO addInstrument(InstrumentDTO instrumentDTO){
        if(!userInstruments.containsKey(instrumentDTO.getUserId())){userInstruments.put(instrumentDTO.getUserId(),new ArrayList<Instrument>());}

        BankInstrument bankInstrument=new BankInstrument(instrumentDTO.getUserId());
        bankInstrument.setBankAccountNumber(instrumentDTO.getBankAccountNumber());
        bankInstrument.setIfsc(instrumentDTO.getIfscNumber());
        bankInstrument.setInstrumentType(InstrumentType.BANK);
        userInstruments.get(instrumentDTO.getUserId()).add(bankInstrument);

        instrumentDTO.setInstrumentId(bankInstrument.instrumentId);
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
