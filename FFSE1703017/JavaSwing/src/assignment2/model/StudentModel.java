package assignment2.model;

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
			ResultSet result= statement.executeQuery(sql);
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
			String sql = "insert into ffse17 (code, course, name, age) values( '" + code
					+ "','" + course + "','" + name + "','"	+ age + "')";
			Statement statement = (Statement) conn.createStatement();
			return statement.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public static int updateStudent(Student st) {
		String code = st.getCode();
		String name = st.getName();
		String age = st.getAge();
		int id = 0;
		ArrayList<Student> arr = getStudent();
		for (Student student : arr) {
			if(code.equals(st.getCode())) {
				id = student.getId();
			}
		}
		try {
			String sql = "update ffse17 set 'code' = '" + code 
					+"' name='" + name + "',age = '"+ age + "' where id='"+ id +"'";
			Statement statement = (Statement) conn.createStatement();
			return statement.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public static int deleteStudent(String code) {
		try {
			String sql = "delete from ffse17 where Ma='" + code +  "'";
			Statement statement = (Statement) conn.createStatement();
			return statement.executeUpdate(sql);
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
				int id = result.getInt("id");
				String code = result.getString("code");
				String course = result.getString("course");
				String name = result.getString("name");
				String age = result.getString("age");
				Student st = new Student(id, code, course, name, age);
				arr.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return arr;
	}
}
