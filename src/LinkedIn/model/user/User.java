package LinkedIn.model.user;

import LinkedIn.model.*;
import LinkedIn.notification.NotificationMediator;

import java.util.Date;
import java.util.List;
import java.util.Queue;

import java.util.*;
import java.util.logging.Logger;

public class User extends Person{


    private static final Logger LOGGER = Logger.getLogger(User.class.getName());
    private PersonalDetail personalDetail;
    private boolean active;
    private Set<User> connections;
    private List<Message> messages;
    private Set<User> pendingConnectionRequests;


    // New fields for following and metrics (R4, R5)
    private Set<User> followers;
    private Set<User> following;
    private int profileViews;
    private int searchAppearances;

    // For recommendations (R6)
    private List<Recommendation> recommendationsReceived;
    private List<Recommendation> recommendationsGiven;

    //For Posts
    private List<Post> posts;




    private int userId;
    private Date dateOfJoining;
    private Profile profile;
    private List<User> followsUser;
    private List<CompanyPage> followCompanies;
    private List<Group> joinedGroups;
    private List<CompanyPage> createdCompanies;
    private List<Group> createdGroups;



    public User(String username, PersonalDetail personalDetail) {
        this.username = username;
        this.personalDetail = personalDetail;
        this.active = true;
        this.connections = new HashSet<>();
        this.messages = new ArrayList<>();
        this.pendingConnectionRequests = new HashSet<>();
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
        this.profileViews = 0;
        this.posts=new ArrayList<>();

        this.searchAppearances = 0;
        this.recommendationsReceived = new ArrayList<>();
        this.recommendationsGiven = new ArrayList<>();
    }

    public String getUsername() { return username; }
    public PersonalDetail getPersonalDetail() { return personalDetail; }
    public boolean isActive() { return active; }

    public void deactivate() {
        this.active = false;
        LOGGER.info(username + " deactivated.");
    }

    public void activate() {
        this.active = true;
        LOGGER.info(username + " activated.");
    }

    public Set<User> getConnections() { return connections; }
    public List<Message> getMessages() { return messages; }
    public Set<User> getPendingConnectionRequests() { return pendingConnectionRequests; }

    public Set<User> getFollowers() { return followers; }
    public Set<User> getFollowing() { return following; }

    public int getProfileViews() { return profileViews; }
    public int getSearchAppearances() { return searchAppearances; }

    public List<Recommendation> getRecommendationsReceived() { return recommendationsReceived; }
    public List<Recommendation> getRecommendationsGiven() { return recommendationsGiven; }

    // Metrics increment methods (R5)
    public void incrementProfileViews() {
        profileViews++;
    }

    public void addPost(Post newPost){
        posts.add(newPost);
       // linkedInApp.addPost(this);
        //notify every connection regarding the post
    }



    public void incrementSearchAppearances() {
        searchAppearances++;
    }

    // R3: Connection request methods
    public void sendConnectionRequest(User target) {
        if (!this.active) {
            LOGGER.warning(username + " is deactivated and cannot send connection requests.");
            return;
        }
        if (!target.isActive()) {
            LOGGER.warning(target.username + " is deactivated and cannot receive connection requests.");
            return;
        }
        target.receiveConnectionRequest(this);
        LOGGER.info(username + " sent connection request to " + target.username);
        NotificationMediator.notifyUser(target, "You have a new connection request from " + this.username);
    }

    public void receiveConnectionRequest(User sender) {
        pendingConnectionRequests.add(sender);
        LOGGER.info(username + " received connection request from " + sender.username);
    }

    public void acceptConnectionRequest(User sender) {
        if (pendingConnectionRequests.contains(sender)) {
            pendingConnectionRequests.remove(sender);
            connections.add(sender);
            sender.connections.add(this);
            LOGGER.info(username + " accepted connection request from " + sender.username);
            NotificationMediator.notifyUser(sender, username + " accepted your connection request.");
        } else {
            LOGGER.warning(username + " has no connection request from " + sender.username);
        }
    }

    public void ignoreConnectionRequest(User sender) {
        if (pendingConnectionRequests.contains(sender)) {
            pendingConnectionRequests.remove(sender);
            LOGGER.info(username + " ignored connection request from " + sender.username);
        }
    }

