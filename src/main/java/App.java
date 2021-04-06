import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static final String URL = "jdbc:mysql://localhost:3306/dcUni";
    public static final String USER = "greg";
    public static final String PASS = "zipcode0";
    DAO userDao = new DAO();

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Success!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            conn.close();
        }
        return conn;
    }
}
