package PaymentGateway;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> userList;

    UserService() {
        userList = new ArrayList<>();
    }

    UserDo addUser(UserDo user) {
        User user1=new User(user.getName(),user.getEmail());
        userList.add(user1);
        user.setId(user1.id);
        return user;
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


