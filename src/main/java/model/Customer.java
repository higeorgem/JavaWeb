package model;

import java.sql.Date;

public class Customer {
    private int customerId;
    private String customerName;
    private Date customerDate;

    public Customer(int customerId, String customerName,Date customerDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerDate = customerDate;
    }
//  OVERRIDE THE DEFAULT CONSTRUCTOR

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public Customer(String customerName, Date customerDate) {
        this.customerName = customerName;
        this.customerDate = customerDate;
    }

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public Customer() {
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

    public Date getCustomerDate() {
        return customerDate;
    }

    public void setCustomerDate(Date customerDate) {
        this.customerDate = customerDate;
    }

    @Override
    public String toString() {
        return (customerId+" "+customerName+" "+customerDate);
    }
}
