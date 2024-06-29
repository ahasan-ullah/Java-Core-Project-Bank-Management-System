package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Date;

public class Fast_Cash extends JFrame implements ActionListener {
    JButton deposit,withdraw,fastCash,miniState,pinChange,balance,back;
    String pinNumber;
    Fast_Cash(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image img2=img1.getImage().getScaledInstance(880,880,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel img=new JLabel(img3);
        img.setBounds(0,0,880,880);
        add(img);

        JLabel text=new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        img.add(text);

        deposit=new JButton("500");
        deposit.setBounds(170,375,120,25);
        deposit.addActionListener(this);
        img.add(deposit);

        withdraw=new JButton("1000");
        withdraw.setBounds(355,375,120,25);
        withdraw.addActionListener(this);
        img.add(withdraw);

        fastCash=new JButton("1500");
        fastCash.setBounds(170,405,120,25);
        fastCash.addActionListener(this);
        img.add(fastCash);

        miniState=new JButton("2000");
        miniState.setBounds(355,405,120,25);
        miniState.addActionListener(this);
        img.add(miniState);

        pinChange=new JButton("5000");
        pinChange.setBounds(170,435,120,25);
        pinChange.addActionListener(this);
        img.add(pinChange);

        balance=new JButton("10000");
        balance.setBounds(355,435,120,25);
        balance.addActionListener(this);
        img.add(balance);

        back=new JButton("Back");
        back.setBounds(355,465,120,25);
        back.addActionListener(this);
        img.add(back);


        getContentPane().setBackground(Color.WHITE);
        setSize(880,880);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else {
            String amount=((JButton)ae.getSource()).getText();
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"BDT "+amount+"Debited Successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
