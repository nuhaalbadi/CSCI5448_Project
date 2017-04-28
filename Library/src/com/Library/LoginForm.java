package com.Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 

public class LoginForm extends JFrame implements ActionListener 
{
	JLabel l1, l2, l3;
    JTextField tf1;
    JButton btn1, btn2;
    JPasswordField p1;
 
    LoginForm()
     {
        setVisible(true);
        setSize(600, 500); // window size 
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login Page");
 
        l1 = new JLabel("Library Checkout System");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
 
        l2 = new JLabel("User Name:");
        l3 = new JLabel("Password:");

        tf1 = new JTextField();
        p1 = new JPasswordField();
        
        btn1 = new JButton("Submit");
        btn2 = new JButton("New user?");
 
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        // Setting position of GUI components
        l1.setBounds(80, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        p1.setBounds(300, 110, 200, 30);
        btn1.setBounds(300, 160, 100, 30);
        btn2.setBounds(400, 160, 100, 30);
 
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(p1);
        add(btn1);
        add(btn2);
    }
 
    public void actionPerformed(ActionEvent e) 
     {
        if (e.getSource() == btn1)
         {
    
            String username = tf1.getText(); // username
            char[] s = p1.getPassword();
            String password = new String(s); // password
      
           
                try
               {
                	 Class.forName("com.mysql.jdbc.Driver");
                     Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
                     PreparedStatement preparedStmt = myConnection.prepareStatement("select * from user where username=? and password=?");
                 
                     preparedStmt.setString (1,username);
                     preparedStmt.setString (2,password);
                     ResultSet rs=preparedStmt.executeQuery();
                     if(rs.next())
                     {
                    	 if(rs.getString(8).equals("A")) // if user is admin
                    		 {
                    		  new AdminPortal();
                    		 setVisible(false);
                    		 }
                    	 else //user is customer or librarian #TODO
                    	 {
                    		 JOptionPane.showMessageDialog(btn1, "username and password are correct");
                    		 }

                     }
                     else
                     {
                    	 JOptionPane.showMessageDialog(btn1, "invalid username or password");
                     }
                }
          catch (Exception ex) 
                {
        	        ex.printStackTrace();
                }
            
         
        } 
          else // Go to registration page  
       {
        	  new RegistrationForm();
        	  setVisible(false);
        }
    } 

	   

}
