package LinkedIn.model.user;

import LinkedIn.model.enums.AccountStatus;

public class Account {
    private AccountStatus status;
    private String accountId;
    private String username;
    private String password;
    private String email;

    public boolean resetPassword(String type) {
        // Password reset logic
        return true;
    }
}
