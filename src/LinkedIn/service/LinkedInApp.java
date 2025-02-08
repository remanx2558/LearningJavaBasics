package LinkedIn.service;

import LinkedIn.model.*;
import LinkedIn.model.user.User;

import java.util.HashSet;
import java.util.Set;

public class LinkedInApp {
    // Main collections
    Set<User> users;
    Set<CompanyPage> companies;
    Set<Post> posts;
    Set<Comment> comments;
    Set<Group> groups;

    public LinkedInApp() {
        users = new HashSet<>();
        companies = new HashSet<>();
        posts = new HashSet<>();
        comments = new HashSet<>();
        groups = new HashSet<>();
    }

    public void addUser(User user) { users.add(user); }
    public void addCompany(CompanyPage company) { companies.add(company); }
    public void addPost(Post post) { posts.add(post); }
    public void addComment(Comment comment) { comments.add(comment); }
    public void addGroup(Group group) { groups.add(group); }

    // Existing job search functionality (R12)
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

    // R2: Search for users
    public Set<User> searchUsers(String searchTerm) {
        Set<User> result = new HashSet<>();
        for (User user : users) {
            if (user.getUsername().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    user.getPersonalDetail().getFullName().toLowerCase().contains(searchTerm.toLowerCase())) {
                result.add(user);
                user.incrementSearchAppearances();
            }
        }
        return result;
    }

    // R2: Search for company pages
    public Set<CompanyPage> searchCompanyPages(String searchTerm) {
        Set<CompanyPage> result = new HashSet<>();
        for (CompanyPage company : companies) {
            if (company.getCompanyName().toLowerCase().contains(searchTerm.toLowerCase())) {
                result.add(company);
            }
        }
        return result;
    }

    // R2: Search for groups
    public Set<Group> searchGroups(String searchTerm) {
        Set<Group> result = new HashSet<>();
        for (Group group : groups) {
            if (group.getGroupName().toLowerCase().contains(searchTerm.toLowerCase())) {
                result.add(group);
            }
        }
        return result;
    }
}
