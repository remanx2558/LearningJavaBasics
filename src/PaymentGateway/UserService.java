package PaymentGateway;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    static List<User> userList = new ArrayList<>();


    UserDTO addUser(UserDTO userDo) {
        User user1=new User(userDo.getName(),userDo.getEmail());
        userList.add(user1);
        //add missing elements in DO to return
        userDo.setId(user1.id);
        return userDo;
    }

    User getUser(String userId) {
        for (User user : userList) {
            if (user.getId().compareTo(userId)==0) {
                return user;
            }
        }
        return null;
    }
}


