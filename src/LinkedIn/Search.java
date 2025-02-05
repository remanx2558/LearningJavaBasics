package LinkedIn;

public interface Search {
    User[] searchUser(String name);
    Company[] searchCompany(String name);
    Group[] searchGroup(String name);
    Job[] searchJob(String title);
}
