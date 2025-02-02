package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {
    private long random;
    private JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    private JButton next;
    private JRadioButton male,female,married,single,other;
    private JDateChooser dateChooser;

    SignUpOne(){
        Random rand=new Random();
        random=Math.abs((rand.nextLong()%9000L)+1000L);

        JLabel formNo=new JLabel("APPLICATION FORM No. "+random);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name=new JLabel("Name");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.PLAIN,20));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname=new JLabel("Father's Name");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.PLAIN,20));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        JLabel dob=new JLabel("Date of Birth");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setFont(new Font("Raleway",Font.PLAIN,16));
        add(dateChooser);

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email=new JLabel("Email");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.PLAIN,20));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel marital=new JLabel("Marital Status");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,390,200,30);
        add(marital);
        married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        single=new JRadioButton("Single");
        single.setBounds(450,390,100,30);
        single.setBackground(Color.WHITE);
        add(single);
        other=new JRadioButton("Other");
        other.setBounds(600,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup maritalStatusGroup=new ButtonGroup();
        maritalStatusGroup.add(married);
        maritalStatusGroup.add(single);
        maritalStatusGroup.add(other);

        JLabel address=new JLabel("Address");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.PLAIN,20));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);


        JLabel city=new JLabel("City");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.PLAIN,20));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state=new JLabel("State");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.PLAIN,20));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode=new JLabel("Pin Code");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.PLAIN,20));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        add(next);
        next.addActionListener(this);

        setTitle("Sign Up Form Page 1");
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String formNo=""+random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender="";
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        String email=emailTextField.getText();
        String maritalStatus="";
        if(married.isSelected()){
            maritalStatus="Married";
        }
        else if(single.isSelected()){
            maritalStatus="Single";
        }
        else if(other.isSelected()){
            maritalStatus="Other";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pinCode=pinTextField.getText();


        try{
            if(name.isEmpty() ||fname.isEmpty()||email.isEmpty()||dob.isEmpty()||gender.isEmpty()||address.isEmpty()||city.isEmpty()||state.isEmpty()||pinCode.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter All Details");
            }
            else{
                Conn c=new Conn();
                String query="insert into signup values('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+city+"','"+state+"','"+pinCode+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formNo).setVisible(true);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
