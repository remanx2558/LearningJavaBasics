package LinkedIn.service;

import LinkedIn.model.CompanyPage;
import LinkedIn.model.Group;
import LinkedIn.model.Job;
import LinkedIn.model.user.User;

public interface Search {
    User[] searchUser(String name);
    CompanyPage[] searchCompany(String name);
    Group[] searchGroup(String name);
    Job[] searchJob(String title);
}
