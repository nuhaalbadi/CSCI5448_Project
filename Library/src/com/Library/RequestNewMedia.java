
package com.Library;

/**
 *
 * @author Mukund Madhusudan Atre
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RequestNewMedia extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField tf1, tf2;
    JButton btn1, btn2;
RequestNewMedia(){
    setVisible(true);
    setSize(600, 500); // window size
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("New Media Request");

        l1 = new JLabel("Please fill in Media details");
        l1.setForeground(Color.red);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Media Name:");
        l3 = new JLabel("ISBN/ISSN:");
        tf1 = new JTextField();
        tf2 = new JTextField();

        btn1 = new JButton("Submit Request");
        btn2 = new JButton("Clear");

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        // Setting position of GUI components
        l1.setBounds(80, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        btn1.setBounds(300, 370, 100, 30);
        btn2.setBounds(400, 370, 100, 30);

        add(l1);
        add(l2);
        add(l3);
        add(tf1);
        add(tf2);
        add(btn1);
        add(btn2);
}
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1)
        {
            int x = 0;
            String s1 = tf1.getText(); // username
            String s2 = tf2.getText(); // name
            try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
                    String query = " insert into mediarequests (title, ISBN)" + " values (?, ?)";
                    PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                    preparedStmt.setString (1, s1);
                    preparedStmt.setString (2, s2);
                    preparedStmt.execute();
                    x++;
                    if (x > 0)
                    {
                        JOptionPane.showMessageDialog(btn1, "Media Requested!");
                        new LibrarianPortal();
                        setVisible(false);
                    }
                }
            catch (Exception ex)
                {
                    ex.printStackTrace();

                }
    }
        else // the clear button was clicked
        {
            tf1.setText("");
            tf2.setText("");
        }
    
}
}
