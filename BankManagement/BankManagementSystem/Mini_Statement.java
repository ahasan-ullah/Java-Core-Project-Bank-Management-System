package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Mini_Statement extends JFrame{
    private String pinNumber;
    Mini_Statement(String pinNumber){
        this.pinNumber=pinNumber;

        JLabel mini=new JLabel();
        add(mini);

        JLabel bank=new JLabel("People's Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin='"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number "+rs.getString("card_number").substring(0,4)+"XXXXXXXX"+rs.getString("card_number").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn c=new Conn();
            int bal=0;
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbpc;&nbpc;&nbpc;&nbpc;&nbpc;"+rs.getString("type")+"&nbpc;&nbpc;&nbpc;&nbpc;&nbpc;"+"&nbpc;&nbpc;&nbpc;&nbpc;&nbpc;"+rs.getString("amount")+"<br><br><html>");

                if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal+=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account Balance is "+bal);
        }
        catch(Exception e){
            System.out.println(e);
        }

        setTitle("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLayout(null);
        setVisible(true);
        setLocation(20,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

}
