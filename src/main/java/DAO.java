import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO implements DAOAbs<DTO> {

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

    public DTOclass create(DTOclass dto) throws SQLException {
        PreparedStatement pstmt = App.conn.prepareStatement(
                "INSERT into alter_ego(id, name, player_id) values (id, ?, ?);"
        );
        //pstmt.setString(1, "alter_ego");
        pstmt.setString(1, dto.getName());
        pstmt.setInt(2, dto.getPlayerId());
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
