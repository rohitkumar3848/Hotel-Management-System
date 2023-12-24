package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/twenty.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,530,520);
        add(image);


        JLabel d1=new JLabel("Department");
        d1.setBounds(50,20,150,20);
        d1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(d1);

        JLabel d2=new JLabel("Budget");
        d2.setBounds(300,20,150,20);
        d2.setFont(new Font("Tahoma",Font.BOLD,20));
        add(d2);


        table=new JTable();
        table.setBounds(20,60,500,400);
        add(table);
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from department");
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
        new Department();
    }
}

