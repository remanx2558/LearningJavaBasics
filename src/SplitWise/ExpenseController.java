package SplitWise;

import java.util.ArrayList;
import java.util.List;

public class ExpenseController {

    BalanceSheetController bsController;
    List<Expense> expenseList;
    static private ExpenseController instance;
    private SplitFactory factory;

    ExpenseController(){
        expenseList=new ArrayList<>();
        bsController=BalanceSheetController.getInstance();
        factory=new SplitFactory();
    }

    static public ExpenseController getInstance(){
        if(instance==null){
            synchronized (ExpenseController.class){
                if(instance==null){
                    instance=new ExpenseController();
                }
            }
        }
        return instance;
    }

    //amount , users , split type, expensesplit

    void createExpense(double amount, List<Split>splits, User paidBy, SplitType type){
        ExpenseSplit expenseSplit=factory.getExpenseSplit(type);
        if(expenseSplit.validate(splits,amount)){
            Expense expense=new Expense( amount, splits, paidBy,type);
        }
    }



    void addExpense(Group group, Expense expense){
        group.expenses.add(expense);
    }

    void removeExpense(Group group, Expense expense){
        group.expenses.remove(expense);
    }

    void updateExpense(Expense expense){
        //remove
        //add
    }
}
