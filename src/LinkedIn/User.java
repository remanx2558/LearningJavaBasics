package LinkedIn;

import java.util.Date;
import java.util.Map;
import java.util.Queue;

public class User extends Person{
    int userId;
    Date dateOfJoining;
    Profile profile;




    Post[] post;
    User[] connections;
    User[] followUsers;
    Company[] followCompany;
    Group[] joinedGroups;
    Company[] createdPages;
    Group[] createdGroups;



    //Map<String, String> messages;//key senderuserId+timeStamp  value: content


    Job[] jobs;
    Queue<User> invites;


    boolean sendMessage(Message message){return false;}

    boolean createPage(Company company){return false;}
    boolean deletePage(Company company){return false;}

    boolean createGroup(Group group){return false;}
    boolean deleteGroup(Group group){return false;}



    void updateDetail(Profile profile){}
    void removeDetail(Profile profile){}


    void createJob(Job job){}
    void removeJob(String jobId){}

    void sendInvite(User user){}
    void cancelInvite(User user){}



    boolean applyForJob(Job job){return false;}
    boolean acceptRecommendation(User user){return  false;}
    boolean rejectRecommendation(User user){return  false;}
    boolean react(Post post){return false;}


    void sendMessage(String userId, String content){}
    //post related: Send Notification of creation and updation
    boolean createComment(Comment comment){return false;}
    void addComment2(String content, String commentId){}
    boolean deleteComment(Comment comment){return false;}
    //post related: Send Notification of creation and updation
    void createPost(){}
    void deletePost(){}
    void updatePost(){}
}
