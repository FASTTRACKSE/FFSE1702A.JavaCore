package thu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Register extends JFrame implements ActionListener{ 
     
    JButton bRegister  = new JButton("Register"); 
    JButton bCancel    = new JButton("Cancel"); 
     
    JLabel lUserName   = new JLabel("Username"); 
    JLabel lPassword   = new JLabel("Password"); 
     
    JTextField  tfUserName = new JTextField(15); 
    JPasswordField tfPassword = new JPasswordField(15); 
    
    public Register() 
    { 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container panel = getContentPane();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        panel.add(lUserName);
        panel.add(tfUserName);
        
        panel.add(lPassword);
        panel.add(tfPassword);

        panel.add(bRegister);
        panel.add(bCancel);
        
        // trinh bay lUserName
        layout.putConstraint(SpringLayout.WEST,lUserName,15,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,lUserName,15,SpringLayout.NORTH,panel);
        
         // trinh bay tfUserName
        layout.putConstraint(SpringLayout.WEST,tfUserName,15,SpringLayout.EAST,lUserName);
        layout.putConstraint(SpringLayout.NORTH,tfUserName,15,SpringLayout.NORTH,panel);
        
        // trinh bay lPassword
        layout.putConstraint(SpringLayout.WEST,lPassword,15,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,lPassword,15,SpringLayout.SOUTH,lUserName);
        
        // trinh bay tfPassword
        layout.putConstraint(SpringLayout.WEST,tfPassword,15,SpringLayout.EAST,lPassword);
        layout.putConstraint(SpringLayout.NORTH,tfPassword,15,SpringLayout.SOUTH,tfUserName);

        // trinh bay nut Register
        layout.putConstraint(SpringLayout.WEST,bRegister,90,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,bRegister,15,SpringLayout.SOUTH,tfPassword);

        // trinh bay nut Cancel
        layout.putConstraint(SpringLayout.WEST,bCancel,10,SpringLayout.EAST,bRegister);
        layout.putConstraint(SpringLayout.NORTH,bCancel,15,SpringLayout.SOUTH,tfPassword);
        
    }   
     
     
    /******************************************************************* 
    *       Trien khai cac methods cua interface ActionListener           * 
    ********************************************************************/ 
    public void actionPerformed(ActionEvent e) 
    { 
         
    } 
     
    public static void main(String args[]) 
    { 
       Register a = new Register();
       a.setSize(400,400);
       a.setVisible(true);
    } 
     
}  
