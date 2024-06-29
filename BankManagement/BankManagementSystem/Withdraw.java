package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    private JTextField amount;
    private JButton withdraw,back;
    String pinNumber;
    Withdraw(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image img2=img1.getImage().getScaledInstance(880,880,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel img=new JLabel(img3);
        img.setBounds(0,0,880,880);
        add(img);

        JLabel text=new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        img.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        img.add(amount);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,455,120,25);
        withdraw.addActionListener(this);
        img.add(withdraw);

        back=new JButton("Back");
        back.setBounds(355,485,120,25);
        back.addActionListener(this);
        img.add(back);

        getContentPane().setBackground(Color.WHITE);
        setSize(880,880);
        setLayout(null);
        setVisible(true);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==withdraw){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter valid amount");
            }
            else{
                try{
                    Conn c=new Conn();
                    String query="insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"BDT "+number+"Withdraw Successfully");
                    new Transactions(pinNumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
}
