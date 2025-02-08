package ATM;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Machine {
    private BankServer bankServer;
    private TreeMap<Denomination,Integer> notes;
    private User currentUser;
    Machine(){
        notes=new TreeMap<>((a,b)->b.val-a.val);

        //add some values default
        notes.put(Denomination.FIVE_HUNDRED,500);
        notes.put(Denomination.TWO_HUNDRED,500);
        notes.put(Denomination.ONE_HUNDRED,500);
    }

    private void addMoney(Denomination denomination, int count){
        if(!notes.containsKey(denomination)){
            return;
        }
        int totalCount=notes.get(denomination)+count;
        notes.put(denomination,totalCount);
    }

    private void removeMoney(Denomination denomination, int count) throws Exception {
        if(!notes.containsKey(denomination)){
            return;
        }
        int totalCount=notes.get(denomination);
        if(totalCount<count){
            throw new Exception("Money Not Available");
        }
        totalCount=totalCount-count;
        notes.put(denomination,totalCount);
    }

    private boolean checkMachineAvailableAmount(int amount){

        for (Map.Entry<Denomination, Integer> denominationIntegerEntry : notes.entrySet()) {
            Denomination key=denominationIntegerEntry.getKey();
            int count=denominationIntegerEntry.getValue();


            int times=amount/key.val;
            if(times>count){
                amount=amount-(key.val*count);
            }
            else if(times<=count){
                amount=amount-(key.val*times);
            }

            if(amount==0){
                return  true;
            }

        }
        return false;
    }

   private  boolean checkUserCapability(int amount){
        int totalBalance=bankServer.fetchBalance(currentUser);
        if(amount<=totalBalance){
            return true;
        }
        return false;
   }

    void withDrawMoney(int amount) throws Exception {
        boolean isMachineAvailable=checkMachineAvailableAmount(amount);
        if(!isMachineAvailable){
            throw new Exception("Enter Amount in denomination of 500");
        }

        boolean isAmountAvailable=checkUserCapability(amount);
        if(!isAmountAvailable){
            throw new Exception("You Don't Have sufficient Balance to withdraw");
        }

        bankServer.removeMoney(currentUser,amount);
        disPatchMoney(amount);
        logout();
    }

    private void disPatchMoney(int amount){
        for (Map.Entry<Denomination, Integer> denominationIntegerEntry : notes.entrySet()) {
            Denomination key=denominationIntegerEntry.getKey();
            int count=denominationIntegerEntry.getValue();
            int times=amount/key.val;

            int reduceCount=Math.min(times,count);

            amount=amount-(key.val*reduceCount);
            notes.put(key,count-reduceCount);

            if(amount==0){
                return;
            }

        }
        System.out.println("Please Collect Your Money....");

    }

    void logout(){
        currentUser=null;
    }

    void logIn(Card cardDetails, String password){
        //currentUser=bankServer.getUserDetail(cardDetails,password);
    }



}
