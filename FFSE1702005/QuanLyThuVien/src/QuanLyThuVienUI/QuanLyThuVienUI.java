package QuanLyThuVienUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuanLyThuVienUI extends JFrame {
	public QuanLyThuVienUI(String tieude) {
		super(tieude);
		addControls();
		addEvents();
	}

	// Kết nối database
	private void connect() {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, pass);
			System.out.print("Kết nối thành công");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy lớp", "Connection Error", JOptionPane.PLAIN_MESSAGE,
					icon);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi khi kết nối dữ liệu vui lòng bật ampps hoặc xampp",
					"Connection Error", JOptionPane.PLAIN_MESSAGE, icon);
		}
	}

	// Làm mới dữ liệu quản lý sách
	private void loadData() {
		// create table model
		bang.setRowCount(0);
		bangbr2.setRowCount(0);
		ResultSet rs = getData();
		try {
			while (rs.next()) {
				bang.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
				bangbr2.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(8) });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tbl.setModel(bang);
	}

	// Làm mới dữ liệu quản lý đọc giả
	private void loadDataDG() {
		// create table model
		bangdg.setRowCount(0);
		bangbr1.setRowCount(0);
		ResultSet rs = docGia();
		try {
			while (rs.next()) {
				bangdg.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
				bangbr1.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(9), rs.getString(7) });
				bangtkdg.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		tbldg.setModel(bangdg);
	}

	// Làm mới dữ liệu quản lý mượn trả
	private void loadDataBR() {
		// create table model
		bangbr3.setRowCount(0);
		ResultSet rs = muonTra();
		try {
			while (rs.next()) {
				bangbr3.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tblbr3.setModel(bangbr3);
	}

	// Làm mới dữ liệu thống kê, báo cáo
	private void loadDataTK() {
		bangtk.setRowCount(0);
		ResultSet rs = getData();
		try {
			while (rs.next()) {
				bangtk.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbltk.setModel(bangtk);
	}

	// Làm mới dữ liệu thống kê, báo cáo đọc giả
	private void loadDataTK1() {
		bangtkdg.setRowCount(0);
		ResultSet rs = docGia();
		try {
			while (rs.next()) {
				bangtkdg.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbltk.setModel(bangtk);
	}

	// Lấy data nhà xuất bản(combobox)
	private ResultSet nXB() {
		ResultSet rs = null;
		String sqlCommand = "SELECT * FROM NhaXuatBan ORDER BY Ten ASC";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Lấy data thể loại(combobox)
	private ResultSet theLoai() {
		ResultSet rs = null;
		String sqlCommand = "SELECT * FROM TheLoai ORDER BY Ten ASC";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Lấy data tác giả(combobox)
	private ResultSet tacGia() {
		ResultSet rs = null;
		String sqlCommand = "SELECT DISTINCT `Ten_Tac_Gia` FROM Sach ORDER BY Ten_Tac_Gia ASC";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Lấy data thành phố(combobox)
	private ResultSet thanhPho() {
		ResultSet rs = null;
		String sqlCommand = "SELECT * FROM VN_tinhthanhpho ORDER BY name ASC";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Lấy data quận(combobox)
	private ResultSet quan() {
		ResultSet rs = null;
		String sqlCommand = "SELECT * FROM VN_quanhuyen ORDER BY name ASC";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Lấy data phường(combobox)
	private ResultSet phuong() {
		ResultSet rs = null;
		String sqlCommand = "SELECT * FROM VN_xaphuongthitran ORDER BY name ASC";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Lấy data sách
	private ResultSet getData() {
		ResultSet rs = null;
		String sqlCommand = "SELECT * FROM Sach ORDER BY ID DESC";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Lấy data đọc giả
	private ResultSet docGia() {
		ResultSet rs = null;
		String sqlCommand = "SELECT * FROM BanDoc ORDER BY ID DESC";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Lấy data mượn trả
	private ResultSet muonTra() {
		ResultSet rs = null;
		String sqlCommand = "SELECT * FROM MuonTra WHERE TinhTrang = 'Đang mượn' ORDER BY MaGD DESC";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// In ra nhà xuất bản(combobox)
	private void showNXB(ResultSet rs) {
		try {
			while (rs.next()) {
				jtnxb.addItem(rs.getString(2));
				nxbcb.addItem(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// In ra thể loại(combobox)
	private void showTL(ResultSet rs) {
		try {
			while (rs.next()) {
				jttl.addItem(rs.getString(2));
				tlcb.addItem(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// In ra tác giả(combobox)
	private void showTG(ResultSet rs) {
		try {
			while (rs.next()) {
				tgcb.addItem(rs.getString("Ten_Tac_Gia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// In ra thành phố(combobox)
	private void showTP(ResultSet rs) {
		try {
			while (rs.next()) {
				jttp.addItem(rs.getString(2));
				tpcb.addItem(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// In ra quận(combobox)
	private void showQuan(ResultSet rs) {
		try {
			while (rs.next()) {
				jtquan.addItem(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// In ra phường(combobox)
	private void showPhuong(ResultSet rs) {
		try {
			while (rs.next()) {
				jtphuong.addItem(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// In ra data từ bảng đọc giả
	private void showDocGia(ResultSet rs) {
		try {
			while (rs.next()) {
				bangdg.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
				bangbr1.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(9), rs.getString(7) });
				bangtkdg.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// In ra data từ bảng sách
	private void showData(ResultSet rs) {
		try {
			while (rs.next()) {
				bang.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
				bangbr2.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(8) });
				bangtk.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// In ra data từ bảng mượn trả
	private void showMT(ResultSet rs) {
		try {
			while (rs.next()) {
				bangbr3.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Xóa sách
	public void delete(String ID_Sach) {
		String sqlCommand = "DELETE FROM Sach WHERE ID_Sach = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) connection.prepareStatement(sqlCommand);
			pst.setString(1, ID_Sach);
			if (pst.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Xóa sách thành công", "Delete Button", JOptionPane.PLAIN_MESSAGE,
						icon1);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi xóa sách", "Delete Button", JOptionPane.PLAIN_MESSAGE,
						icon);
			}
		} catch (SQLException e) {
			System.out.println("delete error \n" + e.toString());
		}
	}

	// Thêm sách
	public void insert() {
		String id = "Select Max(ID) as MAXID from Sach";
		int rsid = 0;
		try {
			Statement stm = (Statement) connection.createStatement();
			ResultSet rs = stm.executeQuery(id);
			rs.next();
			rsid = rs.getInt("MAXID");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sqlCommand = "INSERT INTO Sach (`ID_Sach`, `Ten_Sach`, `The_Loai`, `Ten_Tac_Gia`, `Nha_Xuat_Ban`, `Nam_Xuat_Ban`, `So_Luong`,`TinhTrang`) VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) connection.prepareStatement(sqlCommand);
			pst.setString(1, "DS" + (rsid + 1));
			pst.setString(2, ten.getText());
			pst.setString(3, (String) jttl.getSelectedItem());
			pst.setString(4, jttentg.getText());
			pst.setString(5, (String) jtnxb.getSelectedItem());
			pst.setString(6, jtnamxb.getText());
			pst.setString(7, jtsl.getText());
			pst.setString(8, jtsl.getText());
			if (pst.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Thêm sách thành công", "Add Button", JOptionPane.PLAIN_MESSAGE,
						icon1);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm sách", "Add Button", JOptionPane.PLAIN_MESSAGE, icon);
			}
		} catch (SQLException e) {
			System.out.println("insert error \n" + e.toString());
		}
	}

	// Sửa sách
	public void update(String ID_Sach) {
		String sqlCommand = "UPDATE Sach SET Ten_Sach = ?, The_Loai = ?, Ten_Tac_Gia = ?, Nha_Xuat_Ban = ?, Nam_Xuat_Ban = ?, So_Luong = ? WHERE ID_Sach = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) connection.prepareStatement(sqlCommand);
			pst.setString(1, ten.getText());
			pst.setString(2, (String) jttl.getSelectedItem());
			pst.setString(3, jttentg.getText());
			pst.setString(4, (String) jtnxb.getSelectedItem());
			pst.setString(5, jtnamxb.getText());
			pst.setString(6, jtsl.getText());
			pst.setString(7, ID_Sach);
			if (pst.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Sửa sách thành công", "Update Button", JOptionPane.PLAIN_MESSAGE,
						icon1);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi lưu sách", "Update Button", JOptionPane.PLAIN_MESSAGE,
						icon);
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
	}

	// Xóa đọc giả
	public void deleteDG(String ID) {
		String sqlCommand = "DELETE FROM BanDoc WHERE ID = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) connection.prepareStatement(sqlCommand);
			pst.setString(1, ID);
			if (pst.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Xóa sách thành công", "Delete Button", JOptionPane.PLAIN_MESSAGE,
						icon1);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi xóa sách", "Delete Button", JOptionPane.PLAIN_MESSAGE,
						icon);
			}
		} catch (SQLException e) {
			System.out.println("delete error \n" + e.toString());
		}
	}

	// Thêm đọc giả
	public void insertDG() {
		String sqlCommand = "INSERT INTO BanDoc (`HoTen`, `Dia_Chi`, `Thanh_Pho`, `Quan`, `Phuong`, `SDT`,`Email`) VALUE(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) connection.prepareStatement(sqlCommand);
			pst.setString(1, tendg.getText());
			pst.setString(2, jtdc.getText());
			pst.setString(3, (String) jttp.getSelectedItem());
			pst.setString(4, (String) jtquan.getSelectedItem());
			pst.setString(5, (String) jtphuong.getSelectedItem());
			pst.setString(6, jtsdt.getText());
			pst.setString(7, jtemail.getText());
			if (pst.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Thêm đọc giả thành công", "Add Button", JOptionPane.PLAIN_MESSAGE,
						icon1);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm đọc giả", "Add Button", JOptionPane.PLAIN_MESSAGE,
						icon);
			}
		} catch (SQLException e) {
			System.out.println("insert error \n" + e.toString());
		}
	}

	// Sửa đọc giả
	public void updateDG(String ID) {
		String sqlCommand = "UPDATE BanDoc SET HoTen = ?, Dia_Chi = ?, Thanh_Pho = ?, Quan = ?, Phuong = ?, SDT= ?, Email = ? WHERE ID = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) connection.prepareStatement(sqlCommand);
			pst.setString(1, tendg.getText());
			pst.setString(2, jtdc.getText());
			pst.setString(3, (String) jttp.getSelectedItem());
			pst.setString(4, (String) jtquan.getSelectedItem());
			pst.setString(5, (String) jtphuong.getSelectedItem());
			pst.setString(6, jtsdt.getText());
			pst.setString(7, jtemail.getText());
			pst.setString(8, ID);
			if (pst.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Sửa đọc giả thành công", "Update Button",
						JOptionPane.PLAIN_MESSAGE, icon1);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi lưu đọc giả", "Update Button", JOptionPane.PLAIN_MESSAGE,
						icon);
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
	}

	// Cho mượn
	public void muon() {
		String sqlCommand = "INSERT INTO MuonTra (`TenDG`, `ID_DG`, `SDT`, `TenSach`, `ID_Sach`, `Tac_Gia`,`NgayMuon`,`TinhTrang`) VALUE(?, ?, ?, ?, ?, ?, ?,'Đang mượn')";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) connection.prepareStatement(sqlCommand);
			pst.setString(1, jtten.getText());
			pst.setString(2, jtmadg1.getText());
			pst.setString(3, jtdt.getText());
			pst.setString(4, jttensach.getText());
			pst.setString(5, jtmas.getText());
			pst.setString(6, jttg.getText());
			pst.setString(7, jtmuon.getText());
			if (pst.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Cho mượn thành công", "Add Button", JOptionPane.PLAIN_MESSAGE,
						icon1);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi mượn", "Add Button", JOptionPane.PLAIN_MESSAGE, icon);
			}
		} catch (SQLException e) {
			System.out.println("insert error \n" + e.toString());
		}
	}

	// Trả sách
	public void traSach(String MaGD) {
		String sqlCommand = "UPDATE MuonTra SET TinhTrang = 'Đã trả' WHERE MaGD = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) connection.prepareStatement(sqlCommand);
			pst.setString(1, MaGD);
			if (pst.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Trả sách thành công", "Borrow Button", JOptionPane.PLAIN_MESSAGE,
						icon1);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi trả sách", "Borrow Button", JOptionPane.PLAIN_MESSAGE,
						icon);
			}
		} catch (SQLException e) {
			System.out.println("error \n" + e.toString());
		}
	}

	public void ttDG1(String ID) {
		String sqlCommand = "UPDATE BanDoc SET `SachDangMuon` = `SachDangMuon` - 1 WHERE ID = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) connection.prepareStatement(sqlCommand);
			pst.setString(1, ID);
			if (pst.executeUpdate() > 0) {
				// JOptionPane.showMessageDialog(null, "Cho mượn thành công", "Add Button",
				// JOptionPane.PLAIN_MESSAGE,
				// icon);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi mượn", "Add Button", JOptionPane.PLAIN_MESSAGE, icon);
			}
		} catch (SQLException e) {
			System.out.println("error \n" + e.toString());
		}
	}

	public void ttSach1(String ID) {
		String sqlCommand = "UPDATE Sach SET `TinhTrang` = `TinhTrang` + 1 WHERE ID_Sach = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) connection.prepareStatement(sqlCommand);
			pst.setString(1, ID);
			if (pst.executeUpdate() > 0) {
				// JOptionPane.showMessageDialog(null, "Cho mượn thành công", "Add Button",
				// JOptionPane.PLAIN_MESSAGE,
				// icon);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi mượn", "Add Button", JOptionPane.PLAIN_MESSAGE, icon);
			}
		} catch (SQLException e) {
			System.out.println("error \n" + e.toString());
		}
	}

	// Tổng sách
	public ResultSet tongSach() {
		ResultSet rs = null;
		String sqlCommand = "SELECT SUM(So_Luong), SUM(TinhTrang) FROM Sach";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
			while (rs.next()) {
				tongs.setText(rs.getString(1) + " cuốn");
				tonk.setText(rs.getString(2) + " cuốn");
			}
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Tổng sách NXB
	public ResultSet tongSach1() {
		ResultSet rs = null;
		String sqlCommand = "SELECT SUM(So_Luong), SUM(TinhTrang) FROM Sach WHERE Nha_Xuat_Ban ='"
				+ (String) nxbcb.getSelectedItem() + "'";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
			while (rs.next()) {
				tongs.setText(rs.getString(1) + " cuốn");
				tonk.setText(rs.getString(2) + " cuốn");
			}
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Tổng sách thể loại
	public ResultSet tongSach2() {
		ResultSet rs = null;
		String sqlCommand = "SELECT SUM(So_Luong), SUM(TinhTrang) FROM Sach WHERE The_Loai ='"
				+ (String) tlcb.getSelectedItem() + "'";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
			while (rs.next()) {
				tongs.setText(rs.getString(1) + " cuốn");
				tonk.setText(rs.getString(2) + " cuốn");
			}
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Tổng sách tác giả
	public ResultSet tongSach3() {
		ResultSet rs = null;
		String sqlCommand = "SELECT SUM(So_Luong), SUM(TinhTrang) FROM Sach WHERE Ten_Tac_Gia ='"
				+ (String) tgcb.getSelectedItem() + "'";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
			while (rs.next()) {
				tongs.setText(rs.getString(1) + " cuốn");
				tonk.setText(rs.getString(2) + " cuốn");
			}
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Tình trạng sách
	public void ttSach(String ID_Sach) {
		String sqlCommand = "UPDATE Sach SET `TinhTrang` = `TinhTrang` - 1 WHERE ID_Sach = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) connection.prepareStatement(sqlCommand);
			pst.setString(1, ID_Sach);
			if (pst.executeUpdate() > 0) {
				// JOptionPane.showMessageDialog(null, "Cho mượn thành công", "Add Button",
				// JOptionPane.PLAIN_MESSAGE,
				// icon);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi mượn", "Add Button", JOptionPane.PLAIN_MESSAGE, icon);
			}
		} catch (SQLException e) {
			System.out.println("error \n" + e.toString());
		}
	}

	// Tình trạng bạn đọc
	public void ttDG(String ID) {
		String sqlCommand = "UPDATE BanDoc SET `SachDangMuon` = `SachDangMuon` + 1 WHERE ID = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) connection.prepareStatement(sqlCommand);
			pst.setString(1, ID);
			if (pst.executeUpdate() > 0) {
				// JOptionPane.showMessageDialog(null, "Cho mượn thành công", "Add Button",
				// JOptionPane.PLAIN_MESSAGE,
				// icon);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi mượn", "Add Button", JOptionPane.PLAIN_MESSAGE, icon);
			}
		} catch (SQLException e) {
			System.out.println("error \n" + e.toString());
		}
	}

	// Kiểm tra đọc giả
	private ResultSet ktDG() {
		ResultSet rs = null;
		ResultSet rs1 = null;
		Statement st;
		Statement st1;
		int rsdg = 0;
		int rssach = 0;
		String sqlCommand = "SELECT SachDangMuon FROM BanDoc WHERE ID ='" + jtmadg1.getText() + "'";
		String sqlCommand1 = "SELECT TinhTrang FROM Sach WHERE ID_Sach ='" + jtmas.getText() + "'";
		int row1 = tblbr1.getSelectedRow();
		int row2 = tblbr2.getSelectedRow();
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sqlCommand);
			st1 = (Statement) connection.createStatement();
			rs1 = st1.executeQuery(sqlCommand1);
			rs.next();
			rs1.next();
			rsdg = rs.getInt("SachDangMuon");
			rssach = rs1.getInt("TinhTrang");
			if (rsdg >= 3) {
				JOptionPane.showMessageDialog(null, "Mỗi đọc giả chỉ được mượn 3 cuốn", "Add Button",
						JOptionPane.PLAIN_MESSAGE, icon1);
			} else if (rssach == 0) {
				JOptionPane.showMessageDialog(null, "Số sách không đủ", "Add Button", JOptionPane.PLAIN_MESSAGE, icon1);
			} else {
				muon();
				ttDG((String) tblbr1.getValueAt(row1, 0));
				ttSach((String) tblbr2.getValueAt(row2, 0));
				tblbr1.getSelectionModel().clearSelection();
				tblbr2.getSelectionModel().clearSelection();
			}
		} catch (SQLException e) {
			System.out.print("Select error \n" + e.toString());
		}
		return rs;
	}

	// Tìm kiếm sách
	public void timKiem() {
		try {
			String sqlCommand = "SELECT * FROM Sach WHERE Sach.ID_Sach LIKE'" + jtfind.getText().trim() + "%'"
					+ " OR Sach.Ten_Sach LIKE'" + jtfind.getText().trim() + "%'" + " OR Sach.The_Loai LIKE'"
					+ jtfind.getText().trim() + "%'" + " OR Sach.Ten_Tac_Gia LIKE'" + jtfind.getText().trim() + "%'"
					+ " OR Sach.Nha_Xuat_Ban LIKE'" + jtfind.getText().trim() + "%'" + " OR Sach.Nam_Xuat_Ban LIKE'"
					+ jtfind.getText().trim() + "%'";
			Statement stm = (Statement) connection.createStatement();
			ResultSet rs = stm.executeQuery(sqlCommand);
			// bang.getDataVector().removeAllElements();
			bang.setRowCount(0);
			while (rs.next()) {
				bang.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu !", "Warning", JOptionPane.ERROR_MESSAGE);
		}

	}

	// Tìm kiếm nhà xuất bản
	public void timKiemNXB() {
		try {
			String sqlCommand = "SELECT * FROM Sach WHERE Nha_Xuat_Ban = '" + (String) nxbcb.getSelectedItem() + "'";
			Statement stm = (Statement) connection.createStatement();
			ResultSet rs = stm.executeQuery(sqlCommand);
			// bang.getDataVector().removeAllElements();
			bangtk.setRowCount(0);
			while (rs.next()) {
				bangtk.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu !", "Warning", JOptionPane.ERROR_MESSAGE);
		}

	}

	// Tìm kiếm thể loại
	public void timKiemTL() {
		try {
			String sqlCommand = "SELECT * FROM Sach WHERE The_Loai = '" + (String) tlcb.getSelectedItem() + "'";
			Statement stm = (Statement) connection.createStatement();
			ResultSet rs = stm.executeQuery(sqlCommand);
			// bang.getDataVector().removeAllElements();
			bangtk.setRowCount(0);
			while (rs.next()) {
				bangtk.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu !", "Warning", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Tìm kiếm thành phố
	public void timKiemTP() {
		try {
			String sqlCommand = "SELECT * FROM BanDoc WHERE Thanh_Pho = '" + (String) tpcb.getSelectedItem() + "'";
			Statement stm = (Statement) connection.createStatement();
			ResultSet rs = stm.executeQuery(sqlCommand);
			// bang.getDataVector().removeAllElements();
			bangtkdg.setRowCount(0);
			while (rs.next()) {
				bangtkdg.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu !", "Warning", JOptionPane.ERROR_MESSAGE);
		}

	}

	// Tìm kiếm mã đọc giả
	public void timKiemMa() {
		try {
			String sqlCommand = "SELECT * FROM BanDoc WHERE ID = '" + jttp1.getText() + "'";
			Statement stm = (Statement) connection.createStatement();
			ResultSet rs = stm.executeQuery(sqlCommand);
			// bang.getDataVector().removeAllElements();
			bangtkdg.setRowCount(0);
			while (rs.next()) {
				bangtkdg.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu !", "Warning", JOptionPane.ERROR_MESSAGE);
		}

	}

	// Tìm kiếm tác giả
	public void timKiemTG() {
		try {
			String sqlCommand = "SELECT * FROM Sach WHERE Ten_Tac_Gia = '" + (String) tgcb.getSelectedItem() + "'";
			Statement stm = (Statement) connection.createStatement();
			ResultSet rs = stm.executeQuery(sqlCommand);
			// bang.getDataVector().removeAllElements();
			bangtk.setRowCount(0);
			while (rs.next()) {
				bangtk.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu !", "Warning", JOptionPane.ERROR_MESSAGE);
		}

	}

	// Tìm kiếm đọc giả
	public void timKiemDG() {
		try {
			String sqlCommand = "SELECT * FROM BanDoc WHERE ID LIKE'" + jtfinddg.getText().trim() + "%'"
					+ " OR HoTen LIKE'" + jtfinddg.getText().trim() + "%'" + " OR Thanh_Pho LIKE'"
					+ jtfinddg.getText().trim() + "%'" + " OR Quan LIKE'" + jtfinddg.getText().trim() + "%'"
					+ " OR Phuong LIKE'" + jtfinddg.getText().trim() + "%'" + " OR Email LIKE'"
					+ jtfinddg.getText().trim() + "%'";
			Statement stm = (Statement) connection.createStatement();
			ResultSet rs = stm.executeQuery(sqlCommand);
			// bang.getDataVector().removeAllElements();
			bangdg.setRowCount(0);
			while (rs.next()) {
				bangdg.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu !", "Warning", JOptionPane.ERROR_MESSAGE);
		}

	}

	// Tìm kiếm đọc giả mượn trả
	public void timKiemBR1() {
		try {
			String sqlCommand = "SELECT * FROM BanDoc WHERE ID LIKE'" + jtfindbr1.getText().trim() + "%'"
					+ " OR HoTen LIKE'" + jtfindbr1.getText().trim() + "%'" + " OR SDT LIKE'"
					+ jtfindbr1.getText().trim() + "%'";
			Statement stm = (Statement) connection.createStatement();
			ResultSet rs = stm.executeQuery(sqlCommand);
			bangbr1.setRowCount(0);
			while (rs.next()) {
				bangbr1.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(9), rs.getString(7) });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu !", "Warning", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Tìm kiếm sách mượn trả
	public void timKiemBR2() {
		try {
			String sqlCommand = "SELECT * FROM Sach WHERE Sach.ID_Sach LIKE'" + jtfindbr2.getText().trim() + "%'"
					+ " OR Sach.Ten_Sach LIKE'" + jtfindbr2.getText().trim() + "%'" + " OR Sach.Ten_Tac_Gia LIKE'"
					+ jtfindbr2.getText().trim() + "%'";
			Statement stm = (Statement) connection.createStatement();
			ResultSet rs = stm.executeQuery(sqlCommand);
			bangbr2.setRowCount(0);
			while (rs.next()) {
				bangbr2.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(8) });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu !", "Warning", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Tìm kiếm mượn trả
	public void timKiemBR3() {
		try {
			String sqlCommand = "SELECT * FROM MuonTra WHERE MaGD LIKE'" + jtfindbr3.getText().trim() + "%'"
					+ " OR TenDG LIKE'" + jtfindbr3.getText().trim() + "%'" + " OR NgayMuon LIKE'"
					+ jtfindbr3.getText().trim() + "%'";
			Statement stm = (Statement) connection.createStatement();
			ResultSet rs = stm.executeQuery(sqlCommand);
			bangbr3.setRowCount(0);
			while (rs.next()) {
				bangbr3.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu !", "Warning", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Chọn dữ liệu từ bảng sách
	MouseAdapter eventSelect = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tbl.getSelectedRow();
			String[] row = new String[7];
			for (int j = 0; j < 7; j++) {
				row[j] = (String) tbl.getValueAt(i, j);
			}
			jtma.setText(row[0]);
			ten.setText(row[1]);
			jttl.setSelectedItem(row[2]);
			jttentg.setText(row[3]);
			jtnxb.setSelectedItem(row[4]);
			jtnamxb.setText(row[5]);
			jtsl.setText(row[6]);
		}
	};

	// Chọn dữ liệu từ bảng đọc giả
	MouseAdapter eventSelectDG = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tbldg.getSelectedRow();
			String[] row = new String[8];
			for (int j = 0; j < 8; j++) {
				row[j] = (String) tbldg.getValueAt(i, j);
			}
			jtmadg.setText(row[0]);
			tendg.setText(row[1]);
			jtdc.setText(row[2]);
			jttp.setSelectedItem(row[3]);
			jtquan.setSelectedItem(row[4]);
			jtphuong.setSelectedItem(row[5]);
			jtsdt.setText(row[6]);
			jtemail.setText(row[7]);
		}
	};

	// Chọn dữ liệu từ bảng sách trong mượn trả
	MouseAdapter eventSelectSBR = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tblbr2.getSelectedRow();
			String[] row = new String[3];
			for (int j = 0; j < 3; j++) {
				row[j] = (String) tblbr2.getValueAt(i, j);
			}
			jtmas.setText(row[0]);
			jttensach.setText(row[1]);
			jttg.setText(row[2]);
		}
	};

	// Chọn dữ liệu từ bảng đọc giả trong mượn trả
	MouseAdapter eventSelectDGBR = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tblbr1.getSelectedRow();
			String[] row = new String[4];
			for (int j = 0; j < 4; j++) {
				row[j] = (String) tblbr1.getValueAt(i, j);
			}
			jtmadg1.setText(row[0]);
			jtten.setText(row[1]);
			jtdt.setText(row[3]);
		}
	};

	// Chọn dữ liệu từ bảng mượn trả trong mượn trả
	MouseAdapter eventSelectBR = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tblbr3.getSelectedRow();
			String[] row = new String[8];
			for (int j = 0; j < 8; j++) {
				row[j] = (String) tblbr3.getValueAt(i, j);
			}
			jtmabr.setText(row[0]);
			jtten.setText(row[1]);
			jtmadg1.setText(row[2]);
			jtdt.setText(row[3]);
			jttensach.setText(row[4]);
			jtmas.setText(row[5]);
			jttg.setText(row[6]);
			jtmuon.setText(row[7]);
		}
	};

	public void addControls() {

		con = getContentPane();

		// Menu

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel iconb = new JPanel();
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon("book (1).png").getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH));
		img = new JButton("Quản lý sách", imageIcon);
		img.setHorizontalTextPosition(AbstractButton.CENTER);
		img.setVerticalTextPosition(AbstractButton.BOTTOM);
		img.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		img.setPreferredSize(new Dimension(210, 210));
		// img.setBackground(new Color(255, 255, 255));
		img.setFocusPainted(false);
		// img.setBorderPainted(false);
		img.setContentAreaFilled(false);
		iconb.add(img);

		JPanel iconrd = new JPanel();
		ImageIcon imageIconrd = new ImageIcon(
				new ImageIcon("reader.png").getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH));
		imgrd = new JButton("Quản lý đọc giả", imageIconrd);
		imgrd.setHorizontalTextPosition(AbstractButton.CENTER);
		imgrd.setVerticalTextPosition(AbstractButton.BOTTOM);
		imgrd.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		imgrd.setPreferredSize(new Dimension(210, 210));
		// imgrd.setBackground(new Color(255, 255, 255));
		imgrd.setFocusPainted(false);
		// imgrd.setBorderPainted(false);
		imgrd.setContentAreaFilled(false);
		iconrd.add(imgrd);

		JPanel iconbr = new JPanel();
		ImageIcon imageIconr = new ImageIcon(
				new ImageIcon("rent.png").getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH));
		imgbr = new JButton("Quản lý mượn, trả", imageIconr);
		imgbr.setHorizontalTextPosition(AbstractButton.CENTER);
		imgbr.setVerticalTextPosition(AbstractButton.BOTTOM);
		imgbr.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		imgbr.setPreferredSize(new Dimension(210, 210));
		// imgbr.setBackground(new Color(255, 255, 255));
		imgbr.setFocusPainted(false);
		// imgbr.setBorderPainted(false);
		imgbr.setContentAreaFilled(false);
		iconbr.add(imgbr);

		JPanel icontk = new JPanel();
		ImageIcon imageIcontk = new ImageIcon(
				new ImageIcon("thongke.png").getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH));
		imgtk = new JButton("Thống kê, báo cáo", imageIcontk);
		imgtk.setHorizontalTextPosition(AbstractButton.CENTER);
		imgtk.setVerticalTextPosition(AbstractButton.BOTTOM);
		imgtk.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		imgtk.setPreferredSize(new Dimension(210, 210));
		// imgtk.setBackground(new Color(255, 255, 255));
		imgtk.setFocusPainted(false);
		// imgtk.setBorderPainted(false);
		imgtk.setContentAreaFilled(false);

		icontk.add(imgtk);

		pnMain.add(iconb);
		pnMain.add(iconrd);
		pnMain.add(iconbr);
		pnMain.add(icontk);

		// Quản lý sách

		JPanel cards = new JPanel(new CardLayout());

		managerbook = new JPanel();
		managerbook.setLayout(new BoxLayout(managerbook, BoxLayout.Y_AXIS));

		JPanel pnFlow = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		pnFlow.setLayout(flowLayout);

		ImageIcon iconsave = new ImageIcon(
				new ImageIcon("save.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		luu = new JButton("Lưu", iconsave);
		luu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		luu.setFocusPainted(false);
		pnFlow.add(luu);

		ImageIcon iconadd = new ImageIcon(
				new ImageIcon("add.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		add = new JButton("Thêm", iconadd);
		add.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add.setFocusPainted(false);
		pnFlow.add(add);

		ImageIcon icondelete = new ImageIcon(
				new ImageIcon("delete.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		xoa = new JButton("Xóa", icondelete);
		xoa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		xoa.setFocusPainted(false);
		pnFlow.add(xoa);
		flowLayout.setHgap(280);

		JPanel title = new JPanel();
		ImageIcon manabook = new ImageIcon(
				new ImageIcon("images.jpg").getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH));
		JLabel mnb = new JLabel(manabook);
		JLabel pt = new JLabel("   Quản lý sách");
		pt.setFont(new Font("Times New Roman", Font.BOLD, 35));
		pt.setHorizontalAlignment(SwingConstants.CENTER);
		title.add(mnb);
		title.add(pt);

		JPanel jpfind = new JPanel();
		ImageIcon search = new ImageIcon(
				new ImageIcon("timkiem.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		jbfind = new JButton("Tìm kiếm", search);
		jbfind.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jbfind.setFocusPainted(false);
		jtfind = new JTextField(75);
		jtfind.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtfind.setPreferredSize(new Dimension(80, 40));
		jpfind.setPreferredSize(new Dimension(80, 70));
		jpfind.add(jtfind);
		jpfind.add(jbfind);

		JPanel jptext = new JPanel();

		JPanel jpma = new JPanel();
		JLabel jlma = new JLabel("Mã sách:");
		jlma.setPreferredSize(new Dimension(110, 60));
		jlma.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jtma = new JTextField(25);
		jtma.setPreferredSize(new Dimension(80, 35));
		jtma.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtma.setEditable(false);
		jtma.setBackground(new Color(255, 255, 255));
		jpma.add(jlma);
		jpma.add(jtma);

		JPanel jpnxb = new JPanel();
		JLabel jlnxb = new JLabel("Nhà xuất bản:");
		jlnxb.setPreferredSize(new Dimension(130, 60));
		jlnxb.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jtnxb = new JComboBox<String>();
		jtnxb.setPreferredSize(new Dimension(355, 35));
		jtnxb.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtnxb.setBackground(new Color(255, 255, 255));
		jpnxb.add(jlnxb);
		jpnxb.add(jtnxb);

		jptext.setLayout(new BoxLayout(jptext, BoxLayout.X_AXIS));
		jptext.add(jpma);
		jptext.add(jpnxb);

		JPanel jptext1 = new JPanel();

		JPanel jptens = new JPanel();
		JLabel jltens = new JLabel("Tên sách:");
		jltens.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jltens.setPreferredSize(new Dimension(110, 60));
		ten = new JTextField(25);
		ten.setPreferredSize(new Dimension(80, 35));
		ten.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jptens.add(jltens);
		jptens.add(ten);

		JPanel jptl = new JPanel();
		JLabel jltl = new JLabel("Thể loại:");
		jltl.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jltl.setPreferredSize(new Dimension(130, 60));
		jttl = new JComboBox<String>();
		jttl.setPreferredSize(new Dimension(355, 35));
		jttl.setBackground(new Color(255, 255, 255));
		jttl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jptl.add(jltl);
		jptl.add(jttl);

		jptext1.setLayout(new BoxLayout(jptext1, BoxLayout.X_AXIS));
		jptext1.add(jptens);
		jptext1.add(jptl);

		JPanel jptext2 = new JPanel();

		JPanel jptentg = new JPanel();
		JLabel jltentg = new JLabel("Tên tác giả:");
		jltentg.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jltentg.setPreferredSize(new Dimension(110, 60));
		jttentg = new JTextField(25);
		jttentg.setPreferredSize(new Dimension(80, 35));
		jttentg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jptentg.add(jltentg);
		jptentg.add(jttentg);

		JPanel jpsl = new JPanel();
		JLabel jltensl = new JLabel("Số lượng:");
		jltensl.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jltensl.setPreferredSize(new Dimension(130, 60));
		jtsl = new JTextField(25);
		jtsl.setPreferredSize(new Dimension(80, 35));
		jtsl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpsl.add(jltensl);
		jpsl.add(jtsl);

		jptext2.setLayout(new BoxLayout(jptext2, BoxLayout.X_AXIS));
		jptext2.add(jptentg);
		jptext2.add(jpsl);

		JPanel jptext3 = new JPanel();

		JPanel jpnamxb = new JPanel();
		JLabel jlnamxb = new JLabel("Năm xuất bản:");
		jlnamxb.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jlnamxb.setPreferredSize(new Dimension(150, 70));
		jtnamxb = new JTextField(25);
		jtnamxb.setPreferredSize(new Dimension(0, 35));
		jtnamxb.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpnamxb.setPreferredSize(new Dimension(-70, 120));
		jpnamxb.add(jlnamxb);
		jpnamxb.add(jtnamxb);

		jptext3.setLayout(new BoxLayout(jptext3, BoxLayout.X_AXIS));
		jptext3.add(jpnamxb);

		bang = new DefaultTableModel();
		bang.addColumn("Mã sách");
		bang.addColumn("Tên sách");
		bang.addColumn("Loại sách");
		bang.addColumn("Tên tác giả");
		bang.addColumn("Nhà xuất bản");
		bang.addColumn("Năm xuất bản");
		bang.addColumn("Số lượng");
		bang.addColumn("Tình trạng");

		tbl = new JTable(bang);
		// bang.addRow(new String[] { "DS001", "Doraemon tập 1", "Truyện tranh", "Fujiko
		// Fujio", "Nhà xuất bản Nhi Đồng",
		// "5" });
		// bang.addRow(new String[] { "DS002", "Conan tập 1", "Truyện tranh", "Gosho
		// Aoyama", "Nhà xuất bản Nhi Đồng", "2" });
		// bang.addRow(new String[] { "DS003", "Nhà giả kim", "Tâm lý", "Paulo Coelho",
		// "Nhà xuất bản Văn Học", "8" });
		// bang.addRow(new String[] { "DS004", "Doraemon tập 2", "Truyện tranh", "Fujiko
		// Fujio", "Nhà xuất bản Nhi Đồng",
		// "10" });
		// bang.addRow(new String[] { "DS005", "Chọc tức vợ yêu chương 1", "Truyện Ngắn
		// - Ngôn Tình", "Quẫn Quẫn Hữu Yêu",
		// "", "4" });

		tbl.setModel(bang);
		tbl.setRowHeight(35);
		tbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tbl.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tbl.getColumnModel().getColumn(0).setMinWidth(100);
		tbl.getColumnModel().getColumn(0).setMaxWidth(100);
		tbl.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tbl.getColumnModel().getColumn(1).setPreferredWidth(220);
		tbl.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tbl.getColumnModel().getColumn(2).setPreferredWidth(210);
		tbl.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tbl.getColumnModel().getColumn(3).setPreferredWidth(140);
		tbl.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tbl.getColumnModel().getColumn(4).setPreferredWidth(140);
		tbl.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tbl.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		tbl.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		tbl.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));

		JScrollPane sc = new JScrollPane(tbl);
		con.setLayout(new BorderLayout());
		con.add(sc, BorderLayout.CENTER);

		managerbook.add(title);
		managerbook.add(jpfind);
		managerbook.add(pnFlow);
		managerbook.add(jptext);
		managerbook.add(jptext1);
		managerbook.add(jptext2);
		managerbook.add(jptext3);
		managerbook.add(sc);

		con.add(pnMain, BorderLayout.LINE_START);

		// Quản lý đọc giả

		reader = new JPanel();
		reader.setLayout(new BoxLayout(reader, BoxLayout.Y_AXIS));

		JPanel pnFlow1 = new JPanel();
		FlowLayout flowLayout1 = new FlowLayout();
		pnFlow1.setLayout(flowLayout1);

		JPanel title1 = new JPanel();
		ImageIcon manabook1 = new ImageIcon(
				new ImageIcon("title.gif").getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH));
		JLabel mnb1 = new JLabel(manabook1);
		JLabel pt1 = new JLabel("   Quản lý đọc giả");
		pt1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		pt1.setHorizontalAlignment(SwingConstants.CENTER);
		title1.add(mnb1);
		title1.add(pt1);

		JPanel jpfind1 = new JPanel();
		ImageIcon search1 = new ImageIcon(
				new ImageIcon("timkiem.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		jbfinddg = new JButton("Tìm kiếm", search1);
		jbfinddg.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jbfinddg.setFocusPainted(false);
		jtfinddg = new JTextField(75);
		jtfinddg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtfinddg.setPreferredSize(new Dimension(80, 40));
		jpfind1.setPreferredSize(new Dimension(80, 70));
		jpfind1.add(jtfinddg);
		jpfind1.add(jbfinddg);

		// ImageIcon show1 = new ImageIcon(
		// new ImageIcon("save.png").getImage().getScaledInstance(25, 25,
		// Image.SCALE_SMOOTH));
		// show = new JButton("Hiển thị", show1);
		// show.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		// show.setFocusPainted(false);
		// pnFlow1.add(show);

		luudg = new JButton("Lưu", iconsave);
		luudg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		luudg.setFocusPainted(false);
		pnFlow1.add(luudg);

		adddg = new JButton("Thêm", iconadd);
		adddg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		adddg.setFocusPainted(false);
		pnFlow1.add(adddg);

		xoadg = new JButton("Xóa", icondelete);
		xoadg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		xoadg.setFocusPainted(false);
		pnFlow1.add(xoadg);
		flowLayout1.setHgap(280);

		JPanel jptextdg = new JPanel();

		JPanel jpmadg = new JPanel();
		JLabel jlmadg = new JLabel("Mã thành viên:");
		jlmadg.setPreferredSize(new Dimension(180, 60));
		jlmadg.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jtmadg = new JTextField(25);
		jtmadg.setPreferredSize(new Dimension(80, 35));
		jtmadg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtmadg.setEditable(false);
		jtmadg.setBackground(new Color(255, 255, 255));
		jpmadg.add(jlmadg);
		jpmadg.add(jtmadg);

		JPanel jpquan = new JPanel();
		JLabel jlquan = new JLabel("Quận, huyện:");
		jlquan.setPreferredSize(new Dimension(180, 60));
		jlquan.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jtquan = new JComboBox<String>();
		jtquan.setPreferredSize(new Dimension(355, 35));
		jtquan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtquan.setBackground(new Color(255, 255, 255));
		jpquan.add(jlquan);
		jpquan.add(jtquan);

		jptextdg.setLayout(new BoxLayout(jptextdg, BoxLayout.X_AXIS));
		jptextdg.add(jpmadg);
		jptextdg.add(jpquan);

		JPanel jptext1dg = new JPanel();

		JPanel jptendg = new JPanel();
		JLabel jltendg = new JLabel("Họ tên thành viên:");
		jltendg.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jltendg.setPreferredSize(new Dimension(180, 60));
		tendg = new JTextField(25);
		tendg.setPreferredSize(new Dimension(80, 35));
		tendg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jptendg.add(jltendg);
		jptendg.add(tendg);

		JPanel jpphuong = new JPanel();
		JLabel jlphuong = new JLabel("Xã, phường, thị trấn:");
		jlphuong.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jlphuong.setPreferredSize(new Dimension(180, 60));
		jtphuong = new JComboBox<String>();
		jtphuong.setPreferredSize(new Dimension(355, 35));
		jtphuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtphuong.setBackground(new Color(255, 255, 255));
		jpphuong.add(jlphuong);
		jpphuong.add(jtphuong);

		jptext1dg.setLayout(new BoxLayout(jptext1dg, BoxLayout.X_AXIS));
		jptext1dg.add(jptendg);
		jptext1dg.add(jpphuong);

		JPanel jptext2dg = new JPanel();

		JPanel jpdc = new JPanel();
		JLabel jldc = new JLabel("Địa chỉ:");
		jldc.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jldc.setPreferredSize(new Dimension(180, 60));
		jtdc = new JTextField(25);
		jtdc.setPreferredSize(new Dimension(80, 35));
		jtdc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpdc.add(jldc);
		jpdc.add(jtdc);

		JPanel jpsdt = new JPanel();
		JLabel jlsdt = new JLabel("Số điện thoại:");
		jlsdt.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jlsdt.setPreferredSize(new Dimension(180, 60));
		jtsdt = new JTextField(25);
		jtsdt.setPreferredSize(new Dimension(80, 35));
		jtsdt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpsdt.add(jlsdt);
		jpsdt.add(jtsdt);

		jptext2dg.setLayout(new BoxLayout(jptext2dg, BoxLayout.X_AXIS));
		jptext2dg.add(jpdc);
		jptext2dg.add(jpsdt);

		JPanel jptext3dg = new JPanel();

		JPanel jptp = new JPanel();
		JLabel jltp = new JLabel("Tỉnh, thành phố:");
		jltp.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jltp.setPreferredSize(new Dimension(180, 60));
		jttp = new JComboBox<String>();
		jttp.setPreferredSize(new Dimension(355, 35));
		jttp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jttp.setBackground(new Color(255, 255, 255));
		jptp.add(jltp);
		jptp.add(jttp);

		JPanel jpemail = new JPanel();
		JLabel jlemail = new JLabel("Email:");
		jlemail.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jlemail.setPreferredSize(new Dimension(180, 60));
		jtemail = new JTextField(25);
		jtemail.setPreferredSize(new Dimension(80, 35));
		jtemail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpemail.setPreferredSize(new Dimension(550, 120));
		jpemail.add(jlemail);
		jpemail.add(jtemail);

		jptext3dg.setLayout(new BoxLayout(jptext3dg, BoxLayout.X_AXIS));
		jptext3dg.add(jptp);
		jptext3dg.add(jpemail);

		bangdg = new DefaultTableModel();
		bangdg.addColumn("ID");
		bangdg.addColumn("Họ, tên TV");
		bangdg.addColumn("Địa chỉ");
		bangdg.addColumn("Thành phố");
		bangdg.addColumn("Quận");
		bangdg.addColumn("Phường");
		bangdg.addColumn("Số ĐT");
		bangdg.addColumn("Email");
		bangdg.addColumn("Sách đang mượn");

		tbldg = new JTable(bangdg);
		// bangdg.addRow(new String[] { "001", "Nguyễn Văn A", "...", "Hà Nội", "Quận",
		// "Phường" ,"0123XXXXXX" ,"Email" ,"2 cuốn"});
		// bangdg.addRow(new String[] { "002", "Nguyễn Văn B", "...", "Sài Gòn", "Quận",
		// "Phường" ,"0123XXXXXX" ,"Email" ,"3 cuốn"});
		// bangdg.addRow(new String[] { "003", "Nguyễn Văn C", "...", "Đồng Tháp",
		// "Quận", "Phường" ,"0123XXXXXX" ,"Email" ,"1 cuốn"});
		// bangdg.addRow(new String[] { "004", "Nguyễn Văn D", "...", "Đà Nẵng", "Quận",
		// "Phường" ,"0123XXXXXX" ,"Email" ,"2 cuốn"});
		// bangdg.addRow(new String[] { "005", "Nguyễn Văn E", "...", "Trà Vinh",
		// "Quận", "Phường" ,"0123XXXXXX" ,"Email" ,"1 cuốn"});

		tbldg.setModel(bangdg);
		tbldg.setRowHeight(35);
		tbldg.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		tbldg.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tbldg.getColumnModel().getColumn(0).setMinWidth(70);
		tbldg.getColumnModel().getColumn(0).setMaxWidth(70);
		tbldg.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tbldg.getColumnModel().getColumn(1).setPreferredWidth(220);
		tbldg.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tbldg.getColumnModel().getColumn(2).setPreferredWidth(210);
		tbldg.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tbldg.getColumnModel().getColumn(3).setPreferredWidth(140);
		tbldg.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tbldg.getColumnModel().getColumn(4).setMinWidth(0);
		tbldg.getColumnModel().getColumn(4).setMaxWidth(0);
		tbldg.getColumnModel().getColumn(4).setPreferredWidth(140);
		tbldg.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tbldg.getColumnModel().getColumn(5).setMinWidth(0);
		tbldg.getColumnModel().getColumn(5).setMaxWidth(0);
		// tbldg.getColumnModel().getColumn(5).setWidth(0);
		tbldg.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		tbldg.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		tbldg.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
		tbldg.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));

		JScrollPane scdg = new JScrollPane(tbldg);
		// con.setLayout(new BorderLayout());
		con.add(scdg, BorderLayout.CENTER);

		reader.add(title1);
		reader.add(jpfind1);
		reader.add(pnFlow1);
		reader.add(jptextdg);
		reader.add(jptext1dg);
		reader.add(jptext2dg);
		reader.add(jptext3dg);
		reader.add(scdg);

		// Quản lý mượn, trả

		borrow = new JPanel();
		borrow.setLayout(new BoxLayout(borrow, BoxLayout.Y_AXIS));

		JPanel pnFlow2 = new JPanel();
		FlowLayout flowLayout2 = new FlowLayout();
		pnFlow2.setLayout(flowLayout2);
		pnFlow2.setPreferredSize(new Dimension(0, 80));

		JPanel title2 = new JPanel();
		ImageIcon borrow1 = new ImageIcon(
				new ImageIcon("borrow.jpg").getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH));
		JLabel jlbr = new JLabel(borrow1);
		JLabel jlbr1 = new JLabel("   Quản lý mượn trả");
		jlbr1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		jlbr1.setHorizontalAlignment(SwingConstants.CENTER);
		title2.add(jlbr);
		title2.add(jlbr1);

		muon = new JButton("Mượn", iconadd);
		muon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		muon.setFocusPainted(false);
		pnFlow2.add(muon);

		ImageIcon icontra = new ImageIcon(
				new ImageIcon("icontra.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		tra = new JButton("Trả", icontra);
		tra.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tra.setFocusPainted(false);
		pnFlow2.add(tra);

		flowLayout2.setHgap(200);

		JPanel jpbr = new JPanel();

		JPanel jpmabr = new JPanel();
		JLabel jlmabr = new JLabel("Mã giao dịch:");
		jlmabr.setPreferredSize(new Dimension(140, 60));
		jlmabr.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jtmabr = new JTextField(25);
		jtmabr.setPreferredSize(new Dimension(80, 35));
		jtmabr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtmabr.setEditable(false);
		jtmabr.setBackground(new Color(255, 255, 255));
		jpmabr.add(jlmabr);
		jpmabr.add(jtmabr);

		JPanel jpmuon = new JPanel();
		JLabel jlmuon = new JLabel("Ngày mượn:");
		// LocalDate date = LocalDate.now();
		jlmuon.setPreferredSize(new Dimension(140, 60));
		jlmuon.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jtmuon = new JTextField(25);
		jtmuon.setPreferredSize(new Dimension(80, 35));
		jtmuon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		// jtmuon.setText(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date));
		jtmuon.setEditable(false);
		jtmuon.setBackground(new Color(255, 255, 255));
		jpmuon.add(jlmuon);
		jpmuon.add(jtmuon);

		jpbr.setLayout(new BoxLayout(jpbr, BoxLayout.X_AXIS));
		jpbr.add(jpmabr);
		jpbr.add(jpmuon);

		JPanel jpbr1 = new JPanel();

		JPanel jpmadg1 = new JPanel();
		JLabel jlmadg1 = new JLabel("Mã đọc giả:");
		jlmadg1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jlmadg1.setPreferredSize(new Dimension(140, 60));
		jtmadg1 = new JTextField(25);
		jtmadg1.setPreferredSize(new Dimension(80, 35));
		jtmadg1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtmadg1.setBackground(new Color(255, 255, 255));
		jtmadg1.setEditable(false);
		jpmadg1.add(jlmadg1);
		jpmadg1.add(jtmadg1);

		JPanel jpmas = new JPanel();
		JLabel jlmas = new JLabel("Mã sách:");
		jlmas.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jlmas.setPreferredSize(new Dimension(140, 60));
		jtmas = new JTextField(25);
		jtmas.setPreferredSize(new Dimension(80, 35));
		jtmas.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtmas.setBackground(new Color(255, 255, 255));
		jtmas.setEditable(false);
		jpmas.add(jlmas);
		jpmas.add(jtmas);

		jpbr1.setLayout(new BoxLayout(jpbr1, BoxLayout.X_AXIS));
		jpbr1.add(jpmadg1);
		jpbr1.add(jpmas);

		JPanel jpbr2 = new JPanel();

		JPanel jpten = new JPanel();
		JLabel jlten = new JLabel("Họ, tên:");
		jlten.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jlten.setPreferredSize(new Dimension(140, 60));
		jtten = new JTextField(25);
		jtten.setPreferredSize(new Dimension(80, 35));
		jtten.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtten.setBackground(new Color(255, 255, 255));
		jtten.setEditable(false);
		jpten.add(jlten);
		jpten.add(jtten);

		JPanel jptensach = new JPanel();
		JLabel jltensach = new JLabel("Tên sách:");
		jltensach.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jltensach.setPreferredSize(new Dimension(140, 60));
		jttensach = new JTextField(25);
		jttensach.setPreferredSize(new Dimension(80, 35));
		jttensach.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jttensach.setBackground(new Color(255, 255, 255));
		jttensach.setEditable(false);
		jptensach.add(jltensach);
		jptensach.add(jttensach);

		jpbr2.setLayout(new BoxLayout(jpbr2, BoxLayout.X_AXIS));
		jpbr2.add(jpten);
		jpbr2.add(jptensach);

		JPanel jpbr3 = new JPanel();

		JPanel jpdt = new JPanel();
		JLabel jldt = new JLabel("SDT:");
		jldt.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jldt.setPreferredSize(new Dimension(140, 60));
		jtdt = new JTextField(25);
		jtdt.setPreferredSize(new Dimension(80, 35));
		jtdt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtdt.setBackground(new Color(255, 255, 255));
		jtdt.setEditable(false);
		jpdt.add(jldt);
		jpdt.add(jtdt);

		JPanel jpthel = new JPanel();
		JLabel jlthel = new JLabel("Tác giả:");
		jlthel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jlthel.setPreferredSize(new Dimension(140, 60));
		jttg = new JTextField(25);
		jttg.setPreferredSize(new Dimension(80, 35));
		jttg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpthel.setPreferredSize(new Dimension(510, 100));
		jttg.setBackground(new Color(255, 255, 255));
		jttg.setEditable(false);
		jpthel.add(jlthel);
		jpthel.add(jttg);

		jpbr3.setLayout(new BoxLayout(jpbr3, BoxLayout.X_AXIS));
		jpbr3.add(jpdt);
		jpbr3.add(jpthel);

		// Tìm kiếm 3 bảng
		JPanel timkiem = new JPanel();
		FlowLayout timkiem1 = new FlowLayout();
		timkiem.setLayout(timkiem1);

		JPanel jpfindtbl1 = new JPanel();
		ImageIcon searchtbl1 = new ImageIcon(
				new ImageIcon("timkiem.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		jbfindbr1 = new JButton("Tìm kiếm", searchtbl1);
		jbfindbr1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jbfindbr1.setFocusPainted(false);
		jtfindbr1 = new JTextField(19);
		jtfindbr1.setPreferredSize(new Dimension(0, 35));
		jtfindbr1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpfindtbl1.add(jtfindbr1);
		jpfindtbl1.add(jbfindbr1);

		JPanel jpfindtbl2 = new JPanel();
		jbfindbr2 = new JButton("Tìm kiếm", searchtbl1);
		jbfindbr2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jbfindbr2.setFocusPainted(false);
		jtfindbr2 = new JTextField(21);
		jtfindbr2.setPreferredSize(new Dimension(0, 35));
		jtfindbr2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpfindtbl2.add(jtfindbr2);
		jpfindtbl2.add(jbfindbr2);

		JPanel jpfindtbl3 = new JPanel();
		jbfindbr3 = new JButton("Tìm kiếm", searchtbl1);
		jbfindbr3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jbfindbr3.setFocusPainted(false);
		jtfindbr3 = new JTextField(20);
		jtfindbr3.setPreferredSize(new Dimension(0, 35));
		jtfindbr3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpfindtbl3.add(jtfindbr3);
		jpfindtbl3.add(jbfindbr3);

		timkiem.add(jpfindtbl1);
		timkiem.add(jpfindtbl2);
		timkiem.add(jpfindtbl3);

		timkiem1.setHgap(15);

		// Bảng 1
		bangbr1 = new DefaultTableModel();
		bangbr1.addColumn("ID");
		bangbr1.addColumn("Họ, tên TV");
		bangbr1.addColumn("Đang mượn");
		bangbr1.addColumn("SDT");

		tblbr1 = new JTable(bangbr1);
		tblbr1.setModel(bangbr1);
		tblbr1.setRowHeight(35);
		tblbr1.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		tblbr1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblbr1.getColumnModel().getColumn(0).setPreferredWidth(10);
		tblbr1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblbr1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblbr1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tblbr1.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));

		JScrollPane scbr1 = new JScrollPane(tblbr1);

		// Bảng 2
		bangbr2 = new DefaultTableModel();
		bangbr2.addColumn("Mã sách");
		bangbr2.addColumn("Tên sách");
		bangbr2.addColumn("Tác giả");
		bangbr2.addColumn("Tình trạng");

		tblbr2 = new JTable(bangbr2);
		tblbr2.setModel(bangbr2);
		tblbr2.setRowHeight(35);
		tblbr2.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		tblbr2.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblbr2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblbr2.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblbr2.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tblbr2.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));

		JScrollPane scbr2 = new JScrollPane(tblbr2);

		// Bảng 3
		bangbr3 = new DefaultTableModel();
		bangbr3.addColumn("Mã GD");
		bangbr3.addColumn("Đọc giả");
		bangbr3.addColumn("ID đọc giả");
		bangbr3.addColumn("SDT");
		bangbr3.addColumn("Tên sách");
		bangbr3.addColumn("Mã sách");
		bangbr3.addColumn("Tác giả");
		bangbr3.addColumn("Ngày mượn");
		bangbr3.addColumn("Tình trạng");

		tblbr3 = new JTable(bangbr3);
		tblbr3.setModel(bangbr3);
		tblbr3.setRowHeight(35);
		tblbr3.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		tblbr3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblbr3.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblbr3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblbr3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblbr3.getColumnModel().getColumn(2).setMinWidth(0);
		tblbr3.getColumnModel().getColumn(2).setMaxWidth(0);
		tblbr3.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tblbr3.getColumnModel().getColumn(3).setMinWidth(0);
		tblbr3.getColumnModel().getColumn(3).setMaxWidth(0);
		tblbr3.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tblbr3.getColumnModel().getColumn(4).setMinWidth(0);
		tblbr3.getColumnModel().getColumn(4).setMaxWidth(0);
		tblbr3.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tblbr3.getColumnModel().getColumn(5).setMinWidth(0);
		tblbr3.getColumnModel().getColumn(5).setMaxWidth(0);
		tblbr3.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		tblbr3.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));

		JScrollPane scbr3 = new JScrollPane(tblbr3);

		scbr1.setPreferredSize(new Dimension(450, 60));
		scbr2.setPreferredSize(new Dimension(450, 60));
		JPanel alltable = new JPanel();
		alltable.setLayout(new BorderLayout());
		alltable.add(scbr1, BorderLayout.LINE_START);
		alltable.add(scbr2, BorderLayout.CENTER);
		alltable.add(scbr3, BorderLayout.LINE_END);

		borrow.add(title2);
		borrow.add(jpbr);
		borrow.add(jpbr1);
		borrow.add(jpbr2);
		borrow.add(jpbr3);
		borrow.add(pnFlow2);
		borrow.add(timkiem);
		borrow.add(alltable);

		// Thống kê, báo cáo
		thongke = new JPanel();
		thongke.setLayout(new BoxLayout(thongke, BoxLayout.Y_AXIS));

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 21));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

		JPanel titletk = new JPanel();
		ImageIcon manabooktk = new ImageIcon(
				new ImageIcon("thongke1.jpg").getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH));
		JLabel mnbtk = new JLabel(manabooktk);
		JLabel pttk = new JLabel("   Thống kê sách");
		pttk.setFont(new Font("Times New Roman", Font.BOLD, 35));
		pttk.setHorizontalAlignment(SwingConstants.CENTER);
		titletk.add(mnbtk);
		titletk.add(pttk);

		JPanel jpfindnxb = new JPanel();
		ImageIcon searchtk = new ImageIcon(
				new ImageIcon("timkiem.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		jbfindtk = new JButton("Tìm kiếm", searchtk);
		jbfindtk.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jbfindtk.setFocusPainted(false);
		JLabel jltltl = new JLabel("Nhà xuất bản:");
		jltltl.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jltltl.setPreferredSize(new Dimension(130, 60));
		nxbcb = new JComboBox<String>();
		nxbcb.setPreferredSize(new Dimension(355, 35));
		nxbcb.setBackground(new Color(255, 255, 255));
		nxbcb.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpfindnxb.add(jltltl);
		jpfindnxb.add(nxbcb);
		jpfindnxb.add(jbfindtk);

		JPanel jpfindthel = new JPanel();
		jbfindthel = new JButton("Tìm kiếm", searchtk);
		jbfindthel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jbfindthel.setFocusPainted(false);
		JLabel jltheloai = new JLabel("Thể loại:");
		jltheloai.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jltheloai.setPreferredSize(new Dimension(130, 60));
		tlcb = new JComboBox<String>();
		tlcb.setPreferredSize(new Dimension(355, 35));
		tlcb.setBackground(new Color(255, 255, 255));
		tlcb.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpfindthel.add(jltheloai);
		jpfindthel.add(tlcb);
		jpfindthel.add(jbfindthel);

		JPanel jpfindtg = new JPanel();
		jbfindtg = new JButton("Tìm kiếm", searchtk);
		jbfindtg.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jbfindtg.setFocusPainted(false);
		JLabel jltg = new JLabel("Tác giả:");
		jltg.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jltg.setPreferredSize(new Dimension(130, 60));
		tgcb = new JComboBox<String>();
		tgcb.setPreferredSize(new Dimension(355, 35));
		tgcb.setBackground(new Color(255, 255, 255));
		tgcb.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpfindtg.setPreferredSize(new Dimension(0, 100));
		jpfindtg.add(jltg);
		jpfindtg.add(tgcb);
		jpfindtg.add(jbfindtg);

		JPanel tstk = new JPanel();
		tstk.setPreferredSize(new Dimension(0, 85));

		JPanel tongsach = new JPanel();
		tongsach.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		JLabel jlts = new JLabel("Tổng sách:");
		jlts.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jlts.setPreferredSize(new Dimension(110, 60));
		tongs = new JTextField(25);
		tongs.setPreferredSize(new Dimension(355, 35));
		tongs.setBackground(new Color(255, 255, 255));
		tongs.setEditable(false);
		tongs.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tongsach.add(jlts);
		tongsach.add(tongs);

		JPanel tonkho = new JPanel();
		tongsach.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		JLabel jltk = new JLabel("Tồn kho:");
		jltk.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jltk.setPreferredSize(new Dimension(100, 60));
		tonk = new JTextField(25);
		tonk.setPreferredSize(new Dimension(355, 35));
		tonk.setBackground(new Color(255, 255, 255));
		tonk.setEditable(false);
		tonk.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tonkho.add(jltk);
		tonkho.add(tonk);

		tstk.setLayout(new BoxLayout(tstk, BoxLayout.X_AXIS));
		tstk.add(tongsach);
		tstk.add(tonkho);

		bangtk = new DefaultTableModel();
		bangtk.addColumn("Mã sách");
		bangtk.addColumn("Tên sách");
		bangtk.addColumn("Loại sách");
		bangtk.addColumn("Tên tác giả");
		bangtk.addColumn("Nhà xuất bản");
		bangtk.addColumn("Năm xuất bản");
		bangtk.addColumn("Số lượng");
		bangtk.addColumn("Tình trạng");

		tbltk = new JTable(bangtk);
		tbltk.setModel(bangtk);
		tbltk.setRowHeight(35);
		tbltk.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		DefaultTableCellRenderer centerRendererTK = new DefaultTableCellRenderer();
		centerRendererTK.setHorizontalAlignment(JLabel.CENTER);
		tbltk.getColumnModel().getColumn(0).setCellRenderer(centerRendererTK);
		tbltk.getColumnModel().getColumn(0).setMinWidth(100);
		tbltk.getColumnModel().getColumn(0).setMaxWidth(100);
		tbltk.getColumnModel().getColumn(1).setCellRenderer(centerRendererTK);
		tbltk.getColumnModel().getColumn(1).setPreferredWidth(220);
		tbltk.getColumnModel().getColumn(2).setCellRenderer(centerRendererTK);
		tbltk.getColumnModel().getColumn(2).setPreferredWidth(210);
		tbltk.getColumnModel().getColumn(3).setCellRenderer(centerRendererTK);
		tbltk.getColumnModel().getColumn(3).setPreferredWidth(140);
		tbltk.getColumnModel().getColumn(4).setCellRenderer(centerRendererTK);
		tbltk.getColumnModel().getColumn(4).setPreferredWidth(140);
		tbltk.getColumnModel().getColumn(5).setCellRenderer(centerRendererTK);
		tbltk.getColumnModel().getColumn(6).setCellRenderer(centerRendererTK);
		tbltk.getColumnModel().getColumn(7).setCellRenderer(centerRendererTK);
		tbltk.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));

		JScrollPane sctk = new JScrollPane(tbltk);
		con.add(sctk, BorderLayout.CENTER);

		panel1.add(titletk);
		panel1.add(jpfindnxb);
		panel1.add(jpfindthel);
		panel1.add(jpfindtg);
		panel1.add(sctk);
		panel1.add(tstk);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

		JPanel titletkdg = new JPanel();
		JLabel mnbtkdg = new JLabel(manabooktk);
		JLabel pttkdg = new JLabel("   Thống kê đọc giả");
		pttkdg.setFont(new Font("Times New Roman", Font.BOLD, 35));
		pttkdg.setHorizontalAlignment(SwingConstants.CENTER);
		titletkdg.add(mnbtkdg);
		titletkdg.add(pttkdg);

		JPanel jpfindtp = new JPanel();
		jbfindtp = new JButton("Tìm kiếm", searchtk);
		jbfindtp.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jbfindtp.setFocusPainted(false);
		JLabel jltltp = new JLabel("Thành phố:");
		jltltp.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jltltp.setPreferredSize(new Dimension(130, 60));
		tpcb = new JComboBox<String>();
		tpcb.setPreferredSize(new Dimension(355, 35));
		tpcb.setBackground(new Color(255, 255, 255));
		tpcb.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpfindtp.add(jltltp);
		jpfindtp.add(tpcb);
		jpfindtp.add(jbfindtp);

		JPanel jpfindma = new JPanel();
		jbfindma = new JButton("Tìm kiếm", searchtk);
		jbfindma.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jbfindma.setFocusPainted(false);
		JLabel jlmatv = new JLabel("Mã đọc giả:");
		jlmatv.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		jlmatv.setPreferredSize(new Dimension(130, 60));
		jttp1 = new JTextField(25);
		jttp1.setPreferredSize(new Dimension(355, 35));
		jttp1.setBackground(new Color(255, 255, 255));
		jttp1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jpfindma.add(jlmatv);
		jpfindma.add(jttp1);
		jpfindma.add(jbfindma);

		bangtkdg = new DefaultTableModel();
		bangtkdg.addColumn("ID");
		bangtkdg.addColumn("Họ, tên TV");
		bangtkdg.addColumn("Địa chỉ");
		bangtkdg.addColumn("Thành phố");
		bangtkdg.addColumn("Quận");
		bangtkdg.addColumn("Phường");
		bangtkdg.addColumn("Số ĐT");
		bangtkdg.addColumn("Email");
		bangtkdg.addColumn("Sách đang mượn");

		tbltkdg = new JTable(bangtkdg);
		tbltkdg.setModel(bangtkdg);
		tbltkdg.setRowHeight(35);
		tbltkdg.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		tbltkdg.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tbltkdg.getColumnModel().getColumn(0).setMinWidth(70);
		tbltkdg.getColumnModel().getColumn(0).setMaxWidth(70);
		tbltkdg.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tbltkdg.getColumnModel().getColumn(1).setPreferredWidth(220);
		tbltkdg.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tbltkdg.getColumnModel().getColumn(2).setPreferredWidth(210);
		tbltkdg.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tbltkdg.getColumnModel().getColumn(3).setPreferredWidth(140);
		tbltkdg.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tbltkdg.getColumnModel().getColumn(4).setMinWidth(0);
		tbltkdg.getColumnModel().getColumn(4).setMaxWidth(0);
		tbltkdg.getColumnModel().getColumn(4).setPreferredWidth(140);
		tbltkdg.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tbltkdg.getColumnModel().getColumn(5).setMinWidth(0);
		tbltkdg.getColumnModel().getColumn(5).setMaxWidth(0);
		tbltkdg.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		tbltkdg.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		tbltkdg.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
		tbltkdg.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));

		JScrollPane sctkdg = new JScrollPane(tbltkdg);
		con.add(sctkdg, BorderLayout.CENTER);

		panel2.add(titletkdg);
		panel2.add(jpfindtp);
		panel2.add(jpfindma);
		panel2.add(sctkdg);

		tabbedPane.addTab("Thống kê sách", null, panel1, "Thống kê sách");
		tabbedPane.addTab("Thống kê đọc giả", null, panel2, "Thống kê đọc giả");

		thongke.add(tabbedPane);

		cards.add(managerbook);
		cards.add(reader);
		cards.add(borrow);
		cards.add(thongke);
		getContentPane().add(cards);
		setVisible(true);
	}

	public void addEvents() {
		tbl.addMouseListener(eventSelect);
		tbldg.addMouseListener(eventSelectDG);
		tblbr1.addMouseListener(eventSelectDGBR);
		tblbr2.addMouseListener(eventSelectSBR);
		tblbr3.addMouseListener(eventSelectBR);
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.BOLD, 18)));

		// Xóa sách
		xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int row = tbl.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "Chọn sách để xóa", "Delete Button", JOptionPane.PLAIN_MESSAGE,
							icon);
				} else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					dialogButton = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sách này!!!", "WARNING",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon1);
					if (dialogButton == JOptionPane.YES_OPTION) {
						// int i = tbl.getSelectedRow();
						// // arrStd.remove(i);
						// bang.removeRow(i);
						delete((String) tbl.getValueAt(row, 0));
						loadData();
						jtma.setText("");
						ten.setText("");
						jtnxb.setSelectedItem("");
						jtnamxb.setText("");
						jttl.setSelectedItem("");
						jttentg.setText("");
						jtsl.setText("");
						if (dialogButton == JOptionPane.NO_OPTION) {
							remove(dialogButton);
						}
					}

				}
			}
		});

		// Thêm sách
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ten.getText().equals("") && jtnxb.getSelectedItem().equals("")
						|| jttl.getSelectedItem().equals("") && jttentg.getText().equals("")
						|| jtsl.getText().equals("") && jtnamxb.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Nhập đầy đủ thông tin để thêm sách hoặc ít tên sách tên tác giả và số lượng", "Add Button",
							JOptionPane.PLAIN_MESSAGE, icon);
				} else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					dialogButton = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm sách này!!!", "WARNING",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon1);
					if (dialogButton == JOptionPane.YES_OPTION) {
						insert();
						loadData();
						jtma.setText("");
						ten.setText("");
						jtnxb.setSelectedItem("");
						jtnamxb.setText("");
						jttl.setSelectedItem("");
						jttentg.setText("");
						jtsl.setText("");
						if (dialogButton == JOptionPane.NO_OPTION) {
							remove(dialogButton);
						}
					}

				}
			}

		});

		// Lưu sách
		luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tbl.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "Chọn sách để sửa", "Add Button", JOptionPane.PLAIN_MESSAGE,
							icon);
				} else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					dialogButton = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu lại sách này!!!", "WARNING",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon1);
					if (dialogButton == JOptionPane.YES_OPTION) {
						update((String) tbl.getValueAt(row, 0));
						loadData();
						jtma.setText("");
						ten.setText("");
						jtnxb.setSelectedItem("");
						jtnamxb.setText("");
						jttl.setSelectedItem("");
						jttentg.setText("");
						jtsl.setText("");
						if (dialogButton == JOptionPane.NO_OPTION) {
							remove(dialogButton);
						}
					}

				}
			}

		});

		// Xóa đọc giả
		xoadg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int row = tbldg.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "Chọn đọc giả để xóa", "Delete Button",
							JOptionPane.PLAIN_MESSAGE, icon);
				} else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					dialogButton = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa đọc giả này!!!", "WARNING",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon1);
					if (dialogButton == JOptionPane.YES_OPTION) {
						deleteDG((String) tbldg.getValueAt(row, 0));
						loadDataDG();
						jtmadg.setText("");
						tendg.setText("");
						jtdc.setText("");
						jttp.setSelectedItem("");
						jtquan.setSelectedItem("");
						jtphuong.setSelectedItem("");
						jtsdt.setText("");
						jtemail.setText("");
						if (dialogButton == JOptionPane.NO_OPTION) {
							remove(dialogButton);
						}
					}

				}
			}
		});

		// Thêm đọc giả
		adddg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tendg.getText().equals("") || jtdc.getText().equals("")
						|| jttp.getSelectedItem().equals("") && jtquan.getSelectedItem().equals("")
								&& jtphuong.getSelectedItem().equals("") && jtemail.getText().equals("")
						|| jtsdt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin để thêm đọc giả có thể bỏ email",
							"Add Button", JOptionPane.PLAIN_MESSAGE, icon);
				} else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					dialogButton = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm đọc giả này!!!", "WARNING",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon1);
					if (dialogButton == JOptionPane.YES_OPTION) {
						insertDG();
						loadDataDG();
						jtmadg.setText("");
						tendg.setText("");
						jtdc.setText("");
						jttp.setSelectedItem("");
						jtquan.setSelectedItem("");
						jtphuong.setSelectedItem("");
						jtsdt.setText("");
						jtemail.setText("");
						if (dialogButton == JOptionPane.NO_OPTION) {
							remove(dialogButton);
						}
					}

				}
			}

		});

		// Sửa đọc giả
		luudg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tbldg.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "Nhập thông tin để lưu đọc giả", "Update Button",
							JOptionPane.PLAIN_MESSAGE, icon);
				} else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					dialogButton = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu lại đọc giả này!!!", "WARNING",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon1);
					if (dialogButton == JOptionPane.YES_OPTION) {
						updateDG((String) tbldg.getValueAt(row, 0));
						loadDataDG();
						jtmadg.setText("");
						tendg.setText("");
						jtdc.setText("");
						jttp.setSelectedItem("");
						jtquan.setSelectedItem("");
						jtphuong.setSelectedItem("");
						jtsdt.setText("");
						jtemail.setText("");
						if (dialogButton == JOptionPane.NO_OPTION) {
							remove(dialogButton);
						}
					}

				}
			}

		});

		// Cho mượn
		muon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1 = tblbr1.getSelectedRow();
				int row2 = tblbr2.getSelectedRow();
				int row3 = tblbr3.getSelectedRow();
				if (row1 < 0 || row2 < 0) {
					JOptionPane.showMessageDialog(null, "Chọn sách và đọc giả", "Borrow Button",
							JOptionPane.PLAIN_MESSAGE, icon);
				} else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					dialogButton = JOptionPane.showConfirmDialog(null, "Cho đọc giả mượn???", "WARNING",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon1);
					if (dialogButton == JOptionPane.YES_OPTION) {
						ktDG();
						loadData();
						loadDataDG();
						loadDataBR();
						jtten.setText("");
						jtmadg1.setText("");
						jtdt.setText("");
						jttensach.setText("");
						jtmas.setText("");
						jttg.setText("");
						jtmabr.setText("");
						jtmuon.setText("");
						if (row1 > 0) {
							tblbr1.getSelectionModel().clearSelection();
						}
						if (row2 > 0) {
							tblbr2.getSelectionModel().clearSelection();
						}
						if (row3 > 0) {
							tblbr3.getSelectionModel().clearSelection();
						}
						if (dialogButton == JOptionPane.NO_OPTION) {
							remove(dialogButton);
						}
					}

				}
			}

		});

		// Trả sách
		tra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1 = tblbr1.getSelectedRow();
				int row2 = tblbr2.getSelectedRow();
				int row3 = tblbr3.getSelectedRow();
				if (row3 < 0) {
					JOptionPane.showMessageDialog(null, "Chọn sách cần trả", "Borrow Button", JOptionPane.PLAIN_MESSAGE,
							icon);
				} else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					dialogButton = JOptionPane.showConfirmDialog(null, "Cho đọc giả trả sách???", "WARNING",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon1);
					if (dialogButton == JOptionPane.YES_OPTION) {
						traSach((String) tblbr3.getValueAt(row3, 0));
						ttDG1((String) tblbr3.getValueAt(row3, 2));
						ttSach1((String) tblbr3.getValueAt(row3, 5));
						loadData();
						loadDataDG();
						loadDataBR();
						jtten.setText("");
						jtmadg1.setText("");
						jtdt.setText("");
						jttensach.setText("");
						jtmas.setText("");
						jttg.setText("");
						jtmabr.setText("");
						jtmuon.setText("");
						if (row1 > 0) {
							tblbr1.getSelectionModel().clearSelection();
						}
						if (row2 > 0) {
							tblbr2.getSelectionModel().clearSelection();
						}
						if (row3 > 0) {
							tblbr3.getSelectionModel().clearSelection();
						}
						if (dialogButton == JOptionPane.NO_OPTION) {
							remove(dialogButton);
						}
					}

				}
			}

		});

		// Tìm kiếm sách
		jbfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiem();
				jtma.setText("");
				ten.setText("");
				jtnxb.setSelectedItem("");
				jtnamxb.setText("");
				jttl.setSelectedItem("");
				jttentg.setText("");
				jtsl.setText("");
			}

		});

		jtfind.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// timKiem();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (jtfind.getText().equals("")) {
					loadData();
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
																				// choose Tools | Templates.
			}

		});

		// Tìm kiếm đọc giả
		jbfinddg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if (jtfinddg.getText().equals("")) {
				// loadDataDG();
				// } else {
				timKiemDG();
				jtmadg.setText("");
				tendg.setText("");
				jtdc.setText("");
				jttp.setSelectedItem("");
				jtquan.setSelectedItem("");
				jtphuong.setSelectedItem("");
				jtsdt.setText("");
				jtemail.setText("");
				// }
			}

		});

		jtfinddg.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// timKiemDG();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (jtfinddg.getText().equals("")) {
					loadDataDG();
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
																				// choose Tools | Templates.
			}

		});

		// Tìm kiếm NXB
		jbfindtk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemNXB();
				tongSach1();
			}
		});

		// Tìm kiếm thành phố
		jbfindtp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemTP();
			}
		});

		// Tìm kiếm mã thành viên
		jbfindma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemMa();
			}
		});

		// Tìm kiếm thể loại
		jbfindthel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemTL();
				tongSach2();
			}
		});

		// Tìm kiếm tác giả
		jbfindtg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemTG();
				tongSach3();
			}
		});

		// Tìm kiếm bảng 1
		jtfindbr1.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// timKiem();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (jtfindbr1.getText().equals("")) {
					loadDataDG();
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}

		});

		jbfindbr1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemBR1();

			}

		});

		// Tìm kiếm bảng 2
		jtfindbr2.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// timKiem();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (jtfindbr2.getText().equals("")) {
					loadData();
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}

		});

		jbfindbr2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemBR2();

			}

		});

		// Tìm kiếm bảng 3
		jtfindbr3.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// timKiem();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (jtfindbr3.getText().equals("")) {
					loadDataBR();
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}

		});

		jbfindbr3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemBR3();

			}

		});

		// Combo Box
		jttp.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				ResultSet rs = null;
				String tentp = (String) jttp.getSelectedItem();
				String sqlCommand = "SELECT VN_quanhuyen.name FROM VN_quanhuyen INNER JOIN VN_tinhthanhpho WHERE VN_tinhthanhpho.matp=VN_quanhuyen.matp AND VN_tinhthanhpho.name='"
						+ tentp + "'";
				Statement st;
				if (e.getStateChange() == ItemEvent.SELECTED) {
					jtquan.removeAllItems();
					jtphuong.removeAllItems();
					try {
						st = (Statement) connection.createStatement();
						rs = st.executeQuery(sqlCommand);
						while (rs.next()) {
							jtquan.addItem(rs.getString("VN_quanhuyen.name"));
						}
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}

			}

		});

		jtquan.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				ResultSet rs = null;
				String tenqh = (String) jtquan.getSelectedItem();
				String Command = "SELECT VN_xaphuongthitran.name FROM VN_xaphuongthitran INNER JOIN VN_quanhuyen WHERE VN_quanhuyen.maqh=VN_xaphuongthitran.maqh AND VN_quanhuyen.name='"
						+ tenqh + "'";
				Statement st;
				if (e.getStateChange() == ItemEvent.SELECTED) {
					jtphuong.removeAllItems();
					try {
						st = (Statement) connection.createStatement();
						rs = st.executeQuery(Command);
						while (rs.next()) {
							jtphuong.addItem(rs.getString("VN_xaphuongthitran.name"));
						}
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}

			}

		});

		img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reader.setVisible(false);
				managerbook.setVisible(true);
				borrow.setVisible(false);
				thongke.setVisible(false);
			}
		});

		imgrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reader.setVisible(true);
				managerbook.setVisible(false);
				borrow.setVisible(false);
				thongke.setVisible(false);
			}
		});

		imgbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerbook.setVisible(false);
				reader.setVisible(false);
				borrow.setVisible(true);
				thongke.setVisible(false);
			}
		});

		imgtk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerbook.setVisible(false);
				reader.setVisible(false);
				borrow.setVisible(false);
				thongke.setVisible(true);
				loadDataTK();
				loadDataTK1();
				tongSach();
			}
		});

		// Select của các bảng
		tblbr1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void actionPerformed(ActionEvent e) {

			}

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				muon.setEnabled(true);
				tra.setEnabled(false);
				LocalDate date = LocalDate.now();
				jtmuon.setText(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date));
				jtmabr.setText("");
				int row1 = tblbr1.getSelectedRow();
				int row3 = tblbr3.getSelectedRow();
				if (row1 < 0) {

				} else if (row3 > 0) {
					tblbr3.getSelectionModel().clearSelection();
				}
			}

		});

		tblbr2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void actionPerformed(ActionEvent e) {

			}

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				muon.setEnabled(true);
				tra.setEnabled(false);
				LocalDate date = LocalDate.now();
				jtmuon.setText(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date));
				jtmabr.setText("");
				int row2 = tblbr2.getSelectedRow();
				int row3 = tblbr3.getSelectedRow();
				if (row2 < 0) {

				} else if (row3 > 0) {
					tblbr3.getSelectionModel().clearSelection();
				}
			}

		});

		tblbr3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void actionPerformed(ActionEvent e) {

			}

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				muon.setEnabled(false);
				tra.setEnabled(true);
				int row1 = tblbr1.getSelectedRow();
				int row2 = tblbr2.getSelectedRow();
				int row3 = tblbr3.getSelectedRow();
				if (row3 < 0) {

				} else if (row1 > 0 && row2 > 0) {
					tblbr1.getSelectionModel().clearSelection();
					tblbr2.getSelectionModel().clearSelection();
					// tblbr1.getSelectionModel().removeSelectionInterval(0, 0);
					// tblbr2.getSelectionModel().removeSelectionInterval(0, 0);
				} else if (row1 > 0) {
					tblbr1.getSelectionModel().clearSelection();
				} else if (row2 > 0) {
					tblbr2.getSelectionModel().clearSelection();
				}
			}

		});
	}

	public void showWindow() {
		this.setSize(1600, 940);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyThuVienUI myUI = new QuanLyThuVienUI("Quản lý thư viện");
					myUI.showWindow();
					myUI.connect();
					myUI.showData(myUI.getData());
					myUI.showNXB(myUI.nXB());
					myUI.showTL(myUI.theLoai());
					myUI.showTG(myUI.tacGia());
					myUI.showDocGia(myUI.docGia());
					myUI.showTP(myUI.thanhPho());
					myUI.showQuan(myUI.quan());
					myUI.showPhuong(myUI.phuong());
					myUI.showMT(myUI.muonTra());
					myUI.tongSach();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	// ArrayList<SinhVien> arrStd = new ArrayList<SinhVien>();
	private DefaultTableModel bang;
	private JTable tbl;
	private DefaultTableModel bangdg;
	private JTable tbldg;
	private DefaultTableModel bangbr1;
	private JTable tblbr1;
	private DefaultTableModel bangbr2;
	private JTable tblbr2;
	private DefaultTableModel bangbr3;
	private JTable tblbr3;
	private DefaultTableModel bangtk;
	private JTable tbltk;
	private DefaultTableModel bangtkdg;
	private JTable tbltkdg;

	private JTextField jtma;
	private JTextField ten;
	private JComboBox<String> jtnxb;
	private JComboBox<String> jttl;
	private JTextField jttentg;
	private JTextField jtnamxb;
	private JTextField jtsl;
	private JTextField jtfind;
	private JTextField jtfinddg;

	private JTextField jtmadg;
	private JTextField tendg;
	private JComboBox<String> jtquan;
	private JComboBox<String> jttp;
	private JTextField jtdc;
	private JTextField jtsdt;
	private JComboBox<String> jtphuong;
	private JTextField jtemail;

	private JTextField jtmas;
	private JTextField jtmadg1;
	private JTextField jtmabr;
	private JTextField jtmuon;
	private JTextField jttg;
	private JTextField jtdt;
	private JTextField jttensach;
	private JTextField jtten;

	private JButton xoa;
	private JButton add;
	private JButton luu;

	private JButton xoadg;
	private JButton adddg;
	private JButton luudg;

	private JButton muon;
	private JButton tra;

	private JButton img;
	private JButton imgbr;
	private JButton imgrd;
	private JButton imgtk;

	private JButton jbfind;

	private JButton jbfinddg;

	private JButton jbfindbr1;
	private JTextField jtfindbr1;
	private JButton jbfindbr2;
	private JTextField jtfindbr2;
	private JButton jbfindbr3;
	private JTextField jtfindbr3;

	private JComboBox<String> nxbcb;
	private JComboBox<String> tlcb;
	private JComboBox<String> tgcb;
	private JComboBox<String> tpcb;
	private JTextField tongs;
	private JTextField tonk;
	private JTextField jttp1;
	private JButton jbfindtk;
	private JButton jbfindthel;
	private JButton jbfindtg;
	private JButton jbfindtp;
	private JButton jbfindma;

	ImageIcon icon = new ImageIcon(new ImageIcon("!!.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	ImageIcon icon1 = new ImageIcon(new ImageIcon("v.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	private JPanel managerbook;
	private JPanel reader;
	private JPanel borrow;
	private JPanel thongke;
	private Connection connection;
	private Container con;
	private final String className = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/QuanLyThuVien?useUnicode=true&characterEncoding=utf-8";
	private final String user = "ffse1702005";
	private final String pass = "ffse1702@12345";
}
