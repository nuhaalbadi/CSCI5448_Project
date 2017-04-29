package com.Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddMedia  extends JFrame implements ActionListener{

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JTextField tf1, tf2, tf3, tf4,tf5, tf6, tf7, tf8;
    JButton btn1, btn2;
    JRadioButton rbtn1, rbtn2;


    AddMedia(){
        setVisible(true);
        setSize(600, 500); // window size
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Media Page");

        l1 = new JLabel("Please fill in all fields");
        l1.setForeground(Color.red);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Title:");
        l3 = new JLabel("Price:");
        l4 = new JLabel("Availability:");
        l5 = new JLabel("Author:");
        l6 = new JLabel("ISBN:");
        l7 = new JLabel("Publication Date:");
        l8 = new JLabel("Publisher:");
        l9 = new JLabel("Edition:");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();

        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");
        rbtn1 = new JRadioButton("Book");
        rbtn2 = new JRadioButton("Journal");

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        rbtn1.addActionListener(this);
        rbtn2.addActionListener(this);
        // Setting position of GUI components
        l1.setBounds(80, 30, 400, 30);
        rbtn1.setBounds(300, 30, 100, 30);
        rbtn2.setBounds(400, 30, 100, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        l9.setBounds(80, 350, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        tf3.setBounds(300, 150, 200, 30);
        tf4.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);
        tf7.setBounds(300, 310, 200, 30);
        tf8.setBounds(300, 350, 200, 30);
        btn1.setBounds(300, 390, 100, 30);
        btn2.setBounds(400, 390, 100, 30);

        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(tf3);
        add(l5);
        add(tf4);
        add(l6);
        add(tf5);
        add(l7);
        add(tf6);
        add(l8);
        add(tf7);
        add(l9);
        add(tf8);
        add(btn1);
        add(btn2);
        add(rbtn1);
        add(rbtn2);

        rbtn1.setSelected(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btn1 && rbtn1.isSelected() )
        {
            int x = 0;
            String s1 = tf1.getText(); // title
            String s2 = tf2.getText(); // price
            String s3 = tf3.getText(); // availability
            String s4 = tf4.getText(); // author
            String s5 = tf5.getText(); //ISBN
            String s6 = tf6.getText(); //publication date
            String s7 = tf7.getText(); //publisher
            String s8 = tf8.getText(); //edition

            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
                String query = " insert into book (title, price, availability, author, ISBN, publicationDate, publisher, edition)" + " values (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                preparedStmt.setString (1, s1);
                preparedStmt.setString (2, s2);
                preparedStmt.setString (3, s3);
                preparedStmt.setString (4, s4);
                preparedStmt.setString (5, s5);
                preparedStmt.setString (6, s6);
                preparedStmt.setString (7, s7);
                preparedStmt.setString (8, s8);
                preparedStmt.execute();
                x++;
                if (x > 0)
                {
                    JOptionPane.showMessageDialog(btn1, "New Book Has Been Added  Successfully to the System");
                    new AdminPortal();
                    setVisible(false);
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();

            }

        }
        else if (e.getSource() == btn1 && rbtn2.isSelected() )
        {
            int x = 0;
            String s1 = tf1.getText(); // title
            String s2 = tf2.getText(); // price
            String s3 = tf3.getText(); // availability
            String s4 = tf4.getText(); // publication date
            String s5 = tf5.getText(); //ISSN
            String s6 = tf6.getText(); //volume
            String s7 = tf7.getText(); //issue


            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
                String query = " insert into journal (title, price, availability, publicationDate, ISSN, volume, issue)" + " values (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                preparedStmt.setString (1, s1);
                preparedStmt.setString (2, s2);
                preparedStmt.setString (3, s3);
                preparedStmt.setString (4, s4);
                preparedStmt.setString (5, s5);
                preparedStmt.setString (6, s6);
                preparedStmt.setString (7, s7);
                preparedStmt.execute();
                x++;
                if (x > 0)
                {
                    JOptionPane.showMessageDialog(btn1, "New Journal Has Been Added  Successfully to the System");
                    new AdminPortal();
                    setVisible(false);
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();

            }

        }
        else if (e.getSource() == btn2) // the clear button was clicked
        {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
            tf8.setText("");
        }
        else if (e.getSource() == rbtn2) // Journal was clicked
        {
            rbtn1.setSelected(false);
            l5.setText("Publication Date:");
            l6.setText("ISSN:");
            l7.setText("Volume:");
            l8.setText("Issue:");
            tf4.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
            l9.setVisible(false);
            tf8.setVisible(false);
        }
        else if (e.getSource() == rbtn1) // book was clicked
        {
            rbtn2.setSelected(false);
            l5.setText("Author:");
            l6.setText("ISBN:");
            l7.setText("Publication Date:");
            l8.setText("Publisher:");
            l9.setText("Edition:");
            tf4.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
            tf8.setText("");
            l9.setVisible(true);
            tf8.setVisible(true);
        }
    }

}