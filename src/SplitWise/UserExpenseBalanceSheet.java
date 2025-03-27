package SplitWise;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    private Map<User, Balance> friendBalance;
    private double amountOweTotal;
    private double amountGetBackTotal;

    UserExpenseBalanceSheet(){
        friendBalance=new HashMap<>();
        amountGetBackTotal=0;
        amountOweTotal=0;
    }


    //Getter and Setters


    public Map<User, Balance> getFriendBalance() {
        return friendBalance;
    }

    public void setFriendBalance(Map<User, Balance> friendBalance) {
        this.friendBalance = friendBalance;
    }

    public double getAmountOweTotal() {
        return amountOweTotal;
    }

    public void setAmountOweTotal(double amountOweTotal) {
        this.amountOweTotal = amountOweTotal;
    }

    public double getAmountGetBackTotal() {
        return amountGetBackTotal;
    }

    public void setAmountGetBackTotal(double amountGetBackTotal) {
        this.amountGetBackTotal = amountGetBackTotal;
    }
}
