package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox cbtype;
    JCheckBox available;
    SearchRoom(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1=new JLabel("Room No.");
        l1.setBounds(100,170,100,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l1);

        JLabel l2=new JLabel("Availability");
        l2.setBounds(300,170,100,20);
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l2);

        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(470,170,200,20);
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(700,170,100,20);
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l4);

        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(900,170,100,20);
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l5);

        JLabel l6=new JLabel("Search For Room");
        l6.setBounds(400,20,300,30);
        l6.setFont(new Font("Tahoma",Font.BOLD,30));
        add(l6);

        JLabel lbltype=new JLabel("Bed Type");
        lbltype.setBounds(50,80,100,25);
        lbltype.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbltype);

        String typeoption[]={"Single Bed","Double Bed"};
        cbtype=new JComboBox(typeoption);
        cbtype.setBounds(150,80,150,25);
        cbtype.setBackground(Color.white);
        cbtype.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(cbtype);

        available=new JCheckBox("Only Display Available");
        available.setBounds(650,80,250,25);
        available.setBackground(Color.white);
        available.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(available);



        table=new JTable();
        table.setBounds(30,200,1000,300);
        add(table);
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from room");
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
                String query1="select * from room where room_type='"+cbtype.getSelectedItem()+"'";
                String query2="select * from room where availability='Available' AND room_type='"+cbtype.getSelectedItem()+"'";
                conn c=new conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs=c.s.executeQuery(query2);
                }
                else{
                    rs=c.s.executeQuery(query1);
                }
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
        new SearchRoom();
    }
}

