import java.sql.SQLException;
import java.util.List;

public abstract class daoAbs<T> {

    T findById(int id) throws SQLException {
        return null;}

    List findAll() {return null;}

    T update(T dto) {return null;}

    T create(T dto) {return null;}

    void delete(int id) {}
}
