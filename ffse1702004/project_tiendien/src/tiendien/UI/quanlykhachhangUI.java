package tiendien.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
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
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import tiendien.MODEL.ExceptionMD;
import tiendien.MODEL.database;

public class quanlykhachhangUI extends JFrame {
	Connection conn = database.getConnect("localhost", "quanlytiendien", "quanlytiendien", "quanlytiendien");
	ResultSet res;
	Statement stm;
	int x;
	String tenQuan, id, key_mct, sql, id_cus;
	JTextField text_search, text_makh, text_name, text_diaChi, text_phone, text_email, text_maCt;
	JButton bt_search, bt_add, bt_edit, bt_delete, bt_home, bt_logout;
	JLabel makh, quan, name, diachi, phuong, phone, email, ds, mact,note;
	JComboBox cb_quan, cb_phuong;
	DefaultTableModel tb = new DefaultTableModel();
	final JTable tbl = new JTable(tb);
	ExceptionMD ex = new ExceptionMD();

	public quanlykhachhangUI() {
		super("Quản Lý Tiền Điện");
		addControls();
		addEvents();
	}
	private void addEvents() {

		bt_home.addActionListener(bt_home_1);
		bt_add.addActionListener(bt_add_1);
		bt_search.addActionListener(bt_search_1);
		tbl.addMouseListener(eventselect_2);
		bt_edit.addActionListener(bt_edit_1);
		bt_delete.addActionListener(bt_delete_1);
		bt_logout.addActionListener(bt_logout_1);
	}

	// đây là sự kiện

