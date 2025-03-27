package PaymentGateway;

public class CardInstrument extends Instrument{

    String cardNumber;
    String cvvNumber;

    CardInstrument(String instrumentId,String userId ){
        super(instrumentId,userId);
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }





}
