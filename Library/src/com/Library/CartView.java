package com.Library;

import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;


public class CartView {
    JButton r;
    CartView() {

        JLabel title=new JLabel("Shopping Cart:");
        JLabel q = new JLabel("Enter ISBN:");
        JButton b = new JButton("Add to Cart");
        JButton d = new JButton("Delete from Cart");
        JButton r = new JButton("Return");
        JButton c = new JButton("Checkout");
        JTextField ISBN=new JTextField(20);
        JTable table=new JTable();
        JScrollPane pane=new JScrollPane(table);
        double total = 0.00;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
            Statement st= myConnection.createStatement();
            ResultSet res=st.executeQuery("select * from cart");
            ResultSetMetaData mdt = res.getMetaData();
            int columns = mdt.getColumnCount();
            Vector columnNames = new Vector();
            Vector data = new Vector();
            for (int col = 2; col <= columns; col++){
                columnNames.addElement(mdt.getColumnName(col) );
            }
            while(res.next()){
                Vector rows = new Vector(columns);
                for (int col = 2; col <= columns; col++){
                    rows.addElement( res.getObject(col) );
                    if(col == 4){
                        total += Double.parseDouble(" " + res.getObject(col));
                    }
                }
                data.addElement(rows);
            }

            DefaultTableModel list=new DefaultTableModel(data, columnNames);
            table.setModel(list);
        }
        catch(Exception ex){
            System.out.println("Checkout Failed");
            JOptionPane.showMessageDialog(b,"Checkout Failed");
        }

        JFrame j = new JFrame();
        j.setLayout(null);
        title.setBounds(10,10,100,20);
        q.setBounds(100,250,180,20);
        b.setBounds(300,230,180,20);
        r.setBounds(200,300,150,20);
        d.setBounds(300,250,180,20);
        c.setBounds(300,270,180,20);

        ISBN.setBounds(200,250,80,20);
        pane.setBounds(10,30,500,170);
        pane.setVisible(false);
        j.add(title);
        j.add(b);
        j.add(pane);
        j.add(q);
        j.add(r);
        j.add(d);
        j.add(c);
        j.add(ISBN);
        pane.setVisible(true);
        j.setSize(600,500);
        j.setVisible(true);

        r.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new CustomerView();
                j.setVisible(false);
            }
        });
        c.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	new PaymentView();
                j.setVisible(false);
            }
        });
        d.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String isnum = ISBN.getText();
                int userid = 2;
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
                    if(isnum != " ") {
                        Statement stmt = null;
                        stmt = myConnection.createStatement();
                        String sql = "DELETE FROM cart WHERE ISBN ='"+isnum+"'";
                        stmt.executeUpdate(sql);
                    }
                }
                catch(Exception ex){
                    System.out.println("Add Media Failed");
                    JOptionPane.showMessageDialog(b,"Can't add media");
                }
                new CartView();
                j.setVisible(false);
            }
        });


        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String isnum = ISBN.getText();
                String title = " ";
                String price = " ";
                String ISBN = " ";
                int userid = 2;
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
                    Statement st= myConnection.createStatement();
                    ResultSet res=st.executeQuery("select * from book where ISBN ='"+isnum+"'");
                    while(res.next()) {
                        title = res.getString(1);
                        price = res.getString(2);
                        ISBN  = res.getString(5);
                    }
                    if(title != " ") {
                        Statement stmt = null;
                        stmt = myConnection.createStatement();
                        String sql = "INSERT INTO cart(userid,ISBN,title,price) VALUES ('" + userid + "','" + ISBN + "','" + title + "','" + price + "')";
                        stmt.executeUpdate(sql);
                    }
                }
                catch(Exception ex){
                    System.out.println("Add Media Failed");
                    JOptionPane.showMessageDialog(b,"Can't add media");
                }
                new CartView();
                j.setVisible(false);
            }
        });
    }

}
