package model;

public class Receiving {
    private String receivalDate;
    private long batchNo;
    private int qty;
    private double runningBalance;
    private double buyingPrice;
    private double sellingPrice;
    private int productId;

    public Receiving() {
    }

    public Receiving(String receivalDate, long batchNo, int qty, double runningBalance, double buyingPrice, double sellingPrice, int productId) {
        this.receivalDate = receivalDate;
        this.batchNo = batchNo;
        this.qty = qty;
        this.runningBalance = runningBalance;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.productId = productId;
    }
// OVERRIDE THE MAIN CONSTRUCTOR
    public Receiving(String receivalDate, int qty, double runningBalance, double buyingPrice, double sellingPrice, int productId) {
        this.receivalDate = receivalDate;
        this.qty = qty;
        this.runningBalance = runningBalance;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.productId = productId;
    }

    public String getReceivalDate() {
        return receivalDate;
    }

    public void setReceivalDate(String receivalDate) {
        this.receivalDate = receivalDate;
    }

    public long getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(long batchNo) {
        this.batchNo = batchNo;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getRunningBalance() {
        return runningBalance;
    }

    public void setRunningBalance(double runningBalance) {
        this.runningBalance = runningBalance;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return (receivalDate+" "+batchNo+" "+qty+" "+runningBalance+" "+buyingPrice+" "+sellingPrice+" "+productId);
    }
}