package Models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import ffse1702029.KetNoiSQL;
public class SinhVien {
	int id;
	String name, address, sdt;
	Connection conn;
	KetNoiSQL mysql = new KetNoiSQL();
	
	public SinhVien() {
		super();
		conn = mysql.getConnect("localhost", "ffse1702029", "ffse1702029", "12345");
		
	}
	public SinhVien(int id, String name, String address, String sdt) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.sdt = sdt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+this.id+" Hoten: "+this.name;
	}
	public  ResultSet getAll() {
		String sql = "SELECT * FROM dssv";
		try {
			Statement sttm = conn.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet getByID(int id) {
		String sql = "SELECT * FROM dssv WHERE id="+id;
		System.out.println(sql);
		try {
			Statement sttm = conn.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int insert(String name, String address, String sdt) {
		String sql = "INSERT INTO dssv(name,address,sdt) VALUES(?,?,?)";	
		try {
			PreparedStatement sttm = conn.prepareStatement(sql);
			sttm.setString(1,name);
			sttm.setString(2,address);
			sttm.setString(3,sdt);
			return sttm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public void hienthiDS() {
		SinhVien qlsv = new SinhVien();
		ResultSet rs = qlsv.getAll();
	
		SinhVien sv;
		try {
			while(rs.next()) {
			try {
				sv = new SinhVien(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				System.out.println(sv);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SinhVien qlsv = new SinhVien();
		ResultSet rs = qlsv.getAll();
	
		SinhVien sv;
		
		rs=qlsv.getByID(2);
		try {
			rs.next();
			sv = new SinhVien(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			System.out.println(sv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int kq = qlsv.insert("MrLam", "QN", "0935");
		if(kq==1) {
			qlsv.hienthiDS();
		}else {
			System.out.println("Them that bai");
		}
		
	}
	
}
