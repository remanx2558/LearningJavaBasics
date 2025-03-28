package ObjectPoolDesignPattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnectionResource {
    private Connection mysqlConnection;
    private static final Logger logger = Logger.getLogger(DBConnectionResource.class.getName());

    DBConnectionResource(){
        try {
            mysqlConnection = DriverManager.getConnection("url", "userName", "password");
            logger.info("Connection successfully established");
        } catch (SQLException sqlEx) {
            logger.log(Level.SEVERE, "SQL Exception occurred while establishing connection: ", sqlEx);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Unexpected Exception occurred: ", ex);
        }
    }


    // Optionally,

    // you might define other methods to work with DB Connection and include logging within them.
    public Connection getConnection() {
        return mysqlConnection;
    }

    // Ensure to close connection properly and consider logging during resource cleanup
    public void closeConnection() {
        try {
            if (mysqlConnection != null && !mysqlConnection.isClosed()) {
                mysqlConnection.close();
                logger.info("Connection closed successfully");
            }
        } catch (SQLException sqlEx) {
            logger.log(Level.SEVERE, "SQL Exception occurred while closing connection: ", sqlEx);
        }
    }
}
