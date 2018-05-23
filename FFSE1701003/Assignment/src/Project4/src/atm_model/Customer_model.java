package atm_model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Customer_model {
	private final static Connection conn = atm_connection.getConnect();
	private int id, thanhpho, quan, phuong;
	private String name, code, address, phone, email, sn_card, soTKNH;
	private Double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThanhpho() {
		return thanhpho;
	}

	public void setThanhpho(int thanhpho) {
		this.thanhpho = thanhpho;
	}

	public int getQuan() {
		return quan;
	}

	public void setQuan(int quan) {
		this.quan = quan;
	}

	public int getPhuong() {
		return phuong;
	}

	public void setPhuong(int phuong) {
		this.phuong = phuong;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSn_card() {
		return sn_card;
	}

	public void setSn_card(String sn_card) {
		this.sn_card = sn_card;
	}

	public String getSoTKNH() {
		return soTKNH;
	}

	public void setSoTKNH(String soTKNH) {
		this.soTKNH = soTKNH;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Customer_model() {
	}

	public Customer_model(String code, String name, int quan, int phuong, String address, String phone, String email,
			String sn_card, String soTKNH, Double amount) {
		super();
		this.quan = quan;
		this.phuong = phuong;
		this.name = name;
		this.code = code;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.sn_card = sn_card;
		this.soTKNH = soTKNH;
		this.amount = amount;
	}

	public ArrayList<Customer_model> getRecords() {
		ArrayList<Customer_model> data = new ArrayList<>();
		String sql = "SELECT * FROM tbl_customer WHERE isactive=1";
		try {
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(sql);
			Customer_model customer;
			while (result.next()) {
				customer = new Customer_model(result.getString("code"), result.getString("name"), result.getInt("quan"),
						result.getInt("phuong"), result.getString("address"), result.getString("phone"),
						result.getString("email"), result.getString("sn_card"), result.getString("soTKNH"),
						result.getDouble("amount"));
				data.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public int addNew(Customer_model ctm) {
		try {
			String sql = "insert into tbl_customer (code, name, quan, phuong, address,"
					+ "phone, email, sn_card, soTKNH, amount) " + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			stm.setString(1, ctm.getCode());
			stm.setString(2, ctm.getName());
			stm.setInt(3, ctm.getQuan());
			stm.setInt(4, ctm.getPhuong());
			stm.setString(5, ctm.getAddress());
			stm.setString(6, ctm.getPhone());
			stm.setString(7, ctm.getEmail());
			stm.setString(8, ctm.getSn_card());
			stm.setString(9, ctm.getSoTKNH());
			stm.setDouble(10, ctm.getAmount());
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int edit(Customer_model ctm, String maKH) {
		try {
			String sql = "UPDATE tbl_customer SET name = ?, quan = ?, phuong = ?, address = ?,"
					+ "phone = ?, email = ? WHERE code = '"+ maKH +"'";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			stm.setString(1, ctm.getName());
			stm.setInt(2, ctm.getQuan());
			stm.setInt(3, ctm.getPhuong());
			stm.setString(4, ctm.getAddress());
			stm.setString(5, ctm.getPhone());
			stm.setString(6, ctm.getEmail());
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int delete(Customer_model ctm, String maKH) {
		try {
			String sql = "DELETE FROM tbl_customer WHERE code = '"+ maKH +"'";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public void excecuteSQLQuery(String query, String message) {
		Connection con = atm_connection.getConnect();
		Statement st;
		try {
			st = con.createStatement();
			if (st.executeUpdate(query) == 1) {
				JOptionPane.showMessageDialog(null, "Data " + message + " successfully");
			} else {
				JOptionPane.showMessageDialog(null, "Data not " + message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Customer_model getCustomerById(int id) {
		Customer_model customer = new Customer_model();
		String sql = "SELECT * FROM tbl_customer WHERE isactive = 1 AND code = " + id;
		try {
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				customer = new Customer_model(result.getString("code"), result.getString("name"), result.getInt("quan"),
						result.getInt("phuong"), result.getString("address"), result.getString("phone"),
						result.getString("email"), result.getString("sn_card"), result.getString("soTKNH"),
						result.getDouble("amount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	public static Customer_model getCustomerbyCardSN(int cardSN) {
		Customer_model ctm = new Customer_model();
		try {
			String sql = "SELECT * FROM tbl_customer WHERE sn_card = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setInt(1, cardSN);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ctm.setName(rs.getString("name"));
				ctm.setPhone(rs.getString("phone"));
				ctm.setEmail(rs.getString("email"));
				ctm.setQuan(rs.getInt("quan"));
				ctm.setPhuong(rs.getInt("phuong"));
				ctm.setCode(rs.getString("code"));
				ctm.setSn_card(rs.getString("sn_card"));
				ctm.setSoTKNH(rs.getString("soTKNH"));
				ctm.setAmount(rs.getDouble("amount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ctm;
	}
}
