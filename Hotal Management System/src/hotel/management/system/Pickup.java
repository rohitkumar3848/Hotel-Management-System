package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;




public class Pickup extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    Choice typeofCar;
    Pickup(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1=new JLabel("Name");
        l1.setBounds(30,170,100,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l1);

        JLabel l2=new JLabel("Age");
        l2.setBounds(200,170,100,20);
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l2);

        JLabel l3=new JLabel("Gender");
        l3.setBounds(330,170,200,20);
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l3);

        JLabel l4=new JLabel("Company");
        l4.setBounds(460,170,100,20);
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l4);

        JLabel l5=new JLabel("Brand");
        l5.setBounds(630,170,100,20);
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l5);

        JLabel l8=new JLabel("Available");
        l8.setBounds(740,170,100,20);
        l8.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l8);

        JLabel l9=new JLabel("Location");
        l9.setBounds(900,170,100,20);
        l9.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l9);

        JLabel l6=new JLabel("Pick Up Service");
        l6.setBounds(400,20,300,30);
        l6.setFont(new Font("Tahoma",Font.BOLD,30));
        add(l6);

        JLabel lbltype=new JLabel("Type of Car");
        lbltype.setBounds(50,80,100,25);
        lbltype.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lbltype);

        typeofCar=new Choice();
        typeofCar.setBounds(180,80,150,25);
        typeofCar.setBackground(Color.white);
        typeofCar.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(typeofCar);

        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                typeofCar.add(rs.getString("brand"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        table=new JTable();
        table.setBounds(30,200,1000,300);
        add(table);
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBounds(300,500,120,35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        submit=new JButton("Submit");
        submit.setBounds(550,500,120,35);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);


        setBounds(300,200,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
                String query="select * from driver where brand='"+typeofCar.getSelectedItem()+"'";
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Reception();
        }
    }
    public static  void main(String []args){
        new Pickup();
    }
}


