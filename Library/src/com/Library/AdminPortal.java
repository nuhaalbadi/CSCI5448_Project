package com.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 
public class AdminPortal extends JFrame implements ActionListener {
	JButton btn1, btn2;
	JLabel l1;
	
	AdminPortal()
	{
		setVisible(true);
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
        
        l1.setBounds(80, 30, 400, 30);
        btn1.setBounds(300, 70, 150, 30);
        btn2.setBounds(300, 110, 150, 30);
        
        add(l1);
        add(btn1);
        add(btn2);
		
	}
	
	 public void actionPerformed(ActionEvent e) 
     {
        if (e.getSource() == btn1) //add librarian
         {
        	  new AddLibrarian();
        	  setVisible(false);
        }
        else if (e.getSource() == btn2)
        {
       	  new AddMedia();
       	  setVisible(false);
       }
    } 


}
