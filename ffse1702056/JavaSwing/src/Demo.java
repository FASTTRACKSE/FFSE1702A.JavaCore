


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Demo{

 private JFrame frame;
 private JTextField txtUser;

 private Connection conn;
 private PreparedStatement stmt;
 private ResultSet rs;
 private JPasswordField txtPass;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Demo window = new Demo();
     window.frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the application.
  */
 public Demo() {
  initializeLogin();
  try {
  
  } catch (Exception e) {
   // TODO: handle exception
  }
  this.frame.setResizable(false);
 }

 /**
  * Initialize the contents of the frame.
  */
 private void initializeLogin() {
  frame = new JFrame();
  frame.setBounds(100, 100, 387, 500);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.getContentPane().setLayout(null);

  JLabel lblLogin = new JLabel("Login");
  lblLogin.setIcon(new ImageIcon("C:\\Users\\Lonely\\workspace\\Swing004\\icon\\user-login-icon.png"));
  lblLogin.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 37));
  lblLogin.setBounds(93, 11, 207, 40);
  frame.getContentPane().add(lblLogin);

  JLabel lblquan = new JLabel("Quản lí sinh viên");
  lblquan.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 15));
  lblquan.setBounds(93, 11, 207, 140);
  frame.getContentPane().add(lblquan);

	  txtUser = new JTextField();
	  txtUser.setBounds(162, 103, 133, 20);
  frame.getContentPane().add(txtUser);
  txtUser.setColumns(10);

  JButton btnLogin = new JButton("Login");
  btnLogin.setIcon(new ImageIcon("C:\\Users\\Lonely\\workspace\\Swing004\\icon\\About-me-icon.png"));
  btnLogin.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    String User = txtUser.getText();
    String Pass = txtPass.getText();

    String sql = "SELECT * FROM manager.login WHERE user=? and pass=?";
    try {
     stmt = conn.prepareStatement(sql);
     stmt.setString(1, User);
     stmt.setString(2, Pass);
     
     rs = stmt.executeQuery();
     if (rs.next()) {

      String user = rs.getString("roles");
      switch (user) {
      case "Admin":
     
       frame.dispose();


       break;
      case "Saler":
       JOptionPane.showMessageDialog(null, "Xin loi ban la Saler khong phai admin");
       break;
      case "Acountant":
       JOptionPane.showMessageDialog(null, "Xin loi ban la Acountant khong phai admin");
       break;
      case "Manager":
       JOptionPane.showMessageDialog(null, "Xin loi ban la Manager khong phai admin");
       break;
      default:
       break;
      }
     } else {
      JOptionPane.showMessageDialog(null, "User or Pass khong dung!");
     }

    } catch (Exception e2) {
     // TODO: handle exception
    }
   }
  });

  btnLogin.setBounds(75, 186, 89, 23);
  frame.getContentPane().add(btnLogin);

  JButton btnExit = new JButton("Exit");
  btnExit.setIcon(new ImageIcon("C:\\Users\\Lonely\\workspace\\Swing004\\icon\\Actions-window-close-icon.png"));
  btnExit.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    System.exit(0);
   }
  });
  btnExit.setBounds(207, 186, 89, 23);
  frame.getContentPane().add(btnExit);

  JLabel lblUsername = new JLabel("Username:");
  lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
  lblUsername.setBounds(60, 106, 74, 14);
  frame.getContentPane().add(lblUsername);

  JLabel lblPassword = new JLabel("Password:");
  lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
  lblPassword.setBounds(60, 147, 74, 14);
  frame.getContentPane().add(lblPassword);

  txtPass = new JPasswordField();
  txtPass.setBounds(162, 144, 133, 20);
  frame.getContentPane().add(txtPass);
 }
}