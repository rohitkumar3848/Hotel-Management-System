package hotel.management.system;
import javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    JButton newCustomer,rooms,department,allEmployees,customer,managerInfo,checkout,updateStatus,updateroomStatus,search,pickup,logout;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newCustomer=new JButton("Add New Customer");
        newCustomer.setBounds(10,30,250,30);
        newCustomer.setForeground(Color.white);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setFont(new Font("Tahoma",Font.BOLD,20));
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms=new JButton("Rooms");
        rooms.setBounds(10,70,250,30);
        rooms.setForeground(Color.white);
        rooms.setBackground(Color.BLACK);
        rooms.setFont(new Font("Tahoma",Font.BOLD,20));
        rooms.addActionListener(this);
        add(rooms);

        department=new JButton("Department");
        department.setBounds(10,110,250,30);
        department.setForeground(Color.white);
        department.setBackground(Color.BLACK);
        department.setFont(new Font("Tahoma",Font.BOLD,20));
        department.addActionListener(this);
        add(department);

        allEmployees=new JButton("Employees");
        allEmployees.setBounds(10,150,250,30);
        allEmployees.setForeground(Color.white);
        allEmployees.setBackground(Color.BLACK);
        allEmployees.setFont(new Font("Tahoma",Font.BOLD,20));
        allEmployees.addActionListener(this);
        add(allEmployees);

        customer=new JButton("Customer Info");
        customer.setBounds(10,190,250,30);
        customer.setForeground(Color.white);
        customer.setBackground(Color.BLACK);
        customer.setFont(new Font("Tahoma",Font.BOLD,20));
        customer.addActionListener(this);
        add(customer);

        managerInfo=new JButton("Manager Info");
        managerInfo.setBounds(10,230,250,30);
        managerInfo.setForeground(Color.white);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setFont(new Font("Tahoma",Font.BOLD,20));
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkout=new JButton("Checkout ");
        checkout.setBounds(10,270,250,30);
        checkout.setForeground(Color.white);
        checkout.setBackground(Color.BLACK);
        checkout.setFont(new Font("Tahoma",Font.BOLD,20));
        checkout.addActionListener(this);
        add(checkout);

        updateStatus=new JButton("Update Status ");
        updateStatus.setBounds(10,310,250,30);
        updateStatus.setForeground(Color.white);
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setFont(new Font("Tahoma",Font.BOLD,20));
        updateStatus.addActionListener(this);
        add(updateStatus);

        updateroomStatus=new JButton("Update Room Status ");
        updateroomStatus.setBounds(10,350,250,30);
        updateroomStatus.setForeground(Color.white);
        updateroomStatus.setBackground(Color.BLACK);
        updateroomStatus.setFont(new Font("Tahoma",Font.BOLD,20));
        updateroomStatus.addActionListener(this);
        add(updateroomStatus);

        pickup=new JButton("Pickup Service");
        pickup.setBounds(10,390,250,30);
        pickup.setForeground(Color.white);
        pickup.setBackground(Color.BLACK);
        pickup.setFont(new Font("Tahoma",Font.BOLD,20));
        pickup.addActionListener(this);
        add(pickup);

        search=new JButton("Search Room");
        search.setBounds(10,430,250,30);
        search.setForeground(Color.white);
        search.setBackground(Color.BLACK);
        search.setFont(new Font("Tahoma",Font.BOLD,20));
        search.addActionListener(this);
        add(search);

        logout=new JButton("Logout");
        logout.setBounds(10,470,250,30);
        logout.setForeground(Color.white);
        logout.setBackground(Color.BLACK);
        logout.setFont(new Font("Tahoma",Font.BOLD,20));
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/thirteen.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,60,400,350);
        add(image);


        setBounds(350,200,800,570);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newCustomer){
            setVisible(false);
            new AddCustomer();
        }
        if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        if(ae.getSource()==department){
            setVisible(false);
            new Department();
        }
        if(ae.getSource()==allEmployees){
            setVisible(false);
            new EmployeeInfo();
        }
        if(ae.getSource()==managerInfo){
            setVisible(false);
            new ManagerInfo();
        }
        if(ae.getSource()==customer){
            setVisible(false);
            new CustomerInfo();
        }
        if(ae.getSource()==search){
            setVisible(false);
            new SearchRoom();
        }
        if(ae.getSource()==updateStatus){
            setVisible(false);
            new UpdateCheck();
        }
        if(ae.getSource()==updateroomStatus){
            setVisible(false);
            new UpdateRoom();
        }
        if(ae.getSource()==pickup){
            setVisible(false);
            new Pickup();
        }
        if(ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }
        if(ae.getSource()==logout){
            JOptionPane.showMessageDialog(null,"Logout Sucessfully");
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String args[]){
        new Reception();
    }
}
