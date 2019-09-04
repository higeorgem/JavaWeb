package bean;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DBHelper <T>{
    boolean create(T t) throws SQLException;
    T readOneObject(int id) throws SQLException;
    T checkReceivedId(int id)throws SQLException;
    ArrayList<T>readAllObjects() throws SQLException;
    boolean update (T t) throws SQLException;
    boolean delete (T t) throws SQLException;
}
