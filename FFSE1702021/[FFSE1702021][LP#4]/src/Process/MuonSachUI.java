package Process;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;

import Data.Connect;

import Data.quan;
import Data.tinh;

public class MuonSachUI extends JPanel {
	Connect cn = new Connect();
	Connection conn = (Connection) Connect.getConnect();
	JPanel pnMSNgayTra;
	Font ftxtNgayTra;
	JLabel lbngaytra;
	String masach, ten_s, ten_tg;
	String masach1, ten_s1, ten_tg1, hoten, magd;
	JButton jbTK, jbThemSach, jbXoaSach,jbThoat;
	JDateChooser txtNM;
	JComboBox comboBoxSM, comboBoxQuan, comboBoxPhuong, comboBoxTinh;
	JTextField txtDate = new JTextField();
	JTextField txtTK, txtMTV, txtMGD, txtHoten, txtTpho, txtSDT, txtNgayTra;
	JTable tbListSachMuon = new JTable();
	JScrollPane spListSachMuon = new JScrollPane();
	String tbSachMuon[] = { "Họ tên", "Mã_GD", "Mã Sách", "Tên sách", "Tác gỉa", "Tình Trạng" };
	DefaultTableModel mdTableSachMuon = new DefaultTableModel(tbSachMuon, 0);

	JScrollPane scrollPaneSach = new JScrollPane();
	JTable tbListSach = new JTable();
	String tbSach[] = { "Mã Sách", "Tên sách", "Tác gỉa" };
	DefaultTableModel mdTableSach = new DefaultTableModel(tbSach, 0);

	MouseAdapter eventselect = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {

			int index = tbListSach.getSelectedRow();
			masach = (String) mdTableSach.getValueAt(index, 0);
			ten_s = (String) mdTableSach.getValueAt(index, 1);
			ten_tg = (String) mdTableSach.getValueAt(index, 2);

		}
	};
	MouseAdapter eventselect1 = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {

			int index = tbListSachMuon.getSelectedRow();
			hoten = (String) mdTableSachMuon.getValueAt(index, 0);
			magd = (String) mdTableSachMuon.getValueAt(index, 1);

			masach1 = (String) mdTableSachMuon.getValueAt(index, 2);
			ten_s1 = (String) mdTableSachMuon.getValueAt(index, 3);
			ten_tg1 = (String) mdTableSachMuon.getValueAt(index, 4);

		}
	};
	ActionListener evThemSach = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String sql = "SELECT * FROM QuanLy_Sach WHERE   ma_s=?";
			PreparedStatement ptmt;

			String sql1 = "SELECT * FROM BanDoc WHERE   Matv=?";
			PreparedStatement ptmt1;

			try {
				ptmt = (PreparedStatement) conn.prepareStatement(sql);
				ptmt.setString(1, masach);

				ptmt1 = (PreparedStatement) conn.prepareStatement(sql1);
				ptmt1.setString(1, txtMTV.getText());

				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					String SLS = rs.getString("so_luong_s");
					int sls = Integer.parseInt(SLS);
					if (sls == 0) {
						JOptionPane.showMessageDialog(null, "Sách đã hết");

					} else {
						ResultSet rs1 = ptmt1.executeQuery();
						while (rs1.next()) {
							String SL = rs1.getString("so_sach_muon");
							int sl = Integer.parseInt(SL);

							if (sl >= 3) {
								JOptionPane.showMessageDialog(null, "Hết lượt mượn");

							} else {

								try {
									insert();
								} catch (MyException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

//								try {
//									updateSoSachMuon();
//								} catch (MyException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}

							}
						}

					}
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	};
	ActionListener evXoaSach = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String sql = "SELECT * FROM Phieu_Muon WHERE   ma_gd=?";
			PreparedStatement ptmt;

			try {
				ptmt = (PreparedStatement) conn.prepareStatement(sql);
				ptmt.setString(1, txtMGD.getText());

				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {

					if (rs.getString("tinh_trang").equals("Đã trả")) {
						JOptionPane.showMessageDialog(null, "Sách đã trả!");

					} else {
						deleteSoSachMuon();
						Delete();

					}
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	};
	ActionListener evTimKiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			TimKiem1();
			TimKiem();
			TimKiem2();
			TimKiemTen();
		}

	};

	public MuonSachUI() {
		controls();
		Display();
		DisplayPhieuMuon();
		events();
	}

	public void events() {
		tbListSach.addMouseListener(eventselect);
		tbListSachMuon.addMouseListener(eventselect1);
		jbThemSach.addActionListener(evThemSach);
		jbXoaSach.addActionListener(evXoaSach);
		jbTK.addActionListener(evTimKiem);
	}

	public void controls() {

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));

		JPanel pnTimKiemSM = new JPanel();
		// pnTimKiemSM.setLayout(new BoxLayout(pnTimKiemSM, BoxLayout.X_AXIS));

		txtTK = new JTextField();
		txtTK.setColumns(20);
		Font fSM = new Font("arial", Font.PLAIN, 15);
		txtTK.setFont(fSM);
		jbTK = new JButton("Tìm kiếm");
		jbTK.setPreferredSize(new Dimension(90, 20));
		Font fTKSM = new Font("arial", Font.PLAIN, 12);
		pnTimKiemSM.add(txtTK);
		pnTimKiemSM.add(jbTK);

		JPanel pnMS = new JPanel();
		pnMS.setLayout(new BoxLayout(pnMS, BoxLayout.Y_AXIS));
		// Border borderMS = BorderFactory.createLineBorder(Color.BLUE);
		// TitledBorder borderTittleMS = BorderFactory.createTitledBorder(borderMS,
		// "Danh sách các loại sách");
		// pnMS.setBorder(borderTittleMS);
		//
		JPanel pnMS1 = new JPanel();
		JLabel lbMTV = new JLabel("Mã thành viên");
		lbMTV.setPreferredSize(new Dimension(80, 20));
		txtMTV = new JTextField();
		txtMTV.setEditable(false);
		Font fMTV = new Font("arial", Font.PLAIN, 12);
		lbMTV.setFont(fMTV);
		txtMTV.setColumns(15);

		JPanel pnMS2 = new JPanel();
		JLabel lbMGD = new JLabel("Mã giao dịch");
		lbMGD.setPreferredSize(new Dimension(80, 20));
		txtMGD = new JTextField();
		Font fMGD = new Font("arial", Font.PLAIN, 12);
		lbMGD.setFont(fMGD);
		txtMGD.setColumns(15);

		pnMS1.add(lbMTV);
		pnMS1.add(txtMTV);
		pnMS2.add(lbMGD);
		pnMS2.add(txtMGD);

		JPanel pnMS3 = new JPanel();
		JLabel lbHoten = new JLabel("Họ tên");
		lbHoten.setPreferredSize(new Dimension(80, 20));
		txtHoten = new JTextField();
		txtHoten.setEditable(false);
		Font fMS = new Font("arial", Font.PLAIN, 12);
		lbHoten.setFont(fMS);
		txtHoten.setColumns(15);

		JPanel pnMS4 = new JPanel();
		JLabel lbNM = new JLabel("Ngày mượn");
		lbNM.setPreferredSize(new Dimension(80, 20));
		txtNM = new JDateChooser();
		txtNM.setDateFormatString("MM/dd/yyyy");
		txtNM.setPreferredSize(new Dimension(170, 20));
		Font fNM = new Font("arial", Font.PLAIN, 12);
		lbNM.setFont(fNM);

		pnMS3.add(lbHoten);
		pnMS3.add(txtHoten);
		pnMS4.add(lbNM);
		pnMS4.add(txtNM);

		pnMSNgayTra = new JPanel();
		lbngaytra = new JLabel("Ngày Trả");
		lbngaytra.setPreferredSize(new Dimension(80, 20));
		txtNgayTra = new JTextField();
		txtNgayTra.setEditable(false);
		ftxtNgayTra = new Font("arial", Font.PLAIN, 12);
		lbngaytra.setFont(ftxtNgayTra);
		txtNgayTra.setColumns(15);
		pnMSNgayTra.add(lbngaytra);
		pnMSNgayTra.add(txtNgayTra);

		JPanel pnMS5 = new JPanel();
		JLabel lbTpho = new JLabel("Thành phố");
		lbTpho.setPreferredSize(new Dimension(80, 20));
		txtTpho = new JTextField();
		txtTpho.setEditable(false);
		Font fTpho = new Font("arial", Font.PLAIN, 12);
		lbTpho.setFont(fTpho);
		txtTpho.setColumns(15);
		pnMS5.add(lbTpho);
		pnMS5.add(txtTpho);

		JPanel pnMS6 = new JPanel();
		JLabel lbSDT = new JLabel("Số điện thoại");
		lbSDT.setPreferredSize(new Dimension(80, 20));
		txtSDT = new JTextField();

		txtSDT.setEditable(false);
		Font fSDT = new Font("arial", Font.PLAIN, 12);
		lbSDT.setFont(fSDT);
		txtSDT.setColumns(15);

		pnMS6.add(lbSDT);
		pnMS6.add(txtSDT);

		pnMS.add(pnMS1);
		pnMS.add(pnMS2);
		pnMS.add(pnMS3);
		pnMS.add(pnMS4);
		pnMS.add(pnMSNgayTra);
		pnMS.add(pnMS5);
		pnMS.add(pnMS6);

		JPanel pnTableSach = new JPanel();
		pnTableSach.setLayout(new BoxLayout(pnTableSach, BoxLayout.Y_AXIS));

		scrollPaneSach.setPreferredSize(new Dimension(400, 120));
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh sách các loại sách");
		scrollPaneSach.setBorder(borderTittle);
		tbListSach.setModel(mdTableSach);
		scrollPaneSach.setViewportView(tbListSach);

		JPanel pnThemXoa = new JPanel();
		pnThemXoa.setLayout(new BoxLayout(pnThemXoa, BoxLayout.X_AXIS));
		jbThemSach = new JButton("Mượn Sách");
		jbThemSach.setPreferredSize(new Dimension(100, 20));
		jbXoaSach = new JButton("Trả Sách");
		jbXoaSach.setPreferredSize(new Dimension(100, 20));
		jbThoat = new JButton("Quay lại");
		jbThoat.setPreferredSize(new Dimension(100, 20));
		jbThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
			MainUI.login.addShow();
			MainUI.home.dispose();
			
			}
		});

		pnThemXoa.add(jbThemSach);
		pnThemXoa.add(jbXoaSach);
		pnThemXoa.add(jbThoat);
		pnTableSach.add(scrollPaneSach);
		pnTableSach.add(pnThemXoa);
		// pnPhieuMuon.add(scrollPanePhieuMuon);
		// pnPhieuMuon.add(phieuMuon);
		JPanel pnTableSachMuon = new JPanel();
		Border borderSach = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTittleSach = BorderFactory.createTitledBorder(border, "Danh Sach phiếu mượn");
		spListSachMuon.setBorder(borderTittleSach);
		tbListSachMuon.setModel(mdTableSachMuon);
		spListSachMuon.setViewportView(tbListSachMuon);
		pnTableSachMuon.add(spListSachMuon);

		pnMain.add(pnMS);
		pnMain.add(pnTableSach);

		this.add(pnTimKiemSM);
		this.add(pnMain);
		this.add(pnTableSachMuon);

	}

	public void Display() {
		if (conn != null) {

			String sql = "select * from QuanLy_Sach";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {
					String rows[] = new String[4];

					rows[0] = rs.getString(2);

					rows[1] = rs.getString(3);
					rows[2] = rs.getString(4);
					rows[3] = rs.getString(6);

					mdTableSach.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public void insert() throws MyException {

		try {

			if (MyException.ChekEmpty(txtMGD.getText())&&MyException.ChekMPM(txtMGD.getText()) && MyException.ChekNgay(txtNM.getDate())) {

				if (conn != null) {
					String sql1 = "INSERT INTO `Phieu_Muon`( `ma_gd`,`ngay_muon`,`ma_tv`,`ma_s`,`tinh_trang`) VALUES (?,?,?,?,?)";
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					try {
						String dateAdd = format.format(txtNM.getDate());

						PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql1);
						ptmt.setString(1, txtMGD.getText());
						ptmt.setString(2, dateAdd);
						ptmt.setString(3, txtMTV.getText());
						ptmt.setString(4, masach);
						ptmt.setString(5, "Đang mượn");

						int k = ptmt.executeUpdate();
						mdTableSachMuon.setRowCount(0);
						if (k != 0) {
							String sql2 = "select * from ((QuanLy_Sach inner join Phieu_Muon on QuanLy_Sach.ma_s=Phieu_Muon.ma_s) inner join BanDoc on BanDoc.Matv=Phieu_Muon.ma_tv and  Phieu_Muon.ma_gd='"
									+ txtMGD.getText() + "' )";
							// System.out.print(sql2);
							try {
								PreparedStatement ptmt2 = (PreparedStatement) conn.prepareStatement(sql2);
								// khởi tạo resultset
								ResultSet rs2 = ptmt2.executeQuery();
								while (rs2.next()) {

									// sql2
									String rows[] = new String[6];

									rows[0] = rs2.getString("ho_ten");
									rows[1] = rs2.getString("ma_gd");
									rows[2] = rs2.getString(2);
									rows[3] = rs2.getString(3);
									rows[4] = rs2.getString(4);
									rows[5] = rs2.getString("tinh_trang");

									mdTableSachMuon.addRow(rows);
									
								}
							} catch (SQLException e) {
								System.out.println("loi  " + e.getMessage());

							}
							String sql3 = "UPDATE `BanDoc` SET `so_sach_muon`=so_sach_muon + 1 WHERE Matv=?";

							try {
								PreparedStatement ptmt3 = (PreparedStatement) conn.prepareStatement(sql3);
								ptmt3.setString(1, txtMTV.getText());
								int k1 = ptmt3.executeUpdate();
							} catch (SQLException e) {
								System.out.println("loi  " + e.getMessage());

							}
							String sql4 = "UPDATE `QuanLy_Sach` SET `so_luong_s`= so_luong_s -1 WHERE ma_s=?";
							try {
								PreparedStatement ptmt4 = (PreparedStatement) conn.prepareStatement(sql4);
								ptmt4.setString(1, masach);
								int k2 = ptmt4.executeUpdate();
							} catch (SQLException e) {
								System.out.println("loi  " + e.getMessage());

							}
						}

					} catch (SQLException e) {
						System.out.println("loi  " + e.getMessage());

					}
				} else {
					System.out.println("Kết nối MYSQL thất bại");
				}
			}
		} catch (MyException e) {
			System.out.println(e);
		}
	}

//	public void updateSoSachMuon() throws MyException {
//		try {
//
//			if (MyException.ChekEmpty(txtMGD.getText()) && MyException.ChekNgay(txtNM.getDate())) {
//				if (conn != null) {
//
//					String sql = "UPDATE `BanDoc` SET `so_sach_muon`=so_sach_muon + 1 WHERE Matv=?";
//
//					try {
//						PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
//						ptmt.setString(1, txtMTV.getText());
//						int k = ptmt.executeUpdate();
//					} catch (SQLException e) {
//						System.out.println("loi  " + e.getMessage());
//
//					}
//					String sql1 = "UPDATE `QuanLy_Sach` SET `so_luong_s`= so_luong_s -1 WHERE ma_s=?";
//					try {
//						PreparedStatement ptmt1 = (PreparedStatement) conn.prepareStatement(sql1);
//						ptmt1.setString(1, masach);
//						int k = ptmt1.executeUpdate();
//					} catch (SQLException e) {
//						System.out.println("loi  " + e.getMessage());
//
//					}
//				} else {
//					System.out.println("Kết nối MYSQL thất bại");
//				}
//			}
//		} catch (MyException e) {
//			System.out.println(e);
//		}
//	}

	public void deleteSoSachMuon() {

		if (conn != null) {

			String sql = "UPDATE `BanDoc` SET `so_sach_muon`=so_sach_muon - 1 WHERE Matv=?";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				ptmt.setString(1, txtMTV.getText());
				int k = ptmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
			String sql1 = "UPDATE `QuanLy_Sach` SET `so_luong_s`= so_luong_s +1 WHERE ma_s=?";
			try {
				PreparedStatement ptmt1 = (PreparedStatement) conn.prepareStatement(sql1);
				ptmt1.setString(1, masach1);
				int k = ptmt1.executeUpdate();
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}

	}

	public void Delete() {

		if (conn != null) {
			String sql = "UPDATE `Phieu_Muon` SET `tinh_trang`=? WHERE ma_gd=?";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ptmt.setString(1, "Đã trả");
				ptmt.setString(2, txtMGD.getText());

				int k = ptmt.executeUpdate();
				mdTableSachMuon.setRowCount(0);
				if (k != 0) {
					String sql1 = "select * from ((QuanLy_Sach inner join Phieu_Muon on QuanLy_Sach.ma_s=Phieu_Muon.ma_s) inner join BanDoc on BanDoc.Matv=Phieu_Muon.ma_tv and  Phieu_Muon.ma_gd='"
							+ txtMGD.getText() + "' )";
					try {
						PreparedStatement ptmt1 = (PreparedStatement) conn.prepareStatement(sql1);
						// khởi tạo resultset
						ResultSet rs1 = ptmt1.executeQuery();
						while (rs1.next()) {
							txtNgayTra.setText(rs1.getString("ngay_tra"));
							// sql2
							String rows[] = new String[6];

							rows[0] = rs1.getString("ho_ten");
							rows[1] = rs1.getString("ma_gd");
							rows[2] = rs1.getString(2);
							rows[3] = rs1.getString(3);
							rows[4] = rs1.getString(4);
							rows[5] = rs1.getString("tinh_trang");

							mdTableSachMuon.addRow(rows);

						}
					} catch (SQLException e) {
						System.out.println("loi  " + e.getMessage());

					}
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}

	}

	public void TimKiem() {
		if (conn != null) {

			// System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM Phieu_Muon WHERE ma_gd LIKE '%" + txtTK.getText() + "%'";
			String sql1 = "select * from  BanDoc inner join Phieu_Muon on BanDoc.Matv=Phieu_Muon.ma_tv and  Phieu_Muon.ma_gd='"
					+ txtTK.getText() + "' ";
			String sql2 = "select * from ((QuanLy_Sach inner join Phieu_Muon on QuanLy_Sach.ma_s=Phieu_Muon.ma_s) inner join BanDoc on BanDoc.Matv=Phieu_Muon.ma_tv and Phieu_Muon.ma_gd='"
					+ txtTK.getText() + "') ";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				PreparedStatement ptmt1 = (PreparedStatement) conn.prepareStatement(sql1);
				PreparedStatement ptmt2 = (PreparedStatement) conn.prepareStatement(sql2);

				// khởi tạo resultset
				mdTableSachMuon.setRowCount(0);
				ResultSet rs = ptmt.executeQuery();
				ResultSet rs1 = ptmt1.executeQuery();
				ResultSet rs2 = ptmt2.executeQuery();
				// mdTableSachMuon.setRowCount(0);

				while (rs.next()) {

					// sql
					txtMTV.setText(rs.getString(4));
					txtMGD.setText(rs.getString(2));
					txtMGD.setEditable(false);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

					String dateInString = rs.getString(3);
					try {
						java.util.Date date = formatter.parse(dateInString);

						txtNM.setDate(date);
						txtNM.setEnabled(false);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					txtNgayTra.setText(rs.getString(7));
				}
				while (rs1.next()) {
					// sql1
					txtHoten.setText(rs1.getString(3));
					txtSDT.setText(rs1.getString(4));
					txtTpho.setText(rs1.getString(7));

				}
				while (rs2.next()) {

					// sql2
					String rows1[] = new String[6];

					rows1[0] = rs2.getString("ho_ten");
					rows1[1] = rs2.getString("ma_gd");
					rows1[2] = rs2.getString(2);
					rows1[3] = rs2.getString(3);
					rows1[4] = rs2.getString(4);
					rows1[5] = rs2.getString("tinh_trang");

					mdTableSachMuon.addRow(rows1);

				}

			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	public void TimKiem1() {
		if (conn != null) {

			String sql3 = "SELECT * FROM QuanLy_Sach WHERE ma_s LIKE '%" + txtTK.getText() + "%' or ten_s LIKE '%"
					+ txtTK.getText() + "%'";
			try {

				PreparedStatement ptmt3 = (PreparedStatement) conn.prepareStatement(sql3);
				// khởi tạo resultset

				ResultSet rs3 = ptmt3.executeQuery();
				while (rs3.next()) {
					mdTableSach.setRowCount(0);
					String rows[] = new String[3];

					rows[0] = rs3.getString(2);
					rows[1] = rs3.getString(3);
					rows[2] = rs3.getString(4);

					mdTableSach.addRow(rows);
				}

			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	public void TimKiem2() {
		if (conn != null) {

			// System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM BanDoc WHERE Matv LIKE '%" + txtTK.getText() + "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);

				// khởi tạo resultset

				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {

					// sql
					txtMTV.setText(rs.getString(2));
					txtHoten.setText(rs.getString(3));
					txtSDT.setText(rs.getString(4));
					txtTpho.setText(rs.getString(7));

					txtMGD.setText("");
					txtMGD.setEditable(true);
					txtNM.setEnabled(true);
					mdTableSachMuon.setRowCount(0);
				}

			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	public void TimKiemTen() {
		if (conn != null) {

			String sql1 = "select * from ((QuanLy_Sach inner join Phieu_Muon on QuanLy_Sach.ma_s=Phieu_Muon.ma_s) inner join BanDoc on BanDoc.Matv=Phieu_Muon.ma_tv ) where BanDoc.ho_ten LIKE"
					+ "'%" + txtTK.getText() + "%'";
			try {

				PreparedStatement ptmt1 = (PreparedStatement) conn.prepareStatement(sql1);
				// khởi tạo resultset

				ResultSet rs1 = ptmt1.executeQuery();

				while (rs1.next()) {
					// mdTableSachMuon.setRowCount(0);
					// sql1

					String rows[] = new String[6];

					rows[0] = rs1.getString("ho_ten");
					rows[1] = rs1.getString("ma_gd");
					rows[2] = rs1.getString(2);
					rows[3] = rs1.getString(3);
					rows[4] = rs1.getString(4);
					rows[5] = rs1.getString("tinh_trang");

					mdTableSachMuon.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	public void DisplayPhieuMuon() {
		if (conn != null) {

			String sql = "select * from ((QuanLy_Sach inner join Phieu_Muon on QuanLy_Sach.ma_s=Phieu_Muon.ma_s) inner join BanDoc on BanDoc.Matv=Phieu_Muon.ma_tv ) ";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {

					// sql2
					String rows[] = new String[6];

					rows[0] = rs.getString("ho_ten");
					rows[1] = rs.getString("ma_gd");
					rows[2] = rs.getString(2);
					rows[3] = rs.getString(3);
					rows[4] = rs.getString(4);
					rows[5] = rs.getString("tinh_trang");

					mdTableSachMuon.addRow(rows);

				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}
}
