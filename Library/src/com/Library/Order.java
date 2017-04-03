package com.Library;

/**
 * Created by Khandady on 3/31/2017.
 */
public class Order {
    public String orderDate;
    public int orderNo;
    public String orderDetails;

    public String getOrderDate(){
        return orderDate;
    }

    public void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }

    public int getOrderNo(){
        return orderNo;
    }

    public void setOrderNo(int orderNo){
        this.orderNo = orderNo;
    }

    public String getOrderDetails(){
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails){
        this.orderDetails = orderDetails;
    }
}
