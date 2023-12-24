package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;



public class UpdateRoom extends JFrame implements ActionListener {
    Choice customer;
    JTextField tfroom,tfavailable,tfamount,tfstatus,tfpending;
    JButton back,update,check;
    UpdateRoom(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text=new JLabel("Update Room Status");
        text.setBounds(30,20,300,30);
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        text.setForeground(Color.blue);
        add(text);

        JLabel lbid=new JLabel("Customer ID");
        lbid.setBounds(30,80,100,20);
        lbid.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lbid);

        customer = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                customer.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        customer.setBounds(200, 80, 150, 25);
        add(customer);

        JLabel lbroom=new JLabel("Room No.");
        lbroom.setBounds(30,130,100,20);
        lbroom.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lbroom);

        tfroom=new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);

        JLabel lbavailable=new JLabel("Availability");
        lbavailable.setBounds(30,180,100,20);
        lbavailable.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lbavailable);

        tfavailable=new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);

        JLabel lbclean=new JLabel("Cleaning Status");
        lbclean.setBounds(30,230,150,20);
        lbclean.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lbclean);

        tfstatus=new JTextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);


        check=new JButton("Check");
        check.setBounds(30,300,100,35);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update=new JButton("Update");
        update.setBounds(150,300,100,35);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);


        back=new JButton("Back");
        back.setBounds(280,300,100,35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);



        setBounds(300,200,980,500);
        setVisible(true);


    }
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id=customer.getSelectedItem();
            String query="select * from customer where number='"+id+"'";
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                }
                ResultSet rs2=c.s.executeQuery("select * from room where romnumber ='"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("room_status"));

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==update){
            String number=customer.getSelectedItem();
            String room=tfroom.getText();
            String available=tfavailable.getText();
            String status=tfstatus.getText();
            try{
                conn c=new conn();
                String query="update room set availability='"+available+"',room_status='"+status+"' where romnumber='"+number+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Data Updated Sucessfully");
                setVisible(false);
                new Reception();

            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
            new Reception();
        }

    }
    public static void main(String [] args){
        new UpdateRoom();
    }
}

