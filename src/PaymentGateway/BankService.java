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
    void addInstrument(String userId, InstrumentDO instrumentDO){
        if(!userInstruments.containsKey(userId)){userInstruments.put(userId,new ArrayList<Instrument>());}

        BankInstrument bankInstrument=new BankInstrument(instrumentDO.getInstrumentId(),instrumentDO.getUserId());
        bankInstrument.setBankAccountNumber(instrumentDO.getBankAccountNumber());
        bankInstrument.setIfsc(instrumentDO.getInstrumentId());
        userInstruments.get(userId).add(bankInstrument);
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


}
