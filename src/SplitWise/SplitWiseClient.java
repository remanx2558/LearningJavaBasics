package SplitWise;

import java.util.ArrayList;
import java.util.List;

public class SplitWiseClient {

    public static SplitWise splitWise;
    public static void main(String args[]){
        splitWise=new SplitWise();
        demo();

    }

    public static void demo(){

        setupUserAndGroup();

        //Step1: add members to the group
        Group group = splitWise.groupController.getGroup("G1001");
        group.addMember(splitWise.userController.getUser("U2001"));
        group.addMember(splitWise.userController.getUser("U3001"));

        //Step2. create an expense inside a group
        List<Split> splits = new ArrayList<>();
        Split split1 = new Split(splitWise.userController.getUser("U1001"), 300);
        Split split2 = new Split(splitWise.userController.getUser("U2001"), 300);
        Split split3 = new Split(splitWise.userController.getUser("U3001"), 300);
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);
        Expense expense1=new Expense("Exp1001",
                900,
                "Breakfast",
                splitWise.userController.getUser("U1001"),
                SplitType.EQUAL, splits);
        group.addExpense(expense1);

        List<Split> splits2 = new ArrayList<>();
        Split splits2_1 = new Split(splitWise.userController.getUser("U1001"), 400);
        Split splits2_2 = new Split(splitWise.userController.getUser("U2001"), 100);
        splits2.add(splits2_1);
        splits2.add(splits2_2);

        Expense expense2=new Expense("Exp1002",
                500,
                "Lunch",
                splitWise.userController.getUser("U2001"),
                SplitType.UNEQUAL, splits2);
        group.addExpense(expense2);

        for(User user : splitWise.userController.getAllUsers()) {
            splitWise.balanceSheetController.showBalanceSheetOfUser(user);
        }
    }



    public  static void setupUserAndGroup(){

        //onboard user to splitwise app
        addUsersToSplitwiseApp();

        //create a group by user1
        User user1 = splitWise.userController.getUser("U1001");
        splitWise.groupController.createNewGroup("G1001", "Outing with Friends", user1);
    }

    private  static void addUsersToSplitwiseApp(){

        //adding User1
        User user1 = new User("U1001", "User1");

        //adding User2
        User user2 = new User ("U2001", "User2");

        //adding User3
        User user3 = new User ("U3001", "User3");

        splitWise.userController.addUser(user1);
        splitWise.userController.addUser(user2);
        splitWise.userController.addUser(user3);
    }

}
