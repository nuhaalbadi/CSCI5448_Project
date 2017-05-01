package com.Library;

/**
 * @author Mukund Madhusudan Atre
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LibrarianPortal extends JFrame implements ActionListener {
    JButton btn1, btn2, btn3, btn4;
    JLabel l1;
LibrarianPortal() {
        setSize(600, 500); // window size
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Librarian Portal");

        l1 = new JLabel("Library Checkout System");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        btn1 = new JButton("Search Customer");
        btn1.addActionListener(this);
        btn2 = new JButton("Request New Media");
        btn2.addActionListener(this);
        btn3 = new JButton("Update Customer Info");
        btn3.addActionListener(this);
        btn4 = new JButton("Logout");
        btn4.addActionListener(this);

        l1.setBounds(80, 30, 400, 30);
        btn1.setBounds(150, 70, 300, 30);
        btn2.setBounds(150, 110, 300, 30);
        btn3.setBounds(150, 150, 300, 30);
        btn4.setBounds(150,190,300,30);

        add(l1);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == btn1)
        {
            new SearchCustomer();
            setVisible(false);
        }
        else if (ae.getSource() == btn2)
        {
            new RequestNewMedia();
            setVisible(false);
        }
        else if (ae.getSource() == btn3) 
        {
           new UpdateInfo();
            setVisible(false);
        }
        else if (ae.getSource() == btn4) // logout
        {
        	new LoginForm();
            setVisible(false);
        }
    }
    
}
