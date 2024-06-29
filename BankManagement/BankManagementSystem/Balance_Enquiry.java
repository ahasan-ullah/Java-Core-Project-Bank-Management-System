package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Balance_Enquiry extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;
    Balance_Enquiry(String pinNumber) {
        this.pinNumber = pinNumber;
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image img2 = img1.getImage().getScaledInstance(880, 880, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img = new JLabel(img3);
        img.setBounds(0, 0, 880, 880);
        add(img);

        back = new JButton("Back");
        back.setBounds(360, 500, 120, 30);
        back.addActionListener(this);
        img.add(back);


        Conn c = new Conn();
        int balance=0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin='" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        JLabel text = new JLabel("Your current account balance is " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(200,300,400,30);
        img.add(text);

        getContentPane().setBackground(Color.WHITE);
        setSize(880, 880);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setLocation(300, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
}
