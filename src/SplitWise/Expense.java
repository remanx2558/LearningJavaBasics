package SplitWise;

import java.util.List;

public class Expense {
    private final String id;
    //Bussiness Parameters
    private String description;
    private double totalAmount;
    private User paidBy;
    private SplitType splitType;
    private List<Split> receivedBy;

    //Getter setters constructor
    Expense(){
        this.id="Some logic to genrate id";
    }

    Expense(String name, double totalAmount,String description,User paidBy,SplitType splitType,List<Split> splits ){
        this.id=name;
        this.description=description;
        this.totalAmount=totalAmount;
        this.receivedBy=splits;
        this.paidBy=paidBy;
        this.splitType=splitType;


    }

    Expense(double totalAmount, List<Split> splits, User paidBy, SplitType type){
        this.id="Some logic to genrate id";
        this.totalAmount=totalAmount;
        this.receivedBy=splits;
        this.paidBy=paidBy;
        this.splitType=type;

    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public List<Split> getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(List<Split> receivedBy) {
        this.receivedBy = receivedBy;
    }
}
