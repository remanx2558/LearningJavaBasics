package LinkedIn;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class Group {

    private static final Logger LOGGER = Logger.getLogger(Group.class.getName());
    private String groupName;
    private User createdBy;


    public Group(String groupName, User createdBy) {
        this.groupName = groupName;
        this.createdBy = createdBy;
        LOGGER.info(createdBy.getUsername() + " created group: " + groupName);
    }

    public String getGroupName() {
        return groupName;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", createdBy=" + createdBy.getUsername() +
                '}';
    }


    private int groupId;
    private String name;
    private String description;
    private Date startDate;
    private List<User> members;

    public boolean updateDescription(String newDesc) { return true; }

    String desription;
    User[] memebers;
    int totalMembers;

    boolean updateDescription(){return false;}

}
