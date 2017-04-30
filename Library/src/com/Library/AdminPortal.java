package com.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminPortal extends JFrame implements ActionListener {
    JButton btn1, btn2, btn3, btn4;
    JLabel l1;

    AdminPortal()
    {
        setSize(600, 500); // window size
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Portal");

        l1 = new JLabel("Library Checkout System");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        btn1 = new JButton("Add New Librarian");
        btn1.addActionListener(this);
        btn2 = new JButton("Add New Media");
        btn2.addActionListener(this);
        btn3 = new JButton("Search Customer");
        btn3.addActionListener(this);
        btn4 = new JButton("Logout");
        btn4.addActionListener(this);

        l1.setBounds(80, 30, 400, 30);
        btn1.setBounds(300, 70, 150, 30);
        btn2.setBounds(300, 110, 150, 30);
        btn3.setBounds(300, 150, 150, 30);
        btn4.setBounds(300,190,150,30);

        add(l1);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
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
    }


}