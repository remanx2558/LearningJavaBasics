package LinkedIn.model;

import LinkedIn.model.user.User;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Recommendation {
    private User from;
    private String text;
    private LocalDateTime timestamp;

    public Recommendation(User from, String text) {
        this.from = from;
        this.text = text;
        this.timestamp = LocalDateTime.now();
    }

    public User getFrom() { return from; }
    public String getText() { return text; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Recommendation{" +
                "from=" + from.getUsername() +
                ", text='" + text + '\'' +
                ", timestamp=" + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                '}';
    }

    private int recommendationId;
    private User sender;
    private User receiver;
    private String description;
    private String status;


    int userId;
    Date createdOn;
    boolean isAccepted;

}
