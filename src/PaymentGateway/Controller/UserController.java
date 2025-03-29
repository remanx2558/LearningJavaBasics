package PaymentGateway.Controller;

import PaymentGateway.DTO.UserDTO;
import PaymentGateway.Entities.User;
import PaymentGateway.Services.UserService;

public class UserController {



    static private UserController instance;

    public static UserController getInstance(){
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

    public UserDTO addUser(UserDTO user){
        return userService.addUser(user);
    }

    public User getuser(String userId){
        return userService.getUser(userId);
    }
}
