
package com.Library;

/**
 *
 * @author mmsatre
 */

import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class UpdateInfo {
    UpdateInfo() {
    JLabel title=new JLabel("Enter Name:");
    JTextField tf1, tf2, tf5, tf6;
    JLabel l2,l3,l4,l5;    
        l2 = new JLabel("Name:");
        l3 = new JLabel("Email:");
        l4 = new JLabel("Phone No:");
        l5 = new JLabel("Address:");
        JTextField t=new JTextField(20);
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        JButton b = new JButton("Search");
        JButton r = new JButton("Return");
        JTable table=new JTable();
        JScrollPane pane=new JScrollPane(table);

        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(null);
        title.setBounds(10,10,100,20);
        t.setBounds(120,10,100,20);
        b.setBounds(250,10,80,20);
        r.setBounds(250,700,80,20);
        l2.setBounds(80, 450, 200, 30);
        l3.setBounds(80, 500, 200, 30);
        l4.setBounds(80, 550, 200, 30);
        l5.setBounds(80, 600, 200, 30);
        tf1.setBounds(300, 450, 200, 30);
        tf2.setBounds(300, 500, 200, 30);
        tf5.setBounds(300, 550, 200, 30);
        tf6.setBounds(300, 600, 200, 30);
        pane.setBounds(10,70,500,170);
        pane.setVisible(false);
        j.add(title);
        j.add(t);
        j.add(b);
        j.add(pane);
        j.add(r);
        j.add(l2);
        j.add(tf1);
        j.add(l3);
        j.add(tf2);
        j.add(l4);
        j.add(tf5);
        j.add(l5);
        j.add(tf6);
        pane.setVisible(false);
        j.setSize(1200,1000);
        j.setVisible(true);

        r.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new LibrarianPortal();
                j.setVisible(false);
            }
        });

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name=t.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
                    Statement st= myConnection.createStatement();
                    ResultSet res=st.executeQuery("select * from user where name='"+name+"'");
                    ResultSetMetaData mdt = res.getMetaData();
                    int columns = mdt.getColumnCount();
                    Vector columnNames = new Vector();
                    Vector data = new Vector();
                    for (int col = 1; col <= columns; col++){
                        columnNames.addElement(mdt.getColumnName(col) );
                    }
                    while(res.next()){
                        Vector rows = new Vector(columns);
                        for (int col = 1; col <= columns; col++){
                            rows.addElement( res.getObject(col) );
                        }
                        data.addElement(rows);
                    }
                    DefaultTableModel list=new DefaultTableModel(data, columnNames);
                    table.setModel(list);
                    pane.setVisible(true);
                }
                catch(Exception ex){
                    System.out.println("Search Failed");
                }
            }
        });
    }
    
 
}
