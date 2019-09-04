package dao;

import java.sql.*;

public class DBClass {
    private String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/retail_shop";
    private static  final String USER = "root";
    private static final String PASS = "";

    //        SETUP
    private static Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private static DBClass dbInstance=null;

    public DBClass() {
        createConnection();
    }

    private void createConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static DBClass getInstance(){
        if(dbInstance==null){
            synchronized (DBClass.class) {
                dbInstance = new DBClass();
            }
        }
        return dbInstance;
    }
    public Connection getConnection(){
        return connection;
    }
    public boolean execute(String sql) throws SQLException {
        statement = connection.createStatement();
        return statement.executeUpdate(sql)>0;
    }
    public ResultSet executeQuery(String sql) throws SQLException {
        statement = connection.createStatement();
        return statement.executeQuery(sql);
    }



}
