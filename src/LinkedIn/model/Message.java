package LinkedIn.model;

import LinkedIn.model.user.User;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private User from;
    private User to;
    private String content;
    private LocalDateTime timestamp;


    private int messageId;
    private User sender;
    private List<User> recipients;
    private String text;
//    private Date timestamp;

    public Message(User from, User to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from=" + from.getUsername() +
                ", to=" + to.getUsername() +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                '}';
    }




    public void addRecipient(User user) { }

    User[] recipents;
    Byte[] media;

    boolean addRecipients(){return false;}
}
