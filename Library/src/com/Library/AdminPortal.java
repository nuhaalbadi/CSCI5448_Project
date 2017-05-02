package com.Library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class AdminPortal extends JFrame implements ActionListener {
    JButton btn1, btn2, btn3, btn4, btn5;
    JLabel l1,l2;

    AdminPortal()
    {
        setSize(600, 500); // window size
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Portal");

        l1 = new JLabel("Library Checkout System");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("New Media Requests!");
        l2.setForeground(Color.red);
        l2.setFont(new Font("Serif", Font.BOLD, 20));
        l2.setVisible(false);
        int numRows = 0;
        int currRows = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
            Statement st= myConnection.createStatement();
            ResultSet res=st.executeQuery("SELECT COUNT(*) FROM mediarequests");

            res.next();
            numRows = res.getInt(1);
            res.close();

            st= myConnection.createStatement();
            res=st.executeQuery("SELECT * FROM oldrequestnum");

            res.next();
            currRows = res.getInt(1);
            res.close();
        }
        catch(Exception ex){
            System.out.println("Count Failed");
        }

        if(numRows > currRows){
            l2.setVisible(true);
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
                PreparedStatement pst = myConnection.prepareStatement("update oldrequestnum set Number='"+numRows+"' where Number='"+currRows+"'");
                pst.execute();
            }
            catch(Exception ex){
                System.out.println("Update Failed");
            }
        }

        btn1 = new JButton("Add New Librarian");
        btn1.addActionListener(this);
        btn2 = new JButton("Add New Media");
        btn2.addActionListener(this);
        btn3 = new JButton("Search Customer");
        btn3.addActionListener(this);
        btn4 = new JButton("Logout");
        btn4.addActionListener(this);
        btn5 = new JButton("View Requests");
        btn5.addActionListener(this);

        l1.setBounds(150, 30, 400, 30);
        l2.setBounds(150,300,400,30);
        btn1.setBounds(175, 70, 200, 30);
        btn2.setBounds(175, 110, 200, 30);
        btn3.setBounds(175, 150, 200, 30);
        btn4.setBounds(175,230,200,30);
        btn5.setBounds(175,190,200,30);

        add(l1);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(l2);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btn1) //add librarian
        {
            new AddLibrarian();
            setVisible(false);
        }
        else if (e.getSource() == btn2) // add media
        {
            new AddMedia();
            setVisible(false);
        }
        else if (e.getSource() == btn3) // Search Customer
        {
            new SearchCustomer();
            setVisible(false);
        }
        else if (e.getSource() == btn4) // logout
        {
            new LoginForm();
            setVisible(false);
        }
        else if (e.getSource() == btn5)
        {
            new RequestsView();
            setVisible(false);
        }
    }


}