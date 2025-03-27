package PaymentGateway;

public class Transaction {
    String txnId;
    String senderUserId;
    String receiverUserId;
    String senderInstrumentId;
    String receiverInstrumentId;
    double amount;
    TransactionStatus status;
}
