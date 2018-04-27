package Process;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import Data.phuong;
import Data.quan;
import Data.tinh;

public class KhachHang extends JFrame {
	Connect cn = new Connect();
	Connection conn = (Connection) Connect.getConnect();
	private String email;
	JComboBox comboBox;
	JButton jbThem, jbThoat, jbTKBDoc;
	JTextField txtTKBDoc, txtMTV, txtDC, txtHTen, txtSDT, txtEmail, txttinh, txthuyen, txtxa;
	String cb[] = { "Đang mượn", "Đã trả" };
	JScrollPane spListBDoc = new JScrollPane();
	JTable tbListBDoc = new JTable();
	String tbBDoc[] = { "Họ tên", "Mã_GD", "Mã Sách", "Tên sách", "Tác gỉa", "Tình Trạng" };
	DefaultTableModel mdTableBDoc = new DefaultTableModel(tbBDoc, 0);

	ActionListener evTimKiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
            timkiem();
		}

	};

	public KhachHang(String email) {
		super();
		this.email = email;
		controls();
		Display();
		addEvents();

	}

	public void controls() {

		String sql = "select * from BanDoc where email=?";
		try {
			PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
			// khởi tạo resultset
			ptmt.setString(1, email);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {

				JPanel pnMain = new JPanel();
				pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));



				JPanel pnBDoc = new JPanel();

				JLabel lbMTV = new JLabel("Mã thành viên");
				lbMTV.setPreferredSize(new Dimension(90, 20));
				txtMTV = new JTextField(rs.getString(2));
				Font fMTV = new Font("arial", Font.PLAIN, 12);
				lbMTV.setFont(fMTV);
				txtMTV.setColumns(15);

				JLabel lbDC = new JLabel("Địa chỉ nhà");
				lbDC.setPreferredSize(new Dimension(90, 20));
				txtDC = new JTextField(rs.getString(6));
				Font fDC = new Font("arial", Font.PLAIN, 12);
				lbDC.setFont(fDC);
				txtDC.setColumns(15);

				pnBDoc.add(lbMTV);
				pnBDoc.add(txtMTV);
				pnBDoc.add(lbDC);
				pnBDoc.add(txtDC);

				JPanel pnBDoc1 = new JPanel();

				JLabel lbHTen = new JLabel("Họ tên");
				lbHTen.setPreferredSize(new Dimension(90, 20));
				txtHTen = new JTextField(rs.getString(3));
				Font fHTen = new Font("arial", Font.PLAIN, 12);
				lbHTen.setFont(fHTen);
				txtHTen.setColumns(15);

				JLabel lbTinh = new JLabel("Tỉnh");
				lbTinh.setPreferredSize(new Dimension(90, 20));
				lbTinh.setFont(new Font("Arial", Font.PLAIN, 12));
				txttinh = new JTextField(rs.getString(7));
				txttinh.setColumns(15);
				pnBDoc1.add(lbHTen);
				pnBDoc1.add(txtHTen);
				pnBDoc1.add(lbTinh);
				pnBDoc1.add(txttinh);

				JPanel pnBDoc2 = new JPanel();

				JLabel lbSDT = new JLabel("Số điện thoại");
				lbSDT.setPreferredSize(new Dimension(90, 20));
				txtSDT = new JTextField(rs.getString(4));
				Font fSDT = new Font("arial", Font.PLAIN, 12);
				lbSDT.setFont(fSDT);
				txtSDT.setColumns(15);

				JLabel lbQuan = new JLabel("Quận");
				lbQuan.setPreferredSize(new Dimension(90, 20));
				lbQuan.setFont(new Font("Arial", Font.PLAIN, 12));
				txthuyen = new JTextField(rs.getString(8));
				txthuyen.setColumns(15);

				pnBDoc2.add(lbSDT);
				pnBDoc2.add(txtSDT);
				pnBDoc2.add(lbQuan);
				pnBDoc2.add(txthuyen);

				JPanel pnBDoc3 = new JPanel();

				JLabel lbEmail = new JLabel("Email");
				lbEmail.setPreferredSize(new Dimension(90, 20));
				txtEmail = new JTextField(rs.getString(5));
				Font fEmail = new Font("arial", Font.PLAIN, 12);
				lbEmail.setFont(fEmail);
				txtEmail.setColumns(15);

				JLabel lbPhuong = new JLabel("Phường");
				lbPhuong.setPreferredSize(new Dimension(90, 20));
				lbPhuong.setFont(new Font("Arial", Font.PLAIN, 12));

				txtxa = new JTextField(rs.getString(9));
				txtxa.setColumns(15);

				pnBDoc3.add(lbEmail);
				pnBDoc3.add(txtEmail);
				pnBDoc3.add(lbPhuong);
				pnBDoc3.add(txtxa);

				JPanel pnSuKien = new JPanel();

				JPanel pnThem = new JPanel();

				comboBox = new JComboBox(cb);
				comboBox.setPreferredSize(new Dimension(170, 20));

				comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
				comboBox.setToolTipText("");
				pnThem.add(comboBox);
				
				JPanel pnTimKiemBDoc = new JPanel();

				jbTKBDoc = new JButton("Tìm kiếm");
				jbTKBDoc.setPreferredSize(new Dimension(90, 20));

				pnTimKiemBDoc.add(jbTKBDoc);
				
				JPanel pnThoat = new JPanel();
				jbThoat = new JButton("Quay lại");
				jbThoat.setPreferredSize(new Dimension(100, 20));
				jbThoat.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						MainUI.login.addShow();
						dispose();

					}
				});
				pnThoat.add(jbThoat);

				pnSuKien.add(pnThem);
				pnSuKien.add(pnTimKiemBDoc);
				pnSuKien.add(pnThoat);

				JPanel pnTableKH = new JPanel();

				Border border = BorderFactory.createLineBorder(Color.RED);
				TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh Sach");
				spListBDoc.setBorder(borderTittle);
				tbListBDoc.setModel(mdTableBDoc);
				spListBDoc.setViewportView(tbListBDoc);
				pnTableKH.add(spListBDoc);

				pnMain.add(pnSuKien);
				
				pnMain.add(pnBDoc);
				pnMain.add(pnBDoc1);
				pnMain.add(pnBDoc2);
				pnMain.add(pnBDoc3);
				pnMain.add(pnSuKien);
				pnMain.add(pnTableKH);

				this.add(pnMain);
			}
		} catch (SQLException e) {
			System.out.println("loi  " + e.getMessage());

		}
	}

	public void Display() {
		
		if (conn != null) {

			String sql = "select * from ((QuanLy_Sach inner join Phieu_Muon on QuanLy_Sach.ma_s=Phieu_Muon.ma_s) inner join BanDoc on BanDoc.Matv=Phieu_Muon.ma_tv and BanDoc.email "
					+ "='"+this.email
					+ "') ";
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

					mdTableBDoc.addRow(rows);

				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public void addEvents() {

		jbTKBDoc.addActionListener(evTimKiem);

	}
   public void timkiem() {
	   String sql = "select * from ((QuanLy_Sach inner join Phieu_Muon on QuanLy_Sach.ma_s=Phieu_Muon.ma_s) inner join BanDoc on BanDoc.Matv=Phieu_Muon.ma_tv and Phieu_Muon.tinh_trang"
				+ "='"+comboBox.getSelectedItem().toString()
				+ "' and BanDoc.email ='"+this.email
				+ "') ";


		try {
			PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
			// khởi tạo resultset

			ResultSet rs = ptmt.executeQuery();
			mdTableBDoc.setRowCount(0);
			// mdTableSach.getDataVector().removeAllElements();
			while (rs.next()) {
				String rows[] = new String[6];

				rows[0] = rs.getString("ho_ten");
				rows[1] = rs.getString("ma_gd");
				rows[2] = rs.getString(2);
				rows[3] = rs.getString(3);
				rows[4] = rs.getString(4);
				rows[5] = rs.getString("tinh_trang");

				mdTableBDoc.addRow(rows);

				
			}
		} catch (SQLException e1) {
			System.out.println("loi  " + e1.getMessage());

		}

   }
	public void showWindow() {

		this.setSize(700, 575);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}