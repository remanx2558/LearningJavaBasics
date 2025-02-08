package LinkedIn;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LinkedInClient {

    private static final Logger LOGGER = Logger.getLogger(LinkedInClient.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Started Client Application");

        LinkedInApp linkedInApp = new LinkedInApp();

        // 1. Add 4 users with different details
        User user1 = new User("user1",
                new PersonalDetail("Alice Smith", "alice@example.com", "1234567890", "New York", "Software Developer"));
        User user2 = new User("user2",
                new PersonalDetail("Bob Johnson", "bob@example.com", "2345678901", "San Francisco", "Data Scientist"));
        User user3 = new User("user3",
                new PersonalDetail("Carol Williams", "carol@example.com", "3456789012", "Chicago", "Product Manager"));
        User user4 = new User("user4",
                new PersonalDetail("David Brown", "david@example.com", "4567890123", "Seattle", "QA Engineer"));

        linkedInApp.addUser(user1);
        linkedInApp.addUser(user2);
        linkedInApp.addUser(user3);
        linkedInApp.addUser(user4);
        LOGGER.info("4 users added.");

        // 2. Deactivate 2 users (user2 and user3)
        user2.deactivate();
        user3.deactivate();

        // 3. Activate one of the deactivated users (activate user2)
        user2.activate();

        // 4. All the active users send connection request to every other active user
        List<User> activeUsers = new ArrayList<>();
        for (User user : linkedInApp.users) {
            if (user.isActive()) {
                activeUsers.add(user);
            }
        }
        LOGGER.info("Active users: " + activeUsers);

        for (User sender : activeUsers) {
            for (User receiver : activeUsers) {
                if (!sender.equals(receiver)) {
                    sender.sendConnectionRequest(receiver);
                }
            }
        }

        // 5. Everyone accepts the request except one user who ignores the request.
        // In this simulation, let user4 ignore all incoming connection requests.
        for (User user : activeUsers) {
            if (user.equals(user4)) {
                // user4 ignores all requests
                List<User> toIgnore = new ArrayList<>(user.getPendingConnectionRequests());
                for (User sender : toIgnore) {
                    user.ignoreConnectionRequest(sender);
                }
                LOGGER.info(user.getUsername() + " ignored all connection requests.");
            } else {
                // Accept all pending connection requests
                List<User> pending = new ArrayList<>(user.getPendingConnectionRequests());
                for (User sender : pending) {
                    user.acceptConnectionRequest(sender);
                }
            }
        }

        // 6. All the connected users send messages to every other connected user.
        for (User user : activeUsers) {
            for (User connection : user.getConnections()) {
                String messageContent = "Hello " + connection.getUsername() +
                        ", this is " + user.getUsername();
                user.sendMessage(connection, messageContent);
            }
        }

        // 7. Check messages of one of the users (user1) in logs.
        LOGGER.info("Messages for " + user1.getUsername() + ":");
        for (Message msg : user1.getMessages()) {
            LOGGER.info(msg.toString());
        }

        // 8. One user creates a company (user1 creates a company)
        CompanyPage company = new CompanyPage("TechCorp", user1);
        linkedInApp.addCompany(company);

        // 9. The same user also creates a group
        Group group = new Group("Tech Enthusiasts", user1);
        linkedInApp.addGroup(group);

        // 10. That user also posts 4 jobs for that company
        Job job1 = new Job("Software Engineer", "Develop software applications", user1);
        Job job2 = new Job("Data Scientist", "Analyze data and build models", user1);
        Job job3 = new Job("Product Manager", "Manage product lifecycle", user1);
        Job job4 = new Job("QA Engineer", "Test software applications", user1);

        company.addJob(job1);
        company.addJob(job2);
        company.addJob(job3);
        company.addJob(job4);

        // 11. Another user (user2) searches for jobs using company name and job name keyword.
        LOGGER.info(user2.getUsername() + " is searching for jobs at TechCorp with title containing 'Engineer'.");
        linkedInApp.searchJobs("TechCorp", "Engineer");

        // 12. All users search job based on only company page only, and apply to job 1 of that only.
        LOGGER.info("All active users are applying to the first job at TechCorp.");
        for (User user : linkedInApp.users) {
            if (user.isActive()) {
                for (CompanyPage comp : linkedInApp.companies) {
                    if (comp.getCompanyName().equalsIgnoreCase("TechCorp")) {
                        if (!comp.getJobs().isEmpty()) {
                            Job firstJob = comp.getJobs().get(0);
                            firstJob.apply(user);
                        }
                    }
                }
            }
        }

        // 13. Some user creates a post (let user3 create a post)
        Post newPost = new Post("Check out my new blog post on software development!", user3);
        linkedInApp.addPost(newPost);
        LOGGER.info(user3.getUsername() + " created a new post: " + newPost.getContent());
        // Notify all other users about the new post
        for (User user : linkedInApp.users) {
            if (!user.equals(user3)) {
                NotificationMediator.notifyUser(user, "New post from " + user3.getUsername());
            }
        }

        // 14. All the users comment on that post.
        for (User user : linkedInApp.users) {
            Comment comment = new Comment("Great post from " + user.getUsername() + "!", user, newPost);
            linkedInApp.addComment(comment);
            LOGGER.info(user.getUsername() + " commented on the post.");
            // Optionally, notify the post owner about the new comment
            if (!user.equals(newPost.getCreatedBy())) {
                NotificationMediator.notifyUser(newPost.getCreatedBy(), "New comment from " + user.getUsername() + " on your post.");
            }
        }

        // 15. Owner of the post (user3) comments on the comment of all the users' comment.
        // For each comment on the post that was not created by user3, user3 replies.
        // 15. Owner of the post (user3) comments on the comment of all the users' comment.
        for (Comment comment : new ArrayList<>(linkedInApp.comments)) { // Iterate over a copy
            if (comment.getPost().equals(newPost) && !comment.getCreatedBy().equals(user3)) {
                Comment reply = new Comment("Thanks for your comment, " + comment.getCreatedBy().getUsername() + "!", user3, newPost);
                linkedInApp.addComment(reply);
                LOGGER.info(user3.getUsername() + " replied to comment from " + comment.getCreatedBy().getUsername());
                NotificationMediator.notifyUser(comment.getCreatedBy(), "Your comment received a reply from " + user3.getUsername());
            }
        }

    }
}
