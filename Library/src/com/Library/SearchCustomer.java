package com.Library;

import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class SearchCustomer {
    JButton r;
    SearchCustomer() {

        JLabel title=new JLabel("Enter Name:");
        JTextField t=new JTextField(20);
        JButton b = new JButton("Search");
        JButton r = new JButton("Return");
        JTable table=new JTable();
        JScrollPane pane=new JScrollPane(table);

        JFrame j = new JFrame();
        j.setLayout(null);
        title.setBounds(10,10,100,20);
        t.setBounds(120,10,100,20);
        b.setBounds(250,10,80,20);
        r.setBounds(250,400,80,20);
        pane.setBounds(10,70,500,170);
        pane.setVisible(false);
        j.add(title);
        j.add(t);
        j.add(b);
        j.add(pane);
        j.add(r);
        pane.setVisible(false);
        j.setSize(600,500);
        j.setVisible(true);

        r.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AdminPortal();
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
