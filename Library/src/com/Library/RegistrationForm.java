package com.Library;
// credit: http://www.c-sharpcorner.com/UploadFile/fd0172/registration-form-in-windows-form-using-swing-in-java/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegistrationForm extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf1, tf2, tf5, tf6, tf7;
    JButton btn1, btn2;
    JPasswordField p1, p2;

    RegistrationForm()
    {
        setVisible(true);
        setSize(600, 500); // window size
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registration Page");

        l1 = new JLabel("Please fill in all fields");
        l1.setForeground(Color.red);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("User Name:");
        l3 = new JLabel("Name:");
        l4 = new JLabel("Passowrd:");
        l5 = new JLabel("Retype Password:");
        l6 = new JLabel("Email:");
        l7 = new JLabel("Phone No.:");
        l8 = new JLabel("Address:");
        tf1 = new JTextField();
        tf2 = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();

        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        // Setting position of GUI components
        l1.setBounds(80, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        p1.setBounds(300, 150, 200, 30);
        p2.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);
        tf7.setBounds(300, 310, 200, 30);
        btn1.setBounds(300, 370, 100, 30);
        btn2.setBounds(400, 370, 100, 30);

        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(p1);
        add(l5);
        add(p2);
        add(l6);
        add(tf5);
        add(l7);
        add(tf6);
        add(l8);
        add(tf7);
        add(btn1);
        add(btn2);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btn1)
        {
            int x = 0;
            String s1 = tf1.getText(); // username
            String s2 = tf2.getText(); // name

            char[] s3 = p1.getPassword();
            char[] s4 = p2.getPassword();
            String s8 = new String(s3); // password
            String s9 = new String(s4);

            String s5 = tf5.getText(); //email
            String s6 = tf6.getText(); //phone
            String s7 = tf7.getText(); //address
            if (s8.equals(s9)) // if password matches
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
                    String query = " insert into user (username, name, password, email, phoneNo, address, user_type)" + " values (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                    preparedStmt.setString (1, s1);
                    preparedStmt.setString (2, s2);
                    preparedStmt.setString (3, s8);
                    preparedStmt.setString (4, s5);
                    preparedStmt.setString (5, s6);
                    preparedStmt.setString (6, s7);
                    preparedStmt.setString (7, "C"); // set user type as C = customer
                    preparedStmt.execute();
                    x++;
                    if (x > 0)
                    {
                        JOptionPane.showMessageDialog(btn1, "User Created Successfully");
                        new LoginForm();
                        setVisible(false);
                    }
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();

                }
            }
            else // if password does not match
            {
                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
            }
        }
        else // the clear button was clicked
        {
            tf1.setText("");
            tf2.setText("");
            p1.setText("");
            p2.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
        }
    }

}