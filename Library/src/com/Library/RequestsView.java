
package com.Library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mukund Madhusudan Atre
 */
public class RequestsView {
    RequestsView() {
       
        JButton r = new JButton("Return");
        JTable table=new JTable();
        JScrollPane pane=new JScrollPane(table);

        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(null);
        r.setBounds(400,400,120,20);
        pane.setBounds(10,70,900,200);
        pane.setVisible(false);
        j.add(pane);
        j.add(r);
        pane.setVisible(false);
        j.setSize(1000,500);
        j.setVisible(true);

        r.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AdminPortal();
                j.setVisible(false);
            }
        });

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "admin");
                    Statement st= myConnection.createStatement();
                    ResultSet res=st.executeQuery("select * from mediarequests");
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
    }
    
