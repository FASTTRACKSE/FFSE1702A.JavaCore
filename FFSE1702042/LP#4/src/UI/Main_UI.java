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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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

public class Main_UI extends JFrame {
	Connection conn = (Connection) Connect.getConnect();

	JComboBox comboBoxNXB, comboBoxTheLoai, comboBoxTacGia;
	JTextField txtTKBD, txtLook, txtTK;
	JPasswordField jPassword;
	JButton btTKBD, btTKSach, btTKSach1, btTKSach2, btLook, btLogin;

	JScrollPane scrollPaneBD = new JScrollPane();
	JTable tbListBD = new JTable();
	String tbBD[] = { "Mã TV", "Tên sách", "Ngày mượn", "Hạn trả", "Tình trạng" };
	DefaultTableModel mdTableBD = new DefaultTableModel(tbBD, 0);
	// table sach
	JScrollPane scrollPaneSach = new JScrollPane();
	JScrollPane scrollPaneTK = new JScrollPane();
	JTable tbListSach = new JTable();
	JTable tbListTK = new JTable();
	String tbSach[] = { "Mã Sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản", "Tồn kho", "Tổng sách" };

	DefaultTableModel mdTableSach = new DefaultTableModel(tbSach, 0);

	ActionListener evTimKiemMa = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimMaTV();
		}

	};

	ActionListener evTimKiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimKiem();
		}

	};

	ActionListener evTimKiemSach = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimKiemSach();

		}

	};
	ActionListener evTimKiemSach1 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimKiemSach1();

		}

	};

	ActionListener evTimKiemSach2 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimKiemSach2();

		}

	};

	ActionListener evLogin = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (conn != null) {
				String sql = "SELECT * FROM admin WHERE admin=? and Password=?";

				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);

					ptmt.setString(1, txtTK.getText());
					ptmt.setString(2, jPassword.getText());

					ResultSet rs = ptmt.executeQuery();

					if (rs.next()) {

						if (rs.getString("admin").equals("qttv14193") && rs.getString("Password").equals("87172195")) {
							PhieuMuon_UI phieu = new PhieuMuon_UI("Phiếu mượn");
							phieu.setVisible(true);
							dispose();
							JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");

						}
					} else {
						JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu chưa đúng!");
					}
				} catch (SQLException e) {
					System.out.println("loi  " + e.getMessage());

				}
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}

	};

	public Main_UI(String tieude) {
		super(tieude);
		addControls();
		events();
		Display1();
		comboboxNXB();
		comboboxTheLoai();
		comboboxTacGia();
		Display2();
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

		JPanel pnMain1 = new JPanel();
		pnMain1.setLayout(new BoxLayout(pnMain1, BoxLayout.Y_AXIS));
		pnMain1.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel pnTittle = new JPanel();
		JLabel lbTittle = new JLabel("Bạn đọc");
		lbTittle.setForeground(Color.BLUE);
		Font fTittle = new Font("Tahoma", Font.BOLD, 25);
		lbTittle.setFont(fTittle);
		pnTittle.add(lbTittle);

		JPanel pnTimKiemBD = new JPanel();
		JLabel lbBD1 = new JLabel("Mã thành viên:");
		lbBD1.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTKBD = new JTextField();
		txtTKBD.setColumns(15);
		Font fTk = new Font("arial", Font.PLAIN, 15);
		txtTKBD.setFont(fTk);
		btTKBD = new JButton("Tìm kiếm");
		btTKBD.setPreferredSize(new Dimension(100, 20));
		Font fTK = new Font("arial", Font.PLAIN, 12);
		pnTimKiemBD.add(lbBD1);
		pnTimKiemBD.add(txtTKBD);
		pnTimKiemBD.add(btTKBD);

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
		JLabel lbTittle1 = new JLabel("Tìm kiếm sách");
		Font fTittle1 = new Font("Tahoma", Font.BOLD, 25);
		lbTittle1.setForeground(Color.BLUE);
		lbTittle1.setFont(fTittle1);
		pnTittle1.add(lbTittle1);

		JPanel pnLook = new JPanel();
		txtLook = new JTextField(45);
		btLook = new JButton("Tìm sách");
		pnLook.add(txtLook);
		pnLook.add(btLook);

		JPanel pnTimKiemSach = new JPanel();

		JPanel pnNXB = new JPanel();
		Border nxb = BorderFactory.createLineBorder(Color.RED);
		TitledBorder nxbTittle = BorderFactory.createTitledBorder(nxb);
		pnNXB.setBorder(nxbTittle);
		JLabel lbSach = new JLabel("Nhà xuất bản:");
		lbSach.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxNXB = new JComboBox();
		comboBoxNXB.setFont(new Font("Arial", Font.PLAIN, 12));
		btTKSach = new JButton("Tìm kiếm");
		btTKSach.setPreferredSize(new Dimension(100, 20));

		pnNXB.add(lbSach);
		pnNXB.add(comboBoxNXB);
		pnNXB.add(btTKSach);

		JPanel pnTL = new JPanel();
		Border tl = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTL = BorderFactory.createTitledBorder(tl);
		pnTL.setBorder(borderTL);
		JLabel lbSach1 = new JLabel("Thể lọai:");
		lbSach1.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxTheLoai = new JComboBox();

		comboBoxTheLoai.setFont(new Font("Arial", Font.PLAIN, 12));
		btTKSach1 = new JButton("Tìm kiếm");
		btTKSach1.setPreferredSize(new Dimension(100, 20));
		pnTL.add(lbSach1);
		pnTL.add(comboBoxTheLoai);
		pnTL.add(btTKSach1);

		JPanel pnTG = new JPanel();
		Border tg = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTG = BorderFactory.createTitledBorder(tg);
		pnTG.setBorder(borderTG);
		JLabel lbSach2 = new JLabel("Tác Giả:");
		lbSach2.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxTacGia = new JComboBox();

		comboBoxTacGia.setFont(new Font("Arial", Font.PLAIN, 12));
		btTKSach2 = new JButton("Tìm kiếm");
		btTKSach2.setPreferredSize(new Dimension(100, 20));
		pnTG.add(lbSach2);
		pnTG.add(comboBoxTacGia);
		pnTG.add(btTKSach2);

		pnTimKiemSach.add(pnNXB);
		pnTimKiemSach.add(pnTL);
		pnTimKiemSach.add(pnTG);

		Font fTkSach = new Font("arial", Font.PLAIN, 15);

		JPanel pnTableSach = new JPanel();
		pnTableSach.setLayout(new BoxLayout(pnTableSach, BoxLayout.Y_AXIS));

		// scrollPaneSach.setPreferredSize(new Dimension(400, 170));
		Border border1 = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTittle1 = BorderFactory.createTitledBorder(border1, "Danh sách");
		scrollPaneSach.setBorder(borderTittle1);
		tbListSach.setModel(mdTableSach);
		scrollPaneSach.setViewportView(tbListSach);
		pnTableSach.add(scrollPaneSach);

		pnMain2.add(pnTittle1);
		pnMain2.add(pnLook);
		pnMain2.add(pnTimKiemSach);
		pnMain2.add(pnTableSach);

		// Main3

		JPanel pnMain3 = new JPanel();
		pnMain3.setLayout(new BoxLayout(pnMain3, BoxLayout.Y_AXIS));
		pnMain3.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel pnTittle3 = new JPanel();
		JLabel lbTittle3 = new JLabel("DÀNH CHO NGƯỜI QUẢN TRỊ THƯ VIỆN!");
		Font fTittle3 = new Font("Tahoma", Font.BOLD, 25);
		lbTittle3.setForeground(Color.RED);
		lbTittle3.setFont(fTittle3);
		pnTittle3.add(lbTittle3);

		JPanel pnTK = new JPanel();
		JLabel lbTK = new JLabel("Username:	");
		txtTK = new JTextField();
		Font fTK1 = new Font("arial", Font.PLAIN, 15);
		lbTK.setFont(fTK1);
		txtTK.setColumns(17);
		pnTK.add(lbTK);
		pnTK.add(txtTK);

		JPanel pnMK = new JPanel();
		JLabel lbMK = new JLabel("Password:	");
		jPassword = new JPasswordField();
		Font fMK = new Font("arial", Font.PLAIN, 15);
		lbMK.setFont(fMK);
		jPassword.setColumns(17);
		pnMK.add(lbMK);
		pnMK.add(jPassword);

		JPanel pnLogin = new JPanel();
		btLogin = new JButton("Đăng Nhập");
		pnLogin.add(btLogin);

		pnMain3.add(pnTittle3);
		pnMain3.add(pnTK);
		pnMain3.add(pnMK);
		pnMain3.add(pnLogin);

		JTab.add("Tìm kiếm sách", pnMain2);
		JTab.add("Tìm kiếm bạn đọc", pnMain1);
		JTab.add("Admin", pnMain3);

		con.add(JTab);

	}

	public void events() {
		btLook.addActionListener(evTimKiem);
		btTKBD.addActionListener(evTimKiemMa);
		btTKSach.addActionListener(evTimKiemSach);
		btTKSach1.addActionListener(evTimKiemSach1);
		btTKSach2.addActionListener(evTimKiemSach2);
		btLogin.addActionListener(evLogin);
	}

	private void Display1() {
		// TODO Auto-generated method stub
		if (conn != null) {
			String sql = "SELECT `ma_TV`, sach.Ten_Sach,`Ngay_Muon`,`Han_Tra`,phieu_muon.Tinh_Trang"
					+ " FROM `phieu_muon`INNER JOIN sach ON phieu_muon.Ma_Sach = sach.Ma_Sach ";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset

				ResultSet rs = ptmt.executeQuery();
				mdTableBD.setRowCount(0);

				while (rs.next()) {

					String rows[] = new String[5];

					rows[0] = rs.getString(1);
					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);

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

	public void TimKiem() {
		if (conn != null) {

			String sql = "SELECT * from sach WHERE Ma_Sach like N'%" + this.txtLook.getText() + "%' "
					+ "or Ten_Sach like N'%" + this.txtLook.getText() + "%'" + "or Ten_Tac_gia like N'%"
					+ this.txtLook.getText() + "%'" + "or Nha_Xb like N'%" + this.txtLook.getText() + "%'"
					+ "or The_loai like N'%" + this.txtLook.getText() + "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				mdTableSach.setRowCount(0);
				ResultSet rs = ptmt.executeQuery();
				// mdTableSach.getDataVector().removeAllElements();
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

	public void TimMaTV() {
		if (conn != null) {
			String sql = "SELECT `ma_TV`, sach.Ten_Sach,`Ngay_Muon`,`Han_Tra`,phieu_muon.Tinh_Trang FROM `phieu_muon`INNER JOIN sach ON phieu_muon.Ma_Sach = sach.Ma_Sach WHERE  ma_TV LIKE '%"
					+ txtTKBD.getText() + "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// kh?i t?o resultset

				ResultSet rs = ptmt.executeQuery();
				mdTableBD.setRowCount(0);

				while (rs.next()) {

					String rows[] = new String[5];

					rows[0] = rs.getString(1);
					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);

					mdTableBD.addRow(rows);
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

	public static void main(String[] args) {
		Main_UI myUI = new Main_UI("THƯ VIỆN ĐIỆN TỬ CỦA TÙNG");
		myUI.addShowWindow();
	}
}