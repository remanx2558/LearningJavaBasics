package PaymentGateway.Entities;

public class BankInstrument extends Instrument {
    String bankAccountNumber;
    String ifsc;
    public BankInstrument(String userId ){
        super(userId);
    }



    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }
}
