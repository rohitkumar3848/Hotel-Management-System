package hotel.management.system;
import com.mysql.cj.protocol.Resultset;

import  javax.swing.*;
import javax.xml.stream.events.Comment;
import  java.awt.*;
import java.sql.Connection;
import  java.sql.*;
import java.util.Date;
import java.awt.event.*;


public class AddCustomer extends JFrame implements ActionListener {
    JComboBox combodid;
    JTextField tfNumber,tfName,tfCountry,tfDeposit;
    JRadioButton jrmale,jrfemale;
    Choice c1;
    JLabel checkintime;
    JButton add,back;
    AddCustomer(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(100,20,300,30);
        add(text);

        JLabel lbid=new JLabel("ID");
        lbid.setFont(new Font("Tahoma",Font.BOLD,20));
        lbid.setBounds(35,80,100,20);
        add(lbid);

        String str[]={"Adhaar Card","Passport","Driving License","Voter ID Card","Ration Card"};
        combodid=new JComboBox(str);
        combodid.setBounds(200,80,150,25);
        combodid.setBackground(Color.white);
        combodid.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(combodid);

        JLabel lbNumber=new JLabel("Number");
        lbNumber.setFont(new Font("Tahoma",Font.BOLD,20));
        lbNumber.setBounds(35,120,100,20);
        add(lbNumber);

        tfNumber=new JTextField();
        tfNumber.setBounds(200,120,150,25);
        add(tfNumber);

        JLabel lbName=new JLabel("Name");
        lbName.setFont(new Font("Tahoma",Font.BOLD,20));
        lbName.setBounds(35,160,100,20);
        add(lbName);

        tfName=new JTextField();
        tfName.setBounds(200,160,150,25);
        add(tfName);

        JLabel lbgender=new JLabel("Gender");
        lbgender.setFont(new Font("Tahoma",Font.BOLD,20));
        lbgender.setBounds(35,200,100,20);
        add(lbgender);

        jrmale=new JRadioButton("Male");
        jrmale.setBackground(Color.white);
        jrmale.setBounds(200,200,60,25);
        jrmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(jrmale);

        jrfemale=new JRadioButton("Female");
        jrfemale.setBackground(Color.white);
        jrfemale.setBounds(280,200,80,25);
        jrfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(jrfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add((jrmale));
        bg.add(jrfemale);

        JLabel lbCountry=new JLabel("Country");
        lbCountry.setFont(new Font("Tahoma",Font.BOLD,20));
        lbCountry.setBounds(35,240,100,20);
        add(lbCountry);

        tfCountry=new JTextField();
        tfCountry.setBounds(200,240,150,25);
        add(tfCountry);

        JLabel lbRoom=new JLabel("Room No.");
        lbRoom.setFont(new Font("Tahoma",Font.BOLD,20));
        lbRoom.setBounds(35,280,100,20);
        add(lbRoom);

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room where availability='Available'");
            while(rs.next()){
                c1.add(rs.getString("romnumber"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(200, 280, 150, 25);
        add(c1);

        JLabel lbtime=new JLabel("CheckIn Time");
        lbtime.setFont(new Font("Tahoma",Font.BOLD,20));
        lbtime.setBounds(35,320,150,20);
        add(lbtime);

        Date date=new Date();

        checkintime=new JLabel(""+date);
        checkintime.setFont(new Font("PLAINTEXT",Font.PLAIN,16));
        checkintime.setBounds(200,320,150,25);
        add(checkintime);

        JLabel lbdeposit=new JLabel("Deposit");
        lbdeposit.setFont(new Font("Tahoma",Font.BOLD,20));
        lbdeposit.setBounds(35,360,100,20);
        add(lbdeposit);

        tfDeposit=new JTextField();
        tfDeposit.setBounds(200,360,150,25);
        add(tfDeposit);

        add=new JButton("Add");
        add.setBounds(50,410,120,35);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back=new JButton("Back");
        back.setBounds(200,410,120,35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/fifteen.png"));
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,400,370);
        add(image);


        setBounds(350,200,800,550);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String id=(String) combodid.getSelectedItem();
            String number=tfNumber.getText();
            String name=tfName.getText();
            String gender=null;
            if(jrmale.isSelected()){
                gender="Male";
            }
            else{
                gender="Female";
            }
            String country=tfCountry.getText();
            String room=c1.getSelectedItem();
            String time=checkintime.getText();
            String deposit=tfDeposit.getText();

            try {
                conn con = new conn();
                String query = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room + "','" + time + "','" + deposit + "')";
                String query2 = "update room set availability='Occupied' where romnumber='" + room + "'";
                con.s.executeUpdate(query);
                con.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "New Customer Added Sucessfully");
                setVisible(false);
                new Reception().setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }


        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception().setVisible(true);
        }

    }
    public static void main(String []args){
        new AddCustomer();
    }
}
