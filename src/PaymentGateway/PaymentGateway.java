package PaymentGateway;

public class PaymentGateway {
    UserController userController;
    InstrumentController instrumentController;
    TransactionService transactionService;

    PaymentGateway(){
        userController=new UserController();
        instrumentController=new InstrumentController();
        transactionService=new TransactionService();
    }

}
