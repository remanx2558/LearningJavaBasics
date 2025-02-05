package LinkedIn;

import java.util.Map;

public class SearchCatalog implements Search{

    Map<String, User[]> users;
    Map<String, Company[]> companies;
    Map<String, Job[]> jobs;
    Map<String, Group[]> groups;

    //

    void addNewUser(User user){}
    void addNewCompany(Company company){}
    void addNewJob(Job job){}
    void addNewGroup(Group group){}


    //



    @Override
    public User[] searchUser(String name) {
        return new User[0];
    }

    @Override
    public Company[] searchCompany(String name) {
        return new Company[0];
    }

    @Override
    public Group[] searchGroup(String name) {
        return new Group[0];
    }

    @Override
    public Job[] searchJob(String title) {
        return new Job[0];
    }
}
