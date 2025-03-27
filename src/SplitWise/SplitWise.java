package SplitWise;

public class SplitWise {
    UserController userController;
    GroupController groupController;

    BalanceSheetController balanceSheetController;

    SplitWise(){
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = BalanceSheetController.getInstance();
    }

}
