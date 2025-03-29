package PaymentGateway.Entities;

public class CardInstrument extends Instrument {

    String cardNumber;
    String cvvNumber;

    public CardInstrument(String userId ){
        super(userId);
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
