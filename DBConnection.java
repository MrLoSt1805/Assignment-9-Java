import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "dani2004";

    public static Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
