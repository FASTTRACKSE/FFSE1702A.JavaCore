package namdv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BanDocModel {
	private Connection conn;
	private PreparedStatement ps;
	private String sql;
	private ResultSet rs;

	public BanDocModel() {
		super();
		try {
			conn = (new ConnectDB()).getConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet getThanhPho() throws SQLException {
		sql = "SELECT matp, name FROM  `gsovn_tinhthanhpho` ORDER BY name ASC";
		ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

	public ResultSet getQuan(String maThanhPho) throws SQLException {
		sql = "SELECT maqh, name FROM `gsovn_quanhuyen` WHERE matp = ? ORDER BY name ASC";
		ps = conn.prepareStatement(sql);
		ps.setString(1, maThanhPho);
		return ps.executeQuery();
	}

	public ResultSet getPhuong(String maQuan) throws SQLException {
		sql = "SELECT xaid, name FROM `gsovn_xaphuongthitran` WHERE maqh = ? ORDER BY name ASC";
		ps = conn.prepareStatement(sql);
		ps.setString(1, maQuan);
		return ps.executeQuery();
	}

	public ResultSet getDataSachChuaTra(String idBanDoc) throws SQLException {
		sql = "SELECT ma_sach_muon FROM `muon_tra_sach` WHERE id_ban_doc = ? AND ngay_tra = '0000-00-00 00:00:00'";
		ps = conn.prepareStatement(sql);
		ps.setString(1, idBanDoc);
		rs = ps.executeQuery();

		// get infor sách
		sql = "SELECT id, ten, tac_gia FROM `sach` WHERE ";
		if ((rs != null) && (rs.next())) {
			sql += "id = '" + rs.getString("ma_sach_muon") + "'";
			while ((rs != null) && (rs.next())) {
				sql += " OR id = '" + rs.getString("ma_sach_muon") + "'";
			}
			ps = conn.prepareStatement(sql);
			return ps.executeQuery();
		}
		return null;
	}

	public String getAutoId() throws SQLException {
		sql = "SELECT `AUTO_INCREMENT` FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'myjavaapp' AND TABLE_NAME = 'ban_doc'";
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return String.format("%05d", Integer.parseInt(rs.getString("AUTO_INCREMENT")));
	}

	public ResultSet getBanDoc(String[] where, String[] value) throws SQLException {
		int count = where.length;
		sql = "SELECT * FROM ban_doc INNER JOIN gsovn_tinhthanhpho ON ban_doc.thanh_pho = gsovn_tinhthanhpho.matp INNER JOIN gsovn_quanhuyen ON ban_doc.quan = gsovn_quanhuyen.maqh INNER JOIN gsovn_xaphuongthitran ON ban_doc.phuong = gsovn_xaphuongthitran.xaid WHERE ";
		for (int i = 0; i < count; i++) {
			if (where[i].equals("ho_ten")) {
				sql += where[i] + " LIKE '%" + value[i] + "%'";
			} else {
				sql += where[i] + " = '" + value[i] + "'";
			}
			if (i < count - 1) {
				sql += " AND ";
			}
		}
		ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

	public int addBanDoc(BanDoc banDoc) throws SQLException {
		sql = "INSERT INTO ban_doc (ho_ten, dia_chi, phuong, quan, thanh_pho, dien_thoai, email) VALUES (?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, banDoc.getHoTen());
		ps.setString(2, banDoc.getDiaChi());
		ps.setString(3, banDoc.getPhuong());
		ps.setString(4, banDoc.getQuan());
		ps.setString(5, banDoc.getThanhPho());
		ps.setString(6, banDoc.getDienThoai());
		ps.setString(7, banDoc.getEmail());
		return ps.executeUpdate();
	}

	public int editBanDoc(BanDoc banDoc) throws SQLException {
		sql = "UPDATE ban_doc SET ho_ten = ?, dia_chi = ?, phuong = ?, quan = ?, thanh_pho = ?, dien_thoai = ?, email = ? WHERE id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, banDoc.getHoTen());
		ps.setString(2, banDoc.getDiaChi());
		ps.setString(3, banDoc.getPhuong());
		ps.setString(4, banDoc.getQuan());
		ps.setString(5, banDoc.getThanhPho());
		ps.setString(6, banDoc.getDienThoai());
		ps.setString(7, banDoc.getEmail());
		ps.setString(8, banDoc.getId());
		return ps.executeUpdate();
	}

	public int deleteBanDoc(String id) throws SQLException {
		sql = "DELETE FROM ban_doc WHERE id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
}
