package fasttrack.edu.vn.ui;

import java.sql.*;
import java.util.*;
import fasttrack.edu.vn.main.MyApplication;

public class ThemSinhVien  {
Connection conn = null;
PreparedStatement ptmt = null;
Scanner sc = new Scanner(System.in);
MyApplication kn = new MyApplication();
	public void Insertstudent(){
		//MyApplication kn = new MyApplication();
		conn = kn.getConnect("localhost", "Appcuatoi", "Appcuatoi", "123456");
		String 	username;
		int MSV;
		System.out.print("nhập tên sinh viên : ");
		username = sc.nextLine();
		System.out.print("nhập ma sinh viên : ");
		MSV = sc.nextInt();
		String sql = "insert into student(username,MSV) value(?,?)";
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, username);
			ptmt.setInt(2, MSV);
			//executeUpdate hàm trả về kiểu int nên khai báo 1 giá trị
			int kt = ptmt.executeUpdate();
			if(kt!=0) {
				System.out.println("thêm thành công");
				
			}else {
				System.out.println("thêm không thành công");
			}
			ptmt.close();
		} catch (SQLException e) {
			System.out.println("loi  "+ e.getMessage());
		}
	}
	public void Display(){
		conn = kn.getConnect("localhost", "Appcuatoi", "Appcuatoi", "123456");
		String sql = "select * from student";
		try {
			ptmt = conn.prepareStatement(sql);
			//khởi tạo resultset
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) 
			{
				int MSV= rs.getInt("MSV");
				String username = rs.getString("username");
				System.out.print(MSV);
				System.out.print(username);
			}
		}catch(SQLException e){
			System.out.println("loi  "+ e.getMessage());
	
		}
	}
}
