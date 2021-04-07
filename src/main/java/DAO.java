import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO implements DAOAbs {

    public String findById(int id) throws SQLException {
        PreparedStatement pstmt = App.conn.prepareStatement(
                "Select * from alter_ego where player_id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        String em = new String();
        while (rs.next()) {
            em = rs.getString("name");
        }
        return em;
    }

    public ArrayList<String> findAll() {
        ArrayList<String> out = new ArrayList<String>();
        try {
            PreparedStatement pstmt = App.conn.prepareStatement(
                    "Select name from alter_ego");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                out.add(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return out;
    }

    public String update(String dto) throws SQLException {
        PreparedStatement pstmt = App.conn.prepareStatement(
                "Update alter_ego set name = ? where id = 4"
        );
        pstmt.setString(1, dto);
        pstmt.executeUpdate();

        return findById(4);
    }

    public String create(String dto) throws SQLException {
        PreparedStatement pstmt = App.conn.prepareStatement(
                "CREATE TABLE ? (id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, Name VARCHAR(255) NOT NULL);"
        );
        pstmt.setString(1, dto);
        pstmt.executeUpdate();
        return dto;
    }

    public void delete(int id) throws SQLException {
        PreparedStatement pstmt = App.conn.prepareStatement(
                "DELETE from alter_ego where player_id = ?"
        );
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }


//    public String update(String dto) throws SQLException {
//        PreparedStatement pstmt = App.conn.prepareStatement(
//                "Update alter_ego set name = ? where id = 2"
//        );
//        pstmt.setString(1, dto);
//    }
}
