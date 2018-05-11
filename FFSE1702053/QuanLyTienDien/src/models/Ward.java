package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class Ward {
  private String tenPhuong;
  private int maPhuong;
  public static  ArrayList<Ward> listWard;
public String getTenPhuong() {
	return tenPhuong;
}
public void setTenPhuong(String tenPhuong) {
	this.tenPhuong = tenPhuong;
}
public int getMaPhuong() {
	return maPhuong;
}
public void setMaPhuong(int maPhuong) {
	this.maPhuong = maPhuong;
}
public Ward (int id, String tenP) {
	this.maPhuong = id;
	this.tenPhuong = tenP;
}

public static Ward getWardByName(String WardName) {
	
	for(Ward p : listWard) {
		if(p.tenPhuong.equals(WardName)) {
			return p;
		}
	}
	
	return null;
}

public static ArrayList<Ward> getListWard(JComboBox jc, int maQuan) {
	ArrayList<Ward> arr = new ArrayList<>();
	listWard = new ArrayList<>();
	Connection connect = KhachHang.getConnect();
    ResultSet result = null;
    String sql = "SELECT * FROM ffse1702053_Phuong WHERE ID_QUAN = " + maQuan;
    
  //tao gia tri default
    Ward temp = new Ward(0, "");
    jc.addItem(temp);
    try {
        Statement statement = (Statement) connect.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()) {
        	Ward p = new Ward(rs.getInt("ID"), rs.getString("Phuong"));
        	arr.add(p);
        	jc.addItem(p);
        	listWard.add(p);
        }
        return arr;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
}
