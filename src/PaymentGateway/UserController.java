package PaymentGateway;

public class UserController {

    UserService userService;
    UserController(){
        userService=new UserService();
    }

    void addUser(UserDo user){
        userService.addUser(user);
    }

    User getuser(String userId){
        return userService.getUser(userId);
    }
}
