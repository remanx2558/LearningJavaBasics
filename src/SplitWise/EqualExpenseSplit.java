package SplitWise;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit{

    @Override
    public boolean validate(List<Split> splitList, double amount) {
        return false;
    }
}
