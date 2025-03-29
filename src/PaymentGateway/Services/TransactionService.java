package PaymentGateway.Services;

import PaymentGateway.Controller.InstrumentController;
import PaymentGateway.DTO.TransactionDTO;
import PaymentGateway.Entities.Instrument;
import PaymentGateway.Entities.Transaction;
import PaymentGateway.Entities.User;
import PaymentGateway.Processor;
import PaymentGateway.Controller.UserController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {
    InstrumentController instrumentController;
    public static Map<User, List<Transaction>> transactionMap;
    Processor processor;

    public TransactionService(){
        processor=new Processor();
        transactionMap=new HashMap<>();
        instrumentController=new InstrumentController();
    }

    public void makePayment(TransactionDTO tranactionDO){
        Instrument senderInstrument=instrumentController.getInstrument(tranactionDO.getSenderInstrumentType(),tranactionDO.getSenderUserId(),tranactionDO.getSenderInstrumentId());
        Instrument receiverInstrument=instrumentController.getInstrument(tranactionDO.getReceiverInstrumentType(),tranactionDO.getReceiverUserId(),tranactionDO.getReceiverInstrumentId());
        processor.processPayment(senderInstrument,receiverInstrument,tranactionDO.getAmount());
    }
    List<Transaction> getTxnHistroy(User user){
       return transactionMap.get(user);
    }

    public List<Transaction> getTxnHistroy(String userId){
        User user= UserController.getInstance().getuser(userId);
        return transactionMap.get(user);
    }
}
