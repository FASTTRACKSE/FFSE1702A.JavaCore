package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.KhachHangController;
import models.District;
import models.ItemRenderer;
import models.KhachHang;
import models.Ward;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;

public class CustomerManage {

	public JFrame frame;
	private JTextField textHoten;
	private JTextField textDiaChi;
	private JTextField textEmail;
	private JTextField textMaCongTo;
	private JTextField textSoDt;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTable table;
	private JTextField textMaKH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerManage window = new CustomerManage();
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
	public CustomerManage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 704, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblQuanLyKhach = new JLabel("QU\u1EA2N L\u00DD KH\u00C1CH H\u00C0NG");
		lblQuanLyKhach.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblQuanLyKhach.setBounds(207, 6, 263, 44);
		frame.getContentPane().add(lblQuanLyKhach);
		
		JLabel lblQun = new JLabel("Qu\u1EADn:");
		lblQun.setBounds(10, 149, 46, 14);
		frame.getContentPane().add(lblQun);
		
		JLabel lblHuyn = new JLabel("Ph\u01B0\u1EDDng:");
		lblHuyn.setBounds(203, 149, 60, 14);
		frame.getContentPane().add(lblHuyn);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(254, 146, 141, 17);
		comboBox_1.addItem(new Ward(0, ""));
		comboBox_1.setRenderer(new ItemRenderer());
		frame.getContentPane().add(comboBox_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(54, 146, 116, 20);
		District.getListDistric(comboBox);
		comboBox.setRenderer(new ItemRenderer());
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				District d = (District)((JComboBox) e.getSource()).getSelectedItem();
				int maQuan = d.getMaQuan();
				comboBox_1.removeAllItems();
				Ward.getListWard(comboBox_1, maQuan);
				comboBox_1.setRenderer(new ItemRenderer());
			}
		});
		frame.getContentPane().add(comboBox);
		
		textHoten = new JTextField();
		textHoten.setBounds(388, 61, 141, 17);
		frame.getContentPane().add(textHoten);
		textHoten.setColumns(10);
		
		JLabel lblHoTen = new JLabel("H\u1ECD T\u00EAn:");
		lblHoTen.setBounds(332, 61, 46, 16);
		frame.getContentPane().add(lblHoTen);
		
		textDiaChi = new JTextField();
		textDiaChi.setBounds(254, 100, 141, 20);
		frame.getContentPane().add(textDiaChi);
		textDiaChi.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblDiaChi.setBounds(206, 103, 46, 14);
		frame.getContentPane().add(lblDiaChi);
		
		textEmail = new JTextField();
		textEmail.setBounds(472, 100, 133, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(424, 103, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textMaCongTo = new JTextField();
		textMaCongTo.setBounds(472, 147, 133, 17);
		frame.getContentPane().add(textMaCongTo);
		textMaCongTo.setColumns(10);
		
		JLabel lblMaCongTo = new JLabel("M\u00E3 c\u00F4ng t\u01A1:");
		lblMaCongTo.setBounds(399, 149, 71, 14);
		frame.getContentPane().add(lblMaCongTo);
		
		textSoDt = new JTextField();
		textSoDt.setBounds(54, 100, 116, 20);
		frame.getContentPane().add(textSoDt);
		textSoDt.setColumns(10);
		
		JLabel lblDt = new JLabel("DT:");
		lblDt.setBounds(10, 103, 32, 14);
		frame.getContentPane().add(lblDt);
		
		
		JButton btnTimKiem = new JButton("Search");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KhachHangController.timKiemKhachHang(getInformations(), table);
			}
		});
		
		btnTimKiem.setBounds(33, 348, 89, 23);
		frame.getContentPane().add(btnTimKiem);
		
		JButton btnThemMoi = new JButton("Add");
		btnThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(KhachHangController.themKhachHang(getInformations()))
				{
					JOptionPane.showMessageDialog(null, "Them khach hang thanh cong!");
					//thong bao thanh cong
				} else {
					//thong bao that bai
					JOptionPane.showMessageDialog(null, "Them khach hang that bai!");
				}
				
				resetFields();
			}
		});
		btnThemMoi.setBounds(152, 348, 89, 23);
		frame.getContentPane().add(btnThemMoi);
		
		JButton btnUpdate = new JButton("Edit");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(KhachHangController.suaKh(getInformations()))
				{
					JOptionPane.showMessageDialog(null, "Sua khach hang thanh cong!");
					//thong bao thanh cong
				} else {
					//thong bao that bai
					JOptionPane.showMessageDialog(null, "Sua khach hang that bai!");
				}
				
				resetFields();
			}
		});
		btnUpdate.setBounds(275, 348, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnXoa = new JButton("Detele");
		btnXoa.setBounds(408, 348, 89, 23);
		frame.getContentPane().add(btnXoa);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(542, 348, 89, 23);
		frame.getContentPane().add(btnBack);
		
		String[] columns = {"Mã KH", "Họ tên", "Số dt", "Địa chỉ", "Quận", "Phường","Email", "Mã công tơ"};
		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(22, 190, 609, 147);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 589, 112);
		panel.add(scrollPane);
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				String[] row = new String[8];
				for (int j = 0; j < row.length; j++) {
					row[j] = (String) table.getValueAt(i, j);
				}
				textMaKH.setText(row[0]);
				textHoten.setText(row[1]);
				textEmail.setText(row[6]);
				comboBox.setSelectedItem(District.getDistricByName(row[4]));
				comboBox_1.setSelectedItem(Ward.getWardByName(row[5]));
				textSoDt.setText(row[2]);
				textDiaChi.setText(row[3]);
				textMaCongTo.setText(row[7]);
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(54, 266, 174, -25);
		scrollPane.setViewportView(table);
		
		JLabel lblMKh = new JLabel("Mã KH :");
		lblMKh.setBounds(76, 63, 46, 14);
		frame.getContentPane().add(lblMKh);
		
		textMaKH = new JTextField();
		textMaKH.setColumns(10);
		textMaKH.setBounds(122, 61, 141, 17);
		frame.getContentPane().add(textMaKH);
	}
	
	private KhachHang getInformations()
	{
		KhachHang kh = new KhachHang();
	
		kh.setHoTen(textHoten.getText().trim());
		kh.setDiaChi(textDiaChi.getText().trim());
		kh.setEmail(textEmail.getText().trim());
		kh.setMaCongTo(textMaCongTo.getText().trim());
		kh.setSoDienThoai(textSoDt.getText().trim());
		District d = (District)comboBox.getSelectedItem();
		Ward w = (Ward)comboBox_1.getSelectedItem();
		kh.setQuan(d);
		kh.setPhuong(w);
		return kh;
	}
	
	private void resetFields() {
		textMaKH.setText("");
		textHoten.setText("");
		textEmail.setText("");
		textDiaChi.setText("");
		textMaCongTo.setText("");
		textSoDt.setText("");
		comboBox.setSelectedIndex(0);
	}
}
