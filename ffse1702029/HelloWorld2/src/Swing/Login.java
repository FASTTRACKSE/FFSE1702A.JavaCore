package Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("welcom Login system");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(124, 22, 168, 39);
		frame.getContentPane().add(lblLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setForeground(Color.BLUE);
		panel.setBounds(0, 0, 434, 74);
		frame.getContentPane().add(panel);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserName.setBounds(37, 106, 78, 32);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblUsername = new JLabel("Password:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(37, 163, 78, 32);
		frame.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(110, 113, 231, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 170, 231, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(163, 201, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBackground(new Color(255, 51, 51));
		btnCancel.setBounds(252, 201, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnAdd = new JButton("new account");
		btnAdd.setBackground(new Color(0, 204, 255));
		btnAdd.setBounds(63, 201, 101, 23);
		frame.getContentPane().add(btnAdd);
	}
}
