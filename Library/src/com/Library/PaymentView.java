package com.Library;


import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;


public class PaymentView {
    JButton r;
    PaymentView() {

        JLabel title=new JLabel("Shopping Cart:");
        JLabel q = new JLabel("Complete Order?");
        JButton b = new JButton("Finish");
        JButton r = new JButton("Return");
        JTable table=new JTable();
        JScrollPane pane=new JScrollPane(table);

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
            Statement st= myConnection.createStatement();
            ResultSet res=st.executeQuery("select * from cart");
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
        }
        catch(Exception ex){
            System.out.println("Checkout Failed");
            JOptionPane.showMessageDialog(b,"invalid username or password");
        }

        JFrame j = new JFrame();
        j.setLayout(null);
        title.setBounds(10,10,100,20);
        q.setBounds(150,270,180,20);
        b.setBounds(150,300,80,20);
        r.setBounds(250,300,80,20);
        pane.setBounds(10,30,500,170);
        pane.setVisible(false);
        j.add(title);
        j.add(b);
        j.add(pane);
        j.add(q);
        j.add(r);
        pane.setVisible(true);
        j.setSize(600,500);
        j.setVisible(true);

        r.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new CustomerView();
                j.setVisible(false);
            }
        });

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new CustomerView();
                j.setVisible(false);
            }
        });
    }

}