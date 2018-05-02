package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import MODEL.Connect;

public class ThongKeUI extends JFrame {
	Connection conn = (Connection) Connect.getConnect();

	JComboBox comboBoxBDoc, comboBoxNXB, comboBoxTheLoai, comboBoxTacGia;
	JTextField txtTKBD, txtTKSach, txtTongSach, txtTonKho;
	JButton jbTKBD, jbTKBD1, jbTKSach, jbTKSach1, jbTKSach2, btSach, btBanDoc, btPhieu, btLogout;
	String tonKho, tongSach;

	JScrollPane scrollPaneBD = new JScrollPane();
	JTable tbListBD = new JTable();
	String tbBD[] = { "Mã TV", "Tên", "Số điện thoại", "Số sách đang mượn" };
	DefaultTableModel mdTableBD = new DefaultTableModel(tbBD, 0);
	// table sach
	JScrollPane scrollPaneSach = new JScrollPane();
	JScrollPane scrollPaneTK = new JScrollPane();
	JTable tbListSach = new JTable();
	JTable tbListTK = new JTable();
	String tbSach[] = { "Mã Sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản", "Tồn kho", "Tổng sách" };
	// String tbTK[]= {"Tổng số sách tồn kho", "Tổng số sách"};
	DefaultTableModel mdTableSach = new DefaultTableModel(tbSach, 0);
	// DefaultTableModel mdTableTK = new DefaultTableModel(tbTK, 0);
	ActionListener evTimKiemTinh = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimKiemBDoc();
		}

	};
	ActionListener evTimKiemMa = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimMaTV();
		}

	};

	ActionListener evTimKiemSach = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimKiemSach();
			TKNXB();

		}

	};
	ActionListener evTimKiemSach1 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimKiemSach1();
			TKTL();
		}

	};

	ActionListener evTimKiemSach2 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimKiemSach2();
			TKTG();
		}

	};

	public ThongKeUI(String tieude) {
		super(tieude);
		addControls();
		events();
		Display1();
		comboboxThanhPho();
		comboboxNXB();
		comboboxTheLoai();
		comboboxTacGia();
		Display2();
		TK();
		addShowWindow();

	}

	private void addShowWindow() {
		// TODO Auto-generated method stub
		this.setSize(990, 660);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private void addControls() {
		Container con = getContentPane();
		JTabbedPane JTab = new JTabbedPane();
		JPanel pnLink = new JPanel();
		pnLink.setBorder(new EmptyBorder(5, 5, 5, 5));
		btSach = new JButton("Sách");
		btSach.setPreferredSize(new Dimension(200, 40));
		btPhieu = new JButton("Phiếu mượn");
		btPhieu.setPreferredSize(new Dimension(200, 40));
		btBanDoc = new JButton("Bạn đọc");
		btBanDoc.setPreferredSize(new Dimension(200, 40));
		btLogout	=	new JButton("Đăng xuất");
		btLogout.setPreferredSize(new Dimension(200, 40));
		pnLink.add(btSach);
		pnLink.add(btPhieu);
		pnLink.add(btBanDoc);
		pnLink.add(btLogout);
		JPanel pnMain1 = new JPanel();
		pnMain1.setLayout(new BoxLayout(pnMain1, BoxLayout.Y_AXIS));
		pnMain1.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel pnTittle = new JPanel();
		JLabel lbTittle = new JLabel("Thống kê theo bạn đọc");
		Font fTittle = new Font("arial", Font.BOLD, 20);
		lbTittle.setFont(fTittle);
		pnTittle.add(lbTittle);

		JPanel pnTimKiemBD = new JPanel();
		JLabel lbBD = new JLabel("Tỉnh thành:");
		lbBD.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxBDoc = new JComboBox();
		comboBoxBDoc.setPreferredSize(new Dimension(150, 20));

		comboBoxBDoc.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxBDoc.setToolTipText("");
		pnTimKiemBD.add(lbBD);
		pnTimKiemBD.add(comboBoxBDoc);
		jbTKBD = new JButton("Tìm kiếm");
		jbTKBD.setPreferredSize(new Dimension(100, 20));
		pnTimKiemBD.add(jbTKBD);

		JLabel lbBD1 = new JLabel("Mã TV:");
		lbBD1.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTKBD = new JTextField();
		txtTKBD.setColumns(15);
		Font fTk = new Font("arial", Font.PLAIN, 15);
		txtTKBD.setFont(fTk);
		jbTKBD1 = new JButton("Tìm kiếm");
		jbTKBD1.setPreferredSize(new Dimension(100, 20));
		Font fTK = new Font("arial", Font.PLAIN, 12);
		pnTimKiemBD.add(lbBD1);
		pnTimKiemBD.add(txtTKBD);
		pnTimKiemBD.add(jbTKBD1);

		JPanel pnTableBD = new JPanel();
		pnTableBD.setLayout(new BoxLayout(pnTableBD, BoxLayout.Y_AXIS));

		scrollPaneBD.setPreferredSize(new Dimension(400, 170));
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh sách bạn đọc");
		scrollPaneBD.setBorder(borderTittle);
		tbListBD.setModel(mdTableBD);
		scrollPaneBD.setViewportView(tbListBD);
		pnTableBD.add(scrollPaneBD);

		pnMain1.add(pnTittle);
		pnMain1.add(pnTimKiemBD);
		pnMain1.add(pnTableBD);

		// Main 2

		JPanel pnMain2 = new JPanel();
		pnMain2.setLayout(new BoxLayout(pnMain2, BoxLayout.Y_AXIS));
		pnMain2.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel pnTittle1 = new JPanel();
		JLabel lbTittle1 = new JLabel("Thống kê theo sách");
		Font fTittle1 = new Font("arial", Font.BOLD, 20);
		lbTittle1.setFont(fTittle1);
		pnTittle1.add(lbTittle1);

		JPanel pnTimKiemSach = new JPanel();

		JLabel lbSach = new JLabel("Nhà xuất bản:");
		lbSach.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxNXB = new JComboBox();
		// comboBoxNXB.setPreferredSize(new Dimension(110, 20));
		comboBoxNXB.setFont(new Font("Arial", Font.PLAIN, 12));
		jbTKSach = new JButton("Tìm kiếm");
		jbTKSach.setPreferredSize(new Dimension(100, 20));

		pnTimKiemSach.add(lbSach);
		pnTimKiemSach.add(comboBoxNXB);
		pnTimKiemSach.add(jbTKSach);

		JLabel lbSach1 = new JLabel("Thể lọai:");
		lbSach1.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxTheLoai = new JComboBox();
		comboBoxTheLoai.setPreferredSize(new Dimension(110, 20));
		comboBoxTheLoai.setFont(new Font("Arial", Font.PLAIN, 12));
		// comboBoxTheLoai.setToolTipText("");
		jbTKSach1 = new JButton("Tìm kiếm");
		jbTKSach1.setPreferredSize(new Dimension(100, 20));
		pnTimKiemSach.add(lbSach1);
		pnTimKiemSach.add(comboBoxTheLoai);
		pnTimKiemSach.add(jbTKSach1);

		JLabel lbSach2 = new JLabel("Tác Giả:");
		lbSach2.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxTacGia = new JComboBox();
		comboBoxTacGia.setPreferredSize(new Dimension(110, 20));
		comboBoxTacGia.setFont(new Font("Arial", Font.PLAIN, 12));
		// comboBoxTacGia.setToolTipText("");
		jbTKSach2 = new JButton("Tìm kiếm");
		jbTKSach2.setPreferredSize(new Dimension(100, 20));
		pnTimKiemSach.add(lbSach2);
		pnTimKiemSach.add(comboBoxTacGia);
		pnTimKiemSach.add(jbTKSach2);

		Font fTkSach = new Font("arial", Font.PLAIN, 15);

		JPanel pnTableSach = new JPanel();
		pnTableSach.setLayout(new BoxLayout(pnTableSach, BoxLayout.Y_AXIS));

		scrollPaneSach.setPreferredSize(new Dimension(400, 170));
		Border border1 = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTittle1 = BorderFactory.createTitledBorder(border1, "Danh sách");
		scrollPaneSach.setBorder(borderTittle1);
		tbListSach.setModel(mdTableSach);
		scrollPaneSach.setViewportView(tbListSach);
		pnTableSach.add(scrollPaneSach);

		JPanel pnThongKe = new JPanel();
		pnThongKe.setLayout(new BoxLayout(pnThongKe, BoxLayout.X_AXIS));
		JPanel pnTongSach = new JPanel();
		JLabel lbTongSach = new JLabel("Tổng sách");
		txtTongSach = new JTextField(20);
		pnTongSach.add(lbTongSach);
		pnTongSach.add(txtTongSach);
		JPanel pnTonKho = new JPanel();
		JLabel lbTonKho = new JLabel("Tồn kho");
		txtTonKho = new JTextField(20);
		pnTonKho.add(lbTonKho);
		pnTonKho.add(txtTonKho);
		pnThongKe.add(pnTongSach);
		pnThongKe.add(pnTonKho);

		pnMain2.add(pnTittle1);
		pnMain2.add(pnTimKiemSach);
		pnMain2.add(pnTableSach);
		pnMain2.add(pnThongKe);
		pnMain2.add(pnLink);

		JTab.add("Thống kê sách", pnMain2);
		JTab.add("Thống kê bạn đọc", pnMain1);
		

		con.add(JTab);

	}

	public void events() {
		jbTKBD.addActionListener(evTimKiemTinh);
		jbTKBD1.addActionListener(evTimKiemMa);
		jbTKSach.addActionListener(evTimKiemSach);
		jbTKSach1.addActionListener(evTimKiemSach1);
		jbTKSach2.addActionListener(evTimKiemSach2);
		btBanDoc.addActionListener(evBanDoc);
		btSach.addActionListener(evSach);
		btPhieu.addActionListener(evPhieu);
		btLogout.addActionListener(evLogout);
	}

	private void Display1() {
		// TODO Auto-generated method stub
		if (conn != null) {
			String sql = "select * from ban_doc";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {
					String rows[] = new String[4];

					rows[0] = rs.getString(1);

					rows[1] = rs.getString(2);
					rows[2] = rs.getString(4);
					rows[3] = rs.getString(9);

					mdTableBD.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public void Display2() {
		if (conn != null) {
			String sql = "select * from sach";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {
					String rows[] = new String[8];

					rows[0] = rs.getString(1);

					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(8);
					rows[6] = rs.getString(7);

					mdTableSach.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public void TK() {
		if (conn != null) {
			String sql = "SELECT SUM(`Tinh_trang`), SUM(`So_luong`) FROM `sach`";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset

				ResultSet rs = ptmt.executeQuery();
				// mdTableTK.setRowCount(0);
				// mdTableSach.getDataVector().removeAllElements();
				while (rs.next()) {

					tonKho = rs.getString(1);
					txtTonKho.setText(tonKho);
					tongSach = rs.getString(2);
					txtTongSach.setText(tongSach);

					// mdTableTK.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");

		}

	}

	public void TKNXB() {
		if (conn != null) {
			String sql = "SELECT SUM(Tinh_trang), SUM(So_luong) FROM sach WHERE Nha_xb=? ";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset
				ptmt.setString(1, (String) comboBoxNXB.getSelectedItem());
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {

					tonKho = rs.getString(1);
					txtTonKho.setText(tonKho);
					tongSach = rs.getString(2);
					txtTongSach.setText(tongSach);

					// mdTableTK.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");

		}

	}

	public void TKTL() {
		if (conn != null) {
			String sql = "SELECT SUM(Tinh_trang), SUM(So_luong) FROM sach WHERE The_loai=? ";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset
				ptmt.setString(1, (String) comboBoxTheLoai.getSelectedItem());
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {

					tonKho = rs.getString(1);
					txtTonKho.setText(tonKho);
					tongSach = rs.getString(2);
					txtTongSach.setText(tongSach);

					// mdTableTK.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");

		}

	}

	public void TKTG() {
		if (conn != null) {
			String sql = "SELECT SUM(Tinh_trang), SUM(So_luong) FROM sach WHERE Ten_Tac_Gia=? ";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset
				ptmt.setString(1, (String) comboBoxTacGia.getSelectedItem());
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {

					tonKho = rs.getString(1);
					txtTonKho.setText(tonKho);
					tongSach = rs.getString(2);
					txtTongSach.setText(tongSach);

					// mdTableTK.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");

		}

	}

	public void TimMaTV() {
		if (conn != null) {
			// System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM ban_doc WHERE  Ma_TV LIKE '%" + txtTKBD.getText() + "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset

				ResultSet rs = ptmt.executeQuery();
				mdTableBD.setRowCount(0);
				// mdTableSach.getDataVector().removeAllElements();
				while (rs.next()) {

					String rows[] = new String[4];

					rows[0] = rs.getString(1);

					rows[1] = rs.getString(2);

					rows[2] = rs.getString(4);
					rows[3] = rs.getString(9);

					mdTableBD.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");

		}
	}

	public void TimKiemBDoc() {
		if (conn != null) {
			// System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM ban_doc WHERE tinh_thanh LIKE '%" + comboBoxBDoc.getSelectedItem().toString()
					+ "%' ";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset

				ResultSet rs = ptmt.executeQuery();
				mdTableBD.setRowCount(0);
				// mdTableSach.getDataVector().removeAllElements();
				while (rs.next()) {

					String rows[] = new String[4];

					rows[0] = rs.getString(1);

					rows[1] = rs.getString(2);

					rows[2] = rs.getString(4);
					rows[3] = rs.getString(9);

					mdTableBD.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");

		}
	}

	public void comboboxThanhPho() {
		if (conn != null) {
			String sql = "select distinct tinh_thanh from ban_doc Where 1";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset
				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					String tpho = rs.getString("tinh_thanh");
					comboBoxBDoc.addItem(tpho);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");
		}
	}

	public void TimKiemSach() {
		if (conn != null) {
			// System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM sach WHERE Nha_xb LIKE '%" + comboBoxNXB.getSelectedItem().toString() + "%' ";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset

				ResultSet rs = ptmt.executeQuery();
				mdTableSach.setRowCount(0);
				// mdTableSach.getDataVector().removeAllElements();
				while (rs.next()) {

					String rows[] = new String[7];

					rows[0] = rs.getString(1);

					rows[1] = rs.getString(2);

					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(8);
					rows[6] = rs.getString(7);

					mdTableSach.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");

		}
	}

	public void TimKiemSach2() {
		if (conn != null) {
			// System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM sach WHERE Ten_Tac_Gia LIKE '%" + comboBoxTacGia.getSelectedItem().toString()
					+ "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset

				ResultSet rs = ptmt.executeQuery();
				mdTableSach.setRowCount(0);
				// mdTableSach.getDataVector().removeAllElements();
				while (rs.next()) {

					String rows[] = new String[7];

					rows[0] = rs.getString(1);

					rows[1] = rs.getString(2);

					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(8);
					rows[6] = rs.getString(7);

					mdTableSach.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");

		}
	}

	public void TimKiemSach1() {
		if (conn != null) {
			// System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM sach WHERE  The_loai LIKE '%" + comboBoxTheLoai.getSelectedItem().toString()
					+ "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset

				ResultSet rs = ptmt.executeQuery();
				mdTableSach.setRowCount(0);
				// mdTableSach.getDataVector().removeAllElements();
				while (rs.next()) {

					String rows[] = new String[7];

					rows[0] = rs.getString(1);

					rows[1] = rs.getString(2);

					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(8);
					rows[6] = rs.getString(7);

					mdTableSach.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");

		}
	}

	public void comboboxNXB() {
		if (conn != null) {
			String sql = "SELECT DISTINCT `Nha_xb` FROM `sach` WHERE 1";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset
				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					String nxb = rs.getString("Nha_xb");
					comboBoxNXB.addItem(nxb);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");
		}
	}

	public void comboboxTheLoai() {
		if (conn != null) {
			String sql = "SELECT DISTINCT The_loai FROM sach WHERE 1";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset
				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					String tl = rs.getString("The_loai");
					comboBoxTheLoai.addItem(tl);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");
		}
	}

	public void comboboxTacGia() {
		if (conn != null) {
			String sql = "SELECT DISTINCT Ten_Tac_Gia FROM sach WHERE 1";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset
				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					String tg = rs.getString("Ten_Tac_Gia");
					comboBoxTacGia.addItem(tg);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");
		}
	}
	ActionListener evSach = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Sach_UI sach	=	new Sach_UI("Quản lí sách");	
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
	ActionListener evPhieu = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			PhieuMuon_UI phieu	=	new PhieuMuon_UI("Mượn trả sách");	
			phieu.setVisible(true);
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

	public static void main(String[] args) {
		ThongKeUI myUI = new ThongKeUI("Báo cáo & Thống kê");
		myUI.addShowWindow();
	}
}