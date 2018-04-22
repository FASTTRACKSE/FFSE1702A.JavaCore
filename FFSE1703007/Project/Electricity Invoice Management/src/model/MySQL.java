package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MySQL {
	static Connection conn = getConnect("localhost", "java", "java", "12345");

	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	public static boolean checkConnection() {
		if (conn != null) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkLogin(String username, String password) {
		try {
			String sql = "select * from user where username = ? and password = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet result = stm.executeQuery();
			if (!result.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ResultSet getCounty() {
		try {
			String sql = "select name from county";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getWard(int countyID) {
		try {
			String sql = "select * from ward where county = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setInt(1, countyID);
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean addCustomer(String fullname, String address, int countyID, int wardID, String phone,
			String email, String meterID) {
		try {
			String sql = "insert into customer ( fullname, address, countyID, wardID, phone, email, meterID ) values ( ?, ?, ?, ?, ?, ?, ? )";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			stm.setString(1, fullname);
			stm.setString(2, address);
			stm.setInt(3, countyID);
			stm.setInt(4, wardID);
			stm.setString(5, phone);
			stm.setString(6, email);
			stm.setString(7, meterID);
			int x = stm.executeUpdate();
			if (x > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ResultSet getCustomerList(String countyName, String wardName) {
		try {
			String sql = "SELECT customer.id, customer.fullname, customer.address, county.name, ward.name, customer.phone, customer.email, customer.meterID,customer.countyID,customer.wardID FROM ((customer INNER JOIN county on customer.countyID = county.id)\r\n"
					+ "               INNER JOIN ward ON customer.wardID = ward.id) where county.name like ? and ward.name like ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + countyName + "%");
			stm.setString(2, "%" + wardName + "%");
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean editCustomer(String fullname, String address, int countyID, int wardID, String phone,
			String email, String meterID, String customerID) {
		try {
			String sql = "update customer set fullname = ?, address = ?, countyID = ?, wardID = ? , phone = ?, email = ?, meterID = ? where id=?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			stm.setString(1, fullname);
			stm.setString(2, address);
			stm.setInt(3, countyID);
			stm.setInt(4, wardID);
			stm.setString(5, phone);
			stm.setString(6, email);
			stm.setString(7, meterID);
			stm.setString(8, customerID);
			int x = stm.executeUpdate();
			if (x > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean delCustomer(String customerID) {
		try {
			String sql = "delete from customer where id=?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			stm.setString(1, customerID);

			int x = stm.executeUpdate();
			if (x > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ResultSet getInvoice(String meterID) {
		try {
			String sql = "SELECT * from invoice where meterID = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, meterID);
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean addInvoice(String meterID, String dateAdded, Date cycle, int meterIndex, int amount) {
		try {
			String sql = "insert into invoice ( meterID, dateAdded, cycle, meterIndex, amount) values ( ?, ?, ?, ?, ? )";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			java.sql.Date sqlDate = new java.sql.Date(cycle.getTime());

			stm.setString(1, meterID);
			stm.setString(2, dateAdded);
			stm.setDate(3, sqlDate);
			stm.setInt(4, meterIndex);
			stm.setInt(5, amount);
			int x = stm.executeUpdate();
			if (x > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ResultSet getLastestInvoice(String meterID) {
		try {
			String sql = "SELECT id,meterID, meterIndex from invoice where meterID = ? ORDER BY id DESC LIMIT 1";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, meterID);
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean editInvoice(Date cycle, String meterIndex, int amount, int invoiceID) {
		try {
			String sql = "update invoice set cycle = ?, meterIndex = ?, amount = ? where id=?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			java.sql.Date sqlDate = new java.sql.Date(cycle.getTime());

			stm.setDate(1, sqlDate);
			stm.setString(2, meterIndex);
			stm.setInt(3, amount);
			stm.setInt(4, invoiceID);

			int x = stm.executeUpdate();
			if (x > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ResultSet getLastestInvoiceForEdit(String meterID, int InvoiceID) {
		try {
			String sql = "SELECT * from invoice where meterID = ? AND (id BETWEEN 1 AND ?)  ORDER BY id DESC LIMIT 1";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, meterID);
			stm.setInt(2, InvoiceID - 1);
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean delInvoice(String invoiceID) {
		try {
			String sql = "delete from invoice where id=?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			stm.setString(1, invoiceID);

			int x = stm.executeUpdate();
			if (x > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ResultSet getDataBySearch1(String customerName, String countyName, String wardName, String cycle) {
		try {
			String sql = "SELECT customer.id, customer.meterID,customer.fullname, customer.address, county.name, ward.name, customer.phone, customer.email, invoice.cycle,invoice.amount,customer.countyID,customer.wardID FROM (((customer INNER JOIN county on customer.countyID = county.id)\r\n"
					+ "					              INNER JOIN ward ON customer.wardID = ward.id) INNER JOIN invoice ON customer.meterID = invoice.meterID) where customer.fullname like ? and county.name like ? and ward.name like ? and invoice.cycle like ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + customerName + "%");
			stm.setString(2, "%" + countyName + "%");
			stm.setString(3, "%" + wardName + "%");
			stm.setString(4, "%" + cycle + "%");
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getDataBySearch2(String customerName, String countyName, String wardName, Date cycleStart,
			Date cycleEnd) {
		try {
			String sql = "SELECT customer.id, customer.meterID,customer.fullname, customer.address, county.name, ward.name, customer.phone, customer.email, invoice.cycle,invoice.amount,customer.countyID,customer.wardID FROM (((customer INNER JOIN county on customer.countyID = county.id)\r\n"
					+ "					              INNER JOIN ward ON customer.wardID = ward.id) INNER JOIN invoice ON customer.meterID = invoice.meterID) where customer.fullname like ? and county.name like ? and ward.name like ? and (invoice.cycle between ? and ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			java.sql.Date sqlCycleStart = new java.sql.Date(cycleStart.getTime());
			java.sql.Date sqlCycleEnd = new java.sql.Date(cycleEnd.getTime());

			stm.setString(1, "%" + customerName + "%");
			stm.setString(2, "%" + countyName + "%");
			stm.setString(3, "%" + wardName + "%");
			stm.setDate(4, sqlCycleStart);
			stm.setDate(5, sqlCycleEnd);
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getDataBySearch3(String customerName, String countyName, String wardName, Date cycle) {
		try {
			String sql = "SELECT customer.id, customer.meterID,customer.fullname, customer.address, county.name, ward.name, customer.phone, customer.email, invoice.cycle,invoice.amount,customer.countyID,customer.wardID FROM (((customer INNER JOIN county on customer.countyID = county.id)\r\n"
					+ "					              INNER JOIN ward ON customer.wardID = ward.id) INNER JOIN invoice ON customer.meterID = invoice.meterID) where customer.fullname like ? and county.name like ? and ward.name like ? and invoice.cycle = ? ";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			java.sql.Date sqlCycle = new java.sql.Date(cycle.getTime());

			stm.setString(1, "%" + customerName + "%");
			stm.setString(2, "%" + countyName + "%");
			stm.setString(3, "%" + wardName + "%");
			stm.setDate(4, sqlCycle);
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getMeterIdList() {
		try {
			String sql = "select meterID from customer";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
