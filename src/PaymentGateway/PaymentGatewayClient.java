package PaymentGateway;

import PaymentGateway.DTO.InstrumentDTO;
import PaymentGateway.DTO.TransactionDTO;
import PaymentGateway.DTO.UserDTO;
import PaymentGateway.Entities.Instrument;
import PaymentGateway.Entities.Transaction;
import PaymentGateway.enums.InstrumentType;

import java.util.List;

public class PaymentGatewayClient {
    public static void main(String args[]){
        PaymentGateway paymentGateway=new PaymentGateway();


        //add user1
        UserDTO user1=new UserDTO();
        user1.setName("yg");
        user1.setEmail("yashwant@gmail.com");
        UserDTO user1Dtails=paymentGateway.userController.addUser(user1);

        //add user2
        UserDTO user2=new UserDTO();
        user2.setName("kt");
        user2.setEmail("kittu@gmail.com");
        UserDTO user2Dtails=paymentGateway.userController.addUser(user2);


        //add bank to user1
        InstrumentDTO bankInstrumentDO=new InstrumentDTO();
        bankInstrumentDO.setBankAccountNumber("123");
        bankInstrumentDO.setIfscNumber("345");
        bankInstrumentDO.setType(InstrumentType.BANK);
        bankInstrumentDO.setUserId(user1Dtails.getId());

        paymentGateway.instrumentController.addInstrument(bankInstrumentDO);


        //add card to user2
        InstrumentDTO cardInstrumentDO=new InstrumentDTO();
        cardInstrumentDO.setCardNumber("567");
        cardInstrumentDO.setCvvNumber("789");
        cardInstrumentDO.setType(InstrumentType.CARD);
        cardInstrumentDO.setUserId(user2Dtails.getId());

        paymentGateway.instrumentController.addInstrument(cardInstrumentDO);


        //make payment

        TransactionDTO transactionDo=new TransactionDTO();
        transactionDo.setAmount(10);

        transactionDo.setSenderUserId(user1Dtails.getId());
        transactionDo.setReceiverUserId(user2Dtails.getId());

        transactionDo.setSenderInstrumentType(InstrumentType.BANK);
        transactionDo.setReceiverInstrumentType(InstrumentType.CARD);

        transactionDo.setSenderInstrumentId(bankInstrumentDO.instrumentId);
        transactionDo.setReceiverInstrumentId(cardInstrumentDO.instrumentId);

        paymentGateway.transactionService.makePayment(transactionDo);


        //get all instruments  of user2
        List<Instrument> user1Instruments=paymentGateway.instrumentController.getAllInstrument(user1Dtails.getId());
        for(Instrument instrument:user1Instruments){
            System.out.println(instrument.getInstrumentId()+" * ");
        }




        //get all instruments  of user2
        List<Instrument> user2Instruments=paymentGateway.instrumentController.getAllInstrument(user2Dtails.getId());
        for(Instrument instrument:user2Instruments){
            System.out.println(instrument.getInstrumentId()+" * ");
        }


        //get all transaction History
        List<Transaction> user1transaction=paymentGateway.transactionService.getTxnHistroy(user1Dtails.getId());
        for (Transaction transaction: user1transaction){
            System.out.println(transaction.getTxnId()+" * ");
        }



    }
}
