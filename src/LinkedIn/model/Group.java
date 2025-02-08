package LinkedIn.model;

import LinkedIn.model.user.User;
import LinkedIn.notification.NotificationMediator;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class Group {

    private static final Logger LOGGER = Logger.getLogger(Group.class.getName());
    private String groupName;
    private User createdBy;
    private Set<User> members; // R13: Members of the group

    public Group(String groupName, User createdBy) {
        this.groupName = groupName;
        this.createdBy = createdBy;
        this.members = new HashSet<>();
        LOGGER.info(createdBy.getUsername() + " created group: " + groupName);
    }

    public String getGroupName() { return groupName; }
    public User getCreatedBy() { return createdBy; }
    public Set<User> getMembers() { return members; }

    public void addMember(User user) {
        members.add(user);
        LOGGER.info(user.getUsername() + " joined group: " + groupName);
        NotificationMediator.notifyUser(createdBy, user.getUsername() + " joined your group " + groupName);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", createdBy=" + createdBy.getUsername() +
                ", members=" + members +
                '}';
    }


    private int groupId;
    private String name;
    private String description;
    private Date startDate;

    public boolean updateDescription(String newDesc) { return true; }

    String desription;
    User[] memebers;
    int totalMembers;

    boolean updateDescription(){return false;}

}
