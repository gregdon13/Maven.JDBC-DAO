import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DAOAbs<T extends DTO> {

    String findById(int id) throws SQLException;

    List findAll();

    String update(String dto) throws SQLException;

    T create(T dto) throws SQLException;

    void delete(int id) throws SQLException;

}
