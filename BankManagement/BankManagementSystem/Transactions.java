package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdraw,fastCash,miniState,pinChange,balance,exit;
    String pinNumber;
    Transactions(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image img2=img1.getImage().getScaledInstance(880,880,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel img=new JLabel(img3);
        img.setBounds(0,0,880,880);
        add(img);

        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        img.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(170,375,120,25);
        deposit.addActionListener(this);
        img.add(deposit);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,375,120,25);
        withdraw.addActionListener(this);
        img.add(withdraw);

        fastCash=new JButton("Fast Cash");
        fastCash.setBounds(170,405,120,25);
        fastCash.addActionListener(this);
        img.add(fastCash);

        miniState=new JButton("Mini Statement");
        miniState.setBounds(355,405,120,25);
        miniState.addActionListener(this);
        img.add(miniState);

        pinChange=new JButton("Pin Change");
        pinChange.setBounds(170,435,120,25);
        pinChange.addActionListener(this);
        img.add(pinChange);

        balance=new JButton("Balance");
        balance.setBounds(355,435,120,25);
        balance.addActionListener(this);
        img.add(balance);

        exit=new JButton("Exit");
        exit.setBounds(355,465,120,25);
        exit.addActionListener(this);
        img.add(exit);


        getContentPane().setBackground(Color.WHITE);
        setSize(880,880);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==fastCash){
            setVisible(false);
            new Fast_Cash(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==pinChange){
            setVisible(false);
            new Pin_Change(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==balance){
            setVisible(false);
            new Balance_Enquiry(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==miniState){
            new Mini_Statement(pinNumber).setVisible(true);
        }
    }
}
