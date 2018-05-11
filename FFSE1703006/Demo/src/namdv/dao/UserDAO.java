package namdv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import namdv.model.User;
import namdv.util.ConnectDB;

public class UserDAO {
	private static Connection con = ConnectDB.getConnect();

	public static int add(User u) {
		int status = 0;
		try {
			PreparedStatement ps = con
					.prepareStatement("insert into testcrud(id,name,password,email,sex,country) values(?,?,?,?,?,?)");
			ps.setString(1, u.getId());
			ps.setString(2, u.getName());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getSex());
			ps.setString(6, u.getCountry());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int update(User u) {
		int status = 0;
		PreparedStatement ps;
		try {
			if (u.getPassword().isEmpty()) {
				ps = con.prepareStatement("update testcrud set name=?,email=?,sex=?,country=? where id=?");
				ps.setString(1, u.getName());
				ps.setString(2, u.getEmail());
				ps.setString(3, u.getSex());
				ps.setString(4, u.getCountry());
				ps.setString(5, u.getId());
			} else {
				ps = con.prepareStatement("update testcrud set name=?,password=?,email=?,sex=?,country=? where id=?");
				ps.setString(1, u.getName());
				ps.setString(2, u.getPassword());
				ps.setString(3, u.getEmail());
				ps.setString(4, u.getSex());
				ps.setString(5, u.getCountry());
				ps.setString(6, u.getId());
			}
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int delete(String id) {
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from testcrud where id=?");
			ps.setString(1, id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static List<User> getAllRecords() {
		List<User> list = new ArrayList<User>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from testcrud");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getString("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("country"));
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static User getRecordById(String id) {
		User u = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from testcrud where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getString("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("country"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}
}
