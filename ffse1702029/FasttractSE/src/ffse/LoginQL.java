package ffse;


import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.eclipse.swt.internal.mozilla.Execute;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import model.KetNoiSQL;

import java.awt.Color;
import java.awt.Dimension;

public class LoginQL extends JFrame {

	private JTextField mail, pass;
	private JPanel login;
	private JLabel chulg, email, Password ;
	private JButton Cancel, log;
	public LoginQL(String title) {
		super(title);
		addControls();
		addEvents();
	}
	ActionListener loghome = new ActionListener() {
		public	void actionPerformed(ActionEvent e ) {
			log_home();
		}
	};
	
	protected void log_home() {
		 this.setVisible(false);
		 Login myUI = new Login("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN SINH VIÊN");
	        myUI.showWindow();
	}
	private void addEvents() {
		Cancel.addActionListener(loghome);
		
	}

	private Connection getConnect(String strServer,String strDatabase,String strUser,String strPwd) {
	
	return null;
}

	private void addControls() {
		Container con = getContentPane();
        JPanel pnMain = new JPanel();
        pnMain.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        login = new JPanel();
        login.setBackground(new Color(0, 0, 255));
        login.setBounds(0, 0, 434, 60);
        pnMain.add(login);
        
        chulg = new JLabel("    Quản lý login");
        chulg.setFont(new Font("Tahoma", Font.BOLD, 20));
        chulg.setPreferredSize(new Dimension(200, 50));
        login.add(chulg);
        
        email = new JLabel("Email");
        email.setFont(new Font("Tahoma", Font.BOLD, 16));
        email.setBounds(46, 94, 104, 24);
        pnMain.add(email);
        
        mail = new JTextField();
        mail.setBounds(157, 94, 219, 24);
        pnMain.add(mail);
        mail.setColumns(10);
        
        Password = new JLabel("Password");
        Password.setFont(new Font("Tahoma", Font.BOLD, 16));
        Password.setBounds(46, 164, 104, 24);
        pnMain.add(Password);
        
        pass = new JPasswordField();
        pass.setBounds(157, 166, 219, 24);
        pnMain.add(pass);
        pass.setColumns(10);
        
        Cancel = new JButton("cancel");
        Cancel.setBackground(new Color(255, 0, 0));
        Cancel.setFont(new Font("Tahoma", Font.BOLD, 13));
        Cancel.setForeground(new Color(0, 0, 0));
        Cancel.setBounds(287, 227, 89, 23);
        pnMain.add(Cancel);
        
        log = new JButton("login");
        log.setBackground(new Color(30, 144, 255));
        log.setFont(new Font("Tahoma", Font.BOLD, 13));
        log.setForeground(new Color(0, 0, 0));
        log.setBounds(157, 227, 89, 23);
       log.addActionListener(new ActionListener(){
    	   @Override
    	   public void actionPerformed(ActionEvent arg0) {
    		   try {
    			   Connection conn = KetNoiSQL.getConnect("localhost", "ffse1702029", "ffse1702029","12345");
    				Statement ptmt = (Statement) conn.createStatement();
    			   String sql = "SELECT * FROM `account` WHERE Email='"+mail.getText()+"'and Pass='"+pass.getText().toString()+"'";
    			   ResultSet rs = ptmt.executeQuery(sql);
    			   if(rs.next()) {
    				
    				   setVisible(false);
    			   		DSsvAc myUI = new DSsvAc("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN SINH VIÊN");
    			        myUI.showWindow();
    			   		
    			   		}
    			   else
    				   JOptionPane.showMessageDialog(null, "incorrect username and password");
    			   
    		   }catch(Exception e){
    			   e.printStackTrace();
    		   }
    	   }
       });
        pnMain.add(log);
        
        con.add(pnMain);
        pnMain.setLayout(null);
        
	}
//	public static void main(String[] args) {
//		 LoginQL myUI = new LoginQL("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN SINH VIÊN");
//	        myUI.showWindow();
//
//	 }
	 public void showWindow() {
	        this.setSize(450, 300);
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
	 }
}







