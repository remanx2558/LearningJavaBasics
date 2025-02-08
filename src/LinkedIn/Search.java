package LinkedIn;

public interface Search {
    User[] searchUser(String name);
    CompanyPage[] searchCompany(String name);
    Group[] searchGroup(String name);
    Job[] searchJob(String title);
}
