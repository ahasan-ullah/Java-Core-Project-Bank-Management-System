package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    private final JButton login,signup,clear;
    private final JTextField cardTextField;
    private final JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");


        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("images/logo.jpg"));
        Image img2= img1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel label=new JLabel(img3);
        label.setBounds(70,10,100,100);
        add(label);


        JLabel text=new JLabel("WELCOME TO ATM");
        text.setBounds(250,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        JLabel cardNo=new JLabel("Card No");
        cardNo.setBounds(150,150,150,30);
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        add(cardNo);
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,300,30);
        cardTextField.setFont(new Font("Arial",Font.PLAIN,14));
        add(cardTextField);

        JLabel pin=new JLabel("Pin");
        pin.setBounds(150,220,400,40);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        add(pin);
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,300,30);
        pinTextField.setFont(new Font("Arial",Font.PLAIN,14));
        add(pinTextField);

        login=new JButton("SIGN IN");
        login.setBounds(320,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(480,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(375,350,150,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setLayout(null);
        setVisible(true);
        setLocation(350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
     }
     @Override
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login) {
            Conn c=new Conn();
            String cardNumber=cardTextField.getText();
            String pinNumber= pinTextField.getText();
            String query="select * from login where card_number='"+cardNumber+"' and pin='"+pinNumber+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
     }
}
