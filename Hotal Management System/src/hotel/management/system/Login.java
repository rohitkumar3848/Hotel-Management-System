
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel user=new JLabel("Username");
        user.setBounds(50,20,120,40);
        add(user);
        
        username=new JTextField();
        username.setBounds(160,20,150,40);
        add(username);
        
        JLabel pass=new JLabel("Password");
        pass.setBounds(50,75,120,40);
        add(pass);
        
        password=new JPasswordField();
        password.setBounds(160,75,150,40);
        add(password);
        
        login=new JButton("Login");
        login.setBounds(50,150,120,40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(190,150,120,40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/nine.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
        setBounds(500,200,600,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String user=username.getText();
            String pass=password.getText();
            try{
                    conn c=new conn();
                    String query="select * from login where username = '"+ user +"' and password = '"+ pass + "'";
                    ResultSet rs=c.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Dashboard();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                        setVisible(false);
                    }
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==cancel){
            setVisible(false);
        }

    }
    public static void main(String []args){
        new Login();
    }
}
