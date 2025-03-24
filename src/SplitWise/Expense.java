package SplitWise;

public class Expense {
    String id;
    String description;
    SplitType splitType;
    double amount;
    User paidBy;
    List<Split> reveivedBy;
}
