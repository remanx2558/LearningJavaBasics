package PaymentGateway.Entities;

import PaymentGateway.enums.InstrumentType;
import PaymentGateway.enums.TransactionStatus;

public class Transaction {
    String txnId;
    String senderUserId;
    String receiverUserId;
    String senderInstrumentId;
    String receiverInstrumentId;
    double amount;

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    TransactionStatus status;
    InstrumentType instrumentType;

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(String senderUserId) {
        this.senderUserId = senderUserId;
    }

    public String getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(String receiverUserId) {
        this.receiverUserId = receiverUserId;
    }

    public String getSenderInstrumentId() {
        return senderInstrumentId;
    }

    public void setSenderInstrumentId(String senderInstrumentId) {
        this.senderInstrumentId = senderInstrumentId;
    }

    public String getReceiverInstrumentId() {
        return receiverInstrumentId;
    }

    public void setReceiverInstrumentId(String receiverInstrumentId) {
        this.receiverInstrumentId = receiverInstrumentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
