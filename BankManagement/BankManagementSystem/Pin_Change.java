package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin_Change extends JFrame implements ActionListener {
    private String pinNumber;
    private JPasswordField pin,rePin;
    private JButton change,back;
    Pin_Change(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image img2=img1.getImage().getScaledInstance(880,880,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel img=new JLabel(img3);
        img.setBounds(0,0,880,880);
        add(img);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        img.add(text);

        JLabel pinText=new JLabel("New Pin");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System",Font.BOLD,16));
        pinText.setBounds(165,350,150,25);
        img.add(pinText);

        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(330,350,150,25);
        img.add(pin);

        JLabel rePinText=new JLabel("Re-Enter New Pin");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System",Font.BOLD,16));
        rePinText.setBounds(165,400,150,25);
        img.add(rePinText);

        rePin=new JPasswordField();
        rePin.setFont(new Font("Raleway",Font.BOLD,20));
        rePin.setBounds(330,400,150,25);
        img.add(rePin);

        change=new JButton("Change");
        change.setBounds(360,440,120,30);
        change.addActionListener(this);
        img.add(change);

        back=new JButton("Back");
        back.setBounds(360,480,120,30);
        back.addActionListener(this);
        img.add(back);

        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setLayout(null);
        setSize(880,880);
        setVisible(true);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change) {
            try {
                String npin = pin.getText();
                String rpin = rePin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin doesn't match");
                    return;
                }
                if (npin.equals(" ")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Pin");
                    return;
                }
                if (rpin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter Pin");
                    return;
                }
                Conn c=new Conn();
                String query1="update login set pin='"+rpin+"'where pin='"+pinNumber+"'";
                String query2="update bank set pin='"+rpin+"'where pin='"+pinNumber+"'";
                String query3="update signupThree set pin='"+rpin+"'where pin='"+pinNumber+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

}
