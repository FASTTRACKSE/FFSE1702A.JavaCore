package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMenu.setBounds(243, 11, 67, 24);
		contentPane.add(lblMenu);
		
		JButton btnNewButton = new JButton("KH\u00C1CH H\u00C0NG ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerManage window = new CustomerManage();
				window.frame.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(70, 60, 131, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BI\u00CAN LAI");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BienLaiManage bl = new BienLaiManage("Quan ly bien lai");
				bl.setSize(800,600);
				bl.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(345, 60, 118, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("B\u00C1O C\u00C1O KH\u00C1CH H\u00C0NG ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaoCaoKH bh;
				try {
					bh = new BaoCaoKH();
					bh.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(27, 201, 243, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnBoCoBin = new JButton("B\u00C1O C\u00C1O BI\u00CAN LAI ");
		btnBoCoBin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBoCoBin.setBounds(290, 201, 243, 34);
		contentPane.add(btnBoCoBin);
	}

}
