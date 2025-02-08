package LinkedIn.model;

import LinkedIn.model.user.User;
import LinkedIn.notification.NotificationMediator;

import java.util.*;

public class Comment {

    private String content;
    private User createdBy;
    private Post post;
    private Map<User, String> reactions; // R8: Reactions on a comment
    private List<Comment> replies;       // Replies to this comment

    public Comment(String content, User createdBy, Post post) {
        this.content = content;
        this.createdBy = createdBy;
        this.post = post;
        this.reactions = new HashMap<>();
        this.replies = new ArrayList<>();
    }

    public String getContent() { return content; }
    public User getCreatedBy() { return createdBy; }
    public Post getPost() { return post; }
    public Map<User, String> getReactions() { return reactions; }
    public List<Comment> getReplies() { return replies; }

    public void addReaction(User user, String reaction) {
        reactions.put(user, reaction);
        NotificationMediator.notifyUser(createdBy, user.getUsername() + " reacted on your comment.");
    }

    public void addReply(Comment reply) {
        replies.add(reply);
        NotificationMediator.notifyUser(createdBy, reply.getCreatedBy().getUsername() + " replied to your comment.");
    }

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                ", createdBy=" + createdBy.getUsername() +
                ", post=" + post +
                ", reactions=" + reactions +
                ", replies=" + replies +
                '}';
    }

    private int commentId;
    private User commenter;
    private String text;
    private int totalReacts;
    private List<Comment> comments;

    public boolean updateText(String newText) { return true; }


    User commentOwner;
    Date timeStamp;

    boolean updateText(){return false;}
}
