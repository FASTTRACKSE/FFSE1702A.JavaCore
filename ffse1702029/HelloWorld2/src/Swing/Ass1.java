package Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ass1 {

	private JFrame frame;
	private JTextField txta;
	private JTextField txtb;
	private JTextField txtnghiem;
	private int a;
	private int b;
//	private double g;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ass1 window = new Ass1();
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
	public Ass1() {
		initialize();
		
	}
	public Ass1(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public void setA(int a) {
		this.a = a;
	}
	public void setB(int b) {
		this.b = b;
	}
	public double giai() {
		return (-(double)this.b/this.a);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 399, 256);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//tiêu đề
		JLabel lblNewLabel = new JLabel("GI\u1EA2I PH\u01AF\u01A0NG TR\u00CCNH B\u1EACC 1");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(87, 11, 211, 33);
		frame.getContentPane().add(lblNewLabel);
		
		//hệ số a
		JLabel a = new JLabel("H\u1EC7 s\u1ED1 a:");
		a.setFont(new Font("Tahoma", Font.BOLD, 11));
		a.setBounds(40, 56, 58, 14);
		frame.getContentPane().add(a);
		
		txta = new JTextField();
		txta.setBounds(97, 53, 201, 20);
		frame.getContentPane().add(txta);
		txta.setColumns(10);
		
		//hệ số b
		JLabel b = new JLabel("H\u1EC7 s\u1ED1 b:");
		b.setFont(new Font("Tahoma", Font.BOLD, 11));
		b.setBounds(40, 101, 46, 14);
		frame.getContentPane().add(b);
		
		txtb = new JTextField();
		txtb.setBounds(97, 98, 201, 20);
		frame.getContentPane().add(txtb);
		txtb.setColumns(10);
		
		//giải
		JButton giai = new JButton("GI\u1EA2I");
		giai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = Integer.parseInt(txta.getText());
				int b = Integer.parseInt(txtb.getText());
				if(a==0 && b ==0) {
					JOptionPane.showMessageDialog(frame, "phương trình vô số nghiệm");
				}
				else if (a==0 && b!=0) {
					JOptionPane.showMessageDialog(frame, "phương trình vô nghiệm");
				}
				else {
					Ass1 ass = new Ass1 (a, b);
					txtnghiem.setText("x = " + String.valueOf(ass.giai()));
				}
			}
		});
		giai.setBackground(Color.CYAN);
		giai.setBounds(55, 157, 82, 23);
		frame.getContentPane().add(giai);
		
		
		//thoát
		JButton btnThot = new JButton("THO\u00C1T");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			
			}
		});
		btnThot.setBackground(Color.CYAN);
		btnThot.setBounds(158, 157, 89, 23);
		frame.getContentPane().add(btnThot);
		
		//help
		JButton btnHelp = new JButton("HELP");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "phương trình vô nghiệm khi a=0 và b><0, phương trình vô số nghiệm khi a=b=0");
			}
		});
		btnHelp.setBackground(Color.CYAN);
		btnHelp.setBounds(263, 157, 89, 23);
		frame.getContentPane().add(btnHelp);
		
		//kết quả
		JLabel x = new JLabel("K\u1EBFt qu\u1EA3");
		x.setFont(new Font("Tahoma", Font.BOLD, 11));
		x.setBounds(40, 191, 46, 14);
		frame.getContentPane().add(x);
		
		txtnghiem = new JTextField();
		txtnghiem.setBounds(97, 188, 201, 20);
		frame.getContentPane().add(txtnghiem);
		txtnghiem.setColumns(10);
	}
}
