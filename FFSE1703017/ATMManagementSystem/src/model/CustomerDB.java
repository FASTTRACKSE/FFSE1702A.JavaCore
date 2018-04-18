package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CustomerDB {
	private final static Connection conn = ConnectDB.getConnect();

	public static boolean isItem(String property, String value) {
		try {
			String sql = "SELECT * FROM tbl_customer WHERE " + property + " = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, value);
			ResultSet rs = stm.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Customer getCustomerbyCode(String code) {
		Customer ctm = new Customer();
		try {
			String sql = "SELECT * FROM tbl_customer WHERE code = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, code);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ctm.setName(rs.getString("name"));
				ctm.setPhone(rs.getString("phone"));
				ctm.setEmail(rs.getString("email"));
				ctm.setDistrictID(rs.getInt("districtid"));
				ctm.setWardID(rs.getInt("wardid"));
				ctm.setStreet(rs.getString("street"));
				ctm.setCode(rs.getString("code"));
				ctm.setCardSN(rs.getString("card_sn"));
				ctm.setAccSN(rs.getString("acc_sn"));
				ctm.setAmount(rs.getDouble("amount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ctm;
	}

	public static ArrayList<Customer> getCustomersByName(String name) {
		ArrayList<Customer> arr = new ArrayList<>();
		try {
			name = replaceString(name);
			String sql = "SELECT * FROM tbl_customer WHERE name LIKE ? ";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, "%" + name + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Customer ctm = new Customer();
				ctm.setName(rs.getString("name"));
				ctm.setPhone(rs.getString("phone"));
				ctm.setEmail(rs.getString("email"));
				ctm.setDistrictID(rs.getInt("districtid"));
				ctm.setWardID(rs.getInt("wardid"));
				ctm.setStreet(rs.getString("street"));
				ctm.setCode(rs.getString("code"));
				ctm.setCardSN(rs.getString("card_sn"));
				ctm.setAccSN(rs.getString("acc_sn"));
				ctm.setAmount(rs.getDouble("amount"));
				arr.add(ctm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public static ArrayList<Customer> getCustomersList() {
		ArrayList<Customer> arr = new ArrayList<>();
		try {
			String sql = "SELECT * FROM tbl_customer";
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Customer ctm = new Customer();
				ctm.setName(rs.getString("name"));
				ctm.setPhone(rs.getString("phone"));
				ctm.setEmail(rs.getString("email"));
				ctm.setDistrictID(rs.getInt("districtid"));
				ctm.setWardID(rs.getInt("wardid"));
				ctm.setStreet(rs.getString("street"));
				ctm.setCode(rs.getString("code"));
				ctm.setCardSN(rs.getString("card_sn"));
				ctm.setAccSN(rs.getString("acc_sn"));
				ctm.setAmount(rs.getDouble("amount"));
				arr.add(ctm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public static int setCustomer(Customer ctm) {
		try {
			String sql = "update tbl_customer set name = ?, phone = ?, email = ?, "
					+ "districtid = ?, wardid = ?, street = ?, " + "amount = ? where code = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, ctm.getName());
			stm.setString(2, ctm.getPhone());
			stm.setString(3, ctm.getEmail());
			stm.setInt(4, ctm.getDistrictID());
			stm.setInt(5, ctm.getWardID());
			stm.setString(6, ctm.getStreet());
			stm.setDouble(7, ctm.getAmount());
			stm.setString(8, ctm.getCode());
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int addCustomer(Customer ctm) {
		try {
			String sql = "insert into tbl_customer (name, phone, email, districtid,"
					+ "wardid, street, code, card_sn, acc_sn, amount) " + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, ctm.getName());
			stm.setString(2, ctm.getPhone());
			stm.setString(3, ctm.getEmail());
			stm.setInt(4, ctm.getDistrictID());
			stm.setInt(5, ctm.getWardID());
			stm.setString(6, ctm.getStreet());
			stm.setString(7, ctm.getCode());
			stm.setString(8, ctm.getCardSN());
			stm.setString(9, ctm.getAccSN());
			stm.setDouble(10, ctm.getAmount());
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int delCustomer(String code) {
		try {
			String sql = "delete from tbl_customer where code = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, code);
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	private static String replaceString(String code) {
		code = code.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
		return code;
	}
}
