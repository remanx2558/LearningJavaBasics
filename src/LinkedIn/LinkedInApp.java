package LinkedIn;

import java.util.HashSet;

public class LinkedInApp {

    // Collections to hold our data
    HashSet<User> users;
    HashSet<CompanyPage> companies;
    HashSet<Post> posts;
    HashSet<Comment> comments;
    HashSet<Group> groups;

    // Constructor
    public LinkedInApp() {
        users = new HashSet<>();
        companies = new HashSet<>();
        posts = new HashSet<>();
        comments = new HashSet<>();
        groups = new HashSet<>();
    }

    // Methods to add data
    public void addUser(User user) {
        users.add(user);
    }

    public void addCompany(CompanyPage company) {
        companies.add(company);
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }


    // Method to search for jobs by company name and job title keyword
    public void searchJobs(String companyName, String jobTitleKeyword) {
        System.out.println("Searching for jobs in company: " + companyName +
                " with job title containing: " + jobTitleKeyword);
        boolean found = false;
        for (CompanyPage company : companies) {
            if (company.getCompanyName().equalsIgnoreCase(companyName)) {
                for (Job job : company.getJobs()) {
                    if (job.getJobTitle().toLowerCase().contains(jobTitleKeyword.toLowerCase())) {
                        System.out.println("Found: " + job);
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("No matching jobs found.");
        }
    }
}
