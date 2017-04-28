package com.Library;

/**
 * Created by Khandady on 3/31/2017.
 */
public class User {
    protected String username;
    protected String name;
    protected String password;
    protected String email;
    protected String address;
    protected String phoneNo;
    protected int userID;

    protected String getUsername(){
        return username;
    }

    protected String getPassword(){
        return password;
    }

    protected String getname(){
        return name;
    }

    protected String getEmail(){
        return email;
    }

    protected String getAddress(){
        return address;
    }

    protected String getPhoneNo(){
        return phoneNo;
    }

    protected int getUserID(){
        return userID;
    }

    protected void setUsername(String username){
        this.username = username;
    }

    protected void setPassword(String password){
        this.password = password;
    }

    protected void setname(String name){
        this.name = name;
    }

    protected void setEmail(String email){
        this.email = email;
    }

    protected void setAddress(String address){
        this.address = address;
    }

    protected void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }

    protected void setUserID(int userID){
        this.userID = userID;
    }

    public String searchUser(int userID){
        String a = "something";
        return a;
    }

}
