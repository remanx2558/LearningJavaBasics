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
    InstrumentDO addInstrument(InstrumentDO instrumentDO){
        if(!userInstruments.containsKey(instrumentDO.getUserId())){userInstruments.put(instrumentDO.getUserId(),new ArrayList<Instrument>());}

        BankInstrument bankInstrument=new BankInstrument(instrumentDO.getUserId());
        bankInstrument.setBankAccountNumber(instrumentDO.getBankAccountNumber());
        bankInstrument.setIfsc(instrumentDO.getIfscNumber());
        bankInstrument.setInstrumentType(InstrumentType.BANK);
        userInstruments.get(instrumentDO.getUserId()).add(bankInstrument);

        instrumentDO.setInstrumentId(bankInstrument.instrumentId);
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
