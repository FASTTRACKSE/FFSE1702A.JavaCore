package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.jdbc.Connection;

public class ATMReportDB {

	private final static Connection conn = ConnectDB.getConnect();

	public static ArrayList<ATMReport> getATMsByAddress(int districtID, int wardID, String street) {

		ArrayList<ATMReport> arr = new ArrayList<>();
		try {

			street = replaceString(street);
			String sql = "SELECT atm.code, dis.name, w.name, atm.street, atm.amount "
					+ "FROM tbl_atm atm "
					+ "INNER JOIN district dis ON dis.districtid = atm.districtid "
					+ "INNER JOIN ward w ON w.wardid = atm.wardid " 
					+ "WHERE atm.street LIKE ? ESCAPE '!' ";
					
			sql += (districtID > 0) ? "AND atm.districtid = ? " : "AND atm.districtid > ? ";
			sql += (wardID > 0) ? "AND atm.wardid = ? " : "AND atm.wardid > ? ";
			sql += "ORDER BY atm.code";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, "%" + street + "%");
			stm.setInt(2, districtID);
			stm.setInt(3, wardID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ATMReport atm = new ATMReport();
				atm.setCode(rs.getString(1));
				atm.setDistrict(rs.getString(2));
				atm.setWard(rs.getString(3));
				atm.setStreet(rs.getString(4));
				atm.setAmount(rs.getDouble(5));
				arr.add(atm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;

	}

	public static ArrayList<ATMReport> getATMsByCode(String code) {

		ArrayList<ATMReport> arr = new ArrayList<>();
		try {

			code = replaceString(code);
			String sql = "SELECT atm.code, dis.name, w.name, atm.street, atm.amount "
					+ "FROM tbl_atm atm "
					+ "INNER JOIN district dis ON dis.districtid = atm.districtid  "
					+ "INNER JOIN ward w ON w.wardid = atm.wardid "
					+ "WHERE atm.code LIKE ? ESCAPE '!' "
					+ "ORDER BY atm.code";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, "%" + code + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ATMReport atm = new ATMReport();
				atm.setCode(rs.getString(1));
				atm.setDistrict(rs.getString(2));
				atm.setWard(rs.getString(3));
				atm.setStreet(rs.getString(4));
				atm.setAmount(rs.getDouble(5));
				arr.add(atm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;

	}

	public static ArrayList<ATMWithdraw> getTransactionByCode(String code, Calendar cldFrom, Calendar cldTo) {
		Date sqlDateFrom = new Date(cldFrom.getTimeInMillis());
		Date sqlDateTo = new Date(cldTo.getTimeInMillis());
		ArrayList<ATMWithdraw> arr = new ArrayList<>();
		try {
			code = replaceString(code);
			String sql = "SELECT atm.code, tran.card_sn, tran.code, tran.time, tran.amount, dis.name, w.name, atm.street "
					+ "FROM tbl_atm atm " + "INNER JOIN district dis ON dis.districtid = atm.districtid  "
					+ "INNER JOIN ward w ON w.wardid = atm.wardid "
					+ "INNER JOIN tbl_transaction tran ON tran.atm_code = atm.code "
					+ "WHERE atm.code LIKE ? ESCAPE '!' " 
					+ "AND ( tran.time BETWEEN ? AND ? ) " 
					+ "ORDER BY tran.time";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, "%" + code + "%");
			stm.setDate(2, sqlDateFrom);
			stm.setDate(3, sqlDateTo);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ATMWithdraw atm = new ATMWithdraw();
				atm.setAtm_code(rs.getString(1));
				atm.setCard_sn(rs.getString(2));
				atm.setCode(rs.getString(3));
				atm.setTime(rs.getTimestamp(4));
				atm.setAmount(rs.getDouble(5));
				atm.setDistrict(rs.getString(6));
				atm.setWard(rs.getString(7));
				atm.setStreet(rs.getString(8));
				arr.add(atm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public static ArrayList<ATMWithdraw> getTransactionByAddress(int districtID, int wardID, String street,
			Calendar cldFrom, Calendar cldTo) {

		street = replaceString(street);
		Date sqlDateFrom = new Date(cldFrom.getTimeInMillis());
		Date sqlDateTo = new Date(cldTo.getTimeInMillis());
		ArrayList<ATMWithdraw> arr = new ArrayList<>();
		try {
			String sql = "SELECT atm.code, tran.card_sn, tran.code, tran.time, tran.amount, dis.name, w.name, atm.street "
					+ "FROM tbl_atm atm " + "INNER JOIN district dis ON dis.districtid = atm.districtid  "
					+ "INNER JOIN ward w ON w.wardid = atm.wardid "
					+ "INNER JOIN tbl_transaction tran ON tran.atm_code = atm.code "
					+ "WHERE ( tran.time BETWEEN ? AND ? ) " + "AND atm.street LIKE ? ESCAPE '!' ";
			
			sql += (districtID > 0) ? "AND atm.districtid = ? " : "AND atm.districtid > ? ";
			sql += (wardID > 0) ? "AND atm.wardid  = ? " : "AND atm.wardid  > ? ";
			sql += "ORDER BY tran.time";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setDate(1, sqlDateFrom);
			stm.setDate(2, sqlDateTo);
			stm.setString(3, "%" + street + "%");
			stm.setInt(4, districtID);
			stm.setInt(5, wardID);

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				ATMWithdraw atm = new ATMWithdraw();
				atm.setAtm_code(rs.getString(1));
				atm.setCard_sn(rs.getString(2));
				atm.setCode(rs.getString(3));
				atm.setTime(rs.getTimestamp(4));
				atm.setAmount(rs.getDouble(5));
				atm.setDistrict(rs.getString(6));
				atm.setWard(rs.getString(7));
				atm.setStreet(rs.getString(8));
				arr.add(atm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	private static String replaceString(String street) {
		street = street.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
		return street;
	}

}
