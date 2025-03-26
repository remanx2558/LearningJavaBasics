package SplitWise;

import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplit{

    @Override
    public boolean validate(List<Split> splitList, double amount) {
        double totalPercentage=0;
        for(Split split: splitList){
            totalPercentage+=split.getPercentage();
        }
        return totalPercentage==100.00;
    }
}
