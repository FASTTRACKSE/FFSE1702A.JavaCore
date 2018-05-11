package assignment2.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class StudentModel {
	static Connection conn = ConnectDB.getConnect("localhost", "myapp", "myapp", "0110");
	
	public static ArrayList<Student> getByCourse (String course) {
		ArrayList<Student> arr = new ArrayList<>();
		try {
			Statement statement = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "select * from ffse17 where course = " + "'" + course + "'";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				String code = result.getString("code");
				String name = result.getString("name");
				String age = result.getString("age");
				Student st = new Student(code, name, age);
				arr.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return arr;
	}
	
	public static int addStudent(Student st) {
		String code = st.getCode();
		String course = st.getCourse();
		String name = st.getName();
		String age = st.getAge();
		try {
			String sql = "insert into ffse17 (code, course, name, age) values (?, ?, ?, ?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, code);
			stm.setString(2, course);
			stm.setString(3, name);
			stm.setString(4, age);
			return stm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public static int updateStudent(Student st, String oldCode) {
		String code = st.getCode();
		String name = st.getName();
		String age = st.getAge();
		try {
			String sql = "update ffse17 set code = ?, name = ?, age = ? where code = ?"; 
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, code);
			stm.setString(2, name);
			stm.setString(3, age);
			stm.setString(4, oldCode);
			return stm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public static int deleteStudent(String code) {
		try {
			String sql = "delete from ffse17 where code = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, code);
			return stm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public static ArrayList<Student> getStudent () {
		ArrayList<Student> arr = new ArrayList<>();
		try {
			Statement statement = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "select * from ffse17";
			ResultSet result= statement.executeQuery(sql);
			while(result.next()) {
				String code = result.getString("code");
				String course = result.getString("course");
				String name = result.getString("name");
				String age = result.getString("age");
				Student st = new Student(code, course, name, age);
				arr.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return arr;
	}
}
