package PaymentGateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {
    InstrumentController instrumentController;
    Map<User, List<Transaction>> transactionMap;
    Processor processor;

    TransactionService(){
        processor=new Processor();
        transactionMap=new HashMap<>();
        instrumentController=new InstrumentController();
    }

    void makePayment(TransactionDo tranactionDO){
        Instrument instrument=instrumentController.getInstrument(tranactionDO.getInstrumentType(),tranactionDO.getSenderUserId(),tranactionDO.getSenderInstrumentId());
        processor.processPayment(tranactionDO);
    }
    List<Transaction> getTxnHistroy(User user){
       return transactionMap.get(user);
    }

    List<Transaction> getTxnHistroy(String userId){
        User user=UserController.getInstance().getuser(userId);
        return transactionMap.get(user);
    }
}
