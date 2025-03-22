package ParkingSystem;



import java.time.LocalDateTime;public abstract class UserAccount {
    String id;
    String password;
    String name;
    String phone;
    boolean isBlocked;
    Session session;
    AccountType accountType;

    public String getName() {
        return name;
    }

    UserAccount(String name, String password){
        this.name=name;
        this.password=password;
        id= IdGenerator.generateId();
        accountType=AccountType.PARKING_AGENT;
    }


    //login and logout
    public void logIn(int id, String password){
        String token=generateToken(id,password,accountType);
        this.session=new Session(token);
    }

    public void logOut(){
        session=null;
    }
    //add remove session
    private String generateToken(int id, String password, AccountType accountType){
        return ""+id+password+accountType.toString();
    }

    //having valid session or logged In
    public boolean isValidSession(){
        return session!=null
                && session.getTimeToLive().compareTo(LocalDateTime.now())>0
                && session.isActive();
    }


}
