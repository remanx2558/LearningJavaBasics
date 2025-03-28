package PaymentGateway;

public class UserController {

    UserService userService;
    UserController(){
        userService=new UserService();
    }

    UserDo addUser(UserDo user){
        userService.addUser(user);
        return user;
    }

    User getuser(String userId){
        return userService.getUser(userId);
    }
}
