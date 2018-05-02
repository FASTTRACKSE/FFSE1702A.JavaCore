package ffse;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import model.KetNoiSQL;

import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class DS_SinhVien extends JPanel {

	// private static final long serialVersionUID = 1L;

	// khai báo
	int Id;
	private JTextField txtmaSV, txtid, txthoten, txtngaysinh, txtsdt, txtemail, txtnamhoc;
	private JPanel pnLeft, pnRight, pnLeftTop, pnLeftBot, pnRightTop, pnRightBot, pnRightBot1, pnRightBot2, pnRightBot3,pnRightBot4;
	private JLabel lbloc, space, lbtieude, id, masvLB, hoten, lop, ngaysinh, sdt, diachi, email, namhoc;
	private JTable table;
	private JComboBox boxlop, boxnamhoc, boxlop1, boxtinh, boxhuyen, boxxa;
	private PlaceholderTextField txtchitiet;
	private JButton btnHien, bttim, reset, lbadd, lbupdate, lbdelete;
	String ma_q;
	DefaultTableModel model;
	ImageIcon update, delete, add, check, reseticon;
	Connection conn = KetNoiSQL.getConnect("localhost", "ffse1702029", "ffse1702029", "12345");

	public DS_SinhVien() {
		addPanels();
		addEvents();
	}

	// chọn dữ liệu từ bảng
	MouseAdapter event = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = table.getSelectedRow();
			String[] row = new String[12];
			for (int j = 0; j < 12; j++) {
				row[j] = (String) table.getValueAt(i, j);
			}
			String ID = row[0];
			Id = Integer.parseInt(ID);
			txtid.setText(row[1]);
			txthoten.setText(row[2]);
			boxlop1.setSelectedItem(row[3]);
			txtngaysinh.setText(row[4]);
			boxtinh.setSelectedItem(row[5]);
			boxhuyen.setSelectedItem(row[6]);
			boxxa.setSelectedItem(row[7]);
			txtchitiet.setText(row[8]);
			txtsdt.setText(row[9]);
			txtemail.setText(row[10]);
			txtnamhoc.setText(row[11]);
		}
	};

	// load data
	private void loadData() {
		String[] col = { "id", "Mã số sinh viên", "Họ & Tên", "Lớp", "Ngày sinh", "Tỉnh, Thành Phố", "Quận, huyện",
				"Xã, phường", "Địa chỉ chi tiết", "Số điện thoại", "Email","năm học" };
		String sql = "SELECT * FROM `admin`";
		ResultSet rs = null;
		java.sql.Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			model = new DefaultTableModel(col, 0);

			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("ID"));
				v.add(rs.getString("Masv"));
				v.add(rs.getString("Name"));
				v.add(rs.getString("Lop"));
				v.add(rs.getString("Ngaysinh"));
				v.add(rs.getString("Tinh"));
				v.add(rs.getString("Huyen"));
				v.add(rs.getString("xa"));
				v.add(rs.getString("DiaChi"));
				v.add(rs.getString("Phone"));
				v.add(rs.getString("Email"));
				v.add(rs.getString("nam_hoc"));
				model.addRow(v);
			}
			// Ẩn cột
			table.setModel(model);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			table.getColumnModel().getColumn(6).setMinWidth(0);
			table.getColumnModel().getColumn(6).setMaxWidth(0);
			table.getColumnModel().getColumn(7).setMinWidth(0);
			table.getColumnModel().getColumn(7).setMaxWidth(0);
			table.getColumnModel().getColumn(11).setMinWidth(50);
			table.getColumnModel().getColumn(11).setMaxWidth(50);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addPanels() {
		JPanel pnMain = new JPanel();
		this.add(pnMain);

		/* Panel Main */
		pnLeft = new JPanel();
		pnRight = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
		pnMain.add(pnLeft);
		pnMain.add(pnRight);

		/* Panel Main* - Left */

		pnLeftTop = new JPanel();
		pnLeftBot = new JPanel();

		pnLeftTop.setBackground(SystemColor.activeCaption);
		pnLeftTop.setBorder(new CompoundBorder());
		pnLeftTop.setLayout(new BoxLayout(pnLeftTop, BoxLayout.Y_AXIS));

		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		pnLeft.add(pnLeftTop);
		pnLeft.add(pnLeftBot);

		// lable lọc dữ liệu
		lbloc = new JLabel("Lọc Dữ Liệu");
		lbloc.setBorder(new EmptyBorder(50, 10, 10, 60));
		lbloc.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnLeftTop.add(lbloc);
		pnLeftTop.add(Box.createVerticalStrut(15));

		// combobox năm học
		boxnamhoc = new JComboBox();
		boxnamhoc.setModel(new DefaultComboBoxModel(new String[] { "--năm học--", "2017", "2018" }));
		pnLeftTop.add(boxnamhoc);
		pnLeftTop.add(Box.createVerticalStrut(15));

		// combobox lớp
		boxlop = new JComboBox();
		boxlop.setModel(new DefaultComboBoxModel(new String[] { "--lớp--", "FFSE1701", "FFSE1702" }));
		pnLeftTop.add(boxlop);
		pnLeftTop.add(Box.createVerticalStrut(15));
		// nút hiển thị
		btnHien = new JButton("Hiển Thị");
		pnLeftTop.add(btnHien);
		pnLeftTop.add(Box.createVerticalStrut(15));

		// lable mã sinh viên
		masvLB = new JLabel();
		masvLB.setText("Mã sinh viên");
		pnLeftTop.add(masvLB);

		// textfield mã sv
		txtmaSV = new JTextField();
		pnLeftTop.add(txtmaSV);
		pnLeftTop.setVisible(true);
		pnLeftTop.add(Box.createVerticalStrut(5));

		// nút tìm
		bttim = new JButton("Tìm");
		pnLeftTop.add(bttim);
		bttim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String masv = txtmaSV.getText();
				String sql = "SELECT * FROM `admin` WHERE Masv='" + masv + "'";
				ResultSet rs = null;
				java.sql.Statement st = null;
				try {
					st = conn.createStatement();
					rs = st.executeQuery(sql);
					model.setRowCount(0);

					while (rs.next()) {
						Vector v = new Vector();
						v.add(rs.getString("ID"));
						v.add(rs.getString("Masv"));
						v.add(rs.getString("Name"));
						v.add(rs.getString("Lop"));
						v.add(rs.getString("Ngaysinh"));
						v.add(rs.getString("Tinh"));
						v.add(rs.getString("Huyen"));
						v.add(rs.getString("xa"));
						v.add(rs.getString("DiaChi"));
						v.add(rs.getString("Phone"));
						v.add(rs.getString("Email"));
						v.add(rs.getString("nam_hoc"));
						model.addRow(v);
					}
					table.setModel(model);

				} catch (Exception ex) {

				}
			}
		});

		// khoảng trống
		space = new JLabel("");
		space.setBorder(new EmptyBorder(10, 10, 280, 10));
		pnLeftTop.add(space);
		pnLeftTop.add(Box.createVerticalStrut(20));

		/* Panel Main* - Right */
		pnRightTop = new JPanel();
		pnRightTop.setBackground(SystemColor.scrollbar);
		pnRightTop.setBorder(new EmptyBorder(1, 1, 1, 1));

		pnRightBot = new JPanel();
		pnRightBot.setBackground(SystemColor.inactiveCaptionBorder);
		pnRightBot.setBorder(new BevelBorder(BevelBorder.LOWERED));

		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		pnRight.add(pnRightTop);
		pnRight.add(pnRightBot);

		/* Panel Main* - Right - Top */
		pnRightTop.setLayout(new BoxLayout(pnRightTop, BoxLayout.Y_AXIS));

		// lable tiêu đề
		lbtieude = new JLabel("Danh Sách Sinh Viên");
		lbtieude.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightTop.add(lbtieude);

		// bảng danh sách sinh viên
		table = new JTable();
		String[] col = { "id", "Mã số sinh viên", "Họ & Tên", "Lớp", "Ngày sinh", "Tỉnh, Thành Phố", "Quận, huyện",
				"Xã, phường", "Địa chỉ chi tiết", "Số điện thoại", "Email", "năm học" };
		String sql = "SELECT * FROM `admin`";
		ResultSet rs = null;
		java.sql.Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			model = new DefaultTableModel(col, 0);

			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("ID"));
				v.add(rs.getString("Masv"));
				v.add(rs.getString("Name"));
				v.add(rs.getString("Lop"));
				v.add(rs.getString("Ngaysinh"));
				v.add(rs.getString("Tinh"));
				v.add(rs.getString("Huyen"));
				v.add(rs.getString("xa"));
				v.add(rs.getString("DiaChi"));
				v.add(rs.getString("Phone"));
				v.add(rs.getString("Email"));
				v.add(rs.getString("nam_hoc"));
				model.addRow(v);
			}
			table.setModel(model);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			table.getColumnModel().getColumn(6).setMinWidth(0);
			table.getColumnModel().getColumn(6).setMaxWidth(0);
			table.getColumnModel().getColumn(7).setMinWidth(0);
			table.getColumnModel().getColumn(7).setMaxWidth(0);
			table.getColumnModel().getColumn(11).setMinWidth(50);
			table.getColumnModel().getColumn(11).setMaxWidth(50);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		JScrollPane sp = new JScrollPane(table);
		pnRightTop.add(sp);

		/* Panel Main* - Right - Bot */

		pnRightBot.setLayout(new BoxLayout(pnRightBot, BoxLayout.Y_AXIS));

		pnRightBot1 = new JPanel();
		pnRightBot2 = new JPanel();
		pnRightBot3 = new JPanel();
		pnRightBot4 = new JPanel();

		pnRightBot1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		pnRightBot2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		pnRightBot3.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		pnRightBot4.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));

		pnRightBot.add(pnRightBot1);
		pnRightBot.add(pnRightBot2);
		pnRightBot.add(pnRightBot3);
		pnRightBot.add(pnRightBot4);

		id = new JLabel("Mã sinh viên:");
		id.setPreferredSize(new Dimension(115, 20));
		id.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(id);

		txtid = new JTextField();
		pnRightBot1.add(txtid);
		txtid.setColumns(10);

		hoten = new JLabel("Họ và Tên:");
		hoten.setPreferredSize(new Dimension(115, 20));
		hoten.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(hoten);

		txthoten = new JTextField();
		pnRightBot1.add(txthoten);
		txthoten.setColumns(10);

		lop = new JLabel("Lớp:");
		lop.setPreferredSize(new Dimension(40, 20));
		lop.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(lop);

		boxlop1 = new JComboBox();
		boxlop1.setModel(new DefaultComboBoxModel(new String[] { "--lớp--", "FFSE1701", "FFSE1702" }));
		pnRightBot1.add(boxlop1);
		
		namhoc = new JLabel("Năm học:");
		namhoc.setPreferredSize(new Dimension(70, 20));
		namhoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot1.add(namhoc);

		txtnamhoc = new JTextField();
		pnRightBot1.add(txtnamhoc);
		txtnamhoc.setColumns(10);

		ngaysinh = new JLabel("Ngày sinh:");
		ngaysinh.setPreferredSize(new Dimension(115, 20));
		ngaysinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot2.add(ngaysinh);

		txtngaysinh = new JTextField();
		pnRightBot2.add(txtngaysinh);
		txtngaysinh.setColumns(10);

		sdt = new JLabel("Số điện thoại:");
		sdt.setPreferredSize(new Dimension(115, 20));
		sdt.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot2.add(sdt);

		txtsdt = new JTextField();
		pnRightBot2.add(txtsdt);
		txtsdt.setColumns(10);

		email = new JLabel("email:");
		email.setPreferredSize(new Dimension(40, 20));
		email.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot2.add(email);

		txtemail = new JTextField();
		pnRightBot2.add(txtemail);
		txtemail.setColumns(10);

		diachi = new JLabel("Địa chỉ:");
		diachi.setPreferredSize(new Dimension(115, 20));
		diachi.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnRightBot3.add(diachi);

		// lấy dữ liệu từ database về
		boxtinh = new JComboBox();
		boxtinh.setModel(new DefaultComboBoxModel(new String[] { "--Tỉnh, TP--" }));
		String tinh_sql = "SELECT Ten_tinh FROM tinh";
		ResultSet tinh_rs = null;
		java.sql.Statement tinh_st = null;
		try {
			tinh_st = conn.createStatement();
			tinh_rs = tinh_st.executeQuery(tinh_sql);
			while (tinh_rs.next()) {
				boxtinh.addItem(tinh_rs.getString(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		pnRightBot3.add(boxtinh);

		// huyen
		boxhuyen = new JComboBox();
		boxhuyen.setModel(new DefaultComboBoxModel(new String[] { "--Quận, Huyện--" }));
		boxtinh.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					boxhuyen.removeAllItems();
					String huyen_sql = "SELECT * FROM `huyen` INNER JOIN tinh WHERE huyen.Ma_tinh=tinh.Ma_tinh  AND tinh.Ten_tinh = '"
							+ boxtinh.getItemAt(boxtinh.getSelectedIndex()) + "'";
					ResultSet huyen_rs = null;
					java.sql.Statement huyen_st = null;
					try {
						huyen_st = conn.createStatement();
						huyen_rs = huyen_st.executeQuery(huyen_sql);
						while (huyen_rs.next()) {
							boxhuyen.addItem(huyen_rs.getString(2));
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {

				}
			}
		});
		pnRightBot3.add(boxhuyen);

		// xa
		boxxa = new JComboBox();
		boxxa.setModel(new DefaultComboBoxModel(new String[] { "--Xã,Phường--" }));
		boxhuyen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					boxxa.removeAllItems();
					String xa_sql = "SELECT * FROM `xa_phuong` INNER JOIN huyen WHERE xa_phuong.Ma_huyen=huyen.Ma_huyen  AND huyen.Ten_huyen = '"
							+ boxhuyen.getItemAt(boxhuyen.getSelectedIndex()) + "'";
					ResultSet xa_rs = null;
					java.sql.Statement xa_st = null;
					try {
						xa_st = conn.createStatement();
						xa_rs = xa_st.executeQuery(xa_sql);
						while (xa_rs.next()) {
							boxxa.addItem(xa_rs.getString(2));
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {

				}
			}
		});
		pnRightBot3.add(boxxa);

		txtchitiet = new PlaceholderTextField();
		txtchitiet.setPlaceholder("--địa chỉ chi tiết--");
		pnRightBot3.add(txtchitiet);
		txtchitiet.setColumns(15);

		
		space = new JLabel("");
		space.setPreferredSize(new Dimension(300, 20));
		pnRightBot4.add(space);
		// nút thêm
		add = new ImageIcon(new ImageIcon("add.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		lbadd = new JButton("Thêm  ", add);
		lbadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sqlCommand = "INSERT INTO admin (`Masv`, `Name`, `Lop`, `Ngaysinh`, `Phone`, Email, `Tinh`, `Huyen`, `xa`, DiaChi, nam_hoc) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?)";
				PreparedStatement pst = null;
				try {
					pst = (PreparedStatement) conn.prepareStatement(sqlCommand);
					pst.setString(1, txtid.getText());
					pst.setString(2, txthoten.getText());
					pst.setString(3, (String) boxlop1.getSelectedItem());
					pst.setString(4, txtngaysinh.getText());
					pst.setString(5, txtsdt.getText());
					pst.setString(6, txtemail.getText());
					pst.setString(7, (String) boxtinh.getSelectedItem());
					pst.setString(8, (String) boxhuyen.getSelectedItem());
					pst.setString(9, (String) boxxa.getSelectedItem());
					pst.setString(10, txtchitiet.getText());
					pst.setString(11, txtnamhoc.getText());
					if (pst.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "Thêm thành công", "Thêm học sinh",
								JOptionPane.PLAIN_MESSAGE, check);
						model.setRowCount(0);
						loadData();
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi khi thêm ", "Thêm học sinh", JOptionPane.PLAIN_MESSAGE,
								delete);
					}
				} catch (SQLException e) {
					System.out.println("insert error \n" + e.toString());
				}
			}
		});
		pnRightBot4.add(lbadd);

		// nút sửa
		check = new ImageIcon(new ImageIcon("check.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		update = new ImageIcon(new ImageIcon("update.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		lbupdate = new JButton("Sửa  ", update);
		lbupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sqlupdate = "UPDATE admin SET `Masv`=?, `Name`=?, `Lop`=?, `Ngaysinh`=?, `Phone`=?, `Email`=?, `Tinh`=?, `Huyen`=?, `xa`=?, `DiaChi`=?, nam_hoc=? WHERE ID="
						+ Id;
				PreparedStatement pst = null;
				try {
					pst = (PreparedStatement) conn.prepareStatement(sqlupdate);
					pst.setString(1, txtid.getText());
					pst.setString(2, txthoten.getText());
					pst.setString(3, (String) boxlop1.getSelectedItem());
					pst.setString(4, txtngaysinh.getText());
					pst.setString(5, txtsdt.getText());
					pst.setString(6, txtemail.getText());
					pst.setString(7, (String) boxtinh.getSelectedItem());
					pst.setString(8, (String) boxhuyen.getSelectedItem());
					pst.setString(9, (String) boxxa.getSelectedItem());
					pst.setString(10, txtchitiet.getText());
					pst.setString(11, txtnamhoc.getText());
					if (pst.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "sửa thành công", "sửa học sinh", JOptionPane.PLAIN_MESSAGE,
								check);
						model.setRowCount(0);
						loadData();
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi khi sửa ", "sửa học sinh", JOptionPane.PLAIN_MESSAGE,
								delete);
					}
				} catch (SQLException e) {
					System.out.println("insert error \n" + e.toString());
				}
			}
		});
		pnRightBot4.add(lbupdate);

		delete = new ImageIcon(new ImageIcon("delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		lbdelete = new JButton("Xóa  ", delete);
		lbdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sqldelete = "DELETE FROM `admin` WHERE ID=" + Id;
				PreparedStatement pst = null;
				try {
					pst = (PreparedStatement) conn.prepareStatement(sqldelete);
					int n = JOptionPane.showConfirmDialog(lbdelete, "Bạn thật sự muốn xóa?", "Xóa",
							JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION)
						if (pst.executeUpdate() > 0) {
							JOptionPane.showMessageDialog(null, "Xóa thành công", "xóa", JOptionPane.PLAIN_MESSAGE,
									check);
							loadData();

						} else {
							JOptionPane.showMessageDialog(null, "Lỗi khi xóa", "xóa", JOptionPane.PLAIN_MESSAGE,
									delete);
						}
				} catch (SQLException e) {
					System.out.println("delete error \n" + e.toString());
				}
			}

		});
		pnRightBot4.add(lbdelete);

		reseticon = new ImageIcon(new ImageIcon("reset.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		reset = new JButton("reset", reseticon);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtid.setText(null);
				txthoten.setText(null);
				txtngaysinh.setText(null);
				txtmaSV.setText(null);
				txtsdt.setText(null);
				txtchitiet.setText(null);
				txtemail.setText(null);
				boxlop1.setModel(new DefaultComboBoxModel(new String[] { "--lớp--", "FFSE1701", "FFSE1702" }));
				boxtinh.setModel(new DefaultComboBoxModel(new String[] { "--Tỉnh,TP--", "TP.Đà Nẵng", "Quảng Nam" }));
				boxhuyen.setModel(new DefaultComboBoxModel(new String[] { "--Huyện,Quận--" }));
				boxxa.setModel(new DefaultComboBoxModel(new String[] { "--Xã,Phường--" }));
				boxnamhoc.setModel(new DefaultComboBoxModel(new String[] { "--năm học--", "2017", "2018" }));
				boxlop.setModel(new DefaultComboBoxModel(new String[] { "--lớp--", "FFSE1701", "FFSE1702" }));
				txtnamhoc.setText(null);
				loadData();
			}
		});
		pnRightBot4.add(reset);

	}

	public void addEvents() {
		btnHien.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String namhoc = boxnamhoc.getSelectedItem().toString();
				String lop = boxlop.getSelectedItem().toString();

				String sql = "SELECT * FROM `admin` WHERE nam_hoc='" + namhoc + "' and Lop='" + lop + "'";
				ResultSet rs = null;
				java.sql.Statement st = null;
				try {
					st = conn.createStatement();
					rs = st.executeQuery(sql);
					model.setRowCount(0);

					while (rs.next()) {
						Vector v = new Vector();
						v.add(rs.getString("ID"));
						v.add(rs.getString("Masv"));
						v.add(rs.getString("Name"));
						v.add(rs.getString("Lop"));
						v.add(rs.getString("Ngaysinh"));
						v.add(rs.getString("Tinh"));
						v.add(rs.getString("Huyen"));
						v.add(rs.getString("xa"));
						v.add(rs.getString("DiaChi"));
						v.add(rs.getString("Phone"));
						v.add(rs.getString("Email"));
						v.add(rs.getString("nam_hoc"));
						model.addRow(v);

					}

					table.setModel(model);

				} catch (Exception ex) {

				}
			}
		});
		table.addMouseListener(event);

	}

}
