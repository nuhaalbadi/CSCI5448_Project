package com.Library;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
            Statement stmt = myConnection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getString(7));
            }

            /* Write Code:
            String query = " insert into user (userID, username, name, password, email, phoneNo, address)" + " values (?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = myConnection.prepareStatement(query);
            preparedStmt.setInt (1, 2);
            preparedStmt.setString (2, "username");
            preparedStmt.setString   (3, "name2");
            preparedStmt.setString(4, "password2");
            preparedStmt.setString    (5, "hey@colorado.edu");
            preparedStmt.setString    (6, "408");
            preparedStmt.setString    (7, "Boulder");
            preparedStmt.execute();
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
