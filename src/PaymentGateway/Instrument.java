package PaymentGateway;

import Common.util.IdGenerator;

public abstract class Instrument {
    String instrumentId;
    String userId;
    InstrumentType instrumentType;

    //getter and setter

    public Instrument( String userId) {
        this.instrumentId = IdGenerator.generateId();
        this.userId = userId;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }
}
