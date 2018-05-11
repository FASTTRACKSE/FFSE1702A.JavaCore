package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class District {
	private int maQuan;
	private String tenQuan;
	
	public static ArrayList<District> listDist;
	
	public District(int id, String tenQ) {
		this.maQuan = id;
		this.tenQuan = tenQ;
	}
	public int getMaQuan() {
		return maQuan;
	}
	public void setMaQuan(int maQuan) {
		this.maQuan = maQuan;
	}
	public String getTenQuan() {
		return tenQuan;
	}
	public void setTenQuan(String tenQuan) {
		this.tenQuan = tenQuan;
	}
	
	public static District getDistricByName(String distName) {
		
		for(District d : listDist) {
			if(d.tenQuan.equals(distName)) {
				return d;
			}
		}
		return null;
	}
	
	public static void getListDistric(JComboBox jc) {
		listDist = new ArrayList<>();
		Connection connect = KhachHang.getConnect();
        ResultSet result = null;
        String sql = "SELECT * FROM ffse1702053_Quan";
        
        //tao gia tri default
        District temp = new District(0, "");
        jc.addItem(temp);
        try {
            Statement statement = (Statement) connect.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
            	District q = new District(rs.getInt("ID"), rs.getString("Quan"));
            	jc.addItem(q);
            	listDist.add(q);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
