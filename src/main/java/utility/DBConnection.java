package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {

        // STEP 1
        Class.forName("com.mysql.cj.jdbc.Driver");  //Optional
        String dburl = "jdbc:mysql://localhost:3306/classicmodels";
        final String user = "root";
        final String password = "password";

        // STEP 2
        Connection connection = DriverManager.getConnection(dburl, user, password);
        return connection;

    }
}
