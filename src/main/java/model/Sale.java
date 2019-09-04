package model;

public class Sale {
    private String saleDate;
    private int qty;
    private int productId;
    private String productName;
    private double sellingPrice;
    private int customerId;
    private String customerName;
    private String userName;
    private int userId;

    public Sale(String saleDate, int qty, int productId, String productName, double sellingPrice, int customerId, String customerName, String userName, int userId) {
        this.saleDate = saleDate;
        this.qty = qty;
        this.productId = productId;
        this.productName = productName;
        this.sellingPrice = sellingPrice;
        this.customerId = customerId;
        this.customerName = customerName;
        this.userName = userName;
        this.userId = userId;
    }

    public Sale(String saleDate, int qty, int productId, String productName, double sellingPrice, String customerName, String userName, int userId) {
        this.saleDate = saleDate;
        this.qty = qty;
        this.productId = productId;
        this.productName = productName;
        this.sellingPrice = sellingPrice;
        this.customerName = customerName;
        this.userName = userName;
        this.userId = userId;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return (saleDate+qty+productId+productName+sellingPrice+customerId+customerName+userName+userId);
    }
}