package SplitWise;

import java.util.ArrayList;
import java.util.List;

public class ExpenseController {

    BalanceSheetController bsController;
    List<Expense> expenseList;
    static private ExpenseController instance;

    ExpenseController(){
        expenseList=new ArrayList<>();
        bsController=BalanceSheetController.getInstance();
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
