package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class UpdateCheck extends JFrame implements ActionListener {
       Choice customer;
       JTextField tfroom,tfname,tfamount,tfcheckin,tfpending;
       JButton back,update,check;
       UpdateCheck(){
           getContentPane().setBackground(Color.white);
           setLayout(null);

           JLabel text=new JLabel("Update Status");
           text.setBounds(90,20,280,30);
           text.setFont(new Font("Tahoma",Font.BOLD,20));
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
           lbroom.setBounds(30,120,100,20);
           lbroom.setFont(new Font("Tahoma",Font.BOLD,15));
           add(lbroom);

           tfroom=new JTextField();
           tfroom.setBounds(200,120,150,25);
           add(tfroom);

           JLabel lbname=new JLabel("Name");
           lbname.setBounds(30,160,100,20);
           lbname.setFont(new Font("Tahoma",Font.BOLD,15));
           add(lbname);

           tfname=new JTextField();
           tfname.setBounds(200,160,150,25);
           add(tfname);

           JLabel lbcheckin=new JLabel("Checkin Time");
           lbcheckin.setBounds(30,200,150,20);
           lbcheckin.setFont(new Font("Tahoma",Font.BOLD,15));
           add(lbcheckin);

           tfcheckin=new JTextField();
           tfcheckin.setBounds(200,200,150,25);
           add(tfcheckin);

           JLabel lbamount=new JLabel("Amount Paid");
           lbamount.setBounds(30,240,100,20);
           lbamount.setFont(new Font("Tahoma",Font.BOLD,15));
           add(lbamount);

           tfamount=new JTextField();
           tfamount.setBounds(200,240,150,25);
           add(tfamount);

           JLabel lbpending=new JLabel("Pending Amount");
           lbpending.setBounds(30,280,150,20);
           lbpending.setFont(new Font("Tahoma",Font.BOLD,15));
           add(lbpending);

           tfpending=new JTextField();
           tfpending.setBounds(200,280,150,25);
           add(tfpending);

           check=new JButton("Check");
           check.setBounds(30,340,100,35);
           check.setBackground(Color.BLACK);
           check.setForeground(Color.WHITE);
           check.addActionListener(this);
           add(check);

           update=new JButton("Update");
           update.setBounds(150,340,100,35);
           update.setBackground(Color.BLACK);
           update.setForeground(Color.WHITE);
           update.addActionListener(this);
           add(update);


           back=new JButton("Back");
           back.setBounds(280,340,100,35);
           back.setBackground(Color.BLACK);
           back.setForeground(Color.WHITE);
           back.addActionListener(this);
           add(back);


           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
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
                       tfname.setText(rs.getString("name"));
                       tfcheckin.setText(rs.getString("checkintime"));
                       tfamount.setText(rs.getString("deposit"));
                   }
                   ResultSet rs2=c.s.executeQuery("select * from room where romnumber ='"+tfroom.getText()+"'");
                   while(rs2.next()){
                       String price=rs2.getString("price");
                       int amountPaid=Integer.parseInt(price)-Integer.parseInt(tfamount.getText());
                       tfpending.setText(""+amountPaid);
                   }
               }catch (Exception e){
                   e.printStackTrace();
               }
           }else if(ae.getSource()==update){
               String number=customer.getSelectedItem();
               String room=tfroom.getText();
               String name=tfname.getText();
               String checkin=tfcheckin.getText();
               String deposit=tfamount.getText();
               try{
                   conn c=new conn();
                   String query="update customer set room='"+room+"',name='"+name+"',checkintime='"+checkin+"',deposit='"+deposit+"' where number='"+number+"'";
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
           new UpdateCheck();
       }
}
