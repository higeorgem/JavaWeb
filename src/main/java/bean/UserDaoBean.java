package bean;

import dao.DBClass;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoBean implements DBHelper<User> {
    @Override
    public boolean create(User user) throws SQLException {
        String sql = "INSERT INTO user_tbl(userName, userPassword) VALUES (?,?)";
        Connection connection = DBClass.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getUserPassword());
        return ps.executeUpdate() > 0;
    }

    @Override
    public User readOneObject(int id) throws SQLException {
        String sql = "SELECT * FROM user_tbl WHERE userId=" + id;
        ResultSet rs = DBClass.getInstance().executeQuery(sql);
        User user = null;
        if (rs.next()) {
            user = new User(
                    rs.getInt("userId"),
                    rs.getString("userName"),
                    rs.getString("userPassword"));

        }
        return user;
    }

    @Override
    public User checkReceivedId(int id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<User> readAllObjects() throws SQLException {
        String sql = "SELECT * FROM user_tbl";
        ResultSet rs = DBClass.getInstance().executeQuery(sql);
        ArrayList<User> users = new ArrayList<>();
        while (rs.next()) {
            User retailStaff = new User(
                    rs.getInt("userId"),
                    rs.getString("userName"),
                    rs.getString("userPassword"));
            users.add(retailStaff);
        }
        return users;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = "UPDATE user_tbl SET userName='" + user.getUserName() + "' WHERE userId=" + user.getUserId();
        return DBClass.getInstance().execute(sql);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = "DELETE FROM user_tbl WHERE userId=" + user.getUserId();
        return DBClass.getInstance().execute(sql);
    }

    public boolean check(String userName, String userPassword) throws SQLException {
        String sql = "select *from user_tbl where userName=? and userPassword=?";
        Connection connection = DBClass.getInstance().getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        User user = null;
    return  false;
}
}


