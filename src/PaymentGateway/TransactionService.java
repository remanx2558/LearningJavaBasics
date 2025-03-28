package PaymentGateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {
    InstrumentController instrumentController;
    public static Map<User, List<Transaction>> transactionMap;
    Processor processor;

    TransactionService(){
        processor=new Processor();
        transactionMap=new HashMap<>();
        instrumentController=new InstrumentController();
    }

    void makePayment(TransactionDTO tranactionDO){
        Instrument senderInstrument=instrumentController.getInstrument(tranactionDO.getSenderInstrumentType(),tranactionDO.getSenderUserId(),tranactionDO.getSenderInstrumentId());
        Instrument receiverInstrument=instrumentController.getInstrument(tranactionDO.getReceiverInstrumentType(),tranactionDO.getReceiverUserId(),tranactionDO.getReceiverInstrumentId());
        processor.processPayment(senderInstrument,receiverInstrument,tranactionDO.getAmount());
    }
    List<Transaction> getTxnHistroy(User user){
       return transactionMap.get(user);
    }

    List<Transaction> getTxnHistroy(String userId){
        User user=UserController.getInstance().getuser(userId);
        return transactionMap.get(user);
    }
}
