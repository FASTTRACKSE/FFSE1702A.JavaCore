package namdv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SinhVienModel {
	private Connection conn;
	private PreparedStatement ps;

	public SinhVienModel() {
		super();
		// TODO Auto-generated constructor stub
		try {
			conn = (new ConnectDB()).getConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet selectSinhVien(String where) throws SQLException {
		String sql = "SELECT * FROM  SinhVien WHERE lopSV = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, where);
		return ps.executeQuery();
	}

	public int addSinhVien(SinhVien sv) throws SQLException {
		String sql = "INSERT INTO SinhVien (lopSV, maSV, tenSV, tuoiSV) VALUES (?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, sv.getLopSV());
		ps.setString(2, sv.getMaSV());
		ps.setString(3, sv.getTenSV());
		ps.setString(4, sv.getTuoiSV());
		return ps.executeUpdate();
	}

	public int editSinhVien(SinhVien sv, String maSV) throws SQLException {
		String sql = "UPDATE SinhVien SET lopSV = ?, maSV = ?, tenSV = ?, tuoiSV = ? WHERE maSV = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, sv.getLopSV());
		ps.setString(2, sv.getMaSV());
		ps.setString(3, sv.getTenSV());
		ps.setString(4, sv.getTuoiSV());
		ps.setString(5, maSV);
		return ps.executeUpdate();
	}

	public int deleteSinhVien(String maSV) throws SQLException {
		String sql = "DELETE FROM SinhVien  WHERE maSV = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, maSV);
		return ps.executeUpdate();
	}
}
