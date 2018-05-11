package Process;

import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Data.Connect;
import Data.quan;

public class ThongKeUI extends JPanel {
	Connect cn = new Connect();
	Connection conn = (Connection) Connect.getConnect();
	JComboBox comboBoxBDoc, comboBoxNXB, comboBoxTheLoai, comboBoxTacGia;
	JTextField txtTKBD, txtTKSach, txttonKho, txttongKho;
	JButton jbTKBD, jbTKSach,jbThoat;

	// tabel Ban doc
	JScrollPane scrollPaneBD = new JScrollPane();
	JTable tbListBD = new JTable();
	String tbBD[] = { "Mã TV", "Tên", "Thành Phố", "Số sách mượn" };
	DefaultTableModel mdTableBD = new DefaultTableModel(tbBD, 0);
	// table sach
	JScrollPane scrollPaneSach = new JScrollPane();
	JTable tbListSach = new JTable();
	String tbSach[] = { "Mã Sách", "Tên sách", "Tác gỉa", "Tồn kho", "Tổng sách" };
	DefaultTableModel mdTableSach = new DefaultTableModel(tbSach, 0);
	ActionListener evTimKiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimKiemBDoc();
		}

	};
	ActionListener evTimKiemSach = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimKiemSach();
		}

	};

	public ThongKeUI() {
		controls();
		KhoSach();
		events();
		comboboxThanhPho();
		comboboxNXB();
		comboboxTheLoai();
		comboboxTacGia();
		
	}

	private void controls() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnMain1 = new JPanel();
		pnMain1.setLayout(new BoxLayout(pnMain1, BoxLayout.Y_AXIS));
		JPanel pnTittle = new JPanel();
		JLabel lbTittle = new JLabel("Báo cáo danh sách bạn đọc");
		Font fTittle = new Font("arial", Font.BOLD, 20);
		lbTittle.setFont(fTittle);
		pnTittle.add(lbTittle);

		JPanel pnTimKiemBD = new JPanel();
		JLabel lbBD = new JLabel("Thành Phố:");
		lbBD.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxBDoc = new JComboBox();
		comboBoxBDoc.setPreferredSize(new Dimension(150, 20));

		comboBoxBDoc.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxBDoc.setToolTipText("");
		pnTimKiemBD.add(lbBD);
		pnTimKiemBD.add(comboBoxBDoc);

		txtTKBD = new JTextField();
		txtTKBD.setColumns(15);
		Font fTk = new Font("arial", Font.PLAIN, 15);
		txtTKBD.setFont(fTk);
		jbTKBD = new JButton("Tìm kiếm");
		jbTKBD.setPreferredSize(new Dimension(100, 20));
		Font fTK = new Font("arial", Font.PLAIN, 12);
		pnTimKiemBD.add(txtTKBD);
		pnTimKiemBD.add(jbTKBD);

		JPanel pnTableBD = new JPanel();
		pnTableBD.setLayout(new BoxLayout(pnTableBD, BoxLayout.Y_AXIS));

		scrollPaneBD.setPreferredSize(new Dimension(400, 153));
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh sách Bạn Đọc");
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
		JPanel pnTittle1 = new JPanel();
		JLabel lbTittle1 = new JLabel("Báo cáo Sách");
		Font fTittle1 = new Font("arial", Font.BOLD, 20);
		lbTittle1.setFont(fTittle1);
		pnTittle1.add(lbTittle1);

		JPanel pnTimKiemSach = new JPanel();
		JLabel lbSach = new JLabel("Nhà Xuất Bản:");
		lbSach.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxNXB = new JComboBox();
		comboBoxNXB.setPreferredSize(new Dimension(110, 20));
		comboBoxNXB.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxNXB.setToolTipText("");
		pnTimKiemSach.add(lbSach);
		pnTimKiemSach.add(comboBoxNXB);

		JLabel lbSach1 = new JLabel("Thể Loại:");
		lbSach1.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxTheLoai = new JComboBox();
		comboBoxTheLoai.setPreferredSize(new Dimension(110, 20));
		comboBoxTheLoai.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxTheLoai.setToolTipText("");
		pnTimKiemSach.add(lbSach1);
		pnTimKiemSach.add(comboBoxTheLoai);

		JLabel lbSach2 = new JLabel("Tác Giả:");
		lbSach2.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxTacGia = new JComboBox();
		comboBoxTacGia.setPreferredSize(new Dimension(110, 20));
		comboBoxTacGia.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxTacGia.setToolTipText("");
		pnTimKiemSach.add(lbSach2);
		pnTimKiemSach.add(comboBoxTacGia);

		Font fTkSach = new Font("arial", Font.PLAIN, 15);

		jbTKSach = new JButton("Tìm kiếm");
		jbTKSach.setPreferredSize(new Dimension(100, 20));
		Font fTKSach = new Font("arial", Font.PLAIN, 12);

		pnTimKiemSach.add(jbTKSach);

		JPanel pnKho = new JPanel();
		JLabel lbkho = new JLabel("Sách tồn kho");
		lbkho.setFont(new Font("Arial", Font.PLAIN, 15));
		txttonKho = new JTextField();
		txttonKho.setColumns(5);
		txttonKho.setEditable(false);
		Font fkho = new Font("arial", Font.PLAIN, 15);
		txttonKho.setFont(fkho);

		JLabel lbkho1 = new JLabel("Tổng Sách");
		lbkho1.setFont(new Font("Arial", Font.PLAIN, 15));
		txttongKho = new JTextField();
		txttongKho.setColumns(5);
		txttongKho.setEditable(false);
		Font fkho1 = new Font("arial", Font.PLAIN, 15);
		txttongKho.setFont(fkho1);
		pnKho.add(lbkho);
		pnKho.add(txttonKho);
		pnKho.add(lbkho1);
		pnKho.add(txttongKho);

		JPanel pnTableSach = new JPanel();
		pnTableSach.setLayout(new BoxLayout(pnTableSach, BoxLayout.Y_AXIS));

		scrollPaneSach.setPreferredSize(new Dimension(400, 153));
		Border border1 = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTittle1 = BorderFactory.createTitledBorder(border1, "Danh sách Bạn Đọc");
		scrollPaneSach.setBorder(borderTittle1);
		tbListSach.setModel(mdTableSach);
		scrollPaneSach.setViewportView(tbListSach);
		pnTableSach.add(scrollPaneSach);

		pnMain2.add(pnTittle1);
		pnMain2.add(pnTimKiemSach);
		pnMain2.add(pnKho);
		pnMain2.add(pnTableSach);

		JPanel pnThoat = new JPanel();
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
		pnThoat.add(jbThoat);
		
		pnMain.add(pnMain1);
		pnMain.add(pnMain2);
		pnMain.add(pnThoat);
		
		this.add(pnMain);

	}

	public void events() {
		jbTKBD.addActionListener(evTimKiem);
		jbTKSach.addActionListener(evTimKiemSach);
	}

	public void TimKiemBDoc() {
		if (conn != null) {
			// System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM BanDoc WHERE tinh LIKE '%" + comboBoxBDoc.getSelectedItem().toString()
					+ "%' and Matv LIKE '%" + txtTKBD.getText() + "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset

				ResultSet rs = ptmt.executeQuery();
				mdTableBD.setRowCount(0);
				// mdTableSach.getDataVector().removeAllElements();
				while (rs.next()) {

					String rows[] = new String[4];

					rows[0] = rs.getString(2);

					rows[1] = rs.getString(3);

					rows[2] = rs.getString(6);
					rows[3] = rs.getString(10);

					mdTableBD.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	public void comboboxThanhPho() {
		if (conn != null) {
			String sql = "select * from devvn_tinhthanhpho";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					String tpho = rs.getString("name");
					comboBoxBDoc.addItem(tpho);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public void TimKiemSach() {
		if (conn != null) {
			// System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM QuanLy_Sach WHERE nha_xb LIKE '%" + comboBoxNXB.getSelectedItem().toString()
					+ "%' and the_loai LIKE '%" + comboBoxTheLoai.getSelectedItem().toString() + "%'and tac_gia LIKE '%"
					+ comboBoxTacGia.getSelectedItem().toString() + "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset

				ResultSet rs = ptmt.executeQuery();
				mdTableSach.setRowCount(0);
				// mdTableSach.getDataVector().removeAllElements();
				while (rs.next()) {

					String rows[] = new String[5];

					rows[0] = rs.getString(2);

					rows[1] = rs.getString(3);

					rows[2] = rs.getString(4);
					rows[3] = rs.getString(7);
					rows[4] = rs.getString(9);

					mdTableSach.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	public void comboboxNXB() {
		if (conn != null) {
			String sql = "select distinct nha_xb from QuanLy_Sach";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					String nxb = rs.getString("nha_xb");
					comboBoxNXB.addItem(nxb);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public void comboboxTheLoai() {
		if (conn != null) {
			String sql = "select * from The_Loại";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					String tl = rs.getString("the_loai");
					comboBoxTheLoai.addItem(tl);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public void comboboxTacGia() {
		if (conn != null) {
			String sql = "select  distinct tac_gia from QuanLy_Sach";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					String tg = rs.getString("tac_gia");
					comboBoxTacGia.addItem(tg);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public void KhoSach() {
		if (conn != null) {
			String sql = "SELECT SUM(so_luong_s), SUM(tong_sach) FROM QuanLy_Sach";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);

				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					txttonKho.setText(rs.getString(1));
					txttongKho.setText(rs.getString(2));
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối thất bại");

		}

	}
}
