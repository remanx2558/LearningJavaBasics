package ATM;

public interface BankServer {

    //All operations with abstraction
    public int fetchBalance(User currentUser);
    public void removeMoney(User currentUser,int amount);
}
