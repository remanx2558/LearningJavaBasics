package PaymentGateway;

public class CardService {

    static CardService instance;

    static CardService getInstance(){
        if(instance==null){
            synchronized (CardService.class){
                if(instance==null){
                    instance=new CardService();
                }
            }
        }
        return instance;
    }
}
