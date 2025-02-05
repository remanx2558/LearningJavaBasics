package LinkedIn;

public class Message {
    int messageId;
    User sender;
    User[] recipents;
    String text;
    Byte[] media;

    boolean addRecipients(){return false;}
}
