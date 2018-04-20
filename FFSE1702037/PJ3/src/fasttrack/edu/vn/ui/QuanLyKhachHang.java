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
import java.awt.HeadlessException;
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

import fasttrack.edu.vn.main.ConnectDB;
import fasttrack.edu.vn.main.GiaoDien;

import fasttrack.edu.vn.model.MyException;

public class QuanLyKhachHang extends JFrame {
	private MyException myEx = new MyException();
	ConnectDB cn = new ConnectDB();
	Connection conn = cn.getConnect("localhost", "Appcuatoi", "Appcuatoi", "123456");

	JTextField txtMKH = new JTextField(15);
	JTextField txtNameKH = new JTextField(15);
	JTextField txtEmail = new JTextField(15);
	JTextField txtMCT = new JTextField(15);
	JTextField txtPhuong = new JTextField(15);
	JTextField txtPhone = new JTextField(15);
	JTextField txtDiaChi = new JTextField(15);
	String id;
	JButton btnNew, btnUpdate, btnDelete, btnView, btnExit;

	JScrollPane spList = new JScrollPane();
	JTable tbList = new JTable();
	String tbSV[] = { "Id KH", "Ma KH", "Ten KH", "Email", "Quan", "phuong", "phone", "Địa chỉ", "Mã CT" };
	DefaultTableModel mdTable = new DefaultTableModel(tbSV, 0);

	public QuanLyKhachHang(String tieude) {
		super(tieude);
		addControls();
		combobox();

		addEvents();
	}

