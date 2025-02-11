package LinkedIn.model;

import LinkedIn.model.user.User;
import LinkedIn.notification.NotificationMediator;

import java.util.*;

public class Comment extends DigitalSignature{

    private String content;
    private Post post;
    private Map<User, String> reactions; // R8: Reactions on a comment
    private List<Comment> replies;


    public Comment(String content, User createdBy, Post post) {
        this.content = content;
        this.createdBy = createdBy;
        this.post = post;
        this.reactions = new HashMap<>();
        this.replies = new ArrayList<>();
        createdAt= new Date();
    }

    //Getters

    public String getContent() { return content; }
    public User getCreatedBy() { return createdBy; }
    public Post getPost() { return post; }
    public Map<User, String> getReactions() { return reactions; }
    public List<Comment> getReplies() { return replies; }

    //Setters
    public void addReaction(User user, String reaction) {
        reactions.put(user, reaction);
        NotificationMediator.notifyUser(createdBy, user.getUsername() + " reacted on your comment.");
    }

    public void addReply(Comment reply) {
        replies.add(reply);
        NotificationMediator.notifyUser(createdBy, reply.getCreatedBy().getUsername() + " replied to your comment.");
    }

    public void updateText(String updateContent, User updater) {
        content=updateContent;
        updatedBy=updater;
        updatedAt= new Date();
    }

    //Sinature
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
}
