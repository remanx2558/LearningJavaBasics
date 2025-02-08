package LinkedIn.model;

import LinkedIn.model.user.User;
import LinkedIn.notification.NotificationMediator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class CompanyPage {

    private static final Logger LOGGER = Logger.getLogger(CompanyPage.class.getName());
    private String companyName;
    private User createdBy;
    private List<Job> jobs;
    private Set<User> followers;  // R11: Support for following company pages

    public CompanyPage(String companyName, User createdBy) {
        this.companyName = companyName;
        this.createdBy = createdBy;
        this.jobs = new ArrayList<>();
        this.followers = new HashSet<>();
        LOGGER.info(createdBy.getUsername() + " created company page: " + companyName);
    }

    public String getCompanyName() { return companyName; }
    public User getCreatedBy() { return createdBy; }
    public List<Job> getJobs() { return jobs; }
    public Set<User> getFollowers() { return followers; }

    public void addJob(Job job) {
        jobs.add(job);
        LOGGER.info("Job added: " + job.getJobTitle() + " to company: " + companyName);
    }

    public void addFollower(User user) {
        followers.add(user);
        LOGGER.info(user.getUsername() + " is now following company: " + companyName);
        NotificationMediator.notifyUser(createdBy, user.getUsername() + " started following your company page " + companyName);
    }

    @Override
    public String toString() {
        return "CompanyPage{" +
                "companyName='" + companyName + '\'' +
                ", createdBy=" + createdBy.getUsername() +
                ", jobs=" + jobs +
                ", followers=" + followers +
                '}';
    }


    private int pageId;
    private String title;
    private String about;
    private String companyType;
    private int companySize;
    private User admin;

    public boolean createJobPosting(Job job) { return true; }
    public boolean deleteJobPosting(Job job) { return true; }



    Post[] posts;
    String companyId;

    String type;
    String description;
    String name;

    boolean createJobPosting(){return false;}
    boolean deleteJobPosting(){return false;}

}