    // R3: Cancel connection request
    public void cancelConnectionRequest(User target) {
        if (target.pendingConnectionRequests.contains(this)) {
            target.pendingConnectionRequests.remove(this);
            LOGGER.info(username + " cancelled connection request to " + target.username);
            NotificationMediator.notifyUser(target, username + " cancelled the connection request.");
        } else {
            LOGGER.warning("No pending connection request to cancel for " + target.username);
        }
    }

    // R4: Follow functionality (without becoming a full connection)
    public void followUser(User target) {
        if (!this.equals(target)) {
            following.add(target);
            target.followers.add(this);
            LOGGER.info(username + " is now following " + target.username);
            NotificationMediator.notifyUser(target, username + " started following you.");
        }
    }

    public void unfollowUser(User target) {
        if (following.contains(target)) {
            following.remove(target);
            target.followers.remove(this);
            LOGGER.info(username + " unfollowed " + target.username);
        }
    }

    // R9: Messaging
    public void sendMessage(User recipient, String content) {
        if (!connections.contains(recipient)) {
            LOGGER.warning(username + " is not connected with " + recipient.username + ". Cannot send message.");
            return;
        }
        Message message = new Message(this, recipient, content);
        recipient.receiveMessage(message);
        LOGGER.info(username + " sent message to " + recipient.username + ": " + content);
        NotificationMediator.notifyUser(recipient, "New message from " + this.username);
    }

    public void receiveMessage(Message message) {
        messages.add(message);
        LOGGER.info(username + " received message from " + message.getFrom().username +
                ": " + message.getContent());
    }

    // R6: Recommendation methods
    public void requestRecommendation(User target) {
        NotificationMediator.notifyUser(target, username + " has requested a recommendation from you.");
        LOGGER.info(username + " requested a recommendation from " + target.username);
    }

    public void giveRecommendation(User target, String text) {
        Recommendation rec = new Recommendation(this, text);
        target.recommendationsReceived.add(rec);
        this.recommendationsGiven.add(rec);
        LOGGER.info(username + " gave a recommendation to " + target.username + ": " + text);
        NotificationMediator.notifyUser(target, "You have received a recommendation from " + this.username);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", active=" + active +
                ", profileViews=" + profileViews +
                ", searchAppearances=" + searchAppearances +
                ", personalDetail=" + personalDetail +
                '}';
    }
    // Send a connection request to another user

    // Receive a connection request from another user

    // Send a message to a connected user

    // Receive a message

    public boolean sendMessage(Message message) { return true; }
    public boolean sendInvite(ConnectionInvitation invite) { return true; }
    public boolean cancelInvite(ConnectionInvitation invite) { return true; }
    public boolean createDeleteCompany(CompanyPage company) { return true; }
    public boolean createDeleteGroup(Group group) { return true; }
    public boolean createDeletePost(Post post) { return true; }
    public boolean createDeleteComment(Comment comment) { return true; }
    public boolean reactToPost(Post post) { return true; }
    public boolean acceptRecommendation(User user) { return true; }
    public boolean applyForJob(Job job) { return true; }



    //Map<String, String> messages;//key senderuserId+timeStamp  value: content


    Job[] jobs;
    Queue<User> invites;



    boolean createPage(CompanyPage company){return false;}
    boolean deletePage(CompanyPage company){return false;}

    boolean createGroup(Group group){return false;}
    boolean deleteGroup(Group group){return false;}



    void updateDetail(Profile profile){}
    void removeDetail(Profile profile){}


    void createJob(Job job){}
    void removeJob(String jobId){}

    void sendInvite(User user){}
    void cancelInvite(User user){}



    boolean rejectRecommendation(User user){return  false;}
    boolean react(Post post){return false;}


    void sendMessage(String userId, String content){}
    //post related: Send Notification of creation and updation
    boolean createComment(Comment comment){return false;}
    void addComment2(String content, String commentId){}
    boolean deleteComment(Comment comment){return false;}
    //post related: Send Notification of creation and updation
    void createPost(){}
    void deletePost(){}
    void updatePost(){}
}
