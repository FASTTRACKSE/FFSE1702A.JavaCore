package fasttrack.edu.vn.ui;

import javax.swing.JFrame;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import fasttrack.edu.vn.main.ConnectDB;
import fasttrack.edu.vn.main.GiaoDien;

public class BaoCaoKhachHang extends JFrame {
	private JDateChooser dateChooser;
	ConnectDB cn = new ConnectDB();
	Connection conn = cn.getConnect("localhost", "Appcuatoi", "Appcuatoi", "123456");
	JButton btnView, btnExit;

	JScrollPane spList = new JScrollPane();
	JTable tbList = new JTable();
	String tbSV[] = { "Ma KH", "Mã CT", "Ten KH", "Địa chỉ", "Quan", "phuong", "phone", "Email" };
	DefaultTableModel mdTable = new DefaultTableModel(tbSV, 0);

	public BaoCaoKhachHang(String tieude) {
		super(tieude);
		addControls();
		combobox();
		addEvents();
	}

	ActionListener eventCombobox = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			combobox1(jcQuan.getSelectedItem().toString());
		}
	};
	ActionListener eventMenu = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Menu();

		}
	};
	ActionListener eventView = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mdTable.getDataVector().removeAllElements();
			mdTable.fireTableDataChanged();
			ViewKH();
		}
	};

	protected void Menu() {
		Menu myUI = new Menu("My Application");
		myUI.showWindow();
		dispose();
	}

	public void addEvents() {
		btnExit.addActionListener(eventMenu);
		btnView.addActionListener(eventView);
		jcQuan.addActionListener(eventCombobox);
		/*
		 * btnExit.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) { System.exit(0); } });
		 */

	}

	public void addControls() {
		JPanel panelGirBagLayout = new JPanel();

		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		//gridBagConstraints.insets = new Insets(20, 20, 10, 10);
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.ipadx = 20;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.insets = new Insets(10, 10, 10, 10);
		panelGirBagLayout.setLayout(gridBagLayout);

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("QUẢN LÝ BIÊN LAI");
		Font fontTitle = new Font("Time new roman", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		gridBagConstraints.gridwidth = 4;
		panelGirBagLayout.add(pnTitle, gridBagConstraints);
		
		JPanel pnInput1 = new JPanel();
		JLabel lblTitle1 = new JLabel("Quận :");
		pnInput1.add(lblTitle1);
		lblTitle1.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 1;
		panelGirBagLayout.add(pnInput1, gridBagConstraints1);
		JPanel pnInput2 = new JPanel();
		pnInput2.add(jcQuan);
		jcQuan.setPreferredSize(new Dimension(170, 20));
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 1;
		panelGirBagLayout.add(pnInput2, gridBagConstraints1);

		JPanel pnInput3 = new JPanel();
		JLabel lblTitle3 = new JLabel("Phường :");
		pnInput3.add(lblTitle3);
		lblTitle3.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 2;
		gridBagConstraints1.gridy = 1;
		panelGirBagLayout.add(pnInput3, gridBagConstraints1);
		JPanel pnInput4 = new JPanel();
		pnInput4.add(jcPhuong);
		jcPhuong.setPreferredSize(new Dimension(170, 20));
		gridBagConstraints1.gridx = 3;
		gridBagConstraints1.gridy = 1;
		panelGirBagLayout.add(pnInput4, gridBagConstraints1);
		
		JPanel pnAction = new JPanel();	
		btnView = new JButton("Tìm kiếm");
		pnAction.add(btnView);
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 2;
		panelGirBagLayout.add(pnAction, gridBagConstraints1);
		
		JPanel pnAction1 = new JPanel();
		btnExit = new JButton("Trở lại");
		pnAction1.add(btnExit);
		gridBagConstraints1.gridx = 2;
		gridBagConstraints1.gridy = 2;
		panelGirBagLayout.add(pnAction1, gridBagConstraints1);

		Border border = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh Sách");
		spList.setBorder(borderTittle);
		tbList.setModel(mdTable);
		spList.setViewportView(tbList);

		tbList.setPreferredScrollableViewportSize(new Dimension(600, 350));
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.gridy = 5;
		gridBagConstraints2.gridwidth = 4;
		panelGirBagLayout.add(spList, gridBagConstraints2);

		this.add(panelGirBagLayout);
	}

	JComboBox jcQuan = new JComboBox();

	public void combobox() {
		ConnectDB cn = new ConnectDB();
		Connection conn = cn.getConnect("localhost", "Appcuatoi", "Appcuatoi", "123456");
		if (conn != null) {

			String sql = "select * from quanuy";
			try {
				PreparedStatement ptmt = conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				jcQuan.addItem("Tất cả");
				while (rs.next()) {
					String quan = rs.getString("Name_quan");

					jcQuan.addItem(quan);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	JComboBox jcPhuong = new JComboBox();

	public void combobox1(String name) {
		ConnectDB cn = new ConnectDB();
		Connection conn = cn.getConnect("localhost", "Appcuatoi", "Appcuatoi", "123456");
		if (conn != null) {

			String sql = "SELECT Name_phuong FROM `quanuy` INNER JOIN `phuongxa` WHERE Id_quan = Id_quanphuong AND Name_quan = ?";

			try {
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, name);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				Vector items = new Vector();
				items.add("Tất cả");
				while (rs.next()) {
					String phuong = rs.getString("Name_phuong");

					items.add(phuong);
				}
				jcPhuong.setModel(new DefaultComboBoxModel(items));
			} catch (SQLException e) {
				System.out.println("lỗi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	PreparedStatement ptmt = null;

	public void ViewKH() {
		String sql = "SELECT * FROM `qlkh`  ";
		String quan = (String) jcQuan.getSelectedItem();
		String phuong = (String) jcPhuong.getSelectedItem();

		String sqlWhere = null;
		if (quan.equals("Tất cả")) {
			sqlWhere = sql.concat(" ");
		} else if (phuong.equals("Tất cả")) {
			sqlWhere = sql.concat("WHERE Quan=?");

		} else {
			sqlWhere = sql.concat("WHERE Quan=? and phuong=?");
		}

		try {
			PreparedStatement ptmt = conn.prepareStatement(sqlWhere);

			ptmt = conn.prepareStatement(sqlWhere);
			if (quan.equals("Tất cả")) {

			} else if (phuong.equals("Tất cả")) {
				ptmt.setString(1, quan);
				// ptmt.setString(2, phuong);

			} else {
				ptmt.setString(1, quan);
				ptmt.setString(2, phuong);

			}
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				String rows[] = new String[8];

				rows[0] = rs.getString(2);

				rows[1] = rs.getString(3);
				rows[2] = rs.getString(4);
				rows[3] = rs.getString(5);
				rows[4] = rs.getString(6);
				rows[5] = rs.getString(7);
				rows[6] = rs.getString(9);
				rows[7] = rs.getString(8);
			//	rows[8] = rs.getString(4);
				mdTable.addRow(rows);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Loi " + e1.getMessage());
		}
	}

	public void showWindow() {
		this.setSize(700, 600);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);

		this.setVisible(true);
	}
}
