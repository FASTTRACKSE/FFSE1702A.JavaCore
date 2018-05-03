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

public class Sach_UI extends JFrame {

	Connection conn = (Connection) Connect.getConnect();
	JTextField txtLook, txtTS, txtMS, txtTG, txtNXB, txtSL, txtNamXB, txtTL, txtTT;
	JButton btAdd, btEdit, btDel, btLook, btReset, btBanDoc, btPhieu, btThongKe, btLogout;
	JScrollPane spListSach = new JScrollPane();
	JTable tbListSach = new JTable();
	String tbSach[] = { "Mã Sách", "Tên sách", "Tên tác giả", "Thể loại", "Nhà xuất bản", "Năm xuất bản", "Số lượng",
			"Tình trạng" };
	DefaultTableModel mdTableSach = new DefaultTableModel(tbSach, 0);

	public Sach_UI(String tieude) {
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
			if (txtTS.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên sách");
			} else if (txtTG.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên tác giả");
			} else if (txtTL.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên thể loại");
			} else if (txtNXB.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên Nhà xuất bản");
			} else if (txtNamXB.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng năm xuất bản");
			} else if (txtSL.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng sách");
			} else if (txtTT.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tình trạng sách trong kho");
			} else {
				if (conn != null) {
					String sql = "INSERT INTO sach(Ten_Sach, Ten_Tac_gia, The_loai, Nha_xb, Nam_xb , So_luong, Tinh_trang) VALUES (?,?,?,?,?,?,?)";
					try {
						PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
						// khởi tạo resultset
						// ptmt.setString(1, txtMS.getText());
						ptmt.setString(1, txtTS.getText());
						ptmt.setString(2, txtTG.getText());
						ptmt.setString(3, txtTL.getText());
						ptmt.setString(4, txtNXB.getText());
						ptmt.setString(5, txtNamXB.getText());
						ptmt.setString(6, txtSL.getText());
						ptmt.setString(7, txtTT.getText());
						int k = ptmt.executeUpdate();
						if (k != 0) {

							JOptionPane.showMessageDialog(null, "Thêm thành công");
							String[] row = { txtMS.getText(), txtTS.getText(), txtTG.getText(), txtTL.getText(),
									txtNXB.getText(), txtNamXB.getText(), txtSL.getText(), txtTT.getText() };
							mdTableSach.addRow(row);

							txtMS.setText("");
							txtTS.setText("");
							txtTG.setText("");
							txtTL.setText("");
							txtNXB.setText("");
							txtNamXB.setText("");
							txtSL.setText("");
							txtTT.setText("");
						}

						else {
							JOptionPane.showMessageDialog(null, "Thêm không thành công");
						}
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

				String sql = "UPDATE sach SET `Ten_Sach`=?,`Ten_Tac_gia`=?,The_loai=?,`Nha_xb`=?,`Nam_xb`=?,`So_luong`=?, Tinh_trang=? WHERE Ma_Sach=?";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					// khởi tạo resultset
					// ptmt.setString(1, txtMS.getText());
					ptmt.setString(1, txtTS.getText());
					ptmt.setString(2, txtTG.getText());
					ptmt.setString(3, txtTL.getText());
					ptmt.setString(4, txtNXB.getText());
					ptmt.setString(5, txtNamXB.getText());
					ptmt.setString(6, txtSL.getText());
					ptmt.setString(7, txtTT.getText());

					ptmt.setString(8, txtMS.getText());

					int t = tbListSach.getSelectedRow();
					String[] row = { txtMS.getText(), txtTS.getText(), txtTG.getText(), txtTL.getText(),
							txtNXB.getText(), txtNamXB.getText(), txtSL.getText(), txtTT.getText() };
					for (int j = 0; j < 8; j++) {
						tbListSach.setValueAt(row[j], t, j);
					}

					int k = ptmt.executeUpdate();
					if (k != 0) {

						// mdTableSach.setRowCount(0);

						txtMS.setText("");
						txtTS.setText("");
						txtTG.setText("");
						txtTL.setText("");
						txtNXB.setText("");
						txtNamXB.setText("");
						txtSL.setText("");
						txtTT.setText("");

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
				String sql = "DELETE FROM sach WHERE Ten_Sach=?";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);

					ptmt.setString(1, txtTS.getText());

					int kt = ptmt.executeUpdate();
					if (kt != 0) {
						int j = tbListSach.getSelectedRow();

						mdTableSach.removeRow(j);
						txtMS.setText("");
						txtTS.setText("");
						txtTG.setText("");
						txtTL.setText("");
						txtNXB.setText("");
						txtNamXB.setText("");
						txtSL.setText("");
						txtTT.setText("");
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
	ActionListener evDisplay = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			mdTableSach.setRowCount(0);
			Display();

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
			int i = tbListSach.getSelectedRow();
			String[] row = new String[8];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tbListSach.getValueAt(i, j);
			}

			txtMS.setText(row[0]);
			txtTS.setText(row[1]);
			txtTG.setText(row[2]);
			txtTL.setText(row[3]);
			txtNXB.setText(row[4]);
			txtNamXB.setText(row[5]);
			txtSL.setText(row[6]);
			txtTT.setText(row[7]);
			btAdd.setEnabled(false);
			btEdit.setEnabled(true);
			btDel.setEnabled(true);
		}
	};

	public void controls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnLook = new JPanel();
		pnLook.setBorder(new EmptyBorder(50, 100, 50, 100));
		pnLook.setLayout(new BoxLayout(pnLook, BoxLayout.X_AXIS));

		btLook = new JButton("Tìm kiếm");
		txtLook = new JTextField(20);
		JLabel lbLook1 = new JLabel(" 	     				 	");
		JLabel lbLook2 = new JLabel(" 	      					");

		pnLook.add(lbLook1);
		pnLook.add(txtLook);
		pnLook.add(lbLook2);
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
		btEdit.setEnabled(false);
		pnEdit.add(btEdit);
		JPanel pnDel = new JPanel();
		btDel = new JButton("Xóa");
		btDel.setEnabled(false);
		pnDel.add(btDel);
		pnButton.add(pnReset);
		pnButton.add(pnAdd);
		pnButton.add(pnEdit);
		pnButton.add(pnDel);

		JPanel pnInfo = new JPanel();
		pnInfo.setLayout(new BoxLayout(pnInfo, BoxLayout.X_AXIS));
		JPanel pnMaSach = new JPanel();
		JPanel pnTenSach = new JPanel();
		JPanel pnTacGia = new JPanel();
		JPanel pnTheloai = new JPanel();
		JPanel pnNxb = new JPanel();
		JPanel pnNam = new JPanel();
		JPanel pnSoSach = new JPanel();
		JPanel pnTinhTrang = new JPanel();
		JPanel pnInfoL = new JPanel();
		pnInfoL.setLayout(new BoxLayout(pnInfoL, BoxLayout.Y_AXIS));
		JPanel pnInfoR = new JPanel();
		pnInfoR.setLayout(new BoxLayout(pnInfoR, BoxLayout.Y_AXIS));
		JLabel lbMaSach = new JLabel("Mã sách:	");
		lbMaSach.setPreferredSize(new Dimension(100, 25));
		txtMS = new JTextField(20);
		txtMS.setEnabled(false);
		JLabel lbTenSach = new JLabel("Tên sách:	");
		lbTenSach.setPreferredSize(new Dimension(100, 25));
		txtTS = new JTextField(20);
		JLabel lbTacGia = new JLabel("Tên tác giả:	");
		lbTacGia.setPreferredSize(new Dimension(100, 25));
		txtTG = new JTextField(20);
		JLabel lbTheloai = new JLabel("Thể loại:	");
		lbTheloai.setPreferredSize(new Dimension(100, 25));
		txtTL = new JTextField(20);
		JLabel lbNxb = new JLabel("Nhà xuất bản:	");
		lbNxb.setPreferredSize(new Dimension(100, 25));
		txtNXB = new JTextField(20);
		JLabel lbNam = new JLabel("Năm xuất bản: ");
		lbNam.setPreferredSize(new Dimension(100, 25));
		txtNamXB = new JTextField(20);
		JLabel lbSoSach = new JLabel("Số lượng:	");
		lbSoSach.setPreferredSize(new Dimension(100, 25));
		txtSL = new JTextField(20);
		JLabel lbTinhTrang = new JLabel("Tình trạng:	");
		lbTinhTrang.setPreferredSize(new Dimension(100, 25));
		txtTT = new JTextField(20);

		pnMaSach.add(lbMaSach);
		pnMaSach.add(txtMS);
		pnTenSach.add(lbTenSach);
		pnTenSach.add(txtTS);
		pnTacGia.add(lbTacGia);
		pnTacGia.add(txtTG);
		pnTheloai.add(lbTheloai);
		pnTheloai.add(txtTL);
		pnNxb.add(lbNxb);
		pnNxb.add(txtNXB);
		pnNam.add(lbNam);
		pnNam.add(txtNamXB);
		pnSoSach.add(lbSoSach);
		pnSoSach.add(txtSL);
		pnTinhTrang.add(lbTinhTrang);
		pnTinhTrang.add(txtTT);
		pnInfoL.add(pnMaSach);
		pnInfoL.add(pnTenSach);
		pnInfoL.add(pnTacGia);
		pnInfoL.add(pnTheloai);
		pnInfoR.add(pnNxb);
		pnInfoR.add(pnNam);
		pnInfoR.add(pnSoSach);
		pnInfoR.add(pnTinhTrang);
		pnInfo.add(pnInfoL);
		pnInfo.add(pnInfoR);

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh Sach");
		spListSach.setBorder(borderTittle);
		tbListSach.setModel(mdTableSach);
		spListSach.setViewportView(tbListSach);

		JPanel pnLink = new JPanel();
		pnLink.setBorder(new EmptyBorder(5, 5, 5, 5));
		btBanDoc = new JButton("Bạn đọc");
		btBanDoc.setPreferredSize(new Dimension(200, 40));
		btPhieu = new JButton("Phiếu mượn");
		btPhieu.setPreferredSize(new Dimension(200, 40));
		btThongKe = new JButton("Thống kê");
		btThongKe.setPreferredSize(new Dimension(200, 40));
		btLogout	=	new JButton("Đăng xuất");
		btLogout.setPreferredSize(new Dimension(200, 40));
		pnLink.add(btBanDoc);
		pnLink.add(btPhieu);
		pnLink.add(btThongKe);
		pnLink.add(btLogout);

		pnMain.add(pnLook);
		pnMain.add(pnButton);
		pnMain.add(pnInfo);
		pnMain.add(spListSach);
		pnMain.add(pnLink);
		con.add(pnMain);
 
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
					rows[5] = rs.getString(6);
					rows[6] = rs.getString(7);
					rows[7] = rs.getString(8);

					mdTableSach.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	//PreparedStatement ptmt = null;

	public void Display() {
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
					rows[5] = rs.getString(6);
					rows[6] = rs.getString(7);
					rows[7] = rs.getString(8);

					mdTableSach.addRow(rows);
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
			txtMS.setText("");
			txtTS.setText("");
			txtNXB.setText("");
			txtTL.setText("");
			txtTG.setText("");
			txtTT.setText("");
			txtNamXB.setText("");
			txtSL.setText("");
			btAdd.setEnabled(true);
			btEdit.setEnabled(false);
			btDel.setEnabled(false);
		}

	};

	public void addEvents() {
		tbListSach.addMouseListener(eventselect);
		btEdit.addActionListener(evUpdate);
		btAdd.addActionListener(evInsert);
		btDel.addActionListener(evDelete);
		btLook.addActionListener(evTimKiem);
		btReset.addActionListener(evReset);
		btReset.addActionListener(evDisplay);
		btBanDoc.addActionListener(evBanDoc);
		btPhieu.addActionListener(evPhieu);
		btThongKe.addActionListener(evThongKe);
		btLogout.addActionListener(evLogout);

	}

	public static void main(String[] args) {
		Sach_UI myUI = new Sach_UI("Quản lý sách");
		myUI.addShowWindow();
	}

}
