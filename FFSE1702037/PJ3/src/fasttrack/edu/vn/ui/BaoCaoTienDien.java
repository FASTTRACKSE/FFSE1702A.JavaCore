package fasttrack.edu.vn.ui;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.BorderLayout;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
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
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import fasttrack.edu.vn.main.ConnectDB;
import fasttrack.edu.vn.main.GiaoDien;

public class BaoCaoTienDien extends JFrame {
	ConnectDB cn = new ConnectDB();
	Connection conn = cn.getConnect("localhost", "Appcuatoi", "Appcuatoi", "123456");
	JRadioButton jRadioKH, jRadioYear, jRadioKhuVuc, jRadioTime, jRadioKHCT, jRadioChuKy;
	JPanel pnjRadio22, pnjRadio222, pnjRadio33, pnjRadio1, pnjRadio333, pnInput, pnInput1, pnjRadio55, pnInput2,
			pnjRadio6;
	JTextField txtMKH = new JTextField(15);
	JTextField txtNameKH = new JTextField(15);
	JTextField txtDiaChi = new JTextField(15);
	private JDateChooser dateChooser;
	String Thang[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	String Thang1[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	String Thang2[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	JComboBox jcThang = new JComboBox(Thang);
	JComboBox jcThang1 = new JComboBox(Thang1);
	JComboBox jcThang2 = new JComboBox(Thang2);
	String Nam[] = { "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" };
	String Nam1[] = { "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" };
	String Nam2[] = { "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" };
	String Nam3[] = { "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" };
	JComboBox jcNam = new JComboBox(Nam);
	JComboBox jcNam1 = new JComboBox(Nam1);
	JComboBox jcNam2 = new JComboBox(Nam2);
	JComboBox jcNam3 = new JComboBox(Nam3);
	JButton btnView, btnExit, btnSearch;
	JScrollPane spList = new JScrollPane();
	JTable tbList = new JTable();
	String tbSV[] = { "Ma KH", "Mã CT", "Ten KH", "Quận", "Phường", "Thời Gian", "Chỉ số Tiêu Thụ", "Tiền điện" };
	DefaultTableModel mdTable = new DefaultTableModel(tbSV, 0);

	public BaoCaoTienDien(String tieude) {
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
	ActionListener eventView = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mdTable.getDataVector().removeAllElements();
			mdTable.fireTableDataChanged();
			View();

		}
	};
	ActionListener eventViewKH = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			ViewKH();

		}
	};
	ActionListener eventCombobox = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			combobox1(jcQuan.getSelectedItem().toString());
		}
	};

	protected void Menu() {
		Menu myUI = new Menu("My Application");
		myUI.showWindow();
		dispose();
	}

	public void addEvents() {
		btnSearch.addActionListener(eventViewKH);
		btnView.addActionListener(eventView);
		btnExit.addActionListener(eventMenu);
		jcQuan.addActionListener(eventCombobox);
		jRadioKhuVuc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pnjRadio22.setVisible(true);
					pnjRadio222.setVisible(true);
				} else {
					pnjRadio22.setVisible(false);
					pnjRadio222.setVisible(false);
				}
			}
		});
		jRadioKHCT.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pnInput.setVisible(true);
					pnInput1.setVisible(true);
					pnInput2.setVisible(true);
				} else {
					pnInput.setVisible(false);
					pnInput1.setVisible(false);
					pnInput2.setVisible(false);
				}
			}
		});
		jRadioYear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pnjRadio6.setVisible(true);

				} else {
					pnjRadio6.setVisible(false);
				}
			}
		});
		jRadioTime.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pnjRadio33.setVisible(true);
					pnjRadio333.setVisible(true);

				} else {
					pnjRadio33.setVisible(false);
					pnjRadio333.setVisible(false);
				}
			}
		});
		jRadioChuKy.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pnjRadio55.setVisible(true);

				} else {
					pnjRadio55.setVisible(false);

				}
			}
		});
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("BÁO CÁO HÓA ĐƠN TIỀN ĐIỆN");
		Font fontTitle = new Font("Time new roman", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JPanel pnGroup = new JPanel();
		pnGroup.setLayout(new BoxLayout(pnGroup, BoxLayout.X_AXIS));

		JPanel pnGroup1 = new JPanel();

		pnGroup1.setLayout(new BoxLayout(pnGroup1, BoxLayout.Y_AXIS));
		JPanel pnGroup2 = new JPanel();
		pnGroup2.setLayout(new BoxLayout(pnGroup2, BoxLayout.Y_AXIS));
		// pnGroup.add(Box.createHorizontalGlue());
		pnGroup.add(pnGroup1);
		pnGroup.add(pnGroup2);
		// pnGroup.add(Box.createHorizontalGlue());

		JPanel pnTitle1 = new JPanel();
		JLabel lblTitle1 = new JLabel("Khách hàng :");
		pnTitle1.add(lblTitle1);
		pnGroup1.add(pnTitle1);

		ButtonGroup buttonGroup = new ButtonGroup();
		JPanel pnjRadio = new JPanel();
		jRadioKH = new JRadioButton("Tất cả khách hàng    ");
		// jRadioKH.setPreferredSize(new Dimension(140, 20));
		jRadioKH.setHorizontalAlignment(SwingConstants.RIGHT);
		buttonGroup.add(jRadioKH);
		jRadioKH.setSelected(true);
		pnjRadio.add(jRadioKH);
		// pnjRadio.setVerticalAlignment(SwingConstants.RIGHT);
		pnGroup1.add(pnjRadio);
		// pnGroup1.add(pnjRadio);

		JPanel pnjRadio2 = new JPanel();
		jRadioKhuVuc = new JRadioButton("Khu vực                       ");
		// jRadioKhuVuc.setPreferredSize(new Dimension(140, 20));
		jRadioKhuVuc.setHorizontalAlignment(SwingConstants.RIGHT);
		buttonGroup.add(jRadioKhuVuc);
		pnjRadio2.add(jRadioKhuVuc);
		pnGroup1.add(pnjRadio2, BorderLayout.WEST);
		// pnGroup1.add(pnjRadio2);

		pnjRadio22 = new JPanel();
		JLabel lbCls2 = new JLabel("Quận :    ");
		lbCls2.setHorizontalAlignment(SwingConstants.RIGHT);
		Font fCls2 = new Font("arial", Font.ITALIC, 15);
		lbCls2.setFont(fCls2);
		pnjRadio22.add(lbCls2);
		pnjRadio22.add(jcQuan);
		pnjRadio22.setVisible(false);
		pnGroup1.add(pnjRadio22);

		pnjRadio222 = new JPanel();
		JLabel lbCls22 = new JLabel("Phường :");
		jcPhuong.setPreferredSize(new Dimension(110, 20));
		lbCls22.setHorizontalAlignment(SwingConstants.RIGHT);

		Font fCls22 = new Font("arial", Font.ITALIC, 15);
		lbCls22.setFont(fCls22);
		pnjRadio222.add(lbCls22);
		pnjRadio222.add(jcPhuong);
		pnjRadio222.setVisible(false);
		pnGroup1.add(pnjRadio222);

		JPanel pnjRadio4 = new JPanel();
		jRadioKHCT = new JRadioButton("Khách hàng cụ thể");
		jRadioKHCT.setPreferredSize(new Dimension(140, 20));
		buttonGroup.add(jRadioKHCT);
		pnjRadio4.add(jRadioKHCT);
		pnGroup1.add(pnjRadio4);

		pnInput = new JPanel();
		JLabel lblTitle3 = new JLabel("Mã khách hàng :");
		txtMKH = new JTextField(10);
		pnInput.add(lblTitle3);
		pnInput.add(txtMKH);

		ImageIcon iconFind = new ImageIcon("image/search1.png");
		Image getIconFind = iconFind.getImage();
		Image newIconFind = getIconFind.getScaledInstance(11, 11, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newIconFind);
		btnSearch = new JButton(newIcon);
		pnInput.add(btnSearch);

		pnInput.setVisible(false);
		pnGroup1.add(pnInput);

		pnInput1 = new JPanel();
		JLabel lblTitle4 = new JLabel("Tên khách hàng :");
		txtNameKH = new JTextField(15);
		pnInput1.add(lblTitle4);
		pnInput1.add(txtNameKH);
		pnInput1.setVisible(false);
		pnGroup1.add(pnInput1);

		pnInput2 = new JPanel();
		JLabel lblTitle5 = new JLabel("Địa chỉ :                 ");
		txtDiaChi = new JTextField(15);
		pnInput2.add(lblTitle5);
		pnInput2.add(txtDiaChi);
		pnInput2.setVisible(false);
		pnGroup1.add(pnInput2);

		JPanel pnTitle2 = new JPanel();
		JLabel lblTitle2 = new JLabel("Thời gian :");
		pnTitle2.add(lblTitle2);
		pnGroup2.add(pnTitle2);

		ButtonGroup buttonGroup1 = new ButtonGroup();

		JPanel pnjRadio1 = new JPanel();
		jRadioYear = new JRadioButton("Năm                       ");
		buttonGroup1.add(jRadioYear);
		jRadioYear.setSelected(true);
		pnjRadio1.add(jRadioYear);
		pnGroup2.add(pnjRadio1, BorderLayout.WEST);
		pnGroup2.add(pnjRadio1);

		pnjRadio6 = new JPanel();
		JLabel lbCls1 = new JLabel("Năm :");
		Font fCls1 = new Font("arial", Font.ITALIC, 15);
		// lbCls1.setPreferredSize(new Dimension(80, 20));
		lbCls1.setFont(fCls1);
		pnjRadio6.add(lbCls1);
		pnjRadio6.add(jcNam);
		pnGroup2.add(pnjRadio6);

		JPanel pnjRadio3 = new JPanel();
		jRadioTime = new JRadioButton("Khoảng thời gian");
		buttonGroup1.add(jRadioTime);
		pnjRadio3.add(jRadioTime);
		pnGroup2.add(pnjRadio3);
		pnGroup2.add(pnjRadio3, BorderLayout.WEST);

		pnjRadio33 = new JPanel();
		JLabel lbCls3 = new JLabel("Từ tháng :");
		Font fCls3 = new Font("arial", Font.ITALIC, 15);
		lbCls3.setFont(fCls3);
		pnjRadio33.add(lbCls3);
		pnjRadio33.add(jcThang);

		JLabel lbCls33 = new JLabel("Năm :");
		Font fCls33 = new Font("arial", Font.ITALIC, 15);
		lbCls33.setFont(fCls33);
		pnjRadio33.add(lbCls33);
		pnjRadio33.add(jcNam1);

		pnjRadio33.setVisible(false);
		pnGroup2.add(pnjRadio33);

		pnjRadio333 = new JPanel();
		JLabel lbCls333 = new JLabel("Đến tháng :");
		Font fCls333 = new Font("arial", Font.ITALIC, 15);
		lbCls333.setFont(fCls333);
		pnjRadio333.add(lbCls333);
		pnjRadio333.add(jcThang1);

		JLabel lbCls3333 = new JLabel("Năm :");
		Font fCls3333 = new Font("arial", Font.ITALIC, 15);
		lbCls3333.setFont(fCls3333);
		pnjRadio333.add(lbCls3333);
		pnjRadio333.add(jcNam2);

		pnjRadio333.setVisible(false);
		pnGroup2.add(pnjRadio333);

		JPanel pnjRadio5 = new JPanel();
		jRadioChuKy = new JRadioButton("Theo kỳ                 ");
		buttonGroup1.add(jRadioChuKy);
		pnjRadio5.add(jRadioChuKy);
		pnGroup2.add(pnjRadio5);

		pnjRadio55 = new JPanel();
		JLabel lbCls55 = new JLabel("Tháng :");
		Font fCls55 = new Font("arial", Font.ITALIC, 15);
		lbCls55.setFont(fCls55);
		pnjRadio55.add(lbCls55);
		pnjRadio55.add(jcThang2);

		JLabel lbCls555 = new JLabel("Năm :");
		Font fCls555 = new Font("arial", Font.ITALIC, 15);
		lbCls555.setFont(fCls555);
		pnjRadio55.add(lbCls555);
		pnjRadio55.add(jcNam3);

		pnjRadio55.setVisible(false);
		pnGroup2.add(pnjRadio55);

		JPanel pnAction = new JPanel();
		btnView = new JButton("Tìm");
		pnAction.add(btnView);
		btnExit = new JButton("Trở lại");
		pnAction.add(btnExit);
		Border border = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh Sách");

		spList.setBorder(borderTittle);
		tbList.setModel(mdTable);
		spList.setViewportView(tbList);
		tbList.setPreferredScrollableViewportSize(new Dimension(500, 250));

		pnMain.add(pnTitle);
		pnMain.add(pnGroup);

		pnMain.add(pnAction);
		pnMain.add(spList);

		con.add(pnMain);
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

	// public void Display() {
	// // ConnectDB cn = new ConnectDB();
	// // Connection conn = cn.getConnect("localhost", "Appcuatoi", "Appcuatoi",
	// // "123456");
	// // if (conn != null) {
	// //
	// // String sql = "select * from qlkh";
	// // try {
	// // PreparedStatement ptmt = conn.prepareStatement(sql);
	// // // khởi tạo resultset
	// // ResultSet rs = ptmt.executeQuery();
	// // while (rs.next()) {
	// // String rows[] = new String[8];
	// // rows[0] = rs.getString(1);
	// // rows[1] = rs.getString(3);
	// // rows[2] = rs.getString(7);
	// // rows[3] = rs.getString(5);
	// // rows[4] = rs.getString(6);
	// // rows[5] = rs.getString(8);
	// // rows[6] = rs.getString(4);
	// // rows[7] = rs.getString(2);
	// // mdTable.addRow(rows);
	// // }
	// // } catch (SQLException e) {
	// // System.out.println("loi " + e.getMessage());
	// //
	// // }
	// // } else {
	// // System.out.println("Kết nối MYSQL thất bại");
	// // }
	// }
	private String selectKhoangTg(String thangSt, String namSt, String thangEnd, String namEnd, String sqlWhere) {
		String sql = "";
		int namSt11 = Integer.parseInt(namSt);
		int m = namSt11;
		int namEnd11 = Integer.parseInt(namEnd);

		int thangSt11 = Integer.parseInt(thangSt);
		int n = thangSt11;
		int thangEnd11 = Integer.parseInt(thangEnd);

		while (namSt11 <= namEnd11) {
			if (namSt11 < namEnd11) {
				for (int i = thangSt11; thangSt11 <= 12; thangSt11++) {
					if (thangSt11 == n && namSt11 == m) {
						sqlWhere += " AND ((`Chu_Ky_Year` = " + namSt11 + " AND `Chu_Ky_Month`= " + thangSt11 + ")";
					} else {
						sqlWhere += " OR (`Chu_Ky_Year` = " + namSt11 + " AND `Chu_Ky_Month`= " + thangSt11 + ")";
					}
				}
				thangSt11 = 1;
			} else if (namSt11 == namEnd11) {
				for (int i = thangSt11; thangSt11 <= thangEnd11; thangSt11++) {
					if (thangSt11 == thangEnd11) {
						sqlWhere += " OR (`Chu_Ky_Year` = " + namSt11 + " AND `Chu_Ky_Month`= " + thangSt11 + "))";
					} else {
						sqlWhere += " OR (`Chu_Ky_Year` = " + namSt11 + " AND `Chu_Ky_Month`= " + thangSt11 + ")";
					}
				}
			}
			namSt11 += 1;
		}
		return sqlWhere;
	}

	PreparedStatement ptmt = null;

	public void View() {
		String sql = "SELECT * FROM qlbl INNER JOIN qlkh WHERE qlbl.MaCT=qlkh.MaCT ";
		String quan = (String) jcQuan.getSelectedItem();
		String phuong = (String) jcPhuong.getSelectedItem();

		String sqlWhere = null;
		if (jRadioKhuVuc.isSelected()) {
			if (phuong == null || phuong.equals("Tất cả")) {
				sqlWhere = sql.concat(" AND Quan='" + jcQuan.getSelectedItem() + "'");
			} else {
				sqlWhere = sql.concat(" AND Quan ='" + jcQuan.getSelectedItem() + "' AND  Phuong ='t"
						+ jcPhuong.getSelectedItem() + "' ");
			//	System.out.print("hiện quan phuong "+sqlWhere);
			}
		} else if (jRadioKHCT.isSelected()) {
			sqlWhere = sql.concat(" AND MaKH='" + txtMKH.getText() + "'");
		} else {
			sqlWhere = sql.concat(" ");
		}
		if (jRadioYear.isSelected()) {
			sqlWhere = sqlWhere.concat(" AND Chu_Ky_Year =" + jcNam.getSelectedItem());
		} else if (jRadioTime.isSelected()) {
			sqlWhere = selectKhoangTg(jcThang.getSelectedItem().toString(), jcNam1.getSelectedItem().toString(),
					jcThang1.getSelectedItem().toString(), jcNam2.getSelectedItem().toString(), sqlWhere);

		} else {
			sqlWhere = sqlWhere.concat(" AND Chu_Ky_Month =" + jcThang2.getSelectedItem() + " AND Chu_Ky_year = "
					+ jcNam3.getSelectedItem());
		}

		try {
			PreparedStatement ptmt = conn.prepareStatement(sqlWhere);

			ptmt = conn.prepareStatement(sqlWhere);

			ResultSet rs = ptmt.executeQuery();
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
				String rows[] = new String[8];
				int sm = Integer.parseInt(rs.getString(6));
				int sc = Integer.parseInt(rs.getString(7));
				int kq = sm - sc;
				rows[0] = rs.getString(9);

				rows[1] = rs.getString(2);
				rows[2] = rs.getString(11);
				rows[3] = rs.getString(13);
				rows[4] = rs.getString(14);
				rows[5] = rs.getString(4) + "-" + rs.getString(5);
				rows[6] = String.valueOf(kq);
				String tdString = Double.toString(td);
				rows[7] = tdString;
				mdTable.addRow(rows);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Loi " + e1.getMessage());
		}
	}

	public void ViewKH() {
		String maKH = txtMKH.getText();
		String sql = "SELECT * FROM `qlkh` WHERE MaKH=  '" + maKH + "'";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);

			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("Name");
				String diachi = rs.getString("DiaChi");
				txtNameKH.setText(name);
				txtDiaChi.setText(diachi);
			}

		} catch (SQLException e1) {
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
