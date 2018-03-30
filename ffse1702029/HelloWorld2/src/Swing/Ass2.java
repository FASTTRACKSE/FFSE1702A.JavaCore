package Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Ass2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ass2 window = new Ass2();
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
	public Ass2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.setBounds(100, 100, 450, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//tiêu đê
		JLabel tieude = new JLabel("CH\u01AF\u01A0NG TR\u00CCNH QU\u1EA2N L\u00DD SINH VI\u00CAN");
		tieude.setFont(new Font("Tahoma", Font.BOLD, 11));
		tieude.setBounds(116, 11, 206, 27);
		frame.getContentPane().add(tieude);
		
		//mã sinh viên
		JLabel masv = new JLabel("M\u00E3 sinh vi\u00EAn");
		masv.setFont(new Font("Tahoma", Font.BOLD, 11));
		masv.setBounds(29, 52, 81, 14);
		frame.getContentPane().add(masv);
		
		textField = new JTextField();
		textField.setBounds(126, 49, 214, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//tên sinh viên
		JLabel tensv = new JLabel("T\u00EAn sinh vi\u00EAn");
		tensv.setFont(new Font("Tahoma", Font.BOLD, 11));
		tensv.setBounds(29, 92, 81, 14);
		frame.getContentPane().add(tensv);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 89, 214, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		//tuổi
		JLabel tuoi = new JLabel("Tu\u1ED5i");
		tuoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		tuoi.setBounds(29, 129, 59, 14);
		frame.getContentPane().add(tuoi);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 126, 214, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		//lưu
		JButton luu = new JButton("l\u01B0u");
		luu.setFont(new Font("Tahoma", Font.BOLD, 13));
		luu.setBounds(52, 164, 68, 27);
		frame.getContentPane().add(luu);
		
		//mới
		JButton moi = new JButton("m\u1EDBi");
		moi.setFont(new Font("Tahoma", Font.BOLD, 13));
		moi.setBounds(136, 164, 68, 27);
		frame.getContentPane().add(moi);
		
		//xóa
		JButton xoa = new JButton("x\u00F3a");
		xoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		xoa.setBounds(224, 164, 68, 27);
		frame.getContentPane().add(xoa);
		
		//thoát
		JButton thoat = new JButton("tho\u00E1t");
		thoat.setFont(new Font("Tahoma", Font.BOLD, 13));
		thoat.setBounds(314, 164, 68, 27);
		frame.getContentPane().add(thoat);
		
		//table
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{123, 67, 75},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3 Sinh Vi\u00EAn", "Tên", "Tuổi"
			}
		));
		table.setBounds(29, 215, 381, 179);
		frame.getContentPane().add(table);
	
		
	}
}
	
	