	ActionListener eventMenu = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Menu();
		}
	};
	ActionListener eventCombobox = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			combobox1(jcQuan.getSelectedItem().toString());
		}
	};
	ActionListener eventInsert = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mdTable.getDataVector().removeAllElements();
			mdTable.fireTableDataChanged();
			try {
				Insert();
			} catch (MyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	ActionListener eventDelete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (mdTable.getRowCount() != 0) {
				deleteKH(id.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Không có giá trị ");
			}
		}
	};
	ActionListener eventUpdate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (mdTable.getRowCount() != 0) {
				try {
					updateKH(id.toString());
				} catch (MyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Không có giá trị ");
			}
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
		btnNew.addActionListener(eventInsert);
		btnDelete.addActionListener(eventDelete);
		btnUpdate.addActionListener(eventUpdate);
		btnView.addActionListener(eventView);
		tbList.addMouseListener(eventselect);
		jcQuan.addActionListener(eventCombobox);
		/*
		 * btnExit.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) { System.exit(0); } });
		 */

	}

	MouseAdapter eventselect = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tbList.getSelectedRow();
			String[] row = new String[9];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tbList.getValueAt(i, j);
			}
			id = row[0];
			txtMKH.setText(row[1]);
			txtNameKH.setText(row[2]);
			txtEmail.setText(row[3]);
			jcQuan.setSelectedItem(row[4]);
			jcPhuong.setSelectedItem(row[5]);
			txtPhone.setText(row[6]);
			txtDiaChi.setText(row[7]);
			txtMCT.setText(row[8]);
		}
	};

	public void setText() {
		txtMKH.setText("");
		txtNameKH.setText("");
		txtEmail.setText("");
		jcQuan.setSelectedItem("");
		jcPhuong.setSelectedItem("");
		txtPhone.setText("");
		txtDiaChi.setText("");
		txtMCT.setText("");
	}

	public void addControls() {
		Container con = getContentPane();
		// JPanel pnMain = new JPanel();
		// pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		JPanel panelGirBagLayout = new JPanel();

		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.ipadx = 20;
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.insets = new Insets(10, 10, 10, 10);
		panelGirBagLayout.setLayout(gridBagLayout);

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		Font fontTitle = new Font("Time new roman", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		gridBagConstraints.gridwidth = 4;
		panelGirBagLayout.add(pnTitle, gridBagConstraints);

		JPanel pnInput1 = new JPanel();
		JLabel lblTitle1 = new JLabel("MKH :");
		pnInput1.add(lblTitle1);
		lblTitle1.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 1;
		panelGirBagLayout.add(pnInput1, gridBagConstraints1);
		// this.add(panelGirBagLayout);

		JPanel pnInput2 = new JPanel();
		txtMKH = new JTextField(10);
		pnInput2.add(txtMKH);
		ImageIcon iconView = new ImageIcon("image/search1.png");
		Image getIconView = iconView.getImage();
		Image newIconView = getIconView.getScaledInstance(11, 11, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newIconView);
		btnView = new JButton(newIcon);
		pnInput2.add(btnView);
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 1;
		panelGirBagLayout.add(pnInput2, gridBagConstraints1);

		JPanel pnInput3 = new JPanel();
		JLabel lblTitle3 = new JLabel("Mã CT :");
		pnInput3.add(lblTitle3);
		lblTitle3.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 2;
		gridBagConstraints1.gridy = 1;
		panelGirBagLayout.add(pnInput3, gridBagConstraints1);
		JPanel pnInput4 = new JPanel();
		txtMCT = new JTextField(15);
		pnInput4.add(txtMCT);
		gridBagConstraints1.gridx = 3;
		gridBagConstraints1.gridy = 1;
		panelGirBagLayout.add(pnInput4, gridBagConstraints1);

		JPanel pnInput5 = new JPanel();
		JLabel lblTitle5 = new JLabel("Tên KH :");
		pnInput5.add(lblTitle5);
		lblTitle5.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 2;
		panelGirBagLayout.add(pnInput5, gridBagConstraints1);
		JPanel pnInput6 = new JPanel();
		txtNameKH = new JTextField(15);
		pnInput6.add(txtNameKH);
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 2;
		panelGirBagLayout.add(pnInput6, gridBagConstraints1);

		JPanel pnInput7 = new JPanel();
		JLabel lblTitle7 = new JLabel("Địa Chỉ :           ");
		pnInput7.add(lblTitle7);
		lblTitle5.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 2;
		gridBagConstraints1.gridy = 2;
		panelGirBagLayout.add(pnInput7, gridBagConstraints1);
		JPanel pnInput8 = new JPanel();
		txtDiaChi = new JTextField(15);
		pnInput8.add(txtDiaChi);
		gridBagConstraints1.gridx = 3;
		gridBagConstraints1.gridy = 2;
		panelGirBagLayout.add(pnInput8, gridBagConstraints1);

		JPanel pnInput9 = new JPanel();
		JLabel lblTitle9 = new JLabel("Quận :              ");
		pnInput9.add(lblTitle9);
		lblTitle5.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 3;
		panelGirBagLayout.add(pnInput9, gridBagConstraints1);
		JPanel pnInput11 = new JPanel();
		pnInput11.add(jcQuan);
		jcQuan.setPreferredSize(new Dimension(170, 20));
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 3;
		panelGirBagLayout.add(pnInput11, gridBagConstraints1);

		JPanel pnInput22 = new JPanel();
		JLabel lblTitle22 = new JLabel("Phường :");
		pnInput22.add(lblTitle22);
		lblTitle22.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 2;
		gridBagConstraints1.gridy = 3;
		panelGirBagLayout.add(pnInput22, gridBagConstraints1);
		JPanel pnInput33 = new JPanel();
		pnInput33.add(jcPhuong);
		jcPhuong.setPreferredSize(new Dimension(170, 20));
		gridBagConstraints1.gridx = 3;
		gridBagConstraints1.gridy = 3;
		panelGirBagLayout.add(pnInput33, gridBagConstraints1);

		JPanel pnInput44 = new JPanel();
		JLabel lblTitle44 = new JLabel("Email :");
		pnInput44.add(lblTitle44);
		lblTitle44.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 4;
		panelGirBagLayout.add(pnInput44, gridBagConstraints1);
		JPanel pnInput55 = new JPanel();
		txtEmail = new JTextField(15);
		pnInput55.add(txtEmail);
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 4;
		panelGirBagLayout.add(pnInput55, gridBagConstraints1);

		JPanel pnInput66 = new JPanel();
		JLabel lblTitle66 = new JLabel("Điện Thoại :");
		pnInput66.add(lblTitle66);
		lblTitle66.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 2;
		gridBagConstraints1.gridy = 4;
		panelGirBagLayout.add(pnInput66, gridBagConstraints1);
		JPanel pnInput77 = new JPanel();
		txtPhone = new JTextField(15);
		pnInput77.add(txtPhone);
		gridBagConstraints1.gridx = 3;
		gridBagConstraints1.gridy = 4;
		panelGirBagLayout.add(pnInput77, gridBagConstraints1);

		JPanel pnAction = new JPanel();
		btnNew = new JButton("Thêm");
		pnAction.add(btnNew);
		btnUpdate = new JButton("Sửa");
		pnAction.add(btnUpdate);
		btnDelete = new JButton("Xóa");
		pnAction.add(btnDelete);
		btnExit = new JButton("Trở lại");
		pnAction.add(btnExit);
		gridBagConstraints3.gridx = 0;
		gridBagConstraints3.gridy = 5;
		gridBagConstraints3.gridwidth = 4;
		panelGirBagLayout.add(pnAction, gridBagConstraints3);

		Border border = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh Sách");
		spList.setBorder(borderTittle);
		tbList.setModel(mdTable);

		spList.setViewportView(tbList);
		tbList.setPreferredScrollableViewportSize(new Dimension(600, 250));
		gridBagConstraints3.gridx = 0;
		gridBagConstraints3.gridy = 6;

		panelGirBagLayout.add(spList, gridBagConstraints3);

		this.add(panelGirBagLayout);
	}

	JComboBox jcQuan = new JComboBox();

	public void combobox() {
		if (conn != null) {

			String sql = "select * from quanuy";
			try {
				PreparedStatement ptmt = conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				// jcQuan.addItem("");
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
		if (conn != null) {

			String sql = "SELECT Name_phuong FROM `quanuy` INNER JOIN `phuongxa` WHERE Id_quan = Id_quanphuong AND Name_quan = ?";

			try {
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, name);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				Vector items = new Vector();
				// items.add("");
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

	public void Insert() throws MyException {

		String sql = "insert into qlkh(MaKH,MaCT,Name,DiaChi,Quan,Phuong,Email,Phone,pass) value(?,?,?,?,?,?,?,?,?)";
		try {
			if (myEx.checkMKH(txtMKH.getText()) && myEx.checkMCT(txtMCT.getText()) && myEx.checkEmpty(txtMKH.getText())
					&& myEx.checkEmpty(txtMCT.getText()) && myEx.checkEmpty(txtNameKH.getText())
					&& myEx.checkEmpty(txtDiaChi.getText()) && myEx.checkEmail(txtEmail.getText())
					&& myEx.checkPhone(txtPhone.getText()) && myEx.checkEmpty(jcPhuong.getSelectedItem().toString())) {
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, txtMKH.getText());
				ptmt.setString(2, txtMCT.getText());
				ptmt.setString(3, txtNameKH.getText());
				ptmt.setString(4, txtDiaChi.getText());
				ptmt.setString(5, jcQuan.getSelectedItem().toString());
				ptmt.setString(6, jcPhuong.getSelectedItem().toString());
				ptmt.setString(7, txtEmail.getText());
				ptmt.setString(8, txtPhone.getText());
				ptmt.setString(9,"123123");
				// executeUpdate hàm trả về kiểu int nên khai báo 1 giá trị
				int kt = ptmt.executeUpdate();
				if (kt != 0) {
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					ViewKH();
					// mdTable.setRowCount(0);
					setText();
				} else {
					JOptionPane.showMessageDialog(null, "Thêm không thành công");
				}
				ptmt.close();
			}
		} catch (SQLException e) {
			System.out.println("loi  " + e.getMessage());
		}
	}

	public void deleteKH(String id) {
		String sql = "delete from qlkh where Id_KH = ?";
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, id);
			int k = ptmt.executeUpdate();
			if (k != 0) {
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				mdTable.setRowCount(0);
				setText();
			} else
				JOptionPane.showMessageDialog(null, "Xóa không thành công");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Loi " + e1.getMessage());
		}
	}

	public void updateKH(String id) throws MyException {

		String sql = "UPDATE qlkh SET Name = ?, DiaChi=?, Quan=?,Phuong=?, Email=?, Phone=?, MaKH=?,MaCT=?  WHERE Id_KH = ?";
		try {
			// ptmt = conn.prepareStatement(sql);
			if (myEx.checkEmpty(txtMKH.getText()) && myEx.checkEmpty(txtMCT.getText())
					&& myEx.checkEmpty(txtNameKH.getText()) && myEx.checkEmpty(txtDiaChi.getText())
					&& myEx.checkEmail(txtEmail.getText()) && myEx.checkPhone(txtPhone.getText())
					&& myEx.checkEmpty(jcPhuong.getSelectedItem().toString())) {

				ptmt = (PreparedStatement) conn.prepareStatement(sql);
				ptmt.setString(1, txtNameKH.getText());
				ptmt.setString(2, txtDiaChi.getText());
				ptmt.setString(3, jcQuan.getSelectedItem().toString());
				ptmt.setString(4, jcPhuong.getSelectedItem().toString());
				ptmt.setString(5, txtEmail.getText());
				ptmt.setString(6, txtPhone.getText());
				ptmt.setString(7, txtMKH.getText());
				ptmt.setString(8, txtMCT.getText());
				int i = Integer.parseInt(id);
				ptmt.setInt(9, i);
				int k = ptmt.executeUpdate();
				if (k != 0) {
					JOptionPane.showMessageDialog(null, "Sửa thành công");
					mdTable.setRowCount(0);
					setText();
				} else
					JOptionPane.showMessageDialog(null, "Sửa không thành công");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Loi " + e1.getMessage());
		}

	}

	public void ViewKH() {
		String sql = "SELECT * FROM `qlkh` WHERE  MaKH=? ";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);

			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, txtMKH.getText());
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				String rows[] = new String[9];

				rows[0] = rs.getString(1);

				rows[1] = rs.getString(2);
				rows[2] = rs.getString(4);
				rows[3] = rs.getString(8);
				rows[4] = rs.getString(6);
				rows[5] = rs.getString(7);
				rows[6] = rs.getString(9);
				rows[7] = rs.getString(5);
				rows[8] = rs.getString(3);

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
