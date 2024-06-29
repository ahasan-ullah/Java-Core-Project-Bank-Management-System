package BankManagementSystem;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    private JRadioButton savingAcc,currentAcc,fixedDepositAcc,recurringDepositAcc;
    private JCheckBox atmCard,internetBanking,mobileBanking,emailAlerts,chequeBook,eStatement,declare;
    private JButton submit,cancel;
    private String formNo;
    SignUpThree(String formNo){
        this.formNo=formNo;
        JLabel heading=new JLabel("Page 3: Account Details");
        heading.setFont(new Font("Raleway",Font.BOLD,22));
        heading.setBounds(280,40,400,40);
        add(heading);

        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        savingAcc=new JRadioButton("Saving Account");
        savingAcc.setFont(new Font("Raleway", Font.BOLD,16));
        savingAcc.setBackground(Color.WHITE);
        savingAcc.setBounds(100,180,200,20);
        add(savingAcc);

        fixedDepositAcc=new JRadioButton("Fixed Deposit Account");
        fixedDepositAcc.setFont(new Font("Raleway", Font.BOLD,16));
        fixedDepositAcc.setBackground(Color.WHITE);
        fixedDepositAcc.setBounds(350,180,250,20);
        add(fixedDepositAcc);

        currentAcc=new JRadioButton("Cuurent Account");
        currentAcc.setFont(new Font("Raleway", Font.BOLD,16));
        currentAcc.setBackground(Color.WHITE);
        currentAcc.setBounds(100,220,200,20);
        add(currentAcc);

        recurringDepositAcc=new JRadioButton("Recurring Deposit Account");
        recurringDepositAcc.setFont(new Font("Raleway", Font.BOLD,16));
        recurringDepositAcc.setBackground(Color.WHITE);
        recurringDepositAcc.setBounds(350,220,250,20);
        add(recurringDepositAcc);

        ButtonGroup accountGroup=new ButtonGroup();
        accountGroup.add(savingAcc);
        accountGroup.add(fixedDepositAcc);
        accountGroup.add(currentAcc);
        accountGroup.add(recurringDepositAcc);

        JLabel card=new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,150,30);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-0000");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel cdetail=new JLabel("Your 16 Digit Card Number");
        cdetail.setFont(new Font("Raleway",Font.BOLD,12));
        cdetail.setBounds(100,330,300,20);
        add(cdetail);

        JLabel pin=new JLabel("Pin");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,150,30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,250,30);
        add(pnumber);

        JLabel pdetail=new JLabel("Your 4 Digit Pin Number");
        pdetail.setFont(new Font("Raleway",Font.BOLD,12));
        pdetail.setBounds(100,400,300,20);
        add(pdetail);

        JLabel services=new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,400,30);
        add(services);

        atmCard=new JCheckBox("ATM Card");
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(new Font("Raleway",Font.BOLD,16));
        atmCard.setBounds(100,500,200,30);
        add(atmCard);

        internetBanking=new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway",Font.BOLD,16));
        internetBanking.setBounds(300,500,200,30);
        add(internetBanking);

        mobileBanking=new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway",Font.BOLD,16));
        mobileBanking.setBounds(350,500,200,30);
        add(mobileBanking);

        emailAlerts=new JCheckBox("Email Alerts");
        emailAlerts.setBackground(Color.WHITE);
        emailAlerts.setFont(new Font("Raleway",Font.BOLD,16));
        emailAlerts.setBounds(100,550,200,30);
        add(emailAlerts);

        chequeBook=new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Raleway",Font.BOLD,16));
        chequeBook.setBounds(100,600,200,30);
        add(chequeBook);

        eStatement=new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Raleway",Font.BOLD,16));
        eStatement.setBounds(350,600,200,30);
        add(eStatement);

        declare=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        declare.setBackground(Color.WHITE);
        declare.setFont(new Font("Raleway",Font.BOLD,12));
        declare.setBounds(100,680,600,30);
        add(declare);

        submit=new JButton("Submit");
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setTitle("Sign UP Form Page 3");
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType="";
            if(savingAcc.isSelected()){
                accountType="Savings Account";
            }
            else if(fixedDepositAcc.isSelected()){
                accountType="Fixed Deposit";
            }
            else if(currentAcc.isSelected()){
                accountType="Current Account";
            }
            else if(recurringDepositAcc.isSelected()){
                accountType="Recurring Deposit Account";
            }
            Random random=new Random();
            String cardNumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pin=""+Math.abs((random.nextLong()%9000L)+1000L);
            String facilities="";
            if(atmCard.isSelected()){
                facilities+="ATM Card";
            }
            else if(internetBanking.isSelected()){
                facilities+="Internet Banking";
            }
            else if(mobileBanking.isSelected()){
                facilities+="Mobile Banking";
            }
            else if(emailAlerts.isSelected()){
                facilities+="Email Alerts";
            }
            else if(chequeBook.isSelected()){
                facilities+="Cheque Book";
            }
            else if(eStatement.isSelected()){
                facilities+="E-Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type Required");
                }
                else{
                    Conn c=new Conn();
                    String query1="insert into signupThree values ('"+formNo+"','"+accountType+"','"+cardNumber+"','"+pin+"','"+facilities+"')";
                    JOptionPane.showMessageDialog(null,"Card Number "+cardNumber+"\n Pin "+pin);
                    String query2="insert into login values ('"+formNo+"','"+cardNumber+"','"+pin+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    setVisible(false);
                    new Deposit(pin).setVisible(true);
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
