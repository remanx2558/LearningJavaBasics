package LinkedIn;

public class Post {
    String text;
    Byte[] media;
    int totalReacts;
    int totalShares;
    String postId;
    User postOwner;
    Comment[] comments;


    void deleteComments(String commentId){}
    boolean updateText(String commentId){return false;}
    void addComments(String content, String userId){}

}
