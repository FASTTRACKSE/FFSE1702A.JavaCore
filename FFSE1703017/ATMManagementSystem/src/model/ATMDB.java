package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ATMDB {
	private final static Connection conn = ConnectDB.getConnect();

	public static boolean isValidCode(String code) {
		try {
			String sql = "SELECT * FROM tbl_atm WHERE code = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, code);
			ResultSet rs = stm.executeQuery();
			return !rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static ArrayList<ComboItem> getAllATMs() {
		ArrayList<ComboItem> arr = new ArrayList<>();
		try {
			String sql = "SELECT * FROM tbl_atm ";
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ComboItem it = new ComboItem();
				it.setValue(rs.getString("code"));
				it.setKey(1);
				arr.add(it);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static ATM getATMbyCode(String code) {
		ATM atm = new ATM();
		try {
			String sql = "SELECT * FROM tbl_atm WHERE code = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, code);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				atm.setDistrictID(rs.getInt("districtid"));
				atm.setWardID(rs.getInt("wardid"));
				atm.setStreet(rs.getString("street"));
				atm.setCode(rs.getString("code"));
				atm.setAmount(rs.getDouble("amount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atm;
	}

	public static ArrayList<ATM> getATMsByName(String name) {
		ArrayList<ATM> arr = new ArrayList<>();
		try {
			name = name.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
			String sql = "SELECT * FROM tbl_atm WHERE code LIKE ? ";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, "%" + name + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ATM atm = new ATM();
				atm.setDistrictID(rs.getInt("districtid"));
				atm.setWardID(rs.getInt("wardid"));
				atm.setStreet(rs.getString("street"));
				atm.setCode(rs.getString("code"));
				atm.setAmount(rs.getDouble("amount"));
				arr.add(atm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public static ArrayList<ATM> getATMsList() {
		ArrayList<ATM> arr = new ArrayList<>();
		try {
			String sql = "SELECT * FROM tbl_atm";
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ATM atm = new ATM();
				atm.setDistrictID(rs.getInt("districtid"));
				atm.setWardID(rs.getInt("wardid"));
				atm.setStreet(rs.getString("street"));
				atm.setCode(rs.getString("code"));
				atm.setAmount(rs.getDouble("amount"));
				arr.add(atm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public static int setATM(ATM atm) {
		try {
			String sql = "update tbl_atm set districtid = ?, wardid = ?, street = ?, " + "amount = ? where code = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, atm.getDistrictID());
			stm.setInt(2, atm.getWardID());
			stm.setString(3, atm.getStreet());
			stm.setDouble(4, atm.getAmount());
			stm.setString(5, atm.getCode());
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int addATM(ATM atm) {
		try {
			String sql = "insert into tbl_atm (districtid, wardid, street, code, amount)" + " values (?, ?, ?, ?, ?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, atm.getDistrictID());
			stm.setInt(2, atm.getWardID());
			stm.setString(3, atm.getStreet());
			stm.setString(4, atm.getCode());
			stm.setDouble(5, atm.getAmount());
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int delATM(String code) {
		try {
			String sql = "delete from tbl_atm where code = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, code);
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
