package quanly.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import quanly.model.database;

public class SinhVien {
	database db ;
	Connection con;
	String masv,tensv;
	
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getTensv() {
		return tensv;
	}
	public void setTensv(String tensv) {
		this.tensv = tensv;
	}
	public SinhVien() {
		db = new database();
		con = db.connectSQL();
	}
	public ArrayList<SinhVien> getAll() {
		String sql= "SELECT * FROM sinhvien";
		ArrayList<SinhVien> dssv = new ArrayList<SinhVien>() ;
		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			try {
				while(rs.next()) {
					SinhVien sv = new SinhVien();
					sv.masv=rs.getString("id");
					sv.tensv=rs.getString("name");
					dssv.add(sv);
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssv;
	}
	
	@Override
	public String toString() {
		return "SinhVien [masv=" + masv + ", tensv=" + tensv + "]";
	}
	public static void main(String args[]) {
		SinhVien sv = new SinhVien();
		ArrayList<SinhVien> items = sv.getAll();
		for(SinhVien item:items) {
			System.out.println(item);
		}
	}
}
