package SplitWise;

public class Split {

    // Bussiness Parameters
    private SplitType splitType;
    private User user;
    private double owedAmount;
    private double percentage;

    //Getter setter Constructors
    Split(User user, double owedAmount){
        this.user=user;
        this.owedAmount=owedAmount;
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
