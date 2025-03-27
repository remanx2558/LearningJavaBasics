package SplitWise;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> users;
    UserController(){
        users=new ArrayList<>();
    }

    //CRUD
    User getUser(String id){
        for(User user:users){
            if(user.getId().equals(id)){return user;}
        }
        return null;
    }

    List<User> getAllUsers(){return users;}
    void addUser(User user){users.add(user);}
    void removeUser(User user){users.remove(user);}
    //void updateUser(){}
}
