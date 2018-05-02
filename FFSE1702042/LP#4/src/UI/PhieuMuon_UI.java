package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;

import MODEL.Connect;
import UI.Sach_UI;

public class PhieuMuon_UI extends JFrame {

	Connection conn = (Connection) Connect.getConnect();
	JTextField txtLook, txtMaP, txtMaTV, txtMS, txtMuon, txtTT,txtTen, txtSach;
	JTextField txtTra = new JTextField();
	JDateChooser dateTra;
	JButton btAdd, btEdit, btDel, btTest, btLook, btReset, btBanDoc, btSach, btThongKe, btLogout;

	String tt[] = { "Đang mượn", "Đã trả" };
	JComboBox cbMuonTra = new JComboBox();
	JScrollPane spListPhieu = new JScrollPane();
	JTable tbListPhieu = new JTable();
	String tbPhieu[] = { "Mã phiếu", "Mã Thành viên", "Mã sách", "Ngày mượn", "Hạn trả", "Tình trạng" };
	DefaultTableModel mdTablePhieu = new DefaultTableModel(tbPhieu, 0);

	public PhieuMuon_UI(String tieude) {
		super(tieude);
		addControls();
		addEvent();
		Display();
		addShowWindow();
	}

	private void addShowWindow() {
		// TODO Auto-generated method stub
		this.setSize(990, 660);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void Display() {
		// TODO Auto-generated method stub
		if (conn != null) {
			String sql = "select * from phieu_muon";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {
					String rows[] = new String[6];

					rows[0] = rs.getString(1);

					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(6);

					mdTablePhieu.addRow(rows);
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

			String sql = "SELECT * from phieu_muon WHERE ma_phieu like N'%" + this.txtLook.getText() + "%' "
					+ "or ma_TV like N'%" + this.txtLook.getText() + "%'" + "or Ma_Sach like N'%"
					+ this.txtLook.getText() + "%'" + "or Han_Tra like N'%" + this.txtLook.getText() + "%'"
					+ "or Tinh_Trang like N'%" + this.txtLook.getText() + "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				mdTablePhieu.setRowCount(0);
				ResultSet rs = ptmt.executeQuery();
				// mdTableSach.getDataVector().removeAllElements();
				while (rs.next()) {

					String rows[] = new String[6];

					rows[0] = rs.getString(1);

					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(6);

					mdTablePhieu.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	ActionListener evKtraBandoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (conn != null) {
				String sql = "SELECT sach_dang_muon FROM ban_doc WHERE Ma_TV = ?";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					ptmt.setString(1, txtMaTV.getText());
					ResultSet rs = ptmt.executeQuery();
					if (rs.next()) {
						int a = rs.getInt(1);

						if (a >= 3) {
							JOptionPane.showMessageDialog(null, "Bạn đọc đã mượn 3 quyển sách");
							btAdd.setEnabled(false);

						}
					} else {
						JOptionPane.showMessageDialog(null, "Mã bạn đọc không tồn tại");
					}
				} catch (SQLException e) {
					System.out.println("loi  " + e.getMessage());
				}
			}
		}

	};

	ActionListener evKtraSach = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (conn != null) {
				if (txtMaTV.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mã thành viên");
				} else if (txtMS.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sách");
				} else if (dateTra.getDate() == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày trả sách");
				}

				else {
					String sql = "SELECT Tinh_trang FROM sach WHERE Ma_Sach = ?";

					try {
						PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
						ptmt.setString(1, txtMS.getText());
						ResultSet rs = ptmt.executeQuery();
						if (rs.next()) {
							int b = rs.getInt(1);

							if (b == 0) {
								JOptionPane.showMessageDialog(null, "Đã  hết sách trong kho");
								btAdd.setEnabled(false);

							} else {
								btAdd.setEnabled(true);

							}
						} else {
							JOptionPane.showMessageDialog(null, "Mã sách không tồn tại");
						}

					} catch (SQLException e) {
						System.out.println("loi  " + e.getMessage());
					}
				}
			}
		}

	};

