package PaymentGateway;

import PaymentGateway.Controller.InstrumentController;
import PaymentGateway.Controller.UserController;
import PaymentGateway.Services.TransactionService;

public class PaymentGateway {
    UserController userController;
    InstrumentController instrumentController;
    TransactionService transactionService;

    PaymentGateway(){
        userController=UserController.getInstance();
        instrumentController=new InstrumentController();
        transactionService=new TransactionService();
    }

}
