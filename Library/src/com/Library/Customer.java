package com.Library;

/**
 * Created by Khandady on 3/31/2017.
 */
public class Customer extends User {
    private int customerID;
    private Order order;

    private int getCustomerID(){
        return customerID;
    }

    private void setCustomerID(int customerID){
        this.customerID = customerID;
    }
}
