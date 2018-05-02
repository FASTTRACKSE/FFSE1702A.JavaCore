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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import MODEL.Connect;
import MODEL.tinh;
import MODEL.huyen;
import MODEL.xa;
import UI.Sach_UI;

public class Bandoc_UI extends JFrame {
	JComboBox cbtinh, cbhuyen, cbxa;
	Connection conn = (Connection) Connect.getConnect();
	JTextField txtLook, txtMaTV, txtTenTV, txtEmail, txtSdt, txtDiaChi, txtSach;
	JButton btAdd, btEdit, btDel, btReset, btLook, btSach, btPhieu, btThongKe, btLogout;
	JScrollPane spListBandoc = new JScrollPane();
	JTable tbListBandoc = new JTable();
	String tbBandoc[] = { "Mã thành viên", "Tên thành viên", "Email", "Số điện thoại", "Tỉnh thành", "Quận huyên",
			"Xã, phường", "Địa chỉ", "Số sách đang mượn" };
	DefaultTableModel mdTableBandoc = new DefaultTableModel(tbBandoc, 0);

	public Bandoc_UI(String tieude) {
		super(tieude);
		controls();
		addEvents();
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

	ActionListener evInsert = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (txtTenTV.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên bạn đọc");
			} else if (txtEmail.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập nhập Email");
			} else if (txtSdt.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại");
			} else if (txtDiaChi.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập địa chỉ");
			} else if (cbtinh.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn tỉnh");
			} else if (cbhuyen.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn huyện");
			} else if (cbtinh.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn xã");
			} else if (cbxa.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn xã");
			}

			else {
				if (conn != null) {
					String sql = "INSERT INTO ban_doc(ho_ten,email,dien_thoai,tinh_thanh, quan_huyen,xa_phuong, dia_chi, sach_dang_muon) VALUES (?,?,?,?,?,?,?,0)";
					try {
						PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
						// khởi tạo resultset

						ptmt.setString(1, txtTenTV.getText());
						ptmt.setString(2, txtEmail.getText());
						ptmt.setString(3, txtSdt.getText());
						ptmt.setString(4, cbtinh.getSelectedItem().toString());
						ptmt.setString(5, cbhuyen.getSelectedItem().toString());
						ptmt.setString(6, cbxa.getSelectedItem().toString());
						ptmt.setString(7, txtDiaChi.getText());

						int k = ptmt.executeUpdate();
						if (k != 0) {
							JOptionPane.showMessageDialog(null, "Thêm thành công");
							String[] row = { txtMaTV.getText(), txtTenTV.getText(), txtEmail.getText(),
									txtSdt.getText(), cbtinh.getSelectedItem().toString(),
									cbhuyen.getSelectedItem().toString(), cbxa.getSelectedItem().toString(),
									txtDiaChi.getText(), txtSach.getText() };
							mdTableBandoc.addRow(row);

							txtMaTV.setText("");
							txtTenTV.setText("");
							txtEmail.setText("");
							txtSdt.setText("");
							cbxa.setSelectedItem(null);
							txtDiaChi.setText("");
							txtSach.setText("");

						} else
							JOptionPane.showMessageDialog(null, "Thêm không thành công");
					} catch (SQLException e) {
						System.out.println("loi  " + e.getMessage());

					}
				} else {
					System.out.println("Kết nối MYSQL thất bại");
				}
			}
		}

	};

	ActionListener evUpdate = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			if (conn != null) {

				String sql = "UPDATE ban_doc SET `ho_ten`=?,`email`=?,`dien_thoai`=?,`tinh_thanh`=?,`quan_huyen`=?,`xa_phuong`=?,`dia_chi`=? WHERE Ma_TV=?";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					// khởi tạo resultset
					ptmt.setString(1, txtTenTV.getText());
					ptmt.setString(2, txtEmail.getText());
					ptmt.setString(3, txtSdt.getText());
					ptmt.setString(4, cbtinh.getSelectedItem().toString());
					ptmt.setString(5, cbhuyen.getSelectedItem().toString());
					ptmt.setString(6, cbxa.getSelectedItem().toString());
					ptmt.setString(7, txtDiaChi.getText());
					ptmt.setString(8, txtMaTV.getText());

					int t = tbListBandoc.getSelectedRow();
					String[] row = { txtMaTV.getText(), txtTenTV.getText(), txtEmail.getText(), txtSdt.getText(),
							cbtinh.getSelectedItem().toString(), cbhuyen.getSelectedItem().toString(),
							cbxa.getSelectedItem().toString(), txtDiaChi.getText(), txtSach.getText() };
					for (int j = 0; j < 8; j++) {
						tbListBandoc.setValueAt(row[j], t, j);
					}

					int k = ptmt.executeUpdate();
					if (k != 0) {

						txtMaTV.setText("");
						txtTenTV.setText("");
						txtEmail.setText("");
						txtSdt.setText("");
						cbtinh.setSelectedItem("");
						cbhuyen.setSelectedItem("");
						cbxa.setSelectedItem("");
						txtDiaChi.setText("");
						txtSach.setText("");

						JOptionPane.showMessageDialog(null, "Sửa thành công");
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

	ActionListener evDelete = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			if (conn != null) {
				String sql = "DELETE FROM ban_doc WHERE Ma_TV=?";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);

					ptmt.setString(1, txtMaTV.getText());

					int kt = ptmt.executeUpdate();
					if (kt != 0) {
						int j = tbListBandoc.getSelectedRow();

						mdTableBandoc.removeRow(j);
						txtMaTV.setText("");
						txtTenTV.setText("");
						txtEmail.setText("");
						txtSdt.setText("");
						cbtinh.setSelectedItem("");
						cbhuyen.setSelectedItem("");
						cbxa.setSelectedItem("");
						txtDiaChi.setText("");
						txtSach.setText("");

						JOptionPane.showMessageDialog(null, "Xóa thành công");
					} else
						JOptionPane.showMessageDialog(null, "Xóa không thành công");
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

	ActionListener evSach = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Sach_UI sach	=	new Sach_UI("Sách");	
			sach.setVisible(true);
			dispose();
		}
	};
	
	ActionListener evPhieu = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			PhieuMuon_UI pm	=	new PhieuMuon_UI("Phiếu mượn");	
			pm.setVisible(true);
			dispose();
		}
	};
	
	ActionListener evThongKe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ThongKeUI tk	=	new ThongKeUI("Thống kê");	
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
			int i = tbListBandoc.getSelectedRow();
			String[] row = new String[9];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tbListBandoc.getValueAt(i, j);
			}
			txtMaTV.setText(row[0]);
			txtTenTV.setText(row[1]);
			txtEmail.setText(row[2]);
			txtSdt.setText(row[3]);
			cbtinh.setSelectedItem(row[4]);
			cbhuyen.setSelectedItem(row[5]);
			cbxa.setSelectedItem(row[6]);
			txtDiaChi.setText(row[7]);
			txtSach.setText(row[8]);
			btAdd.setEnabled(false);
			btEdit.setEnabled(true);
			btDel.setEnabled(true);

		}
	};
	

	private void controls() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnLook = new JPanel();
		pnLook.setBorder(new EmptyBorder(50, 100, 50, 100));
		pnLook.setLayout(new BoxLayout(pnLook, BoxLayout.X_AXIS));
		btLook = new JButton("Tìm kiếm");
		txtLook = new JTextField(20);
		JLabel lbLook5 = new JLabel(" 	     				 	");
		JLabel lbLook6 = new JLabel(" 	      					");
		pnLook.add(lbLook5);
		pnLook.add(txtLook);
		pnLook.add(lbLook6);
		pnLook.add(btLook);

		JPanel pnButton = new JPanel();
		pnButton.setBorder(new EmptyBorder(5, 100, 20, 100));
		pnButton.setLayout(new BoxLayout(pnButton, BoxLayout.X_AXIS));
		JPanel pnReset = new JPanel();
		btReset = new JButton("Reset");
		pnReset.add(btReset);
		JPanel pnAdd = new JPanel();
		btAdd = new JButton("Thêm");
		pnAdd.add(btAdd);
		JPanel pnEdit = new JPanel();
		btEdit = new JButton("Sửa");
		pnEdit.add(btEdit);
		btEdit.setEnabled(false);
		JPanel pnDel = new JPanel();
		btDel = new JButton("Xóa");
		btDel.setEnabled(false);
		pnDel.add(btDel);
		pnButton.add(pnReset);
		pnButton.add(pnAdd);
		pnButton.add(pnEdit);
		pnButton.add(pnDel);

		JPanel pnBanDoc = new JPanel();
		pnBanDoc.setLayout(new BoxLayout(pnBanDoc, BoxLayout.X_AXIS));
		JPanel pnMaKhach = new JPanel();
		JPanel pnTenKhach = new JPanel();
		JPanel pnEmail = new JPanel();
		JPanel pnThanhPho = new JPanel();
		JPanel pnHuyen = new JPanel();
		JPanel pnXa = new JPanel();
		JPanel pnDiaChi = new JPanel();
		JPanel pnSoDT = new JPanel();
		JPanel pnSach = new JPanel();
		JPanel pnBanDocL = new JPanel();
		pnBanDocL.setLayout(new BoxLayout(pnBanDocL, BoxLayout.Y_AXIS));
		JPanel pnBanDocR = new JPanel();
		pnBanDocR.setLayout(new BoxLayout(pnBanDocR, BoxLayout.Y_AXIS));
		JLabel lbMaKhach = new JLabel("Mã thành viên:	");
		lbMaKhach.setPreferredSize(new Dimension(100, 25));
		txtMaTV = new JTextField(20);
		txtMaTV.setEnabled(false);
		JLabel lbTenKhach = new JLabel("Tên thành viên:	");
		lbTenKhach.setPreferredSize(new Dimension(100, 25));
		txtTenTV = new JTextField(20);
		JLabel lbEmail = new JLabel("Email:	");
		lbEmail.setPreferredSize(new Dimension(100, 20));
		txtEmail = new JTextField(20);
		JLabel lbThanhPho = new JLabel("Tỉnh, Thành:	");
		lbThanhPho.setPreferredSize(new Dimension(100, 25));
		ArrayList<String> arr = tinh.getList();
		cbtinh = new JComboBox(arr.toArray());
		cbtinh.setPreferredSize(new Dimension(220, 20));
		cbtinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tinh = cbtinh.getSelectedItem().toString();
				ArrayList<String> arr = huyen.getList(tinh);
				cbhuyen.setModel(new DefaultComboBoxModel<>(arr.toArray()));
			}
		});

		cbtinh.setFont(new Font("Arial", Font.PLAIN, 12));
		cbtinh.setToolTipText("");
		JLabel lbHuyen = new JLabel("Quận, Huyện:	");
		lbHuyen.setPreferredSize(new Dimension(100, 25));
		cbhuyen = new JComboBox();
		cbhuyen.setPreferredSize(new Dimension(220, 20));
		cbhuyen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String quan = cbhuyen.getSelectedItem().toString();
				ArrayList<String> arr = xa.getList(quan);
				cbxa.setModel(new DefaultComboBoxModel<>(arr.toArray()));
			}
		});
		cbhuyen.setFont(new Font("Arial", Font.PLAIN, 12));
		cbhuyen.setToolTipText("");
		JLabel lbXa = new JLabel("Xã, Phường:	");
		lbXa.setPreferredSize(new Dimension(100, 25));
		cbxa = new JComboBox();
		cbxa.setPreferredSize(new Dimension(220, 20));

		cbxa.setFont(new Font("Arial", Font.PLAIN, 12));
		cbxa.setToolTipText("");
		JLabel lbDiaChi = new JLabel("Địa chỉ:	");
		lbDiaChi.setPreferredSize(new Dimension(100, 25));
		txtDiaChi = new JTextField(20);
		JLabel lbSoDT = new JLabel("Số điện thoại:	");
		lbSoDT.setPreferredSize(new Dimension(100, 25));
		txtSdt = new JTextField(20);

		JLabel lbSach = new JLabel("Đang mượn:	");
		lbSach.setPreferredSize(new Dimension(100, 25));
		txtSach = new JTextField(20);
		txtSach.setEnabled(false);

		pnMaKhach.add(lbMaKhach);
		pnMaKhach.add(txtMaTV);
		pnTenKhach.add(lbTenKhach);
		pnTenKhach.add(txtTenTV);
		pnEmail.add(lbEmail);
		pnEmail.add(txtEmail);
		pnThanhPho.add(lbThanhPho);
		pnThanhPho.add(cbtinh);
		pnHuyen.add(lbHuyen);
		pnHuyen.add(cbhuyen);
		pnXa.add(lbXa);
		pnXa.add(cbxa);
		pnDiaChi.add(lbDiaChi);
		pnDiaChi.add(txtDiaChi);
		pnSoDT.add(lbSoDT);
		pnSoDT.add(txtSdt);
		pnSach.add(lbSach);
		pnSach.add(txtSach);
		pnBanDocL.add(pnMaKhach);
		pnBanDocL.add(pnTenKhach);
		pnBanDocL.add(pnEmail);
		pnBanDocL.add(pnSoDT);
		pnBanDocL.add(pnSach);
		pnBanDocR.add(pnThanhPho);
		pnBanDocR.add(pnHuyen);
		pnBanDocR.add(pnXa);
		pnBanDocR.add(pnDiaChi);

		pnBanDoc.add(pnBanDocL);
		pnBanDoc.add(pnBanDocR);

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh sách Bạn đọc");
		spListBandoc.setBorder(borderTittle);
		tbListBandoc.setModel(mdTableBandoc);
		spListBandoc.setViewportView(tbListBandoc);

		JPanel pnLink = new JPanel();
		pnLink.setBorder(new EmptyBorder(5, 5, 5, 5));
		btSach = new JButton("Sách");
		btSach.setPreferredSize(new Dimension(200, 40));
		btPhieu = new JButton("Phiếu mượn");
		btPhieu.setPreferredSize(new Dimension(200, 40));
		btThongKe = new JButton("Thống kê");
		btThongKe.setPreferredSize(new Dimension(200, 40));
		btLogout	=	new JButton("Đăng xuất");
		btLogout.setPreferredSize(new Dimension(200, 40));
		pnLink.add(btSach);
		pnLink.add(btPhieu);
		pnLink.add(btThongKe);
		pnLink.add(btLogout);

		pnMain.add(pnLook);
		pnMain.add(pnButton);
		pnMain.add(pnBanDoc);
		pnMain.add(spListBandoc);
		pnMain.add(pnLink);
		con.add(pnMain);
	}

	public void TimKiem() {
		if (conn != null) {

			String sql = "SELECT * from ban_doc WHERE Ma_TV like N'%" + this.txtLook.getText() + "%' "
					+ "or ho_ten like N'%" + this.txtLook.getText() + "%'" + "or email like N'%"
					+ this.txtLook.getText() + "%'" + "or dien_thoai like N'%" + this.txtLook.getText() + "%'"
					+ "or tinh_thanh like N'%" + this.txtLook.getText() + "%'" + "or quan_huyen like N'%"
					+ this.txtLook.getText() + "%'" + "or xa_phuong like N'%" + this.txtLook.getText() + "%'"
					+ "or dia_chi like N'%" + this.txtLook.getText() + "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				mdTableBandoc.setRowCount(0);
				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {

					String rows[] = new String[9];

					rows[0] = rs.getString(1);

					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(6);
					rows[6] = rs.getString(7);
					rows[7] = rs.getString(8);
					rows[8] = rs.getString(9);

					mdTableBandoc.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	private void Display() {
		// TODO Auto-generated method stub
		if (conn != null) {
			String sql = "select * from ban_doc";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {
					String rows[] = new String[9];

					rows[0] = rs.getString(1);

					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(6);
					rows[6] = rs.getString(7);
					rows[7] = rs.getString(8);
					rows[8] = rs.getString(9);

					mdTableBandoc.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	ActionListener evReset = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			txtMaTV.setText("");
			txtTenTV.setText("");
			txtEmail.setText("");
			txtSdt.setText("");
			cbtinh.setSelectedItem("");
			cbhuyen.setSelectedItem("");
			cbxa.setSelectedItem("");
			txtDiaChi.setText("");
			txtSach.setText("");
			btAdd.setEnabled(true);
			btEdit.setEnabled(false);
			btDel.setEnabled(false);
			
		}

	};
	ActionListener evDisplay = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			mdTableBandoc.setRowCount(0);
			Display();

		}
	};

	private void addEvents() {
		// TODO Auto-generated method stub
		tbListBandoc.addMouseListener(eventselect);
		btAdd.addActionListener(evInsert);
		btEdit.addActionListener(evUpdate);
		btDel.addActionListener(evDelete);
		btLook.addActionListener(evTimKiem);
		btReset.addActionListener(evReset);
		btReset.addActionListener(evDisplay);
		btSach.addActionListener(evSach);
		btPhieu.addActionListener(evPhieu);
		btThongKe.addActionListener(evThongKe);
		btLogout.addActionListener(evLogout);
	}

	public static void main(String[] args) {
		Bandoc_UI myUI = new Bandoc_UI("Bạn đọc");
		myUI.addShowWindow();
	}
}
