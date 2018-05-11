package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class KhachHang {

    private int maKhachHang;
    private String hoTen;
    private String diaChi;
    private District quan;
    private Ward phuong;
    private String email;
    private String soDienThoai;
    private String maCongTo;

    public KhachHang() {}
    public KhachHang(int maKhachHang, String hoTen, String diaChi, Ward phuong, District quan, String email, String soDienThoai, String maCongTo) {
    	setMaKhachHang(maKhachHang);
    	setHoTen(hoTen);
    	setDiaChi(diaChi);
    	setPhuong(phuong);
    	setQuan(quan);
    	setEmail(email);
    	setSoDienThoai(soDienThoai);
    	setMaCongTo(maCongTo);
    }
    
    /**
     * @return the maKhachHangc
     */
    public int getMaKhachHang() {
        return maKhachHang;
    }

    /**
     * @param maKhachHang the maKhachHang to set
     */
    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {		
        this.diaChi = diaChi;
    }

    /**
     * @return the phuong
     */
    public Ward getPhuong() {
        return phuong;
    }

    /**
     * @param phuong the phuong to set
     */
    public void setPhuong(Ward phuong) {
        this.phuong = phuong;
    }

    /**
     * @return the quan
     */
    public District getQuan() {
        return quan;
    }

    /**
     * @param quan the quan to set
     */
    public void setQuan(District quan) {
        this.quan = quan;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the soDienThoai
     */
    public String getSoDienThoai() {
        return soDienThoai;
    }

    /**
     * @param soDienThoai the soDienThoai to set
     */
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    /**
     * @return the maCongTo
     */
    public String getMaCongTo() {
        return maCongTo;
    }

    /**
     * @param maCongTo the maCongTo to set
     */
    public void setMaCongTo(String maCongTo) {
        this.maCongTo = maCongTo;
    }
    
    public static void getListCustomers(JComboBox jc) {
		Connection connect = KhachHang.getConnect();
        ResultSet result = null;
        String sql = "SELECT * FROM ffse1702053_KhachHang";
        
        //tao gia tri default
        KhachHang temp = new KhachHang(0, "", "", null, null, "", "", "");
        jc.addItem(temp);
        try {
            Statement statement = (Statement) connect.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
            	KhachHang kh = new KhachHang(rs.getInt("ID"), rs.getString("HoTen"), "", null, null, "", "", rs.getString("MaCongTo"));
            	jc.addItem(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
    
    public static ArrayList<KhachHang> timKh(KhachHang khTim) {
    	ArrayList<KhachHang> listKh = new ArrayList<>();
        Connection connect = getConnect();
        ResultSet result = null;
        String sql = "SELECT * FROM ffse1702053_KhachHang kh, ffse1702053_Quan q, ffse1702053_Phuong p WHERE "
        		+ "kh.MA_QUAN = q.ID"
        		+ " AND kh.MA_PHUONG = p.ID"
        		+ " AND HOTEN LIKE '%"+ khTim.hoTen +"%'"
        		+ " AND DIENTHOAI LIKE '%"+ khTim.soDienThoai +"%' "
        		+ " AND DIACHI LIKE '%"+ khTim.diaChi +"%' "
        		+ " AND EMAIL LIKE '%"+ khTim.email +"%' "
        		+ " AND MACONGTO LIKE '%"+ khTim.maCongTo +"%' ";
        if(khTim.phuong.getMaPhuong() != 0) {
        	sql += " AND MA_PHUONG = " + khTim.phuong.getMaPhuong();
        }
        if(khTim.quan.getMaQuan() != 0) {
        	sql += " AND MA_QUAN = " + khTim.quan.getMaQuan();
        }	
        //sap xep theo ma khach hang
        sql += " ORDER BY MaKH";
        
        try {
            Statement statement = (Statement) connect.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
            	Ward w = new Ward(Integer.parseInt(rs.getString("Ma_Phuong")), rs.getString("Phuong"));
            	District d = new District(Integer.parseInt(rs.getString("Ma_Quan")), rs.getString("Quan"));
            	KhachHang kh = new KhachHang(rs.getInt("MaKH"), rs.getString("HoTen"), 
            			rs.getString("DiaChi"), w, d, rs.getString("Email"), 
            			rs.getString("DienThoai"), rs.getString("MaCongTo"));
            	listKh.add(kh);   
            }
            return listKh;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static Connection getConnect() {
        Connection conn = null;
        String strServer = "localhost:3306";
        String strDatabase = "QuanLyTienDien";
        String strUser = "QuanLyTienDien";
        String strPwd = "123456";
        
        String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase + "?useUnicode=true&characterEncoding=utf-8";
        Properties pro = new Properties();
        pro.put("user", strUser);
        pro.put("password", strPwd);
        try {
               Driver driver = new Driver();
               conn = (Connection) driver.connect(strConnect, pro);
        } catch (SQLException ex) {
               ex.printStackTrace();
        }
        return conn;
 }
	public static boolean themMoi(KhachHang informations) {
		// TODO Auto-generated method stub
		boolean rs = true;
		Connection connect = getConnect();
        String sql = "INSERT INTO ffse1702053_KhachHang(HoTen, DiaChi, Ma_Phuong, Ma_Quan, Email, MaCongTo, DienThoai) "
        		+ "VALUES ('" + informations.hoTen + "', '" + informations.diaChi + "', '" + informations.phuong.getMaPhuong() 
        		+ "', '" + informations.quan.getMaQuan() + "', '" + informations.email + "', '" + informations.maCongTo + "', '" 
        		+ informations.soDienThoai + "')";
        try {
			Statement statement = (Statement) connect.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rs = false;
		}
		return rs;
	}

	public static boolean suaKh(KhachHang informations) {
		// TODO Auto-generated method stub
		boolean rs = true;
		Connection connect = getConnect();
        String sql = "UPDATE ffse1702053_KhachHang SET HoTen =?, DiaChi=?, Ma_Phuong=?, Ma_Quan=?, Email=?, MaCongTo=?, DienThoai=? where MaCongTo=? ";
//        		+ "VALUES ('" +  + "', '" + informations.diaChi + "', '" + informations.phuong.getMaPhuong() 
//        		+ "', '" + informations.quan.getMaQuan() + "', '" + informations.email + "', '" + informations.maCongTo + "', '" 
//        		+ informations.soDienThoai + "')";
        try {
			PreparedStatement ptmt = (PreparedStatement) connect.prepareStatement(sql);
			ptmt.setString(1, informations.hoTen);
			ptmt.setString(2, informations.diaChi);
			ptmt.setInt(3, informations.phuong.getMaPhuong());
			ptmt.setInt(4, informations.quan.getMaQuan());
			ptmt.setString(5, informations.email);
			ptmt.setString(6, informations.maCongTo);
			ptmt.setString(7, informations.soDienThoai);
			ptmt.setString(8, informations.maCongTo);
			
			
			ptmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rs = false;
		}
		return rs;
	}

}
