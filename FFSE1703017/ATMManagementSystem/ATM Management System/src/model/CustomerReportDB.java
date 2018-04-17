package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.jdbc.Connection;

public class CustomerReportDB {
	
	private final static Connection conn = ConnectDB.getConnect();
	
	public static ArrayList<CustomerReport> getCustomers(int districtID, int wardID) {
		
		ArrayList<CustomerReport> arr = new ArrayList<>();
		try {
			String sql = "SELECT cus.name, cus.code, cus.amount, cus.phone, sum(tran.amount) "
					+ "FROM tbl_customer cus INNER JOIN tbl_transaction tran "
					+ "ON cus.card_sn = tran.card_sn "
					+ "WHERE cus.districtid = ? AND cus.wardid ";
			sql += (wardID > 0) ? "=? " : "> ? ";
			sql += "GROUP BY cus.name ORDER BY cus.code";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, districtID);
			stm.setInt(2, wardID);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				CustomerReport cus = new CustomerReport();
				cus.setCustomer_name(rs.getString(1));
				cus.setCustomer_code(rs.getString(2));
				cus.setCustomer_amount(rs.getDouble(3));
				cus.setPhone(rs.getString(4));
				cus.setCustomer_withdraw(rs.getDouble(5));
				arr.add(cus);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return arr;
		
	}
	
	public static ArrayList<CustomerReport> getTransactions(String code, Calendar cldFrom, Calendar cldTo) {
		ArrayList<CustomerReport> arr = new ArrayList<>();
		Date sqlDateFrom = new Date(cldFrom.getTimeInMillis());
		Date sqlDateTo = new Date(cldTo.getTimeInMillis());
		try {
			code = replaceString(code);
			String sql = "SELECT cus.code, cus.name, tran.atm_code, tran.time, tran.code, tran.amount "
					+ "FROM tbl_customer cus INNER JOIN tbl_transaction tran "
					+ "ON cus.card_sn = tran.card_sn "
					+ "WHERE cus.code LIKE ? ESCAPE '!' "
					+ "AND (tran.time BETWEEN ? AND ? ) "
					+ "GROUP BY tran.code ";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, "%" + code + "%");
			stm.setDate(2, sqlDateFrom);
			stm.setDate(3, sqlDateTo);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				CustomerReport cus = new CustomerReport();
				cus.setCustomer_code(rs.getString(1));
				cus.setCustomer_name(rs.getString(2));
				cus.setAtm_code(rs.getString(3));
				cus.setTime(rs.getTimestamp(4));
				cus.setCode(rs.getString(5));
				cus.setAmount(rs.getDouble(6));
				arr.add(cus);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return arr;
		
	}
	
	private static String replaceString(String code) {
		code = code
				.replace("!", "!!")
			    .replace("%", "!%")
			    .replace("_", "!_")
			    .replace("[", "![");
		return code;
	}
}
