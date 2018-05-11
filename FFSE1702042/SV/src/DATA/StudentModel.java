package DATA;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class StudentModel {
	static Connection conn = ConnectDB.getConnect("localhost", "student", "tungtt", "12345");
	
	public static ArrayList<Student> getByCLASS (String CLASS) {
		ArrayList<Student> arr = new ArrayList<>();
		try {
			Statement statement = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "select * from student where CLASS = " + "'" + CLASS + "'";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				String ID = result.getString("ID");
				String NAME = result.getString("NAME");
				String AGE = result.getString("AGE");
				Student st = new Student(ID, NAME, AGE);
				arr.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return arr;
	}
	
	public static int addStudent(Student st) {
		String ID = st.getID();
		String NAME = st.getNAME();
		String AGE = st.getAGE();
		String CLASS = st.getCLASS();
		try {
			String sql = "insert into student (ID, NAME, AGE, CLASS) values (?, ?, ?, ?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, ID );
			stm.setString(2, NAME);
			stm.setString(3, AGE);
			stm.setString(4, CLASS);
			return stm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public static int updateStudent(Student st, String oldID) {
		String ID = st.getID();
		String NAME = st.getNAME();
		String AGE = st.getAGE();
		try {
			String sql = "update student set ID = ?, NAME = ?, AGE = ? where ID = ?"; 
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, ID);
			stm.setString(2, NAME);
			stm.setString(3, AGE);
			stm.setString(4, oldID);
			return stm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public static int deleteStudent(String ID) {
		try {
			String sql = "delete from student where ID = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, ID);
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
			String sql = "select * from student";
			ResultSet result= statement.executeQuery(sql);
			while(result.next()) {
				String ID = result.getString("ID");
				String CLASS = result.getString("CLASS");
				String NAME = result.getString("NAME");
				String AGE = result.getString("AGE");
				Student st = new Student(ID, NAME, AGE, CLASS);
				arr.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return arr;
	}
}
