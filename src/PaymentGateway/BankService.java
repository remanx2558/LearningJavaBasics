package PaymentGateway;

public class BankService extends InstrumentService{
    static BankService instance;

    static BankService getInstance(){
        if(instance==null){
            synchronized (BankService.class){
                if(instance==null){
                    instance=new BankService();
                }
            }
        }
        return instance;
    }


}
