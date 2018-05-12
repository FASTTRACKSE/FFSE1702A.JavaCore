package quanly;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import quanly.Home;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import javax.swing.JTable;
import quanly.model.SinhVien;
import quanly.model.database;

public class KhachHang extends JFrame {
	int mqu;
	database db, db1;
	Connection con;
	String makh, tenkh, tenquan, tenphuong, id;

	public KhachHang() {
		db = new database();
		con = db.connectSQL();
	}

	JComboBox comboboxquan = new JComboBox(), comboboxphuong = new JComboBox();
	JScrollPane sc = new JScrollPane();
	JTable tbl;
	JButton b1, b2, b3, b4;
	JTextField tx1, tx2, txt1, txt2, mail, mc1;
	JLabel ma, quan, ma1, phuong, dt1, dc, em1, mact;
	DefaultTableModel demotable = new DefaultTableModel();

	MouseAdapter eventClick = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tbl.getSelectedRow();
			String[] row = new String[8];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tbl.getValueAt(i, j);
			}
			tx1.setText(row[0]);
			tx2.setText(row[1]);
			txt1.setText(row[2]);
			mail.setText(row[3]);
			comboboxquan.setSelectedItem(row[4]);
			comboboxphuong.setSelectedItem(row[5]);
			txt2.setText(row[6]);
			mc1.setText(row[7]);

			try {
				ResultSet res;
				db = new database();
				con = db1.connectSQL();
				Statement sttm = (Statement) con.createStatement();
				res = con.createStatement()
						.executeQuery("SELECT ID FROM KhachHang WHERE MaCT = '" + mc1.getText() + "'");
				if (res.next()) {
					id = res.getString("ID");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	};
	ActionListener eventhienthi = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Show();
		}

		public void Show() {
			try {
				demotable.setRowCount(0);

				ResultSet res;
				db = new database();
				con = db1.connectSQL();
				Statement sttm = (Statement) con.createStatement();
				res = con.createStatement().executeQuery(
						"SELECT MaKH, TenKH,Phone,Email,Quan,Phuong,DiaChi,MaCT FROM KhachHang ORDER BY ID DESC");
				while (res.next()) {
					demotable.addRow(new String[] { res.getString("MaKH"), res.getString("TenKH"),
							res.getString("Phone"), res.getString("Email"), res.getString("Quan"),
							res.getString("Phuong"), res.getString("DiaChi"), res.getString("MaCT") });
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	};
	ActionListener eventThem = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Them();
		}

		public void Them() {
			try {

				boolean res;
				db = new database();
				con = db1.connectSQL();
				Statement sttm = (Statement) con.createStatement();
				res = con.createStatement().execute(
						"INSERT INTO KhachHang( MaKH, TenKH, Phone, Email, Quan, Phuong, DiaChi, MaCT) VALUES ('"
								+ tx1.getText() + " ','" + tx2.getText() + "','" + txt1.getText() + "','"
								+ mail.getText() + "','" + comboboxquan.getSelectedItem() + "','"
								+ comboboxphuong.getSelectedItem() + "','" + txt2.getText() + "','" + mc1.getText()
								+ "')");
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	};
	ActionListener eventMoi = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Moi();
		}

		public void Moi() {
			tx1.setText("");
			tx2.setText("");
			txt1.setText("");
			txt2.setText("");
			mail.setText("");
			mc1.setText("");

		}
	};
	//Sửa
	ActionListener eventSua = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Sua();

		}

		public void Sua() {
			try {

				boolean res;
				db = new database();
				con = db1.connectSQL();
				Statement sttm = (Statement) con.createStatement();
				res = con.createStatement()
						.execute("UPDATE KhachHang SET MaKH='" + tx1.getText() + "',TenKH='" + tx2.getText()
								+ "',Phone='" + txt1.getText() + "',Email='" + mail.getText() + "',Quan='"
								+ comboboxquan.getSelectedItem() + "',Phuong='" + comboboxphuong.getSelectedItem()
								+ "',Diachi='" + txt2.getText() + "',MaCT='" + mc1.getText() + "'WHERE ID =" +id+"");
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	};

	public KhachHang(String tieude) {
		super(tieude);
		addControls();
		addEvents();

	}

	ActionListener cboQuanChange = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			updatePhuong();
		}
	};

	public void updatePhuong() {
		comboboxphuong.removeAllItems();
		try {
			ResultSet res;
			db1 = new database();
			Connection conn = db.connectSQL();
			// System.out.println(conn);
			Statement sttm = (Statement) conn.createStatement();
			mqu = ((Item) comboboxquan.getSelectedItem()).getId();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// System.out.println(mqu);
		try {
			ResultSet res;
			db = new database();
			Connection conn = db1.connectSQL();
			Statement sttm = (Statement) conn.createStatement();
			res = sttm.executeQuery("SELECT TenPhuong FROM `Phuong` INNER JOIN Quan ON Phuong.MaQuan = '" + mqu
					+ "'  AND Quan.MaQuan = '" + mqu + "'");
			while (res.next()) {
				comboboxphuong.addItem(res.getString("TenPhuong"));
			}
			tenquan = ((Item) comboboxquan.getSelectedItem()).getDescription();
			tenphuong = (String) comboboxphuong.getSelectedItem();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel box = new JPanel();
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		JPanel boxbox = new JPanel();
		boxbox.setLayout(new BoxLayout(boxbox, BoxLayout.X_AXIS));
		JPanel title = new JPanel();
		JLabel Title = new JLabel("Quản lý khách hàng");
		Font fonttitle = new Font("Arial", Font.BOLD, 30);
		Title.setFont(fonttitle);
		title.add(Title);
		// MÃ£ vÃ  quáº­n
		JPanel makh = new JPanel();
		ma = new JLabel("Mã khách hàng");
		tx1 = new JTextField(20);
		JPanel tenkh = new JPanel();
		quan = new JLabel("Quận");
		comboboxquan.addActionListener(cboQuanChange);

		try {

			ResultSet res;
			db = new database();
			Connection conn = db.connectSQL();
			Statement sttm = (Statement) conn.createStatement();
			res = sttm.executeQuery("SELECT * FROM `Quan`");
			while (res.next()) {
				comboboxquan.addItem(new Item(res.getInt("MaQuan"), res.getString("TenQuan")));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		makh.add(ma);
		makh.add(tx1);
		makh.add(quan);
		makh.add(comboboxquan);
		// Tên Và Phư�?ng
		JPanel makh1 = new JPanel();
		ma1 = new JLabel("Tên khách hàng");
		tx2 = new JTextField(20);
		phuong = new JLabel("Phư�?ng");
		updatePhuong();
		makh1.add(ma1);
		makh1.add(tx2);
		makh1.add(phuong);
		makh1.add(comboboxphuong);
		// �?iện thoại và địa chỉ
		JPanel dt = new JPanel();
		dt1 = new JLabel("�?iện thoại");
		txt1 = new JTextField(15);
		dc = new JLabel("�?ịa chỉ");
		txt2 = new JTextField(15);
		dt.add(dt1);
		dt.add(txt1);
		dt.add(dc);
		dt.add(txt2);
		// Email và mã công tơ
		JPanel em = new JPanel();
		em1 = new JLabel("Email");
		mail = new JTextField(15);
		mact = new JLabel("Mã Công tơ");
		mc1 = new JTextField(15);
		em.add(em1);
		em.add(mail);
		em.add(mact);
		em.add(mc1);
		// Button
		JPanel bt = new JPanel();
		b1 = new JButton("Thêm");
		b2 = new JButton("Mới");
		b3 = new JButton("Sửa");
		b4 = new JButton("Back");
		bt.add(b1);
		bt.add(b2);
		bt.add(b3);
		bt.add(b4);
		// Bảng
		JPanel panelTable = new JPanel();
		demotable.addColumn("Mã");
		demotable.addColumn("Tên");
		demotable.addColumn("Điện thoại");
		demotable.addColumn("Email");
		demotable.addColumn("Quận");
		demotable.addColumn("Phường");
		demotable.addColumn("�?ịa chỉ");
		demotable.addColumn("Mã công tơ");
		tbl = new JTable(demotable);
		//tbl.setPreferredSize(new Dimension(1000,200));
		sc = new JScrollPane(tbl);
		Container con1 = getContentPane();
		con1.setLayout(new BorderLayout());
		con1.add(sc, BorderLayout.CENTER);
		panelTable.add(sc);
		// Thêm vào hộp chính
		box.add(title);
		box.add(makh);
		box.add(makh1);
		box.add(dt);
		box.add(em);
		box.add(bt);
		box.add(panelTable);
		box.add(sc);
		con.add(box);

	}

	ActionListener eventback = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			menu_back();
		}
	};

	public void menu_back() {
		Home myUI = new Home("Khách Hàng");
		myUI.showWindow();
		if (con != null) {
	        try {
	            con.close();
	        } catch (SQLException e) { /* ignored */}
	    }
		dispose();
	}

	public void addEvents() {
		tbl.addMouseListener(eventClick);
		b1.addActionListener(eventhienthi);
		b1.addActionListener(eventThem);
		b2.addActionListener(eventMoi);
		b3.addActionListener(eventSua);

		b4.addActionListener(eventback);

	}

	public void showWindow() {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	class Item {

		private int id;
		private String description;

		public Item(int id, String description) {
			this.id = id;
			this.description = description;
		}

		public int getId() {
			return id;
		}

		public String getDescription() {
			return description;
		}

		@Override
		public String toString() {
			return description;
		}
	}
}
