package bean;

import dao.DBClass;
import model.Receiving;
import model.Sale;
import java.sql.*;
import java.util.ArrayList;

public class SaleDaoBean implements DBHelper<Sale> {

    @Override
    public boolean create(Sale sale) throws SQLException {
        String sql = "INSERT INTO sale_tbl(productId, saleDate,qty,sellingPrice,userId, userName,customerName,productName) VALUES (?,NOW(),?,?,?,?,?,?)";

        ReceivingDaoBean receivingDaoBean = new ReceivingDaoBean();
        Receiving receiving = receivingDaoBean.readOneObject(sale.getProductId());
        if (receiving != null) {
            sale.setSellingPrice(receiving.getSellingPrice());
            if (receiving.getRunningBalance() >= sale.getQty()) {
                PreparedStatement ps = DBClass.getInstance().getConnection().prepareStatement(sql);
                ps.setInt(1, sale.getProductId());
                ps.setInt(2, sale.getQty());
                ps.setDouble(3, sale.getSellingPrice());
                ps.setInt(4, sale.getUserId());
                ps.setString(5, sale.getUserName());
                ps.setString(6, sale.getCustomerName());
                ps.setString(7, sale.getProductName());

                //SUBTRACT SOLD QUANTITY FROM THE RUNNING BALANCE
                receiving.setRunningBalance(receiving.getRunningBalance() - sale.getQty());
                if (ps.executeUpdate() > 0 && receivingDaoBean.update(receiving)) {
                    return true;
                }
            } else {
                System.out.println("There is No Stock. Please Procure the product of type " + receiving.getProductId());
            }
        }
        return false;
    }

    @Override
    public Sale readOneObject(int id) throws SQLException {
        String query = "select * from sale_tbl where saleId="+id;
        ResultSet rs =DBClass.getInstance().executeQuery(query);
        Sale sale=null;
        while (rs.next()){
            sale = new Sale(
                    String.valueOf( rs.getDate("saleDate")),
                    rs.getInt("qty"),
                    rs.getInt("productId"),
                    rs.getString("productName"),
                    rs.getDouble("sellingPrice"),
                    rs.getString("userName"),
                    rs.getString("customerName"),
                    rs.getInt("userId")
            );

        }
        return sale;
    }

    @Override
    public Sale checkReceivedId(int id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Sale> readAllObjects(){
        String query = "select * from sale_tbl;";
        ArrayList<Sale> sales = new ArrayList<>();
        try {
            ResultSet rs =DBClass.getInstance().executeQuery(query);
            while (rs.next()) {
                Sale sale = new Sale(
                        String.valueOf(rs.getDate("saleDate")),
                        rs.getInt("qty"),
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getDouble("sellingPrice"),
                        rs.getString("userName"),
                        rs.getString("customerName"),
                        rs.getInt("userId")
                );
                sales.add(sale);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sales;
    }

    @Override
    public boolean update(Sale sale) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Sale sale) throws SQLException {
        return false;
    }
}
