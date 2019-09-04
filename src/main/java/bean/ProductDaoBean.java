package bean;

import dao.DBClass;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoBean implements DBHelper<Product> {
    @Override
    public boolean create(Product product) throws SQLException {
        String sql = "INSERT INTO product_tbl(productName, productDescription) VALUES (?,?)";
        Connection connection = DBClass.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, product.getProductName());
        ps.setString(2, product.getProductDescription());
        return ps.executeUpdate() > 0;
    }

    @Override
    public Product readOneObject(int id) throws SQLException {
        String sql = "SELECT * FROM product_tbl WHERE productId=" + id;
        Product product = null;
            ResultSet rs = DBClass.getInstance().executeQuery(sql);
            if (rs.next()) {
                product = new Product(
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getString("productDescription"));


            }
        return product;
    }

    @Override
    public Product checkReceivedId(int id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Product> readAllObjects() {
        String sql = "SELECT * FROM product_tbl";
        ArrayList<Product> products = new ArrayList<>();
        try {

            ResultSet rs = DBClass.getInstance().executeQuery(sql);
            while (rs.next()) {
                Product ourProduct = new Product(
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getString("productDescription"));
                products.add(ourProduct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        String sql = "UPDATE product_tbl SET productName='" + product.getProductName() + "',productDescription='" + product.getProductDescription() + "' WHERE productId=" + product.getProductId();
        return DBClass.getInstance().execute(sql);

    }

    @Override
    public boolean delete(Product product) throws SQLException {
        return false;
    }

    public boolean deleteWithID(int id) throws SQLException {
        String sql = "DELETE FROM product_tbl WHERE productId=" + id;
        return DBClass.getInstance().execute(sql);
    }

    public boolean updateWithID(int id) throws SQLException {
        String sql = "UPDATE product_tbl SET productName='" + "',productDescription='" + "' WHERE productId=" + id;
        return DBClass.getInstance().execute(sql);
    }
}
