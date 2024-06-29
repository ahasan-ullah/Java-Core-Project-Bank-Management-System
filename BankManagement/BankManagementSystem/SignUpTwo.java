package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {
    private JComboBox religions,catagories,incomes,educations,occupations;
    private JButton next;
    private JTextField nidTextField,passportTextField;
    private JRadioButton syes,sno,eayes,eano;
    private String formNo;
    SignUpTwo(String formNo){
        this.formNo=formNo;
        JLabel additionalDetails=new JLabel("Page 1: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religion=new JLabel("Religion");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(100,140,100,30);
        add(religion);
        String valReligion[]={"Islam","Hindu","Christian","Other"};
        religions=new JComboBox(valReligion);
        religions.setBounds(300,140,400,30);
        religions.setBackground(Color.WHITE);
        add(religions);

        JLabel category=new JLabel("Category");
        category.setFont(new Font("Raleway",Font.BOLD,22));
        category.setBounds(100,190,200,30);
        add(category);
        String valCatagory[]={"General","FQ","Other"};
        catagories=new JComboBox(valCatagory);
        catagories.setBounds(300,190,400,30);
        catagories.setBackground(Color.WHITE);
        add(catagories);

        JLabel income=new JLabel("Income");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100,240,200,30);
        add(income);
        String valIncome[]={"Null","<50,000","1<00,000","<200,000","Upto 10,00,000"};
        incomes=new JComboBox(valIncome);
        incomes.setBounds(300,240,400,30);
        incomes.setBackground(Color.WHITE);
        add(incomes);

        JLabel education=new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,22));
        education.setBounds(100,290,200,30);
        add(education);
        JLabel qualification=new JLabel("Qualification");
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        String valEducation[]={"SSC","HSC","Graduate","Post-Graduate","Doctorate"};
        educations=new JComboBox(valEducation);
        educations.setBounds(300,315,400,30);
        educations.setBackground(Color.WHITE);
        add(educations);


        JLabel occupation=new JLabel("Occoccupation");
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        String valOccupation[]={"Student","Self-Employed","Businessman","Retired","Others"};
        occupations=new JComboBox(valOccupation);
        occupations.setBounds(300,390,400,30);
        occupations.setBackground(Color.WHITE);
        add(occupations);

        JLabel nid=new JLabel("NID");
        nid.setFont(new Font("Raleway",Font.BOLD,22));
        nid.setBounds(100,440,200,30);
        add(nid);
        nidTextField=new JTextField();
        nidTextField.setFont(new Font("Raleway",Font.PLAIN,20));
        nidTextField.setBounds(300,440,400,30);
        add(nidTextField);


        JLabel passport=new JLabel("Passport");
        passport.setFont(new Font("Raleway",Font.BOLD,22));
        passport.setBounds(100,490,200,30);
        add(passport);
        passportTextField=new JTextField();
        passportTextField.setFont(new Font("Raleway",Font.PLAIN,20));
        passportTextField.setBounds(300,490,400,30);
        add(passportTextField);

        JLabel sCitizen=new JLabel("Senior Citizen");
        sCitizen.setFont(new Font("Raleway",Font.BOLD,22));
        sCitizen.setBounds(100,540,200,30);
        add(sCitizen);
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup seniorCitizenGroup=new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);

        JLabel Eaccount=new JLabel("Existing Account");
        Eaccount.setFont(new Font("Raleway",Font.BOLD,22));
        Eaccount.setBounds(100,590,200,30);
        add(Eaccount);
        eayes=new JRadioButton("Yes");
        eayes.setBounds(300,590,100,30);
        eayes.setBackground(Color.WHITE);
        add(eayes);
        eano=new JRadioButton("No");
        eano.setBounds(450,590,100,30);
        eano.setBackground(Color.WHITE);
        add(eano);
        ButtonGroup existingAccountGroup=new ButtonGroup();
        existingAccountGroup.add(eayes);
        existingAccountGroup.add(eano);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        add(next);
        next.addActionListener(this);

        setTitle("Sign Up Form Page 2");
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
        String religion=(String)religions.getSelectedItem();
        String category=(String)catagories.getSelectedItem();
        String income=(String)incomes.getSelectedItem();
        String education=(String)educations.getSelectedItem();
        String occupation=(String)occupations.getSelectedItem();
        String seniorCitizen="";
        if(syes.isSelected()){
            seniorCitizen="Yes";
        }
        else if(sno.isSelected()){
            seniorCitizen="No";
        }
        String existingAccount="";
        if(eayes.isSelected()){
            existingAccount="Yes";
        }
        else if(eano.isSelected()){
            existingAccount="No";
        }
        String nid=nidTextField.getText();
        String passport=passportTextField.getText();

        try{
                Conn c=new Conn();
                String query="insert into signupTwo values('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+nid+"','"+passport+"','"+existingAccount+"','"+seniorCitizen+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpThree(formNo).setVisible(true);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
