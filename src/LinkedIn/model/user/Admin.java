package LinkedIn.model.user;

import LinkedIn.model.CompanyPage;
import LinkedIn.model.Group;

public class Admin extends Person{
    private CompanyPage company;
    private PersonalDetail pDetails;

    boolean blockUser(User user){return false;}
    boolean unBlockUser(User user){return false;}
    boolean enableCompany(CompanyPage company){return false;}
    boolean disableCompany(CompanyPage company){return false;}
    boolean deleteGroup(Group group){return false;}





}
