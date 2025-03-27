package PaymentGateway;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> userList;

    UserService() {
        userList = new ArrayList<>();
    }

    void addUser(User user) {
        userList.add(user);
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


