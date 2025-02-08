package LinkedIn;

import java.util.Date;
import java.util.List;

public class Post {

    private String content;
    private User createdBy;

    public Post(String content, User createdBy) {
        this.content = content;
        this.createdBy = createdBy;
    }

    public String getContent() {
        return content;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                ", createdBy=" + createdBy.getUsername() +
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
