package LinkedIn;

import java.util.Date;
import java.util.List;

public class Comment {

    private String content;
    private User createdBy;
    private Post post;

    public Comment(String content, User createdBy, Post post) {
        this.content = content;
        this.createdBy = createdBy;
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Post getPost() {
        return post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                ", createdBy=" + createdBy.getUsername() +
                ", post=" + post +
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
