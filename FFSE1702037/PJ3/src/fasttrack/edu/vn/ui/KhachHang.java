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
import fasttrack.edu.vn.ui.Login;
import fasttrack.edu.vn.main.ConnectDB;
import fasttrack.edu.vn.main.GiaoDien;

public class KhachHang extends JFrame {
	private JDateChooser dateChooser;
	private String email;
	ConnectDB cn = new ConnectDB();
	Connection conn = cn.getConnect("localhost", "Appcuatoi", "Appcuatoi", "123456");
	JButton btnView, btnExit, btnLogout;

	JScrollPane spList = new JScrollPane();
	JTable tbList = new JTable();
	String tbSV[] = { "Mã BL", "Tháng", "Năm", "Ngày Nhập", "Chỉ số tiêu thụ", "Tiền Điện" };
	DefaultTableModel mdTable = new DefaultTableModel(tbSV, 0);
	String Thang[] = { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	String Nam[] = { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" };
	JComboBox jcNam = new JComboBox(Nam);
	JComboBox jcThang = new JComboBox(Thang);

	public KhachHang(String email) {
		super();
		this.email = email;
		// System.out.print(email);
		addControls();
		addEvents();
	}

	ActionListener eventlogin = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Login();

		}
	};
	ActionListener eventView = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mdTable.getDataVector().removeAllElements();
			mdTable.fireTableDataChanged();
			ViewHD();
		}
	};

	protected void Login() {
		Login myUI = new Login("Phần mềm quản lý tiền điện");
		myUI.showWindow();
		dispose();
	}

	public void addEvents() {
		btnLogout.addActionListener(eventlogin);
		btnView.addActionListener(eventView);

	}

	public void addControls() {
		this.setResizable(false);
		String sql = "SELECT * FROM qlkh INNER JOIN qlbl WHERE BINARY Email = ? ";
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, this.email);
			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) {

				JPanel panelGirBagLayout = new JPanel();

				GridBagLayout gridBagLayout = new GridBagLayout();
				GridBagConstraints gridBagConstraints = new GridBagConstraints();
				// gridBagConstraints.insets = new Insets(20, 20, 10, 10);
				GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
				gridBagConstraints1.ipadx = 10;
				GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
				gridBagConstraints2.insets = new Insets(10, 10, 10, 10);
				panelGirBagLayout.setLayout(gridBagLayout);

				JPanel pnTitle = new JPanel();
				JLabel lblTitle = new JLabel("THÔNG TIN TIỀN ĐIỆN");
				Font fontTitle = new Font("Time new roman", Font.BOLD, 20);
				lblTitle.setFont(fontTitle);
				pnTitle.add(lblTitle);
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.gridwidth = 5;
				panelGirBagLayout.add(pnTitle, gridBagConstraints);

				JPanel pnInput3 = new JPanel();
				JLabel lblTitle3 = new JLabel("             Tên KH :");
				lblTitle3.setPreferredSize(new Dimension(90, 20));
				pnInput3.add(lblTitle3);
				gridBagConstraints1.gridx = 0;
				gridBagConstraints1.gridy = 1;
				panelGirBagLayout.add(pnInput3, gridBagConstraints1);

				JPanel pnInput4 = new JPanel();
				JLabel lblTitle4 = new JLabel(rs.getString("Name"));
				lblTitle4.setPreferredSize(new Dimension(120, 20));
				pnInput4.add(lblTitle4);
				gridBagConstraints1.gridx = 1;
				gridBagConstraints1.gridy = 1;
				panelGirBagLayout.add(pnInput4, gridBagConstraints1);

				JPanel pnInput42 = new JPanel();
				JLabel lblTitle42 = new JLabel("");
				pnInput42.add(lblTitle42);
				pnInput42.setPreferredSize(new Dimension(120, 20));
				gridBagConstraints1.gridx = 2;
				gridBagConstraints1.gridy = 1;
				panelGirBagLayout.add(pnInput42, gridBagConstraints1);

				JPanel pnInput5 = new JPanel();
				JLabel lblTitle5 = new JLabel(" Mã KH :");
				lblTitle5.setPreferredSize(new Dimension(70, 20));
				pnInput5.add(lblTitle5);
				gridBagConstraints1.gridx = 3;
				gridBagConstraints1.gridy = 1;
				panelGirBagLayout.add(pnInput5, gridBagConstraints1);

				JPanel pnInput6 = new JPanel();
				JLabel lblTitle6 = new JLabel(rs.getString("MaKH"));
				lblTitle6.setPreferredSize(new Dimension(90, 20));
				pnInput6.add(lblTitle6);
				gridBagConstraints1.gridx = 4;
				gridBagConstraints1.gridy = 1;
				panelGirBagLayout.add(pnInput6, gridBagConstraints1);

				JPanel pnInput7 = new JPanel();
				JLabel lblTitle7 = new JLabel("             Mã CT :");
				lblTitle7.setPreferredSize(new Dimension(90, 20));
				pnInput7.add(lblTitle7);
				gridBagConstraints1.gridx = 0;
				gridBagConstraints1.gridy = 2;
				panelGirBagLayout.add(pnInput7, gridBagConstraints1);

				JPanel pnInput8 = new JPanel();
				JLabel lblTitle8 = new JLabel(rs.getString("MaCT"));
				pnInput8.add(lblTitle8);
				lblTitle8.setPreferredSize(new Dimension(120, 20));
				gridBagConstraints1.gridx = 1;
				gridBagConstraints1.gridy = 2;
				panelGirBagLayout.add(pnInput8, gridBagConstraints1);

				JPanel pnInput9 = new JPanel();
				JLabel lblTitle9 = new JLabel("Địa chỉ :");
				lblTitle9.setPreferredSize(new Dimension(70, 20));
				pnInput9.add(lblTitle9);
				gridBagConstraints1.gridx = 3;
				gridBagConstraints1.gridy = 2;
				panelGirBagLayout.add(pnInput9, gridBagConstraints1);

				JPanel pnInput11 = new JPanel();
				JLabel lblTitle11 = new JLabel(rs.getString("DiaChi"));
				lblTitle11.setPreferredSize(new Dimension(90, 20));
				pnInput11.add(lblTitle11);
				gridBagConstraints1.gridx = 4;
				gridBagConstraints1.gridy = 2;
				panelGirBagLayout.add(pnInput11, gridBagConstraints1);

				JPanel pnInput22 = new JPanel();
				JLabel lblTitle22 = new JLabel("             Quận :");
				lblTitle22.setPreferredSize(new Dimension(90, 20));
				pnInput22.add(lblTitle22);
				gridBagConstraints1.gridx = 0;
				gridBagConstraints1.gridy = 3;
				panelGirBagLayout.add(pnInput22, gridBagConstraints1);

				JPanel pnInput33 = new JPanel();
				JLabel lblTitle33 = new JLabel(rs.getString("Quan"));
				lblTitle33.setPreferredSize(new Dimension(120, 20));
				pnInput33.add(lblTitle33);
				gridBagConstraints1.gridx = 1;
				gridBagConstraints1.gridy = 3;
				panelGirBagLayout.add(pnInput33, gridBagConstraints1);

				JPanel pnInput44 = new JPanel();
				JLabel lblTitle44 = new JLabel("Phường :");
				lblTitle44.setPreferredSize(new Dimension(70, 20));
				pnInput44.add(lblTitle44);
				gridBagConstraints1.gridx = 3;
				gridBagConstraints1.gridy = 3;
				panelGirBagLayout.add(pnInput44, gridBagConstraints1);

				JPanel pnInput55 = new JPanel();
				JLabel lblTitle55 = new JLabel(rs.getString("Phuong"));
				lblTitle55.setPreferredSize(new Dimension(90, 20));
				pnInput55.add(lblTitle55);
				gridBagConstraints1.gridx = 4;
				gridBagConstraints1.gridy = 3;
				panelGirBagLayout.add(pnInput55, gridBagConstraints1);

				JPanel pnInput66 = new JPanel();
				JLabel lblTitle66 = new JLabel("             Email :");
				lblTitle66.setPreferredSize(new Dimension(90, 20));
				pnInput66.add(lblTitle66);
				gridBagConstraints1.gridx = 0;
				gridBagConstraints1.gridy = 4;
				panelGirBagLayout.add(pnInput66, gridBagConstraints1);

				JPanel pnInput77 = new JPanel();
				JLabel lblTitle77 = new JLabel(rs.getString("Email"));
				lblTitle77.setPreferredSize(new Dimension(120, 20));
				pnInput77.add(lblTitle77);
				gridBagConstraints1.gridx = 1;
				gridBagConstraints1.gridy = 4;
				panelGirBagLayout.add(pnInput77, gridBagConstraints1);

				JPanel pnInput88 = new JPanel();
				JLabel lblTitle88 = new JLabel("Phone :");
				lblTitle88.setPreferredSize(new Dimension(70, 20));
				pnInput88.add(lblTitle88);
				gridBagConstraints1.gridx = 3;
				gridBagConstraints1.gridy = 4;
				panelGirBagLayout.add(pnInput88, gridBagConstraints1);

				JPanel pnInput99 = new JPanel();
				JLabel lblTitle99 = new JLabel(rs.getString("Phone"));
				lblTitle99.setPreferredSize(new Dimension(90, 20));
				pnInput99.add(lblTitle99);
				gridBagConstraints1.gridx = 4;
				gridBagConstraints1.gridy = 4;
				panelGirBagLayout.add(pnInput99, gridBagConstraints1);

				JPanel pnInput1 = new JPanel();
				JLabel lblTitle1 = new JLabel("             Tháng :");
				lblTitle1.setPreferredSize(new Dimension(90, 20));
				pnInput1.add(lblTitle1);
				gridBagConstraints1.gridx = 0;
				gridBagConstraints1.gridy = 5;
				panelGirBagLayout.add(pnInput1, gridBagConstraints1);

				JPanel pnInput2 = new JPanel();
				pnInput2.add(jcThang);
				jcThang.setPreferredSize(new Dimension(50, 20));
				gridBagConstraints1.gridx = 1;
				gridBagConstraints1.gridy = 5;
				panelGirBagLayout.add(pnInput2, gridBagConstraints1);

				JPanel pnInput31 = new JPanel();
				JLabel lblTitle31 = new JLabel("Năm :");
				lblTitle31.setPreferredSize(new Dimension(70, 20));
				pnInput31.add(lblTitle31);
				gridBagConstraints1.gridx = 3;
				gridBagConstraints1.gridy = 5;
				panelGirBagLayout.add(pnInput31, gridBagConstraints1);

				JPanel pnInput41 = new JPanel();
				pnInput41.add(jcNam);
				jcNam.setPreferredSize(new Dimension(60, 20));
				gridBagConstraints1.gridx = 4;
				gridBagConstraints1.gridy = 5;
				panelGirBagLayout.add(pnInput41, gridBagConstraints1);

				JPanel pnAction = new JPanel();
				btnView = new JButton("Tìm kiếm");
				pnAction.add(btnView);
				gridBagConstraints2.gridx = 0;
				gridBagConstraints2.gridy = 6;
				gridBagConstraints2.gridwidth = 5;
				panelGirBagLayout.add(pnAction, gridBagConstraints2);

				Border border = BorderFactory.createLineBorder(Color.CYAN);
				TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh Sách");
				spList.setBorder(borderTittle);
				tbList.setModel(mdTable);
				spList.setViewportView(tbList);

				tbList.setPreferredScrollableViewportSize(new Dimension(600, 220));
				gridBagConstraints2.gridx = 0;
				gridBagConstraints2.gridy = 7;
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
				gridBagConstraints1.gridx = 4;
				gridBagConstraints1.gridy = 8;
				panelGirBagLayout.add(btnLogout, gridBagConstraints1);

				this.add(panelGirBagLayout);

			} else {
				JOptionPane.showMessageDialog(null, "không có");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Loi " + e1.getMessage());
		}
	}

	PreparedStatement ptmt = null;

	public void ViewHD() {
		String sql = "SELECT * FROM qlbl INNER JOIN qlkh WHERE qlbl.MaCT=qlkh.MaCT AND qlkh.Email='"+this.email+"' AND Chu_Ky_Year = '"+jcNam.getSelectedItem().toString()+"'";
		try {
			
			String thang = (String) jcThang.getSelectedItem();
			String sqlWhere = null;
			if (!thang.equals(" ")) {
				sqlWhere = sql.concat(" AND Chu_Ky_Month = '" + jcThang.getSelectedItem().toString() + "'");
			//	PreparedStatement ptmt = conn.prepareStatement(sqlWhere);
			}else {
				sqlWhere = sql;	
			}
			PreparedStatement ptmt = conn.prepareStatement(sqlWhere);
						// khởi tạo resultset
			ResultSet rs = ptmt.executeQuery();
			Vector items = new Vector();
			double td;
			while (rs.next()) {

				int CSTT = rs.getInt(6) - rs.getInt(7);

				if (CSTT <= 50) {
					td = CSTT * 1549;
				} else if (CSTT <= 100) {
					td = 50 * 1549 + (CSTT - 50) * 1600;
				} else if (CSTT <= 200) {
					td = 50 * 1549 + 50 * 1600 + (CSTT - 100) * 1858;
				} else if (CSTT <= 300) {
					td = 50 * 1549 + 50 * 1600 + 100 * 1858 + (CSTT - 200) * 2340;
				} else if (CSTT <= 400) {
					td = 50 * 1549 + 50 * 1600 + 100 * 1858 + 100 * 2340 + (CSTT - 300) * 2615;
				} else {
					td = 50 * 1549 + 50 * 1600 + 100 * 1858 + 100 * 2340 + 100 * 2615 + (CSTT - 400) * 2701;
				}
				String rows[] = new String[6];

				rows[0] = rs.getString(1);

				rows[1] = rs.getString(4);
				rows[2] = rs.getString(5);
				rows[3] = rs.getString(3);
				rows[4] = String.valueOf(CSTT);
				String tdString = Double.toString(td);
				rows[5] = tdString;
				mdTable.addRow(rows);

			}
		} catch (SQLException e) {
			System.out.println("lỗi  " + e.getMessage());

		}
	}

	public void showWindow() {
		this.setSize(700, 600);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);

		this.setVisible(true);
	}
}
