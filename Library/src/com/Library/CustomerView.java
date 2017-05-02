package com.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 * Created by Khandady on 4/29/2017.
 */

public class CustomerView extends JFrame implements ActionListener {
    JButton btn1, btn2, btn4,btn5;
    JLabel l1;
    CustomerView() {
        setSize(600, 500); // window size
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Customer Portal");

        l1 = new JLabel("Library Checkout System");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        btn1 = new JButton("Search Media");
        btn1.addActionListener(this);
        btn2 = new JButton("Add to Cart");
        btn2.addActionListener(this);
        btn4 = new JButton("Logout");
        btn4.addActionListener(this);
        btn5 =new JButton("Request New Media");
        btn5.addActionListener(this);

        l1.setBounds(150, 30, 400, 30);
        btn1.setBounds(175, 70, 250, 30);
        btn2.setBounds(175, 110, 250, 30);
       // btn3.setBounds(175, 150, 250, 30);
        btn5.setBounds(175,150,250,30);
        btn4.setBounds(175, 190, 250, 30);
        add(l1);
        add(btn1);
        add(btn2);
        add(btn4);
        add(btn5);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btn1) //add librarian
        {
            new Search();
            setVisible(false);
        }
        else if (e.getSource() == btn2)
        {
            new CartView();
            setVisible(false);
        }

        else if (e.getSource() == btn4)
        {
            new LoginForm();
            setVisible(false);
        }
        else if (e.getSource() == btn5) {
            new RequestNewMedia();
            setVisible(false);
        }
    }

}
