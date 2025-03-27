package PaymentGateway;

public class TransactionDo {
    String senderUserId;
    String receiverUserId;
    String senderInstrumentId;
    String receiverInstrumentId;
    double amount;
    InstrumentType instrumentType;
    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
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
