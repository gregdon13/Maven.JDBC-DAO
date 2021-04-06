import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO extends daoAbs{

    String[] findById(int id) throws SQLException {
        PreparedStatement pstmt = App.conn.prepareStatement(
                "Select * from alter_ego where player_id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        ArrayList<String> arr = new ArrayList<String>();
        while (rs.next()) {
            String em = rs.getString("name");
            arr.add(em);
        }
        return arr.toArray(new String[0]);
    }

    ArrayList<String> findAll() {
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
}
