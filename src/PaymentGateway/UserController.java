package PaymentGateway;

public class UserController {



    static private UserController instance;

    static UserController getInstance(){
        if(instance==null){
            synchronized (UserController.class){
                if(instance==null){
                    instance=new UserController();
                }
            }
        }
        return instance;
    }



    UserService userService;
    UserController(){
        userService=new UserService();
    }

    UserDTO addUser(UserDTO user){
        return userService.addUser(user);
    }

    User getuser(String userId){
        return userService.getUser(userId);
    }
}
