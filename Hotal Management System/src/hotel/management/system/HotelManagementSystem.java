
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
    JButton image2;
    HotelManagementSystem(){

        setBounds(0,0,1550,1000);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/welcome.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/fourth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400,100,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        image2=new JButton(i4);
        image2.setBounds(1140,50,400,100);
        image2.addActionListener(this);
        image.add(image2);
        
        setVisible(true);
        

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==image2){
            setVisible(true);
            new Login();
        }
    }
    public static void main(String[] args) {
            new HotelManagementSystem();
    }
    
}
