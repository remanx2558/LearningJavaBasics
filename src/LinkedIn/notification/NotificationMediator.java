package LinkedIn.notification;

import LinkedIn.model.user.User;

import java.util.logging.Logger;

public class NotificationMediator {
    private static final Logger LOGGER = Logger.getLogger(NotificationMediator.class.getName());

    public static void notifyUser(User user, String notification) {
        LOGGER.info("Notification to " + user.getUsername() + ": " + notification);
    }
}
