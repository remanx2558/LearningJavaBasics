package LinkedIn;

import java.util.Date;

public class ConnectionInvitation {
    User sender;
    User recipient;
    Date dateCreated;
    ConnectionStatus status;

    boolean acceptConnection(){return false;}
    boolean ignoreConnection(){return false;}
}
