package project1.javadesktop;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.Box;

public class InformationCustomer extends JFrame implements ActionListener {

	private static final MouseListener EventSelect = null;
	private Homepage hp;
	private JPanel contentPane;
	private JTextField tfmact, tfemail, tfphone, tfaddress, tfhoten, tfmakh, tfsearch;
	private JTable table;
	static JComboBox cbquan;
	static JComboBox cbphuong;
	private int Quan_id;
	private JButton btnadd, btnedit, btndel, btnreturn;
	private static String[] cottieude = { "Mã", "Họ Tên", "Địa Chỉ", "Quận", "Phường", "Số đt", "Email", "Mã công tơ" };
	static DefaultTableModel tbmodel = new DefaultTableModel(cottieude, 0);
	private ArrayList<Khachhang> arrkhachhang = new ArrayList<Khachhang>();
	static Connection conn = Connection_Database.Ketnoi();
	static PreparedStatement ptmt = null;
	private JMenuItem mnma, mnten;
	private JLabel lbmactd, lbkh,lbemail;
	static ArrayList<Integer> count = new ArrayList<>();

	/*
	 * ham dung khong truyen tham so
	 */
	public InformationCustomer() {
		Addcontrolls();
		Addevents();
	}

	/*
	 * phuong thuc create event
	 */
	public void Addevents() {
		mnma.addActionListener(eventselect1);
		mnten.addActionListener(eventselect1);
		table.addMouseListener(eventselect2);
		cbquan.addActionListener(cbquan1);
		btnadd.addActionListener(this);
		btnedit.addActionListener(this);
		btndel.addActionListener(this);
		btnreturn.addActionListener(this);
		lbmactd.addMouseListener(mouse1);
		lbkh.addMouseListener(mouse1);
		lbemail.addMouseListener(mouse1);
	}

	// thuc hien chuc nang:
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton bt = (JButton) e.getSource();
		if (bt == btnadd) {
			String sql = "";
			String com = "";
			// add your code
			// kiem tra ma khach hang:
			String makh = tfmakh.getText();
			MyException.MyE_check_mkh(makh);
			if (makh.length() > 0) {
				sql = "select * from Customer where Makh = '" + makh + "'";
				com = "Mã khách hàng";
				MyException.MyE_check_exist(sql, com);
				sql = "";
			}
			// check hoten:
			String hoten = tfhoten.getText();
			MyException.MyE_checkName(hoten);
			// check dia chi:
			String diachi = tfaddress.getText();
			MyException.MyE_checkAddress(diachi);
			// check quan va phuong:
			String quan = (String) cbquan.getSelectedItem();
			String phuong = (String) cbphuong.getSelectedItem();
			MyException.MyE_checkquan(quan, phuong);
			// check so dien thoai:
			String sdt = tfphone.getText();
			MyException.MyE_checkphone(sdt);
			// check email:
			String email = tfemail.getText();
			MyException.MyE_checkemail(email);
			// kiem tra ma cong to:
			String mct = tfmact.getText();
			MyException.MyE_check_mct(mct);
			if (mct.length()>0) {
				//sql.equals()
				sql = "select * from Customer where Macongto = '" + mct + "'";
				com = "Mã công tơ";
				MyException.MyE_check_exist(sql, com);
			}
			if (count.size() == 0) {
				Khachhang kh = new Khachhang(makh, hoten, diachi, quan, phuong, sdt, email, mct);
				arrkhachhang.add(kh);
				setText("", "", "", "", "", "", "", "");
				MySQL_khachhang.add_Khachhang(makh, hoten, diachi, phuong, quan, sdt, email, mct);
			}
			if (count.size() > 0) {

				for (int i = 0; i < count.size(); i++) {
					count.remove(i);
				}
			}
		}

