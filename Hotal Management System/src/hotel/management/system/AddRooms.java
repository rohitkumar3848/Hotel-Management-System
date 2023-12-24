package hotel.management.system;
import  javax.swing.*;
import java.awt.*;
import  java.awt.event.*;

public class AddRooms extends  JFrame implements ActionListener{
    JTextField tfroom,tfprice;
    JButton add,cancel;
    JComboBox cbavailable,cbclean,cbtype;
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Add Rooms");
        heading.setBounds(150,20,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel lblroomno=new JLabel("Room Number");
        lblroomno.setBounds(50,80,180,30);
        lblroomno.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblroomno);

        tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        JLabel lblavailable=new JLabel("Available");
        lblavailable.setBounds(50,130,160,30);
        lblavailable.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblavailable);

        String availableoption[]={"Available","Occupied"};
        cbavailable=new JComboBox(availableoption);
        cbavailable.setBounds(200,130,150,30);
        cbavailable.setBackground(Color.white);
        cbavailable.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(cbavailable);

        JLabel jlclean=new JLabel("Clean Status");
        jlclean.setBounds(50,180,130,30);
        jlclean.setFont(new Font("Tahoma",Font.BOLD,20));
        add(jlclean);

        String cleanOptions[]={"Clean","Dirty"};
        cbclean=new JComboBox(cleanOptions);
        cbclean.setBounds(200,180,150,30);
        cbclean.setBackground(Color.white);
        cbclean.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(cbclean);

        JLabel lblprice=new JLabel("Price");
        lblprice.setBounds(50,220,120,30);
        lblprice.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblprice);

        tfprice=new JTextField();
        tfprice.setBounds(200,220,150,30);
        add(tfprice);

        JLabel lbltype=new JLabel("Bed Type");
        lbltype.setBounds(50,280,120,30);
        lbltype.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbltype);

        String typeoption[]={"Single Bed","Double Bed"};
        cbtype=new JComboBox(typeoption);
        cbtype.setBounds(200,280,150,30);
        cbtype.setBackground(Color.white);
        cbtype.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(cbtype);

        add=new JButton("Add Room");
        add.setBounds(50,350,140,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma",Font.BOLD,20));
        add.addActionListener(this);
        add(add);

        cancel=new JButton("Cancel");
        cancel.setBounds(220,350,130,40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma",Font.BOLD,20));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/thirteen.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,50,450,330);
        add(image);

        setBounds(330,200,940,470);
        setVisible(true);

    }
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String roomnumber=(String) tfroom.getText();
            String availability=(String) cbavailable.getSelectedItem();
            String status=(String) cbclean.getSelectedItem();
            String price=tfprice.getText();
            String type=(String) cbtype.getSelectedItem();
            if(roomnumber.equals("")){
                JOptionPane.showMessageDialog(null,"RoomNumber shouldn't be empty");
                return;
            }
            try{
                conn con=new conn();
                String query="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"!!Room added sucessfully!!");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }

    }
    public static void main(String []args){
        new AddRooms();
    }
}
