package atm_model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import atm_ui.Item;

public class Atm_md {
	private final static Connection conn = atm_connection.getConnect();
	private int id, thanhPho, quan, phuong;
	private String code, address;
	private double total;

	public int getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(int thanhPho) {
		this.thanhPho = thanhPho;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Atm_md() {
	}

	public Atm_md(int thanhPho, int quan, int phuong, String code, String address, double total) {
		super();
		this.thanhPho = thanhPho;
		this.quan = quan;
		this.phuong = phuong;
		this.code = code;
		this.address = address;
		this.total = total;
	}

	public ArrayList<Atm_md> getRecords(String strWhere) {
		ArrayList<Atm_md> data = new ArrayList<>();
		String sql = "SELECT * FROM tbl_atm WHERE isactive=1 "+ strWhere;
		try {
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(sql);
			Atm_md atm;
			while (result.next()) {
				atm = new Atm_md(result.getInt("thanhpho"), result.getInt("quan"), result.getInt("phuong"),
						result.getString("code"), result.getString("address"), result.getDouble("total"));
				data.add(atm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public ArrayList<Atm_md> getRecordsWithCustomer(String strWhere) {
		ArrayList<Atm_md> data = new ArrayList<>();
		String sql = "SELECT trans.*, trans.`code` as transCode, cus.*, cus.code as cusCode FROM tbl_transaction AS trans INNER JOIN "
				+ "tbl_customer AS cus ON trans.sn_card = cus.sn_card WHERE trans.isactive = 1 " + strWhere;
		try {
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(sql);
			Atm_md atm;
			while (result.next()) {
				atm = new Atm_md();
				// atm.setCusName(result.getString("name"));
				// atm.setSn_card(result.getInt("cus.sn_card"));
				// atm.setQuan(result.getInt("quan"));
				// atm.setPhuong(result.getInt("phuong"));
				// atm.setCusAddress(result.getString("address"));
				// atm.setCode(result.getString("transCode"));
				// atm.set_time(result.getString("time"));
				// atm.setNumber(result.getInt("number"));
				data.add(atm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public Atm_md getAtmByCode(String code) {
		Atm_md atm = new Atm_md();
		try {
			String sql = "SELECT * FROM tbl_atm WHERE isactive = 1 AND code = '" + code + "'";
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(sql);
			if (result.next()) {
				atm = new Atm_md(result.getInt("thanhpho"), result.getInt("quan"), result.getInt("phuong"),
						result.getString("code"), result.getString("address"), result.getDouble("total"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return atm;
	}

	public static int addNew(Atm_md atm) {
		try {
			String sql = "insert into tbl_atm (code, thanhpho, quan, phuong, address, total) "
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			stm.setString(1, atm.getCode());
			stm.setInt(2, 48);
			stm.setInt(3, atm.getQuan());
			stm.setInt(4, atm.getPhuong());
			stm.setString(5, atm.getAddress());
			stm.setDouble(6, atm.getTotal());
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int edit(Atm_md ctm, String maThe) {
		try {
			String sql = "UPDATE tbl_atm SET quan = ?, phuong = ?, address = ? WHERE code = '" + maThe + "'";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			stm.setInt(1, ctm.getQuan());
			stm.setInt(2, ctm.getPhuong());
			stm.setString(3, ctm.getAddress());
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int delete(String maATM) {
		try {
			String sql = "DELETE FROM tbl_atm WHERE code = '" + maATM + "'";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static ArrayList<Item> getATM() {
		ArrayList<Item> arr = new ArrayList<>();
		try {
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * from tbl_atm";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("code");
				int provinceid = Integer.parseInt(rs.getString("id"));
				Item item = new Item(provinceid, name);
				arr.add(item);
			}
		} catch (SQLException e) {
		}
		return arr;

	}

	public void setATM(JComboBox<Item> cb) {
		cb.removeAllItems();
		Item item = new Item(0, "Chọn một ATM");
		cb.addItem(item);
		ArrayList<Item> arr = getATM();
		for (Item it : arr) {
			cb.addItem(it);
		}
	}
}