	ActionListener evInsert = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (conn != null) {
				String sql = "INSERT INTO phieu_muon(ma_TV, Ma_Sach, Han_Tra, Tinh_Trang) VALUES (?,?,?,?)";

				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				try {
					txtTra.setText(format.format(dateTra.getDate()));
					String dateAdd = txtTra.getText();
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					// khởi tạo resultset
					// ptmt.setString(1, txtMaP.getText());
					ptmt.setString(1, txtMaTV.getText());
					ptmt.setString(2, txtMS.getText());
					// ptmt.setString(4, txtMuon.getText());
					ptmt.setString(3, dateAdd);
					ptmt.setString(4, (String) cbMuonTra.getSelectedItem());

					int k = ptmt.executeUpdate();
					if (k != 0) {

						JOptionPane.showMessageDialog(null, "Đã mượn thành công");
						String[] row = { txtMaP.getText(), txtMaTV.getText(), txtMS.getText(), txtMuon.getText(),
								txtTra.getText(), (String) cbMuonTra.getSelectedItem() };
						mdTablePhieu.addRow(row);

						txtMaP.setText("");
						txtMaTV.setText("");
						txtMS.setText("");
						txtMuon.setText("");
						txtTra.setText("");
						cbMuonTra.setSelectedItem("");
						btAdd.setEnabled(false);
					} else
						JOptionPane.showMessageDialog(null, "Thêm không thành công");
				} catch (SQLException e) {
					System.out.println("loi  " + e.getMessage());

				}

			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}

	};

	ActionListener evMuonSach = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (conn != null) {
				String sql = "UPDATE sach SET Tinh_trang= Tinh_trang - 1 WHERE Ma_Sach=?";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					ptmt.setString(1, txtMS.getText());
					int kt = ptmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("loi  " + e.getMessage());
				}
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}
	};

	ActionListener evTV_Muon = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (conn != null) {
				String sql = "UPDATE ban_doc SET sach_dang_muon = sach_dang_muon + 1 WHERE Ma_TV=?";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					ptmt.setString(1, txtMaTV.getText());
					int kt = ptmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("loi  " + e.getMessage());
				}
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}
	};

	ActionListener evTV_Tra = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (conn != null) {
				String sql = "UPDATE ban_doc SET sach_dang_muon = sach_dang_muon - 1 WHERE Ma_TV=?";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					ptmt.setString(1, txtMaTV.getText());
					int kt = ptmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("loi  " + e.getMessage());
				}
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}
	};

	ActionListener evTraSach = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (conn != null) {
				String sql = "UPDATE sach SET Tinh_trang= Tinh_trang  + 1 WHERE Ma_Sach=?";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					ptmt.setString(1, txtMS.getText());
					int kt = ptmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("loi  " + e.getMessage());
				}
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}
	};

	ActionListener evUpdate = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			if (conn != null) {

				String sql = "UPDATE phieu_muon SET ma_phieu =?, ma_TV=?, Ma_Sach=?, Han_Tra = ?, Tinh_Trang = ? WHERE ma_phieu = ?";

				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					// khởi tạo resultset
					ptmt.setString(1, txtMaP.getText());
					ptmt.setString(2, txtMaTV.getText());
					ptmt.setString(3, txtMS.getText());
					// ptmt.setString(4, txtMuon.getText());
					ptmt.setString(4, txtTra.getText());
					ptmt.setString(5, (String) cbMuonTra.getSelectedItem());
					ptmt.setString(6, txtMaP.getText());

					int t = tbListPhieu.getSelectedRow();
					String[] row = { txtMaP.getText(), txtMaTV.getText(), txtMS.getText(), txtMuon.getText(),
							txtTra.getText(), (String) cbMuonTra.getSelectedItem() };
					for (int j = 0; j < 6; j++) {
						tbListPhieu.setValueAt(row[j], t, j);
					}

					int k = ptmt.executeUpdate();
					if (k != 0) {

						txtMaP.setText("");
						txtMaTV.setText("");
						txtMS.setText("");
						txtMuon.setText("");
						txtTra.setText("");
						cbMuonTra.setSelectedItem("");
						btEdit.setEnabled(false);

						JOptionPane.showMessageDialog(null, "Trả sách thành công");
					} else
						JOptionPane.showMessageDialog(null, "Sửa không thành công");
				} catch (SQLException e) {
					System.out.println("loi  " + e.getMessage());

				}
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}

	};

	ActionListener evTimKiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimKiem();
		}

	};
	ActionListener evDisplay = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			mdTablePhieu.setRowCount(0);
			Display();

		}
	};

	ActionListener evSach = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Sach_UI sach	=	new Sach_UI("Sách");	
			sach.setVisible(true);
			dispose();
		}
	};
	ActionListener evBanDoc = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Bandoc_UI banDoc	=	new Bandoc_UI("Bạn đọc");	
			banDoc.setVisible(true);
			dispose();
		}
	};
	ActionListener evThongKe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ThongKeUI tk	=	new ThongKeUI("Báo cáo & Thống kê");	
			tk.setVisible(true);
			dispose();
		}
	};
	ActionListener evLogout = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Main_UI main	=	new Main_UI("THƯ VIỆN ĐIỆN TỬ CỦA TÙNG");	
			main.setVisible(true);
			dispose();
		}
	};
	MouseAdapter eventselect = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tbListPhieu.getSelectedRow();
			String[] row = new String[6];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tbListPhieu.getValueAt(i, j);
			}

			txtMaP.setText(row[0]);
			txtMaP.setEnabled(false);
			txtMaTV.setText(row[1]);
			txtMaTV.setEnabled(false);
			txtMS.setText(row[2]);
			txtMS.setEnabled(false);
			txtMuon.setText(row[3]);
			txtMuon.setEnabled(false);
			txtTra.setText(row[4]);
			dateTra.setEnabled(false);
			cbMuonTra.setSelectedItem(tt[1]);
			cbMuonTra.setEnabled(false);
			if (row[5].equals("Đang mượn")) {
				btEdit.setEnabled(true);
			} else {
				btEdit.setEnabled(false);
			}

		}
	};

	ActionListener evReset = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			txtMaP.setEnabled(true);
			txtMaTV.setEnabled(true);
			txtMS.setEnabled(true);
			txtTra.setEnabled(true);
			cbMuonTra.setSelectedItem(tt[0]);
			txtMaP.setText("");
			txtMaTV.setText("");
			txtMS.setText("");
			txtMuon.setText("");
			txtTra.setText("");
			dateTra.setEnabled(true);
			dateTra.setDate(null);
			cbMuonTra.setSelectedItem("");
			btEdit.setEnabled(false);
		}

	};

	private void addEvent() {
		// TODO Auto-generated method stub
		tbListPhieu.addMouseListener(eventselect);
		btAdd.addActionListener(evInsert);
		btAdd.addActionListener(evMuonSach);
		btAdd.addActionListener(evTV_Muon);
		btEdit.addActionListener(evUpdate);
		btEdit.addActionListener(evTraSach);
		btEdit.addActionListener(evTV_Tra);
		btTest.addActionListener(evKtraBandoc);
		btTest.addActionListener(evKtraSach);
		btLook.addActionListener(evTimKiem);
		btReset.addActionListener(evReset);
		btReset.addActionListener(evDisplay);
		btBanDoc.addActionListener(evBanDoc);
		btSach.addActionListener(evSach);
		btThongKe.addActionListener(evThongKe);
		btLogout.addActionListener(evLogout);
	}

	private void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnLook = new JPanel();
		pnLook.setBorder(new EmptyBorder(50, 100, 50, 100));
		pnLook.setLayout(new BoxLayout(pnLook, BoxLayout.X_AXIS));
		btLook = new JButton("Tìm kiếm");
		txtLook = new JTextField(20);
		JLabel lbLook3 = new JLabel(" 	     				 	");
		JLabel lbLook4 = new JLabel(" 	      					");
		pnLook.add(lbLook3);
		pnLook.add(txtLook);
		pnLook.add(lbLook4);
		pnLook.add(btLook);

		JPanel pnButton = new JPanel();
		pnButton.setBorder(new EmptyBorder(5, 100, 20, 100));
		pnButton.setLayout(new BoxLayout(pnButton, BoxLayout.X_AXIS));
		JPanel pnTest = new JPanel();
		btTest = new JButton("Kiểm tra");
		pnTest.add(btTest);
		JPanel pnAdd = new JPanel();
		btAdd = new JButton("Mượn sách");
		btAdd.setEnabled(false);
		pnAdd.add(btAdd);
		JPanel pnEdit = new JPanel();
		btEdit = new JButton("Trả sách");
		pnEdit.add(btEdit);
		btEdit.setEnabled(false);
		JPanel pnReset = new JPanel();
		btReset = new JButton("Reset");
		pnReset.add(btReset);
		pnButton.add(pnTest);
		pnButton.add(pnReset);
		pnButton.add(pnAdd);
		pnButton.add(pnEdit);

		JPanel pnPhieu = new JPanel();
		pnPhieu.setLayout(new BoxLayout(pnPhieu, BoxLayout.X_AXIS));
		JPanel pnMaPhieu = new JPanel();
		JPanel pnMaTV = new JPanel();
		JPanel pnMaSachP = new JPanel();
		JPanel pnNgayMuon = new JPanel();
		JPanel pnHanTra = new JPanel();
		JPanel pnTinhTrang = new JPanel();
		JPanel pnPhieuL = new JPanel();
		pnPhieuL.setLayout(new BoxLayout(pnPhieuL, BoxLayout.Y_AXIS));
		JPanel pnPhieuR = new JPanel();
		pnPhieuR.setLayout(new BoxLayout(pnPhieuR, BoxLayout.Y_AXIS));
		JLabel lbMaPhieu = new JLabel("Mã phiếu:	");
		lbMaPhieu.setPreferredSize(new Dimension(100, 25));
		txtMaP = new JTextField(20);
		txtMaP.setEnabled(false);

		JLabel lbMaTV = new JLabel("Mã thành viên:	");
		lbMaTV.setPreferredSize(new Dimension(100, 25));
		txtMaTV = new JTextField(20);
		JLabel lbMaSachP = new JLabel("Mã sách:	");
		lbMaSachP.setPreferredSize(new Dimension(100, 20));
		txtMS = new JTextField(20);
		JLabel lbNgayMuon = new JLabel("Ngày Mượn: ");
		lbNgayMuon.setPreferredSize(new Dimension(100, 25));
		lbNgayMuon.setBounds(48, 82, 145, 19);
		txtMuon = new JTextField(20);
		JLabel lbHanTra = new JLabel("Hạn trả:	");
		lbHanTra.setPreferredSize(new Dimension(100, 25));
		dateTra = new JDateChooser();
		dateTra.setDateFormatString("dd/MM/yyyy");
		dateTra.setPreferredSize(new Dimension(225, 20));

		JLabel lbTinhTrang = new JLabel("Tình trạng:	");
		lbTinhTrang.setPreferredSize(new Dimension(100, 25));
		cbMuonTra = new JComboBox(tt);
		cbMuonTra.setPreferredSize(new Dimension(225, 20));
		cbMuonTra.setEnabled(false);
		pnMaPhieu.add(lbMaPhieu);
		pnMaPhieu.add(txtMaP);
		pnMaTV.add(lbMaTV);
		pnMaTV.add(txtMaTV);
		pnMaSachP.add(lbMaSachP);
		pnMaSachP.add(txtMS);
		pnNgayMuon.add(lbNgayMuon);
		pnNgayMuon.add(txtMuon);
		pnHanTra.add(lbHanTra);
		pnHanTra.add(dateTra);
		pnTinhTrang.add(lbTinhTrang);
		pnTinhTrang.add(cbMuonTra);
		pnPhieuL.add(pnMaPhieu);
		pnPhieuL.add(pnMaTV);
		pnPhieuL.add(pnMaSachP);
		// pnPhieuR.add(pnNgayMuon);
		pnPhieuR.add(pnHanTra);
		pnPhieuR.add(pnTinhTrang);
		pnPhieu.add(pnPhieuL);
		pnPhieu.add(pnPhieuR);

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh Sach");
		spListPhieu.setBorder(borderTittle);
		tbListPhieu.setModel(mdTablePhieu);
		spListPhieu.setViewportView(tbListPhieu);

		JPanel pnLink = new JPanel();
		pnLink.setBorder(new EmptyBorder(5, 5, 5, 5));
		btSach = new JButton("Sách");
		btSach.setPreferredSize(new Dimension(200, 40));
		btBanDoc = new JButton("Bạn đọc");
		btBanDoc.setPreferredSize(new Dimension(200, 40));
		btThongKe = new JButton("Thống kê");
		btThongKe.setPreferredSize(new Dimension(200, 40));
		btLogout	=	new JButton("Đăng xuất");
		btLogout.setPreferredSize(new Dimension(200, 40));
		pnLink.add(btSach);
		pnLink.add(btBanDoc);
		pnLink.add(btThongKe);
		pnLink.add(btLogout);
		
		pnMain.add(pnLook);
		pnMain.add(pnButton);
		pnMain.add(pnPhieu);

		pnMain.add(spListPhieu);
		pnMain.add(pnLink);

		con.add(pnMain);

	}

	public static void main(String[] args) {
		PhieuMuon_UI myUI = new PhieuMuon_UI("Quản lý mượn trả sách");
		myUI.addShowWindow();
	}
}
