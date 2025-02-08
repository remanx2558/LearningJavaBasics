package LinkedIn.model;

import LinkedIn.model.user.User;
import LinkedIn.notification.NotificationMediator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Post {

    private static final Logger LOGGER = Logger.getLogger(Post.class.getName());
    private String content;
    private User createdBy;
    private Map<User, String> reactions; // R8: Reaction functionality

    public Post(String content, User createdBy) {
        this.content = content;
        this.createdBy = createdBy;
        this.reactions = new HashMap<>();
    }

    public String getContent() { return content; }
    public User getCreatedBy() { return createdBy; }
    public Map<User, String> getReactions() { return reactions; }

    public void addReaction(User user, String reaction) {
        reactions.put(user, reaction);
        LOGGER.info(user.getUsername() + " reacted with " + reaction + " on post by " + createdBy.getUsername());
        NotificationMediator.notifyUser(createdBy, user.getUsername() + " reacted on your post.");
    }

    public void removeReaction(User user) {
        reactions.remove(user);
        LOGGER.info(user.getUsername() + " removed reaction from post by " + createdBy.getUsername());
    }

    // Share functionality (R8): returns a new Post as a shared copy
    public Post sharePost(User sharer) {
        String sharedContent = "Shared: " + content;
        Post sharedPost = new Post(sharedContent, sharer);
        LOGGER.info(sharer.getUsername() + " shared a post originally by " + createdBy.getUsername());
        NotificationMediator.notifyUser(createdBy, sharer.getUsername() + " shared your post.");
        return sharedPost;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                ", createdBy=" + createdBy.getUsername() +
                ", reactions=" + reactions +
                '}';
    }

    private int postId;
    private User owner;
    private String text;
    private Date timestamp;
    private List<Comment> comments;

    public boolean updateText(String newText) { return true; }



    Byte[] media;
    int totalReacts;
    int totalShares;
    User postOwner;


    void deleteComments(String commentId){}
    void addComments(String content, String userId){}

}
