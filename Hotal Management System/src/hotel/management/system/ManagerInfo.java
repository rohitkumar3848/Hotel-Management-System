package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    ManagerInfo(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1=new JLabel("Name");
        l1.setBounds(40,10,100,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l1);

        JLabel l2=new JLabel("Age");
        l2.setBounds(170,10,100,20);
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l2);

        JLabel l3=new JLabel("Gender");
        l3.setBounds(290,10,100,20);
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l3);

        JLabel l4=new JLabel("Job");
        l4.setBounds(420,10,100,20);
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l4);

        JLabel l5=new JLabel("Salary");
        l5.setBounds(540,10,100,20);
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l5);

        JLabel l6=new JLabel("Phone");
        l6.setBounds(660,10,100,20);
        l6.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l6);

        JLabel l7=new JLabel("Email ID");
        l7.setBounds(780,10,100,20);
        l7.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l7);

        JLabel l8=new JLabel("Adhaar");
        l8.setBounds(900,10,100,20);
        l8.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l8);

        table=new JTable();
        table.setBounds(20,40,1000,400);
        add(table);
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from employee where job='manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBounds(420,500,120,35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(300,200,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static  void main(String []args){
        new ManagerInfo();
    }
}


