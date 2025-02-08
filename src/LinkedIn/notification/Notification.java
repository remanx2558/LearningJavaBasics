package LinkedIn.notification;

import LinkedIn.model.user.Account;
import LinkedIn.model.user.User;

import java.util.Date;

public class Notification {

    private int notificationId;
    private User recipient;
    private Date date;
    private String content;


    int notification;
    Date createdOn;


    boolean send(Account account){return false;}
}
