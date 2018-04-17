package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class AddressDB {
	
	private final static Connection conn = ConnectDB.getConnect();
	
	public static ArrayList<ComboItem> getDistricts() {
		ArrayList<ComboItem> arr = new ArrayList<>();
		try {
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * from district WHERE provinceid = 48";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("name");
				int provinceid = Integer.parseInt(rs.getString("districtid"));
				ComboItem item = new ComboItem(provinceid, name);
				arr.add(item);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return arr;
		
	}
	
	public static void setDistricts(JComboBox<ComboItem> cb) {
		ComboItem item = new ComboItem(0, "Chọn quận");
		cb.addItem(item);
		ArrayList<ComboItem> arr = AddressDB.getDistricts();
		for (ComboItem it : arr) {
			cb.addItem(it);
		}
	}
	
	public static ArrayList<ComboItem> getWards(int districtid) {
		ArrayList<ComboItem> arr = new ArrayList<>();
		try {
			String sql = "SELECT * from ward WHERE districtid = ?"; 
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, districtid);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int provinceid = Integer.parseInt(rs.getString("wardid"));
				ComboItem item = new ComboItem(provinceid, name);
				arr.add(item);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return arr;
	}
	
	public static void setWards(JComboBox<ComboItem> cb, int districtid) {
		ComboItem item = new ComboItem(0, "Chọn phường");
		cb.addItem(item);
		ArrayList<ComboItem> arr = getWards(districtid);
		for (ComboItem it : arr) {
			cb.addItem(it);
		}
	}

}
