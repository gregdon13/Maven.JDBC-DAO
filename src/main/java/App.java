import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class App {
    public static final String URL = "jdbc:mysql://localhost:3306/dcUni";
    public static final String USER = "greg";
    public static final String PASS = "zipcode0";
    public static DAO userDao = new DAO();
    public static Connection conn;

    public static Connection getConnection() throws SQLException {
        conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(Arrays.toString(userDao.findById(4)));
            System.out.println(userDao.findAll().toString());
            System.out.println("Success!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Couldn't connect", e);
        } finally {
            conn.close();
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        App.getConnection();
    }
}
