package LinkedIn;

import java.util.Date;

public class Comment {
    User commentOwner;
    String commentId;
    String text;
    int totalReacts;
    Comment[] comments;
    Date timeStamp;

    boolean updateText(){return false;}
}
