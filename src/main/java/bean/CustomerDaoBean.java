package bean;

import dao.DBClass;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoBean implements DBHelper<Customer>{
    @Override
    public boolean create(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer_tbl(customerName, customerDate) VALUES (?, NOW())";
        Connection connection = DBClass.getInstance().getConnection();
        PreparedStatement ps =  connection.prepareStatement(sql);
        ps.setString(1,customer.getCustomerName());
        return ps.executeUpdate()>0;
    }

    @Override
    public Customer readOneObject(int id) throws SQLException {
        return null;
    }

    @Override
    public Customer checkReceivedId(int id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Customer> readAllObjects() throws SQLException {
        return null;
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Customer customer) throws SQLException {
        return false;
    }


}
