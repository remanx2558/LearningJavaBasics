package PaymentGateway;

public class UserController {


    static UserController instance;

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

    UserDo addUser(UserDo user){
        userService.addUser(user);
        return user;
    }

    User getuser(String userId){
        return userService.getUser(userId);
    }
}
