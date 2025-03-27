package SplitWise;

import java.util.ArrayList;
import java.util.List;

public class BalanceSheetController {

    List<UserExpenseBalanceSheet> balanceSheetList;
    static private BalanceSheetController instance;

    //
    void showBalanceSheetOfUser(User user){
        System.out.println(user.getUserExpenseBalanceSheet().toString());
    }

    //add remove update

    private BalanceSheetController(){
        balanceSheetList=new ArrayList<>();
    }

    //get instance
    static BalanceSheetController getInstance(){
        if(instance==null){
            synchronized (BalanceSheetController.class){
                if(instance==null){
                    instance=new BalanceSheetController();
                }
            }
        }
        return instance;
    }

    //add
    void addBS(UserExpenseBalanceSheet bs){
        balanceSheetList.add(bs);
    }
    //remove
    void removeBs(UserExpenseBalanceSheet bs){
        balanceSheetList.remove(bs);
    }
    //update
    void updateFriendBalance(UserExpenseBalanceSheet bs,User friend, Balance bl){

        //step1: update balance related to that friend
        //donot exist
        Balance oldBalnce=new Balance(0,0);

        if(!bs.getFriendBalance().containsKey(friend)){
            oldBalnce=bs.getFriendBalance().get(friend);

        }

        //remove it
        bs.setAmountOweTotal(bs.getAmountOweTotal()-oldBalnce.getAmountOwe());
        bs.setAmountGetBackTotal(bs.getAmountGetBackTotal()-oldBalnce.getAmountGetBack());

        //modify
        oldBalnce.setAmountOwe(bl.getAmountOwe()+oldBalnce.getAmountOwe());
        oldBalnce.setAmountGetBack(bl.getAmountGetBack()+oldBalnce.getAmountGetBack());
        bs.getFriendBalance().put(friend,oldBalnce);

        //put it back

        bs.setAmountOweTotal(bs.getAmountOweTotal()+oldBalnce.getAmountOwe());
        bs.setAmountGetBackTotal(bs.getAmountGetBackTotal()+oldBalnce.getAmountGetBack());

    }


}
