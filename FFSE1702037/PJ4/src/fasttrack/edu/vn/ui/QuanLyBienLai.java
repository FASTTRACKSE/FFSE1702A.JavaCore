package fasttrack.edu.vn.ui;

import javax.swing.JFrame;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

import fasttrack.edu.vn.main.ConnectDB;
import fasttrack.edu.vn.main.GiaoDien;
import fasttrack.edu.vn.model.MyException;

public class QuanLyBienLai extends JFrame {
	private MyException myEx = new MyException();
	String id;
	ConnectDB cn = new ConnectDB();
	Connection conn = cn.getConnect("localhost", "Appcuatoi", "Appcuatoi", "123456");
	JTextField txtMCT = new JTextField(15);
	JTextField txtNameKH = new JTextField(15);
	JTextField txtCSCT = new JTextField(15);
	JTextField txtDate = new JTextField(15);
	private JDateChooser dateChooser;
	String Ngay[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	JComboBox jcThang = new JComboBox(Ngay);
	String Nam[] = { "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026"};
	JComboBox jcNam = new JComboBox(Nam);
	JButton btnNew, btnUpdate, btnDelete, btnLoad, btnExit, btnView,btnLogout;

	JScrollPane spList = new JScrollPane();
	JTable tbList = new JTable();
	String tbSV[] = { "ID_BL", "Mã CT", "Ngày nhập", "Tháng","Năm", "Chỉ số công tơ" };
	DefaultTableModel mdTable = new DefaultTableModel(tbSV, 0);

	public QuanLyBienLai(String tieude) {
		super(tieude);
		addControls();
		addEvents();
		// Display();
	}

	ActionListener eventMenu = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Menu();
			jcThang.setSelectedItem("");
		}
	};
	ActionListener eventUpdate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if (mdTable.getRowCount() != 0) {
			try {
				updateBL(id.toString());
			} catch (MyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}else {
				JOptionPane.showMessageDialog(null, "Không có giá trị ");
			}
			
		}
	};
	ActionListener eventInsert = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mdTable.getDataVector().removeAllElements();
			mdTable.fireTableDataChanged();
			try {
				String month = jcThang.getSelectedItem().toString();
				String year = jcNam.getSelectedItem().toString();
				String maCT = txtMCT.getText();

				Insert(month, year, maCT);
			} catch (MyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	};
	ActionListener eventViewKH = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			try {
				ViewKH();
			} catch (MyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	};
	ActionListener eventLoad = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mdTable.getDataVector().removeAllElements();
			mdTable.fireTableDataChanged();
			try {
				ViewCT();
			} catch (MyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	};
	ActionListener eventDelete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (mdTable.getRowCount() != 0) {
			try {
				deleteBL(id.toString());
			} catch (MyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			} else {
				JOptionPane.showMessageDialog(null, "Không có giá trị ");
			}
		}
	};
	ActionListener eventLogout = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			Login();
		}
	};
	protected void Login() {
		Login myUI = new Login("Phần mềm quản lý tiền điện");
       myUI.showWindow();
		dispose();
	}
	public void setText() {

		txtMCT.setEditable(true);
		txtMCT.setText("");
		txtNameKH.setEditable(true);
		txtNameKH.setText("");
		dateChooser.setEnabled(true);
		txtCSCT.setText("");
		jcNam.setEnabled(true);
		jcNam.setSelectedItem("2005");
		jcThang.setEnabled(true);
		jcThang.setSelectedItem("1");

	}

	MouseAdapter eventselect = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tbList.getSelectedRow();
			String[] row = new String[6];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tbList.getValueAt(i, j);
			}
			id = row[0];

			txtMCT.setText(row[1]);
			txtMCT.setEditable(false);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String dateInString = row[2];
			try {
				Date date = formatter.parse(dateInString);

				dateChooser.setDate(date);
				dateChooser.setEnabled(false);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			String substr = row[3];
			String substr1 = row[4];

			jcNam.setSelectedItem(substr1);
			jcNam.setEnabled(false);
			jcThang.setSelectedItem(substr);
			jcThang.setEnabled(false);
			txtCSCT.setText(row[5]);
			txtNameKH.setEditable(false);
		}
	};

	protected void Menu() {
		Menu myUI = new Menu("Phần mềm quản lý tiền điện");
		myUI.showWindow();
		dispose();
	}

	public void addEvents() {
		btnExit.addActionListener(eventMenu);
		btnNew.addActionListener(eventInsert);
		btnLoad.addActionListener(eventLoad);
		btnDelete.addActionListener(eventDelete);
		btnView.addActionListener(eventViewKH);
		tbList.addMouseListener(eventselect);
		btnUpdate.addActionListener(eventUpdate);
		btnLogout.addActionListener(eventLogout);
	}

	public void addControls() {
		this.setResizable(false);
	
		JPanel panelGirBagLayout = new JPanel();

		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
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
		JLabel lblTitle1 = new JLabel("Mã công tơ :");
		pnInput1.add(lblTitle1);
		lblTitle1.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 1;
		panelGirBagLayout.add(pnInput1, gridBagConstraints1);

		JPanel pnInput2 = new JPanel();
		txtMCT = new JTextField(10);
		pnInput2.add(txtMCT);
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
		JLabel lblTitle3 = new JLabel("Tên KH :");
		pnInput3.add(lblTitle3);
		lblTitle3.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 2;
		gridBagConstraints1.gridy = 1;
		panelGirBagLayout.add(pnInput3, gridBagConstraints1);
		JPanel pnInput4 = new JPanel();
		txtNameKH = new JTextField(15);
		pnInput4.add(txtNameKH);
		gridBagConstraints1.gridx = 3;
		gridBagConstraints1.gridy = 1;
		panelGirBagLayout.add(pnInput4, gridBagConstraints1);

		JPanel pnInput5 = new JPanel();
		JLabel lblTitle5 = new JLabel("Chỉ số công tơ :");
		pnInput5.add(lblTitle5);
		// lblTitle5.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 2;
		panelGirBagLayout.add(pnInput5, gridBagConstraints1);
		JPanel pnInput6 = new JPanel();
		txtCSCT = new JTextField(15);
		pnInput6.add(txtCSCT);
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 2;
		panelGirBagLayout.add(pnInput6, gridBagConstraints1);

		JPanel pnInput7 = new JPanel();
		JLabel lblTitle7 = new JLabel("Ngày nhập :");
		pnInput7.add(lblTitle7);
		lblTitle7.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 2;
		gridBagConstraints1.gridy = 2;
		panelGirBagLayout.add(pnInput7, gridBagConstraints1);
		JPanel pnInput8 = new JPanel();
		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Arial", Font.PLAIN, 12));
		dateChooser.setDateFormatString("dd/MM/yyyy");
		pnInput8.add(dateChooser);
		dateChooser.setPreferredSize(new Dimension(160, 25));
		gridBagConstraints1.gridx = 3;
		gridBagConstraints1.gridy = 2;
		panelGirBagLayout.add(pnInput8, gridBagConstraints1);

		JPanel pnInput9 = new JPanel();
		JLabel lblTitle9 = new JLabel("Chu kỳ :");
		pnInput9.add(lblTitle9);
		lblTitle9.setPreferredSize(new Dimension(80, 20));
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 3;
		panelGirBagLayout.add(pnInput9, gridBagConstraints1);

		JPanel pnInput10 = new JPanel();
		JLabel lbCls = new JLabel("Tháng :");
		pnInput10.add(lbCls);
		pnInput10.add(jcThang);
		

		JLabel lbCls1 = new JLabel("Năm :");
		pnInput10.add(lbCls1);
		pnInput10.add(jcNam);
		jcNam.addItem("2018");
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 3;
		panelGirBagLayout.add(pnInput10, gridBagConstraints1);

		JPanel pnAction = new JPanel();
		btnNew = new JButton("Thêm");
		pnAction.add(btnNew);
		btnUpdate = new JButton("Sửa");
		pnAction.add(btnUpdate);
		btnDelete = new JButton("Xóa");
		pnAction.add(btnDelete);
		btnLoad = new JButton("Tìm");
		pnAction.add(btnLoad);
		btnExit = new JButton("Trở lại");
		pnAction.add(btnExit);
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.gridy = 4;
		gridBagConstraints2.gridwidth = 4;
		panelGirBagLayout.add(pnAction, gridBagConstraints2);

		Border border = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh Sách");
		spList.setBorder(borderTittle);
		tbList.setModel(mdTable);
		spList.setViewportView(tbList);

		tbList.setPreferredScrollableViewportSize(new Dimension(600, 250));
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.gridy = 5;

		panelGirBagLayout.add(spList, gridBagConstraints2);

JPanel pnAction4 = new JPanel();
		
		ImageIcon iconView4 = new ImageIcon("image/logout.png");
		Image getIconView4 = iconView4.getImage();
		Image newIconView4 = getIconView4.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon4 = new ImageIcon(newIconView4);
		btnLogout = new JButton(newIcon4);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		pnAction4.add(btnLogout);
		gridBagConstraints1.gridx = 3;
		gridBagConstraints1.gridy = 6;
		panelGirBagLayout.add(btnLogout, gridBagConstraints1);
		this.add(panelGirBagLayout);
		
		this.add(panelGirBagLayout);
	}

	public void Display() {

		if (conn != null) {

			String sql = "select * from qlbl";
			try {
				PreparedStatement ptmt = conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {
					String rows[] = new String[6];
					rows[0] = rs.getString(1);
					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4) ;
					rows[4]=rs.getString(5);
					// DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

					// rows[3]=;
					// rows[3] = rs.getString(5);
					rows[5] = rs.getString(6);

					mdTable.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public void ViewKH() throws MyException {
		String maCT = txtMCT.getText();
		String sql = "SELECT * FROM `qlkh` WHERE  BINARY MaCT=  '" + maCT + "'";
		try {
			if (myEx.checkBLMaCT(txtMCT.getText())) {
				PreparedStatement ptmt = conn.prepareStatement(sql);

				ptmt = conn.prepareStatement(sql);
				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					String name = rs.getString("Name");
					txtNameKH.setText(name);
				}

			}
		} catch (SQLException e1) {
			System.out.println("Loi " + e1.getMessage());
		}
	}

	public void ViewCT() throws MyException {
		String maCT = txtMCT.getText();
		String sql = "SELECT * FROM `qlbl` WHERE  BINARY MaCT=  '" + maCT + "'";
		try {
			if (myEx.checkBLMaCT(txtMCT.getText())) {
				PreparedStatement ptmt = conn.prepareStatement(sql);

				ptmt = conn.prepareStatement(sql);
				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					String rows[] = new String[6];

					rows[0] = rs.getString(1);
					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(6);
					mdTable.addRow(rows);
				}

			}
		} catch (SQLException e1) {
			System.out.println("Loi " + e1.getMessage());
		}
	}

	public void Insert(String month, String year, String MCT) throws MyException {

		String sql;
		try {
			if (myEx.checkBLMaCT(txtMCT.getText()) && myEx.chkMeterNumber(txtCSCT.getText())
					&& myEx.checkEmpty(txtMCT.getText()) && myEx.checkEmpty(txtCSCT.getText())
					&& myEx.chkCycle(month, year, MCT)&& myEx.chkSameCycle(month, year, MCT)) {
				int chiSoCu = 0;
				int thangChuKy = Integer.parseInt(jcThang.getSelectedItem().toString());
				sql = "select `Chi_So_CT` from `qlbl` where Chu_Ky_Month = ? AND Chu_Ky_Year = ? AND MaCT = ?";
				PreparedStatement ptmt = conn.prepareStatement(sql);
				if (thangChuKy != 1) {
					ptmt.setInt(1, thangChuKy - 1);
					ptmt.setString(2, jcNam.getSelectedItem().toString());
					ptmt.setString(3, txtMCT.getText());
					ResultSet rs = ptmt.executeQuery();
					while (rs.next()) {
						chiSoCu = rs.getInt("Chi_So_CT");
					}
				}

				sql = "insert into qlbl(MaCT,Ngay_Nhap,Chu_Ky_Month,Chu_Ky_Year,Chi_So_CT, Chi_So_Cu) value(?,?,?,?,?,?)";
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				if (dateChooser.getDate() == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng không để trống ");
				} else {
					txtDate.setText(format.format(dateChooser.getDate()));
					String dateAdd = txtDate.getText();
					ptmt = conn.prepareStatement(sql);
					ptmt = conn.prepareStatement(sql);
					ptmt.setString(1, txtMCT.getText());
					ptmt.setString(2, dateAdd);
					ptmt.setInt(3, thangChuKy);
					ptmt.setString(4, jcNam.getSelectedItem().toString());
					ptmt.setString(5, txtCSCT.getText());
					ptmt.setInt(6, chiSoCu);
					// executeUpdate hàm trả về kiểu int nên khai báo 1 giá trị
					int kt = ptmt.executeUpdate();
					if (kt != 0) {
						JOptionPane.showMessageDialog(null, "Thêm thành công");
						mdTable.setRowCount(0);
						ViewCT();
						setText();
					} else {
						JOptionPane.showMessageDialog(null, "Thêm không thành công");
					}
					ptmt.close();
				}
			}
		} catch (SQLException e) {
			System.out.println("loi  " + e.getMessage());
		}
	}

	public void updateBL(String id) throws MyException {
		String sql;
		try {

			int k = -1;
			int chiSoCu = 0;
			int thangChuKy = Integer.parseInt(jcThang.getSelectedItem().toString());
			sql = "update qlbl set `Chi_So_CT` = ? where Chu_Ky_Month = ? AND Chu_Ky_Year = ? AND MaCT = ?";
			PreparedStatement ptmt = conn.prepareStatement(sql);

			ptmt.setString(1, txtCSCT.getText());
			ptmt.setInt(2, thangChuKy);
			ptmt.setString(3, jcNam.getSelectedItem().toString());
			ptmt.setString(4, txtMCT.getText());
			k = ptmt.executeUpdate();

			if (thangChuKy != 12) {
				sql = "UPDATE qlbl SET Chi_So_Cu=? WHERE Chu_Ky_Month = ? AND Chu_Ky_Year = ? AND MaCT = ?";
				// DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				// txtDate.setText(format.format(dateChooser.getDate()));
				// String dateAdd = txtDate.getText();
				// ptmt = conn.prepareStatement(sql);
				ptmt = conn.prepareStatement(sql);
				ptmt = (PreparedStatement) conn.prepareStatement(sql);
				ptmt.setString(1, txtCSCT.getText());
				ptmt.setInt(2, thangChuKy + 1);
				ptmt.setString(3, jcNam.getSelectedItem().toString());
				ptmt.setString(4, txtMCT.getText());

				ptmt.executeUpdate();
			}

			if (k != 0) {
				JOptionPane.showMessageDialog(null, "Sửa thành công");
				mdTable.setRowCount(0);
				ViewCT();
				setText();
			} else
				JOptionPane.showMessageDialog(null, "Sửa không thành công");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Loi " + e1.getMessage());
		}
	}

	public void deleteBL(String id) throws MyException {
		String sql =" DELETE from qlbl WHERE Id_BL = (SELECT ID_MAX FROM (SELECT MAX(Id_BL) ID_MAX FROM qlbl ) as qlbl_max) AND MaCT = '"+txtMCT.getText()+"' AND `Id_BL`="+id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt = conn.prepareStatement(sql);
			ptmt = (PreparedStatement) conn.prepareStatement(sql);

			
			int k = ptmt.executeUpdate();
			if (k != 0) {
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				mdTable.setRowCount(0);
				ViewCT();
				setText();
				
			} else
				JOptionPane.showMessageDialog(null, "Không thể xóa");
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
