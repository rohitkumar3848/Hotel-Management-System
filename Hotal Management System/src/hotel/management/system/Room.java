package hotel.management.system;
import com.mysql.cj.protocol.Resultset;

import  javax.swing.*;
import javax.xml.stream.events.Comment;
import  java.awt.*;
import java.sql.Connection;
import  java.sql.*;
import java.util.Date;
import java.awt.event.*;
import net.proteanit.sql.*;
import  java.awt.event.*;


public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Room(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,560);
        add(image);


        JLabel l1=new JLabel("Room No.");
        l1.setBounds(30,20,100,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l1);

        JLabel l2=new JLabel("Availability");
        l2.setBounds(120,20,100,20);
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l2);

        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(220,20,150,20);
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(350,20,100,20);
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l4);

        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(430,20,100,20);
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l5);

        table=new JTable();
        table.setBounds(30,50,500,400);
        add(table);
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBounds(200,500,120,35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setBounds(300,100,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static  void main(String []args){
            new Room();
    }
}

