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

    void makePayment(Transaction tranactionDO){
        processor.processPayment(tranactionDO);
    }
    void getTxnHistroy(UserDo userDO){}
}