		if (bt == btnedit) {
			// add your code
			int row = table.getSelectedRow();
			if (row != -1) {
				String makh = tfmakh.getText();
				MyException.MyE_check_mkh(makh);
				String hoten = tfhoten.getText();
				MyException.MyE_checkName(hoten);
				String diachi = tfaddress.getText();
				MyException.MyE_checkAddress(diachi);
				String quan = (String) cbquan.getSelectedItem();
				String phuong = (String) cbphuong.getSelectedItem();
				MyException.MyE_checkquan(quan, phuong);
				String sdt = tfphone.getText();
				MyException.MyE_checkphone(sdt);
				String email = tfemail.getText();
				MyException.MyE_checkemail(email);
				String mct = tfmact.getText();
				MyException.MyE_check_mct(mct);
				if (count.size() == 0) {
					Khachhang kh = new Khachhang(makh, hoten, diachi, quan, phuong, sdt, email, mct);
					arrkhachhang.add(kh);
					String field[] = { makh, hoten, diachi, quan, phuong, sdt, email, mct };
					for (int j = 0; j < field.length; j++) {
						tbmodel.setValueAt(field[j], row, j);
					}
					setText("", "", "", "", "", "", "", "");
					MySQL_khachhang.update_Khachhang(makh, hoten, diachi, phuong, quan, sdt, email, mct);
				} else {
					JOptionPane.showMessageDialog(null, "Yêu cầu nhập đầy đủ thông tin", "Thông báo lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
				if (count.size() > 0) {

					for (int i = 0; i < count.size(); i++) {
						count.remove(i);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Chưa có thông tin để edit", "Thông báo lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (bt == btndel) {

			int row = table.getSelectedRow();
			if (row != -1) {
				tbmodel.removeRow(row);
				String makh = tfmakh.getText();
				MySQL_khachhang.del_Khachhang(makh);
			} else {
				JOptionPane.showMessageDialog(null, "Chưa chọn hàng dữ liệu để xóa", "Thông báo lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (bt == btnreturn) {

			super.setVisible(false);
			Homepage hp = new Homepage("PHẦN MỀM TÍNH TIỀN ĐIỆN");
			hp.showWindow();

		}
	}

	/*
	 * phuong thuc setText
	 */
	private void setText(String makh, String hoten, String diachi, String phuong, String quan, String sdt, String email,
			String mact) {
		// TODO Auto-generated method stub
		tfmakh.setText(makh);
		tfhoten.setText(hoten);
		tfaddress.setText(diachi);
		cbquan.setSelectedIndex(0);
		cbphuong.setSelectedIndex(0);
		tfphone.setText(sdt);
		tfemail.setText(email);
		tfmact.setText(mact);
	}

	/*
	 * thuc hien chuc nang khi chon combobox:
	 */
	ActionListener cbquan1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			InformationCustomer.cbphuong.removeAllItems();
			String Name_quan = cbquan.getSelectedItem().toString();
			Quan_id = MySQL_khachhang.getQuanID(Name_quan);
			String sql = "select  *  from Phuong where Parent_id = " + Quan_id;
			try {
				ptmt = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs = ptmt.executeQuery();
				cbphuong.addItem("Chọn Phường");
				while (rs.next()) {
					cbphuong.addItem(rs.getString("Phuong"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("loi" + e1);
			}
		}
	};
	/*
	 * thuc hien chuc nang tim kiem va show thong tin:
	 */
	ActionListener eventselect1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String cottieude = "";
			String key = "";
			String sosanh = "";

			JMenuItem menu = (JMenuItem) e.getSource();
			if (menu == mnma) {
				cottieude = "Makh";
				sosanh = "like";
				key = tfsearch.getText().toString();
				if(key.length()>0)
				{
				String sql2 = "select * from Customer where " + cottieude + " " + sosanh +  "'%" + key + "%'";
				MySQL_khachhang.select_Khachhang(cottieude, key, sosanh, sql2);
				}else {
					JOptionPane.showMessageDialog(null, "Chưa chọn mục để tìm kiếm", "Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
				}

			}
			else if(menu == mnten) {
				cottieude = "Username";
				sosanh = "like";
				key = tfsearch.getText().toString();
				if(key.length()>0)
				{
				String sql1 = "select * from Customer where " + cottieude + " " + sosanh + "'%" + key + "%'";
				MySQL_khachhang.select_Khachhang(cottieude, key, sosanh, sql1);
				}
				else {
					JOptionPane.showMessageDialog(null, "Chưa chọn mục để tìm kiếm", "Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
				}
			}

		};
	};
	/*
	 * thuc hien event khi click vao table;
	 */
	MouseAdapter eventselect2 = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = table.getSelectedRow();
			String[] row = new String[8];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) table.getValueAt(i, j);
			}
			tfmakh.setText(row[0]);
			tfhoten.setText(row[1]);
			tfaddress.setText(row[2]);
			cbquan.setSelectedItem(row[3]);
			cbphuong.setSelectedItem(row[4]);
			tfphone.setText(row[5]);
			tfemail.setText(row[6]);
			tfmact.setText(row[7]);
		}
	};
	/*
	 * thuc hien khi click val LaBel:
	 */
	MouseAdapter mouse1 = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			JLabel lb = (JLabel) e.getSource();
			if (lb == lbkh) {
				tfmakh.setText("DL_00");
			}
			if (lb == lbmactd) {
				tfmact.setText("CT_00");
			}
			if(lb == lbemail)
			{
				tfemail.setText("@gmail.com");
			}
		}
	};

	/**
	 * Create the frame.
	 */
	public void Addcontrolls() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
		this.setTitle("PHẦN MỀM QUẢN LÝ TIỀN ĐIỆN");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 100, 900, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		// set JPanel main:
		Container con = getContentPane();
		con.setFont(new Font("Tahoma", Font.PLAIN, 34));
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BoxLayout(pnmain, BoxLayout.Y_AXIS));

		// set panel title:
		JPanel pntitle = new JPanel();
		pntitle.setBackground(new Color(139, 0, 139));
		JLabel lbtitle = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lbtitle.setForeground(Color.WHITE);
		lbtitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		pntitle.add(lbtitle);
		pnmain.add(pntitle);

		// set panel tim kiem thong tin cua khach hang:
		JPanel pnsearch = new JPanel();

		JMenuBar mnbar = new JMenuBar();
		JMenu mn = new JMenu("Tìm Kiếm");
		mnma = new JMenuItem("Mã khách hàng");
		mnten = new JMenuItem("Họ Ten");
		mn.add(mnma);
		mn.add(mnten);
		mnbar.add(mn);
		pnsearch.add(mnbar);

		tfsearch = new JTextField();
		tfsearch.setToolTipText("Nhập thông tin  khách hàng");
		tfsearch.setColumns(15);
		pnsearch.add(tfsearch);
		pnmain.add(pnsearch);

		// set panel1 nhap thong tin:
		JPanel pnnhap1 = new JPanel();
		pnnhap1.setLayout(new FlowLayout());

		pnnhap1.add(Box.createRigidArea(new Dimension(40, 30)));

		lbkh = new JLabel("Mã khách hàng ");
		lbkh.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbkh.setSize(100, 30);
		pnnhap1.add(lbkh);
		pnnhap1.add(Box.createRigidArea(new Dimension(40, 30)));

		tfmakh = new JTextField();
		tfmakh.setColumns(17);
		tfmakh.setMaximumSize(new Dimension(0, 20));
		// tfmakh.setColumns(15);
		pnnhap1.add(tfmakh);
		// thêm 1 cái area
		pnnhap1.add(javax.swing.Box.createRigidArea(new Dimension(40, 30)));
		JLabel lb1 = new JLabel("");
		pnnhap1.add(lb1);
		JLabel lbphuong = new JLabel("Phường              ");
		lbphuong.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pnnhap1.add(lbphuong);

		pnnhap1.add(Box.createRigidArea(new Dimension(40, 30)));

		cbphuong = new JComboBox();
		cbphuong.setPreferredSize(new Dimension(198, 25));
		pnnhap1.add(cbphuong);
		pnmain.add(pnnhap1);

		// set panel2 nhap thong tin:
		JPanel pnnhap2 = new JPanel();

		pnnhap2.add(Box.createRigidArea(new Dimension(40, 30)));

		JLabel lbhoten = new JLabel("Tên khách hàng");
		lbhoten.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbhoten.setSize(100, 30);
		pnnhap2.add(lbhoten);

		pnnhap2.add(Box.createRigidArea(new Dimension(40, 30)));

		tfhoten = new JTextField();
		tfhoten.setColumns(17);
		tfhoten.setMaximumSize(new Dimension(200, 20));
		pnnhap2.add(tfhoten);

		pnnhap2.add(Box.createRigidArea(new Dimension(40, 30)));
		JLabel lb2 = new JLabel("");
		pnnhap2.add(lb2);

		JLabel lbphone = new JLabel("Số điện thoại      ");
		lbphone.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pnnhap2.add(lbphone);

		pnnhap2.add(Box.createRigidArea(new Dimension(40, 30)));

		tfphone = new JTextField();
		tfphone.setColumns(18);
		tfphone.setMaximumSize(new Dimension(200, 20));
		pnnhap2.add(tfphone);

		// set panel nhap thong tin 3;
		JPanel pnnhap3 = new JPanel();
		pnnhap3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		pnnhap3.add(Box.createRigidArea(new Dimension(40, 30)));
		JLabel lbaddress = new JLabel("Địa chỉ               ");
		lbaddress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbaddress.setSize(100, 30);
		pnnhap3.add(lbaddress);

		Component rigidArea = Box.createRigidArea(new Dimension(40, 30));
		pnnhap3.add(rigidArea);

		tfaddress = new JTextField();
		tfaddress.setColumns(17);
		pnnhap3.add(tfaddress);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(40, 30));
		pnnhap3.add(rigidArea_1);

