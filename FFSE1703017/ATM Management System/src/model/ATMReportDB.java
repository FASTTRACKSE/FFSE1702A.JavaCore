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
		
//		SELECT atm.code, dis.name, w.name, atm.street, atm.amount 
//		FROM tbl_atm cus 
//		INNER JOIN district dis 
//		ON dis.districtid = cus.districtid
//		INNER JOIN ward w ON w.wardid = cus.wardid
//		WHERE cus.code LIKE "%%"
		
		ArrayList<ATMReport> arr = new ArrayList<>();
		try {
			
			street = replaceString(street);
			String sql = "SELECT atm.code, dis.name, w.name, atm.street, atm.amount "
					+ "FROM tbl_atm atm "
					+ "INNER JOIN district dis ON dis.districtid = atm.districtid "
					+ "INNER JOIN ward w ON w.wardid = atm.wardid "
					+ "WHERE atm.street LIKE ? ESCAPE '!' "
					+ "AND atm.districtid  ";
			sql += (districtID > 0) ? "= ? " : "> ? ";
			sql += "AND atm.wardid ";
			sql += (wardID > 0) ? "= ? " : "> ? ";
			sql += "ORDER BY atm.code";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1,"%" + street + "%");
			stm.setInt(2, districtID);
			stm.setInt(3, wardID);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				ATMReport atm = new ATMReport();
				atm.setCode(rs.getString(1));
				atm.setDistrict(rs.getString(2));
				atm.setWard(rs.getString(3));
				atm.setStreet(rs.getString(4));
				atm.setAmount(rs.getDouble(5));
				arr.add(atm);
			}
		} catch (SQLException e) {}
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
					+ "WHERE code LIKE ? ESCAPE '!' "
					+ "ORDER BY atm.code";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1,"%" + code + "%");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				ATMReport atm = new ATMReport();
				atm.setCode(rs.getString(1));
				atm.setDistrict(rs.getString(2));
				atm.setWard(rs.getString(3));
				atm.setStreet(rs.getString(4));
				atm.setAmount(rs.getDouble(5));
				arr.add(atm);
			}
		} catch (SQLException e) {}
		return arr;
		
	}
	
	public static ArrayList<Transaction> getTransactionByCode(String code, Calendar cldFrom, Calendar cldTo) {
		Date sqlDateFrom = new Date(cldFrom.getTimeInMillis());
		Date sqlDateTo = new Date(cldTo.getTimeInMillis());
		ArrayList<Transaction> arr = new ArrayList<>();
		try {
			code = replaceString(code);
			String sql = "SELECT atm_code, card_sn, code, time, amount "
					+ "FROM tbl_transaction "
					+ "WHERE code LIKE ? ESCAPE '!' "
					+ "AND ( time BETWEEN ? AND ? ) "
					+ "ORDER BY time";
			
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, "%" + code + "%");
			stm.setDate(2, sqlDateFrom);
			stm.setDate(3, sqlDateTo);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Transaction tran = new Transaction();
				tran.setAtm_code(rs.getString(1));
				tran.setCard_sn(rs.getString(2));
				tran.setCode(rs.getString(3));
				tran.setTime(rs.getTimestamp(4));
				tran.setAmount(rs.getDouble(5));
				arr.add(tran);
			}
		} catch (SQLException e) {}
		return arr;
	}
	
	public static ArrayList<Transaction> getTransactionByAddress(
			int districtID, int wardID,String street, Calendar cldFrom, Calendar cldTo) {
		
		street = replaceString(street);
		Date sqlDateFrom = new Date(cldFrom.getTimeInMillis());
		Date sqlDateTo = new Date(cldTo.getTimeInMillis());
		ArrayList<Transaction> arr = new ArrayList<>();
		try {
			String sql = "SELECT atm_code, card_sn, tran.code, time, tran.amount "
					+ "FROM tbl_transaction tran "
					+ "INNER JOIN tbl_atm atm ON atm.code = tran.atm_code  "
					+ "WHERE ( time BETWEEN ? AND ? ) "
					+ "AND street LIKE ? "
					+ "AND districtid ";
			sql += (districtID > 0) ? "= ? " : "> ? ";
			sql += "AND wardid ";
			sql += (wardID > 0) ? "= ? " : "> ? ";
			sql += "ORDER BY time";
			
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setDate(1, sqlDateFrom);
			stm.setDate(2, sqlDateTo);
			stm.setString(3, "%" + street + "%");
			stm.setInt(4, districtID);
			stm.setInt(5, wardID);
			
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Transaction tran = new Transaction();
				tran.setAtm_code(rs.getString(1));
				tran.setCard_sn(rs.getString(2));
				tran.setCode(rs.getString(3));
				tran.setTime(rs.getTimestamp(4));
				tran.setAmount(rs.getDouble(5));
				arr.add(tran);
			}
		} catch (SQLException e) {}
		return arr;
	}
	
	private static String replaceString(String street) {
		street = street
				.replace("!", "!!")
			    .replace("%", "!%")
			    .replace("_", "!_")
			    .replace("[", "![");
		return street;
	}

}
