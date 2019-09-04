package bean;
import com.sun.istack.internal.Nullable;
import dao.DBClass;
import model.Receiving;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReceivingDaoBean implements DBHelper<Receiving> {
    @Override
    public boolean create(Receiving receiving) throws SQLException {
        String sql = "INSERT INTO receiving_tbl(qty, receivalDate,runningBalance,buyingPrice,sellingPrice,productId) VALUES (?, NOW(),?,?,?,?)";
        Connection connection = DBClass.getInstance().getConnection();
        PreparedStatement ps =  connection.prepareStatement(sql);
        // ps.setInt(1,product.getProductId());
        ps.setInt(1,receiving.getQty());
        ps.setString(2,receiving.getReceivalDate());
        ps.setDouble(2,receiving.getRunningBalance());
        ps.setDouble(3,receiving.getBuyingPrice());
        ps.setDouble(4,receiving.getSellingPrice());
        ps.setDouble(5,receiving.getProductId());
        return ps.executeUpdate()>0;
    }

    @Override
    public Receiving readOneObject(int id) throws SQLException {
        String sql = "SELECT * FROM receiving_tbl WHERE productId="+id;
        return getReceiving(sql);
    }

    @Nullable
    private Receiving getReceiving(String sql) throws SQLException {
        Receiving receiving = null;
        try {
            ResultSet rs = DBClass.getInstance().executeQuery(sql);
            if (rs.next()) {
                receiving = new Receiving(
                        rs.getString("receivalDate"),
                        rs.getLong("batchNo"),
                        rs.getInt("qty"),
                        rs.getDouble("runningBalance"),
                        rs.getDouble("buyingPrice"),
                        rs.getDouble("sellingPrice"),
                        rs.getInt("productId")
                );

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return receiving;
    }

    @Override
    public Receiving checkReceivedId(int id) throws SQLException {
        String sql = "SELECT * FROM receiving_tbl WHERE productId=" + id;
        return getReceiving(sql);
    }
    @Override
    public ArrayList<Receiving> readAllObjects() {
        String sql = "SELECT * FROM receiving_tbl";
        ArrayList<Receiving> receivings = new ArrayList<>();
        try {
            ResultSet rs = DBClass.getInstance().executeQuery(sql);
            while (rs.next()) {
                Receiving receiving = new Receiving(
                        rs.getString("receivalDate"),
                        rs.getLong("batchNo"),
                        rs.getInt("qty"),
                        rs.getDouble("runningBalance"),
                        rs.getDouble("buyingPrice"),
                        rs.getDouble("sellingPrice"),
                        rs.getInt("productId"));
                receivings.add(receiving);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return receivings;

    }

    @Override
    public boolean update(Receiving receiving) throws SQLException {
        String sql = "UPDATE receiving_tbl SET qty='"+receiving.getQty()+"',receivalDate='"+receiving.getReceivalDate()+"',runningBalance='"+receiving.getRunningBalance()+"',buyingPrice='"+receiving.getBuyingPrice()+"',sellingPrice='"+receiving.getSellingPrice()+"',productId='"+receiving.getProductId()+"' WHERE batchNo="+receiving.getBatchNo();
        return DBClass.getInstance().execute(sql);
    }

    @Override
    public boolean delete(Receiving receiving) throws SQLException {
        String sql = "DELETE FROM receiving_tbl WHERE batchNo="+receiving.getBatchNo();
        return DBClass.getInstance().execute(sql);
    }
}