	// bt tìm kiếm 
	ActionListener bt_search_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				search_home_1();
			} catch (ExceptionMD e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	protected void search_home_1() throws ExceptionMD {
		if (ex.chkEmpty(text_search.getText()) && ex.chkSearch(text_search.getText())) {
			// xoa table:
			int row = tb.getRowCount();
			if (row > 0) {
				tb.setRowCount(0);
			}
			try {
				res = conn.createStatement()
						.executeQuery("SELECT * FROM ffse004_customer WHERE hoten LIKE '%" + text_search.getText() + "%'");
				while (res.next()) {
					tb.addRow(new String[] { res.getString("makh"), res.getString("hoten"), res.getString("diachi"),
							res.getString("quan"), res.getString("phuong"), res.getString("dienthoai"),
							res.getString("email"), res.getString("macongto") });
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// đưa dữ liệu lên
	MouseAdapter eventselect_2 = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tbl.getSelectedRow();
			String[] row = new String[8];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tbl.getValueAt(i, j);
			}
			text_makh.setText(row[0]);
			text_maCt.setText(row[7]);
			cb_quan.setSelectedItem(row[3]);
			text_name.setText(row[1]);
			cb_phuong.setSelectedItem(row[4]);
			text_diaChi.setText(row[2]);
			text_phone.setText(row[5]);
			text_email.setText(row[6]);
		}
	};
	
	// đăng xuất
	ActionListener bt_logout_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			bt_logout1();
		}
	};
	public void bt_logout1() {
		loginUI myUI = new loginUI();
		myUI.showWindow();
		this.dispose();
	}

	// trang chủ
	ActionListener bt_home_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			bt_home_1();
		}
	};
	protected void bt_home_1() {
		menuUI myMenu = new menuUI();
		try {
			myMenu.hienthi();
		} catch (ExceptionMD e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dispose();
	}
	
	// bt thêm khách hàng
	ActionListener bt_add_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				add_home_1();
			} catch (ExceptionMD e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	protected void add_home_1() throws ExceptionMD {
		if (ex.chkMakh(text_makh.getText()) && ex.chkEmpty(text_name.getText()) && ex.chkEmpty(text_diaChi.getText())
				&& ex.chkMaCongTo(text_maCt.getText()) && ex.chkEmpty((String) cb_phuong.getSelectedItem())
				&& ex.chkEmpty((String) cb_quan.getSelectedItem()) && ex.chkPhone(text_phone.getText())
				&& ex.chkEmail(text_email.getText()) &&ex.chkEmptyMct(text_maCt.getText()) && ex.chkEmpty(text_makh.getText())) {
			try {
				String mq = (String) cb_quan.getItemAt(cb_quan.getSelectedIndex());
				String mp = (String) cb_phuong.getItemAt(cb_phuong.getSelectedIndex());
				String sql = "INSERT INTO ffse004_customer( maKH, hoten, diachi, quan, phuong, dienthoai, email, macongto) VALUES ('"
						+ text_makh.getText() + "','" + text_name.getText() + "','" + text_diaChi.getText() + "','" + mq
						+ "','" + mp + "','" + text_phone.getText() + "','" + text_email.getText() + "','"
						+ text_maCt.getText() + "')";
				Statement stm = (Statement) conn.createStatement();
				int x = stm.executeUpdate(sql);
				if (x > 0) {
					sql = "INSERT INTO `quanlytiendien`.`ffse004_used` (`id`, `username`, `passWord`) VALUES (NULL, '"
							+ text_makh.getText() + "', '12345678');";
					stm = (Statement) conn.createStatement();
					x = stm.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Thêm Khách Hàng Thành Công ");
					
					// đặt các text và table về rỗng
					tb.setRowCount(0);
					text_makh.setText("");
					text_name.setText("");
					text_diaChi.setText("");
					text_maCt.setText("");
					text_phone.setText("");
					text_email.setText("");
					text_search.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Thêm Khách Hàng không Thành Công ");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	// bt sửa khách hàng 
		ActionListener bt_edit_1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bt_edit1();
				} catch (ExceptionMD e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		protected void bt_edit1() throws ExceptionMD {
			if (ex.chkEmpty(text_name.getText()) && ex.chkEmpty(text_diaChi.getText())
					&& ex.chkPhone(text_phone.getText()) && ex.chkEmail(text_email.getText())) {
				try {
					res = conn.createStatement().executeQuery(
							"SELECT ffse004_customer.id ,ffse004_used.id,ffse004_customer.macongto,ffse004_used.username FROM ffse004_customer INNER JOIN ffse004_used ON ffse004_customer.maKH = ffse004_used.username WHERE ffse004_customer.macongto = '"
									+ text_maCt.getText() + "'");
					while (res.next()) {
						id = res.getString(1);
						id_cus = res.getString(2);
						key_mct = res.getString("macongto");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (key_mct != null) {
					try {
						String mq = (String) cb_quan.getItemAt(cb_quan.getSelectedIndex());
						String mp = (String) cb_phuong.getItemAt(cb_phuong.getSelectedIndex());
						String sql = "UPDATE ffse004_customer SET  hoten = '" + text_name.getText() + "', diachi ='"
								+ text_diaChi.getText() + "' , quan = '" + mq + "' , phuong = '" + mp + "' , dienthoai = '"
								+ text_phone.getText() + "' , email = '" + text_email.getText() + "'  WHERE id = '" + id
								+ "' ";
						Statement stm = (Statement) conn.createStatement();
						int x = stm.executeUpdate(sql);
						if (x > 0) {
							String message_true = "Cập nhật Khách Hàng Thành Công ";
							JOptionPane.showMessageDialog(null, message_true);

							// đặt các text và table về rỗng
							tb.setRowCount(0);
							text_makh.setText("");
							text_name.setText("");
							text_diaChi.setText("");
							text_maCt.setText("");
							text_phone.setText("");
							text_email.setText("");
							text_search.setText("");	
						} else {
							JOptionPane.showMessageDialog(null, "Cập Nhật Khách Hàng không Thành Công ");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, " mã công tơ không đúng");
				}
			}
		}
	
	// xoá khách hàng 
	ActionListener bt_delete_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				bt_delete1();
			} catch (ExceptionMD e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	protected void bt_delete1() throws ExceptionMD {
		if (ex.chkEmptyMct(text_maCt.getText())) {
			try {
				res = conn.createStatement().executeQuery(
						"SELECT ffse004_customer.id ,ffse004_used.id,ffse004_customer.macongto,ffse004_used.username FROM ffse004_customer INNER JOIN ffse004_used ON ffse004_customer.maKH = ffse004_used.username WHERE ffse004_customer.macongto = '"
								+ text_maCt.getText() + "'");
				while (res.next()) {
					id = res.getString(1);
					id_cus = res.getString(2);
					key_mct = res.getString("macongto");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (key_mct != null) {
				try {
					sql = "DELETE FROM ffse004_customer WHERE id = '" + id + "' ";
					stm = (Statement) conn.createStatement();
					x = stm.executeUpdate(sql);
					//
					if (x > 0) {
						// đặt các text về rỗng
						text_makh.setText("");
						text_name.setText("");
						text_diaChi.setText("");
						text_maCt.setText("");
						text_phone.setText("");
						text_email.setText("");
						text_search.setText("");
						// đặt table về rỗng
						tb.setRowCount(0);
						JOptionPane.showMessageDialog(null, "Xoá Khách Hàng Thành Công ");
						if (true) {
							sql = "DELETE FROM ffse004_bienlai WHERE macongto = '" + key_mct + "' ";
							stm = (Statement) conn.createStatement();
							x = stm.executeUpdate(sql);
						}
						if (true) {
							sql = "DELETE FROM ffse004_used WHERE id = '" + id_cus + "'";
							stm = (Statement) conn.createStatement();
							x = stm.executeUpdate(sql);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Xoá Khách Hàng không Thành Công");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Mã Công Tơ Không Tồn Tại !");
			}
		}
	}

	private void addControls() {
		Container con = getContentPane();
		JPanel boxAll = new JPanel();
		boxAll.setLayout(new BoxLayout(boxAll, BoxLayout.Y_AXIS));
		con.add(boxAll);

		// tiêu đề 
		JLabel box_title = new JLabel("Quản Lý Khách Hàng");
		box_title.setAlignmentX(Component.CENTER_ALIGNMENT);
		box_title.setFont(new Font("Courier New", Font.BOLD, 22));
		box_title.setForeground(Color.red);
		boxAll.add(box_title);

		// tìm kiếm tên khách hàng 
		JPanel box_search = new JPanel();
		JLabel nameKh = new JLabel("Tên Khách Hàng :");
		text_search = new JTextField(25);
		bt_search = new JButton("tìm kiếm");
		box_search.add(nameKh);
		box_search.add(text_search);
		box_search.add(bt_search);
		boxAll.add(box_search);

		// box GridLayout
		JPanel boxTt = new JPanel();

		// ------------------//
		makh = new JLabel("Mã K/H : ");
		text_makh = new JTextField(15);
		boxTt.add(makh);
		boxTt.add(text_makh);
		makh.setHorizontalAlignment(SwingConstants.RIGHT);

		// ------------------//
		mact = new JLabel("Mã Công Tơ : ");
		text_maCt = new JTextField(15);
		mact.setHorizontalAlignment(SwingConstants.RIGHT);
		boxTt.add(mact);
		boxTt.add(text_maCt);

		// ------------------//
		quan = new JLabel("quận : ");
		quan.setHorizontalAlignment(SwingConstants.RIGHT);
		cb_quan = new JComboBox();
		boxTt.add(quan);
		boxTt.add(cb_quan);
		try {
			res = conn.createStatement().executeQuery("select * from ffse004_quan");
			while (res.next()) {
				cb_quan.addItem(res.getString("tenquan"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// ------------------//
		name = new JLabel("Họ Tên : ");
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		text_name = new JTextField(15);
		boxTt.add(name);
		boxTt.add(text_name);

		// ------------------//
		phuong = new JLabel("phường : ");
		phuong.setHorizontalAlignment(SwingConstants.RIGHT);
		cb_phuong = new JComboBox();

		// database
		try {
			tenQuan = (String) cb_quan.getSelectedItem();
			res = conn.createStatement().executeQuery("SELECT tenphuong FROM ffse004_phuong INNER JOIN ffse004_quan ON ffse004_phuong.maquan = ffse004_quan.maphuong WHERE tenquan = '"+tenQuan+"'");
			while (res.next()) {
				cb_phuong.addItem(res.getString("tenphuong"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cb_quan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {		
					tenQuan = (String) cb_quan.getSelectedItem();
					cb_phuong.removeAllItems();
					try {
						res = conn.createStatement().executeQuery("SELECT tenphuong FROM ffse004_phuong INNER JOIN ffse004_quan ON ffse004_phuong.maquan = ffse004_quan.maphuong WHERE tenquan = '"+tenQuan+"'");
						while (res.next()) {
							cb_phuong.addItem(res.getString("tenphuong"));
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		boxTt.add(phuong);
		boxTt.add(cb_phuong);

		// ------------------//
		diachi = new JLabel("Địa Chỉ : ");
		diachi.setHorizontalAlignment(SwingConstants.RIGHT);
		text_diaChi = new JTextField(15);
		boxTt.add(diachi);
		boxTt.add(text_diaChi);

		// ------------------//
		phone = new JLabel("Điện Thoại : ");
		phone.setHorizontalAlignment(SwingConstants.RIGHT);
		text_phone = new JTextField(12);
		boxTt.add(phone);
		boxTt.add(text_phone);

		// ------------------//
		email = new JLabel("Email : ");
		email.setHorizontalAlignment(SwingConstants.RIGHT);
		text_email = new JTextField(15);
		boxTt.add(email);
		boxTt.add(text_email);

		// ----------------//
		boxTt.setLayout(new GridLayout(4, 4, 40, 30));
		boxAll.add(boxTt);

		// button
		JPanel box5 = new JPanel();
		bt_add = new JButton("Thêm");
		bt_edit = new JButton("Sửa");
		bt_delete = new JButton("Xoá");
		bt_home = new JButton("Home");
		bt_logout = new JButton("Đăng Xuất");
		box5.add(bt_add);
		box5.add(bt_edit);
		box5.add(bt_delete);
		box5.add(bt_home);
		box5.add(bt_logout);
		box5.setLayout(new FlowLayout());
		boxAll.add(box5);
		
		// lưu ý 
		JPanel box_note = new JPanel();
		note = new JLabel("Mã Khách Hàng Và Mã Công Tơ Sẽ Không Sửa Được !");
		note.setHorizontalAlignment(SwingConstants.LEFT);
		note.setForeground(Color.red);
		box_note.add(note);
		boxAll.add(box_note);
		
		// table
		ds = new JLabel("danh sách : ");
		boxAll.add(ds);
		JPanel box6 = new JPanel();
		tb.addColumn("mã Khách Hàng  ");
		tb.addColumn("Tên ");
		tb.addColumn("Địa Chỉ");
		tb.addColumn("Quận");
		tb.addColumn("Phường");
		tb.addColumn("Số Điện Thoại");
		tb.addColumn("Email");
		tb.addColumn("Mã Công Tơ");
		JScrollPane sc = new JScrollPane(tbl);
		box6.setLayout(new BorderLayout());
		box6.add(sc, BorderLayout.CENTER);
		boxAll.add(box6);
	}

	public void hienthi_kh() throws ExceptionMD {
		if (ex.chkLogin(loginUI.login)) {
			JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập !");
			loginUI myUI = new loginUI();
			myUI.showWindow();
			this.dispose();
		} else {
			this.setSize(800, 600);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
	}
}
