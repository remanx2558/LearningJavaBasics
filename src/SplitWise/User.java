package SplitWise;

public class User {
    private final String id;
    private String name;
    private String password;
    private UserExpenseBalanceSheet userExpenseBalanceSheet;


    //Getter and Setter

    User(String name, String password){
        this.name=name;
        this.password=password;
        this.id=name;
        this.userExpenseBalanceSheet=new UserExpenseBalanceSheet();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }

    public void setUserExpenseBalanceSheet(UserExpenseBalanceSheet userExpenseBalanceSheet) {
        this.userExpenseBalanceSheet = userExpenseBalanceSheet;
    }
}
