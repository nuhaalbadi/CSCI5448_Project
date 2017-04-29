package com.Library;

/**
 * Created by Khandady on 3/31/2017.
 */
public class Admin extends User implements RequestObserver {
    private int adminID;

    private int getAdminID(){
        return adminID;
    }

    private void setAdminID(int adminID){
        this.adminID = adminID;
    }

    private Admin addAdmin(int adminID){
        Admin admin = new Admin();
        admin.setAdminID(adminID);
        return admin;
    }

    /*Not sure what this function does*/
    public int viewAdminInfo(int adminID){
        return adminID;
    }
    @Override
    public void update(String medianame) {
        System.out.println("A new media is requested: " + medianame);

    }
}