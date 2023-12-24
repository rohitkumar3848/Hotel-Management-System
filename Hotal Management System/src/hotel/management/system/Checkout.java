
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener  {
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    Choice customer;
    JLabel lbroomnumber,lblcheckintime,lblcheckouttime;
    JButton checkout,back;
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("Checkout");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        text.setForeground(Color.blue);
        add(text);

        JLabel lbid=new JLabel("Customer ID");
        lbid.setBounds(30,75,100,30);
        lbid.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lbid);

        JLabel lbroom=new JLabel("Room No.");
        lbroom.setBounds(30,130,100,30);
        lbroom.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lbroom);

        lbroomnumber=new JLabel();
        lbroomnumber.setBounds(180,130,150,30);
        add(lbroomnumber);

        JLabel lbcheckin=new JLabel("Checkin Time");
        lbcheckin.setBounds(30,180,150,30);
        lbcheckin.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lbcheckin);

        lblcheckintime=new JLabel();
        lblcheckintime.setBounds(180,180,150,30);
        add(lblcheckintime);

        JLabel lblcheckout=new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,150,30);
        lblcheckout.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblcheckout);


        Date date=new Date();
        lblcheckouttime=new JLabel(""+date);
        lblcheckouttime.setBounds(180,230,150,30);
        add(lblcheckouttime);

        customer = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                customer.add(rs.getString("number"));
                lbroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        customer.setBounds(180, 80, 150, 30);
        add(customer);


        checkout=new JButton("Checkout");
        checkout.setBounds(40,280,120,40);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        back=new JButton("Back");
        back.setBounds(190,280,120,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(335,80,20,20);
        add(image);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(380,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(400,50,380,250);
        add(image2);

        setBounds(310,80,800,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkout){
            String query1="delete from customer where number='"+customer.getSelectedItem()+"'";
            String query2="update room set availability='Available' where romnumber='"+lbroomnumber.getText()+"' ";
            try{
                conn c=new conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Checkout Done");
                setVisible(false);
                new Reception();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String []args){
        new Checkout();
    }
}
