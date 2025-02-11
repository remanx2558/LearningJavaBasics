package LinkedIn.model;

import LinkedIn.model.user.User;
import LinkedIn.notification.NotificationMediator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class CompanyPage extends DigitalSignature {

    private static final Logger LOGGER = Logger.getLogger(CompanyPage.class.getName());
    private String companyName;
    private List<Job> jobs;
    private Set<User> followers;  // R11: Support for following company pages

    public CompanyPage(String companyName, User createdBy) {
        this.companyName = companyName;
        this.createdBy = createdBy;
        this.jobs = new ArrayList<>();
        this.followers = new HashSet<>();
        LOGGER.info(createdBy.getUsername() + " created company page: " + companyName);
    }

    //Getters
    public String getCompanyName() { return companyName; }
    public User getCreatedBy() { return createdBy; }
    public List<Job> getJobs() { return jobs; }
    public Set<User> getFollowers() { return followers; }


    //Setters
    public void addJob(Job job) {
        jobs.add(job);
        LOGGER.info("Job added: " + job.getJobTitle() + " to company: " + companyName);
    }

    public void removeJob(Job job){
        jobs.remove(job);
    }

    public void addFollower(User user) {
        followers.add(user);
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
}
