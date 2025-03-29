package PaymentGateway.DTO;

import PaymentGateway.enums.InstrumentType;

public class TransactionDTO {
    String senderUserId;
    String receiverUserId;
    String senderInstrumentId;
    String receiverInstrumentId;
    double amount;
    InstrumentType senderInstrumentType;
    InstrumentType receiverInstrumentType;

    public InstrumentType getReceiverInstrumentType() {
        return receiverInstrumentType;
    }

    public void setReceiverInstrumentType(InstrumentType receiverInstrumentType) {
        this.receiverInstrumentType = receiverInstrumentType;
    }

    public InstrumentType getSenderInstrumentType() {
        return senderInstrumentType;
    }

    public void setSenderInstrumentType(InstrumentType senderInstrumentType) {
        this.senderInstrumentType = senderInstrumentType;
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
}
