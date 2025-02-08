package LinkedIn;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CompanyPage {

    private static final Logger LOGGER = Logger.getLogger(CompanyPage.class.getName());
    private String companyName;
    private User createdBy;
    private List<Job> jobs;

    public CompanyPage(String companyName, User createdBy) {
        this.companyName = companyName;
        this.createdBy = createdBy;
        this.jobs = new ArrayList<>();
        LOGGER.info(createdBy.getUsername() + " created company page: " + companyName);
    }

    public String getCompanyName() {
        return companyName;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void addJob(Job job) {
        jobs.add(job);
        LOGGER.info("Job added: " + job.getJobTitle() + " to company: " + companyName);
    }

    @Override
    public String toString() {
        return "CompanyPage{" +
                "companyName='" + companyName + '\'' +
                ", createdBy=" + createdBy.getUsername() +
                ", jobs=" + jobs +
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
