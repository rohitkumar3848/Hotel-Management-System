package hotel.management.system;
import javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField jfname,jfage,jfsal,jfphone,jfemail,jfadhaar;
    JButton submit;
    JComboBox cbjob;
    JRadioButton jrmale,jrfemale;
    AddEmployee(){
        setLayout(null);

        JLabel jlname=new JLabel("Name");
        jlname.setBounds(60,30,120,30);
        jlname.setFont(new Font("Tahoma",Font.BOLD,20));
        add(jlname);

        jfname=new JTextField();
        jfname.setBounds(200,30,150,30);
        add(jfname);

        JLabel jlage=new JLabel("Age");
        jlage.setBounds(60,80,120,30);
        jlage.setFont(new Font("Tahoma",Font.BOLD,20));
        add(jlage);

        jfage=new JTextField();
        jfage.setBounds(200,80,150,30);
        add(jfage);

        JLabel rlbutton=new JLabel("Gender");
        rlbutton.setBounds(60,130,120,30);
        rlbutton.setFont(new Font("Tahoma",Font.BOLD,20));
        add(rlbutton);

        jrmale=new JRadioButton("Male");
        jrmale.setBackground(Color.white);
        jrmale.setBounds(200,130,70,30);
        jrmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(jrmale);

        jrfemale=new JRadioButton("Female");
        jrfemale.setBackground(Color.white);
        jrfemale.setBounds(280,130,70,30);
        jrfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(jrfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add((jrmale));
        bg.add(jrfemale);

        JLabel jljob=new JLabel("Job");
        jljob.setBounds(60,180,120,30);
        jljob.setFont(new Font("Tahoma",Font.BOLD,20));
        add(jljob);

        String str[]={"HouseKeeping","Front Desk Clerks","Kitchen Staff","Room Service","Chef","Manager"};
        cbjob=new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.white);
        cbjob.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(cbjob);

        JLabel jlsal=new JLabel("Salary");
        jlsal.setBounds(60,230,120,30);
        jlsal.setFont(new Font("Tahoma",Font.BOLD,20));
        add(jlsal);

        jfsal=new JTextField();
        jfsal.setBounds(200,230,150,30);
        add(jfsal);

        JLabel jlphone=new JLabel("Phone");
        jlphone.setBounds(60,280,120,30);
        jlphone.setFont(new Font("Tahoma",Font.BOLD,20));
        add(jlphone);

        jfphone=new JTextField();
        jfphone.setBounds(200,280,150,30);
        add(jfphone);

        JLabel jlemail=new JLabel("Email");
        jlemail.setBounds(60,330,120,30);
        jlemail.setFont(new Font("Tahoma",Font.BOLD,20));
        add(jlemail);

        jfemail=new JTextField();
        jfemail.setBounds(200,330,150,30);
        add(jfemail);

        JLabel jladhaar=new JLabel("Adhaar");
        jladhaar.setBounds(60,380,120,30);
        jladhaar.setFont(new Font("Tahoma",Font.BOLD,20));
        add(jladhaar);

        jfadhaar=new JTextField();
        jfadhaar.setBounds(200,380,150,30);
        add(jfadhaar);

        submit=new JButton("Submit");
        submit.setBounds(200,430,150,40);
        submit.setForeground(Color.white);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Tahoma",Font.BOLD,20));
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);

        setBounds(350,200,850,540);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);



    }
    public  void actionPerformed(ActionEvent ae){
        String name=jfname.getText();
        String age=jfage.getText();
        String salary=jfsal.getText();
        String phone=jfphone.getText();
        String email=jfemail.getText();
        String adhaar=jfadhaar.getText();
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name shouldn't be empty");
            return;
        }

        String gender=null;
        if(jrmale.isSelected()){
            gender="Male";
        }else if(jrfemale.isSelected()){
            gender="Female";
        }
        String job=(String) cbjob.getSelectedItem();
        try{
            conn con=new conn();
            String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+adhaar+"')";
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"!!Employee added sucessfully!!");
            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public static void main(String [] args){
        new AddEmployee();
    }
}
