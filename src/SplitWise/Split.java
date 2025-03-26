package SplitWise;

public class Split {
    private final String id;

    // Bussiness Parameters
    private SplitType splitType;
    private User user;
    private double owedAmount;
    private double percentage;

    //Getter setter Constructors
    Split(){
        this.id="Some logic to generate id";
    }

    public String getId() {
        return id;
    }


    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getOwedAmount() {
        return owedAmount;
    }

    public void setOwedAmount(double owedAmount) {
        this.owedAmount = owedAmount;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
