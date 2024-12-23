package hotelmanagementsystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    ManagerInfo() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        

        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(170, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(290, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(400, 10, 100, 20);
        add(l4);
         JLabel l5 = new JLabel("Salary");
        l5.setBounds( 540 , 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone no.");
        l6.setBounds( 650, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Email Id");
        l7.setBounds( 780 , 10, 100, 20);
        add(l7);
        
         JLabel l8 = new JLabel("Aadhar no.");
        l8.setBounds( 900 , 10, 100, 20);
        add(l8);
        
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where job='Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(420,450, 120, 30);
        add(back);

        setBounds(300, 170, 1000, 550);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        setVisible(false);
        new Reception();
    }

    public static void main(String[] aa) {
        new ManagerInfo();
    }
}


        
       