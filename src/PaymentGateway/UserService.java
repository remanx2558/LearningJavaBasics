package PaymentGateway;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> userList;

    UserService() {
        userList = new ArrayList<>();
    }

    void addUser(UserDo user) {
        User user1=new User(user.getId(), user.getName(),user.getEmail());
        userList.add(user1);
    }

    User getUser(String userId) {
        for (User user : userList) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
}


