package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
	
	public static boolean isLogin(String cardSN, String pin) {
		try {
			String sql = "SELECT * FROM tbl_customer WHERE card_sn = ? AND pin = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, cardSN);
			stm.setString(2, pin);
			ResultSet rs = stm.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Customer getCustomerbyCardSN(String cardSN) {
		Customer ctm = new Customer();
		try {
			String sql = "SELECT * FROM tbl_customer WHERE card_sn = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, cardSN);
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
					+ "districtid = ?, wardid = ?, street = ?, "
					+ "amount = ? where code = ?";
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
			int status = -1;
			String sql = "insert into tbl_customer (name, phone, email, districtid,"
					+ "wardid, street, code, card_sn, acc_sn, amount, pin) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 555888)";
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
			int i = stm.executeUpdate();
			
			if (i > 0) {
				String name = ctm.getName();
				name = covertString(name);
				String[] arrName = name.split("\\s");
				String firstName = arrName[0];
				String lastName = arrName[arrName.length -1];
				String username = lastName + firstName;
				
				String queryCount = "select count(*) from tbl_user where username = ?";
				PreparedStatement stmCount = conn.prepareStatement(queryCount);
				stmCount.setString(1, username);
				ResultSet rsCounnt = stmCount.executeQuery();
				if (rsCounnt.next()) {
					int count = rsCounnt.getInt(1);
					username += (count > 0) ? count : "";
				}

				
				String queryAddUser = "insert into tbl_user (username, password, name, role, customer_code) "
						+ "values (?, 555888, ?, 0, ?)";
				PreparedStatement stmAddUser = conn.prepareStatement(queryAddUser);
				stmAddUser.setString(1, username);
				stmAddUser.setString(2, ctm.getName());
				stmAddUser.setString(3, ctm.getCode());
				status = stmAddUser.executeUpdate();
			}
			
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int delCustomer(String code) {
		try {
			int status = -1;
			String sql = "delete from tbl_customer where code = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, code);
			int i = stm.executeUpdate();
			if (i > 0) {
				String query = "delete from tbl_user where customer_code = ?";
				PreparedStatement stmUser = conn.prepareStatement(query);
				stmUser.setString(1, code);
				status = stmUser.executeUpdate();
			}
			
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	private static String replaceString(String code) {
		code = code.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
		return code;
	}
	
	private static String covertString(String str) {
	   try {
	       String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
	       Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	       return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll("đ", "d");
	   } catch (Exception ex) {
	       ex.printStackTrace(); 
	   }
	   return "";
	}
}
