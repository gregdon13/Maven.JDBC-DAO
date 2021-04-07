import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DAOAbs {
    //instead of overriding methods in subclass, just fill out
    //these methods and call them through the subclass

    String findById(int id) throws SQLException;

    List findAll();

    String update(String dto) throws SQLException;

    //T create(T dto);

    void delete(int id) throws SQLException;
}
