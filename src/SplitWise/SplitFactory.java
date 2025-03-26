package SplitWise;

public class SplitFactory {
    public static ExpenseSplit getExpenseSplit(SplitType splitType){
        if(splitType.equals(SplitType.PERCENTAGE)){return new PercentageExpenseSplit();}
        else if(splitType.equals(SplitType.EQUAL)){return new EqualExpenseSplit();}
        return new PercentageExpenseSplit();
    }
}
