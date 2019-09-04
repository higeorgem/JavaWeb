  package bean;
import java.sql.*;

public class LoginDao {
        String sql="select *from user_tbl where userName=? and userPassword=?";
        String url = "jdbc:mysql://localhost:3306/retail_shop";
        String user = "root";
        String pass = "";

        public  boolean check(String userName, String userPassword) {
            Connection con = null;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con= DriverManager.getConnection( url, user, pass );
                PreparedStatement st=con.prepareStatement(sql);
                st.setString(1,userName);
                st.setString(2,userPassword);
                ResultSet rs=st.executeQuery();
                if(rs.next()) {
                    return true;
                }else {
                    return false;
                }

            }catch(Exception e){
               e.printStackTrace();
            }finally {
                try {
                   if (con !=null){
                       con.close();
                   }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return false;
        }

    }


