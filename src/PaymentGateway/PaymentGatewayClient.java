package PaymentGateway;

import java.util.List;

public class PaymentGatewayClient {
    public static void main(String args[]){
        PaymentGateway paymentGateway=new PaymentGateway();


        //add user1
        UserDo user1=new UserDo();
        user1.setName("yg");
        user1.setEmail("yashwant@gmail.com");
        UserDo user1Dtails=paymentGateway.userController.addUser(user1);

        //add user2
        UserDo user2=new UserDo();
        user2.setName("kt");
        user2.setEmail("kittu@gmail.com");
        UserDo user2Dtails=paymentGateway.userController.addUser(user2);


        //add bank to user1
        InstrumentDO bankInstrumentDO=new InstrumentDO();
        bankInstrumentDO.setBankAccountNumber("123");
        bankInstrumentDO.setIfscNumber("345");
        bankInstrumentDO.setType(InstrumentType.BANK);
        bankInstrumentDO.setUserId(user1.getId());

        paymentGateway.instrumentController.addInstrument(bankInstrumentDO);


        //add card to user2
        InstrumentDO cardInstrumentDO=new InstrumentDO();
        cardInstrumentDO.setCardNumber("567");
        cardInstrumentDO.setCvvNumber("789");
        cardInstrumentDO.setType(InstrumentType.CARD);
        cardInstrumentDO.setUserId(user2.getId());

        paymentGateway.instrumentController.addInstrument(cardInstrumentDO);


        //make payment

        TransactionDo transactionDo=new TransactionDo();
        transactionDo.setAmount(10);
        transactionDo.setSenderUserId(user1.getId());
        transactionDo.setReceiverUserId(user2.getId());
        transactionDo.setSenderInstrumentId(bankInstrumentDO.instrumentId);
        transactionDo.setReceiverInstrumentId(cardInstrumentDO.getInstrumentId());
        paymentGateway.transactionService.makePayment(transactionDo);


        //get all instruments  of user2
        List<Instrument> user1Instruments=paymentGateway.instrumentController.getAllInstrument(user1.getId());
        for(Instrument instrument:user1Instruments){
            System.out.println(instrument.getInstrumentId()+" * ");
        }




        //get all instruments  of user2
        List<Instrument> user2Instruments=paymentGateway.instrumentController.getAllInstrument(user2.getId());
        for(Instrument instrument:user2Instruments){
            System.out.println(instrument.getInstrumentId()+" * ");
        }


        //get all transaction History
        List<Transaction> user1transaction=paymentGateway.transactionService.getTxnHistroy(user1);
        for (Transaction transaction: user1transaction){
            System.out.println(transaction.getTxnId()+" * ");
        }



    }
}
