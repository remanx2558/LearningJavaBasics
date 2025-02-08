package LinkedIn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Job {

    private String jobTitle;
    private String description;
    private User postedBy;
    private List<User> applicants;

    private int jobId;
    private String title;
    private Date postingDate;
    private String companyName;
    private String location;
    private String status;

    public Job(String jobTitle, String description, User postedBy) {
        this.jobTitle = jobTitle;
        this.description = description;
        this.postedBy = postedBy;
        this.applicants = new ArrayList<>();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void apply(User applicant) {
        applicants.add(applicant);
        System.out.println(applicant.getUsername() + " applied for job: " + jobTitle);
    }


    @Override
    public String toString() {
        return "Job{" +
                "jobTitle='" + jobTitle + '\'' +
                ", description='" + description + '\'' +
                ", postedBy=" + postedBy.getUsername() +
                '}';
    }


    String applyUrl;
    User[] usersApplied;
    Date dateOfPosting;
    CompanyPage company;
    String employmentType;

}
