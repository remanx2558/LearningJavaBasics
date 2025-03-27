package PaymentGateway;

public class TransactionService {
    InstrumentController instrumentController;
    Map<User, Transaction> transactionMap;
    Processor processor;

    void makePayment(TranactionDO tranactionDO){
        processor.processPayment(tranactionDO);
    }
    void getTxnHistroy(UserDO userDO){}
}
