import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nikhil-Rajput
 */

public class DB {

    public static Connection connect() throws SQLException {
          final String DB_URL = "jdbc:mysql://localhost:3306/Agriculture_Society";
          final String DB_USER = "root";
          final String DB_PASSWORD = "root";
        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
               return con;
    }

}
