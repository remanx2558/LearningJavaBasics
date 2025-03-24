package SplitWise;

public class ExpenseService {

    void addExpense(Group group, Expense expense){
        group.expenses.add(expense);
    }

    void removeExpense(Group group, Expense expense){
        group.expenses.remove(expense);
    }


    void updateExpense(Expense expense){

    }
}
