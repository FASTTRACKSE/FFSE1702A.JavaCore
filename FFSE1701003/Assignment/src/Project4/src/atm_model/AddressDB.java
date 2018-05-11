package atm_model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import atm_ui.Item;

public class AddressDB {
	
	private final static Connection conn = atm_connection.getConnect();
	
	public static ArrayList<Item> getDistricts() {
		ArrayList<Item> arr = new ArrayList<>();
		try {
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * from tbl_district";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("name");
				int provinceid = Integer.parseInt(rs.getString("id"));
				Item item = new Item(provinceid, name);
				arr.add(item);
			}
		} catch (SQLException e) {}
		return arr;
		
	}
	
	public static void setDistricts(JComboBox<Item> cb) {
		cb.removeAllItems();
		Item item = new Item(0, "Chọn quận");
		cb.addItem(item);
		ArrayList<Item> arr = AddressDB.getDistricts();
		for (Item it : arr) {
			cb.addItem(it);
		}
	}
	
	public static ArrayList<Item> getWards(int districtid) {
		ArrayList<Item> arr = new ArrayList<>();
		try {
			String sql = "SELECT * from tbl_ward WHERE district_id = ?"; 
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, districtid);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int wardid = Integer.parseInt(rs.getString("id"));
				Item item = new Item(wardid, name);
				arr.add(item);
			}
		} catch (SQLException e) {}
		return arr;
	}
	
	public static void setWards(JComboBox<Item> cb, int districtid) {
		cb.removeAllItems();
		Item item = new Item(0, "Chọn phường");
		cb.addItem(item);
		ArrayList<Item> arr = getWards(districtid);
		for (Item it : arr) {
			cb.addItem(it);
		}
	}
	
	public static String getNameDistrictById(int id) {
		String data = "";
		try {
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * from tbl_district WHERE id = " + id;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				data = rs.getString("name");
			}
		} catch (SQLException e) {}
		return data;
	}
	
	public static String getNameWardById(int id) {
		String data = "";
		try {
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * from tbl_ward WHERE id = " + id;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				data = rs.getString("name");
			}
		} catch (SQLException e) {}
		return data;
	}
	
	public static void setSelectedDistrict(JComboBox<Item> cb, int id) {
		ArrayList<Item> arrDistrict = AddressDB.getDistricts();
		for (Item itemD : arrDistrict) {
			if (itemD.getId() == id) {
				int indexD = arrDistrict.indexOf(itemD) + 1;
				cb.setSelectedIndex(indexD);
				break;
			}
		}
	}
	
	public static void setSelectedWard(JComboBox<Item> cb, int id, int districtId) {
		ArrayList<Item> arrDistrict = AddressDB.getWards(districtId);
		for (Item itemD : arrDistrict) {
			if (itemD.getId() == id) {
				int indexD = arrDistrict.indexOf(itemD) + 1;
				cb.setSelectedIndex(indexD);
				break;
			}
		}
	}

}
