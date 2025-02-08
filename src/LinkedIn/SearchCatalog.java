package LinkedIn;

import java.util.Map;

public class SearchCatalog implements Search{

    Map<String, User[]> users;
    Map<String, CompanyPage[]> companies;
    Map<String, Job[]> jobs;
    Map<String, Group[]> groups;

    //

    void addNewUser(User user){}
    void addNewCompany(CompanyPage company){}
    void addNewJob(Job job){}
    void addNewGroup(Group group){}


    //



    @Override
    public User[] searchUser(String name) {
        return new User[0];
    }

    @Override
    public CompanyPage[] searchCompany(String name) {
        return new CompanyPage[0];
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
