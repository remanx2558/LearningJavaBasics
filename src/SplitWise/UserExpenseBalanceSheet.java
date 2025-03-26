package SplitWise;

import java.util.Map;

public class UserExpenseBalanceSheet {
    private final String id;
    private Map<User, Balance> friendBalance;
    private double amountOweTotal;
    private double amountGetBackTotal;


    //Getter and Setters


    public UserExpenseBalanceSheet() {
        this.id = "Some logic to generate id";
    }

    public String getId() {
        return id;
    }

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