		JLabel lb3 = new JLabel("");
		pnnhap3.add(lb3);

		 lbemail = new JLabel("Email                  ");
		lbemail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbemail.setSize(100, 30);
		pnnhap3.add(lbemail);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(40, 30));
		pnnhap3.add(rigidArea_2);

		tfemail = new JTextField();
		tfemail.setColumns(18);
		pnnhap3.add(tfemail);

		// set JPanel 4 nhap thong tin:
		JPanel pnnhap4 = new JPanel();
		pnnhap4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		pnnhap4.add(Box.createRigidArea(new Dimension(40, 30)));

		JLabel lbquan = new JLabel("Quận                 ");
		lbquan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbquan.setSize(100, 30);
		pnnhap4.add(lbquan);

		cbquan = new JComboBox();
		cbquan.setPreferredSize(new Dimension(190, 25));
		String chuoi = "InformationCustomer";
		MySQL_khachhang.getQuan(chuoi);

		pnnhap4.add(Box.createRigidArea(new Dimension(40, 30)));
		pnnhap4.add(cbquan);

		pnnhap4.add(Box.createRigidArea(new Dimension(40, 30)));

		JLabel lb4 = new JLabel("");
		pnnhap4.add(lb4);

		lbmactd = new JLabel("Mã công tơ điện  ");
		lbmactd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbmactd.setSize(100, 30);
		pnnhap4.add(lbmactd);

		pnnhap4.add(Box.createRigidArea(new Dimension(40, 30)));

		tfmact = new JTextField();
		tfmact.setColumns(18);
		pnnhap4.add(tfmact);

		/*
		 * 
		 */
		JPanel pntrong = new JPanel();
		/*
		 * them button
		 */

		JPanel pnbutton = new JPanel();
		pnbutton.setLayout(new BoxLayout(pnbutton, BoxLayout.X_AXIS));
		Font font = new Font("Times New Roman", Font.BOLD, 14);

		btnadd = new JButton("Thêm");
		btnadd.setForeground(Color.RED);
		btnadd.setFont(font);
		pnbutton.add(btnadd);

		btnedit = new JButton("Sửa");
		btnedit.setFont(font);
		btnedit.setForeground(Color.RED);
		pnbutton.add(btnedit);

		btndel = new JButton("Xóa");
		btndel.setFont(font);
		btndel.setForeground(Color.RED);
		pnbutton.add(btndel);

		btnreturn = new JButton("Quay lại");
		btnreturn.setForeground(Color.RED);
		btnreturn.setFont(font);
		pnbutton.add(btnreturn);

		// set panel cho table:
		JPanel pntable = new JPanel();
		javax.swing.border.Border border = BorderFactory.createLineBorder(Color.red);
		TitledBorder title = BorderFactory.createTitledBorder(border, "Danh Sách");
		pntable.setBorder(title);

		table = new JTable();
		table.setModel(tbmodel);
		table.setPreferredScrollableViewportSize(new Dimension(800, 250));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane sc = new JScrollPane();

		sc.setViewportView(table);
		pntable.add(sc);

		pnmain.add(pnnhap1);
		pnmain.add(pnnhap2);
		pnmain.add(pnnhap3);
		pnmain.add(pnnhap4);
		pnmain.add(pntrong);
		pnmain.add(pnbutton);
		pnmain.add(pntable);
		con.add(pnmain);
	}
}
