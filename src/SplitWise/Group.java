package SplitWise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
    String id;
    String name;
    String description;

    List<User> users;
    List<Expense> expenses;


    ExpenseController expenseController;
    Group(String name){
        expenseController=ExpenseController.getInstance();
        users=new ArrayList<>();
        expenses=new ArrayList<>();
        this.name=name;
        this.id=name;
    }
    //add remove members
    void addMember(User user){
        users.add(user);
    }

    void removeMember(User user){
        boolean isEnvolved=false;
        for(Expense expense: expenses){

        }
        if(isEnvolved){
            //throw new Exception("1st Settle the Group then allowed to leave the group");
            return;
        }
        users.remove(user);
    }






    //get expense with
    Expense getExpense(String expenseId){
        for(Expense expense: expenses){
            if(expense.getId().compareTo(expenseId)==0){
                return expense;
            }
        }
        return null;
    }
    //add expense
    void addExpense(Expense expense){
        if(expense==null){return;}
        expenses.add(expense);
       // expenseController.addExpense(expense);
    }

    void removeExpesne(Expense expense){
        if(expense==null){return;}
        expenses.remove(expense);
    }

    void updateExpense(String expenseId, Expense modifiedExpense){
        Expense oldExpense=getExpense(expenseId);
        removeExpesne(oldExpense);
        addExpense(modifiedExpense);
    }

    //settle user
    void paidOwedAmount(User user, double paidAmount){

       // int totalOwe=0;
       // Map<User,Integer> toEachIndividual=new HashMap<>();
        for(Expense expense:expenses){
            if(!expense.getPaidBy().equals(user)){
                for(Split split:expense.getReceivedBy()){
                    if(split.getUser().equals(user)){

                        if(split.getOwedAmount()<paidAmount){
                            paidAmount-=split.getOwedAmount();
                            expense.getReceivedBy().remove(split);

                        }
                        else if(split.getOwedAmount()==paidAmount){
                            paidAmount=0;
                            expense.getReceivedBy().remove(split);
                        }
                        else{
                            split.setOwedAmount(split.getOwedAmount()-paidAmount);
                            paidAmount=0;
                            return;
                        }

                    }
                }

            }
        }

    }

    //setters and getters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public ExpenseController getExpenseController() {
        return expenseController;
    }

    public void setExpenseController(ExpenseController expenseController) {
        this.expenseController = expenseController;
    }
}
