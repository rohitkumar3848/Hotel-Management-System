
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{

        Dashboard(){
            setBounds(0,0,1550,1000);
            setLayout(null);
            
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/ten.jpg"));
            Image i2=i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            image.setBounds(0,0,1550,1000);
            add(image);
            
            ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/eleven.jpg"));
            JLabel image2=new JLabel(i4);
            image2.setBounds(1250,0,300,300);
            image.add(image2);
            
            JMenuBar mb=new JMenuBar();
            mb.setBounds(0,0,1550,30);
            image.add(mb);
            mb.setBackground(Color.red);
            
            JMenu hotel=new JMenu("HOTEL MANAGEMENT"); 
            mb.add(hotel);
            hotel.setForeground(Color.BLACK);
            hotel.setFont(new Font("monospaced",Font.BOLD,20));
            
            JMenuItem reception=new JMenuItem("RECEPTION");
            hotel.add(reception);
            hotel.setForeground(Color.BLACK);
            reception.addActionListener(this);
            hotel.setFont(new Font("monospaced",Font.BOLD,20));
            
            JMenu admin=new JMenu("ADMIN");  
            mb.add(admin);
            admin.setForeground(Color.BLACK);
            admin.setFont(new Font("monospaced",Font.BOLD,20));
            
            JMenuItem addEmployee=new JMenuItem("ADD EMPLOYEE");
            admin.add(addEmployee);
            admin.setForeground(Color.BLACK);
            addEmployee.addActionListener(this);
            admin.setFont(new Font("monospaced",Font.BOLD,20));
            
            JMenuItem addRooms=new JMenuItem("ADD ROOMS");
            admin.add(addRooms);
            admin.setForeground(Color.BLACK);
            addRooms.addActionListener(this);
            admin.setFont(new Font("monospaced",Font.BOLD,20));
            
            JMenuItem addDrivers=new JMenuItem("ADD DRIVERS");
            admin.add(addDrivers);
            admin.setForeground(Color.BLACK);
            admin.setFont(new Font("monospaced",Font.BOLD,20));
            
            
            setVisible(true);
            
        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("ADD EMPLOYEE")){
                new AddEmployee();
            }
            else if(ae.getActionCommand().equals("ADD ROOMS")){
                new AddRooms();
            }
            else if(ae.getActionCommand().equals("RECEPTION")){
                new Reception();
            }
        }
        public static void main(String [] args){
            new Dashboard();
        }
}

