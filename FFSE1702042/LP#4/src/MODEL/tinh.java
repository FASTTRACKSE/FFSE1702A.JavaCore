package MODEL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class tinh {
	public static ArrayList<String> getList() {
		Connection conn=(Connection) Connect.getConnect();
		String sql="select * from devvn_tinhthanhpho";
		ArrayList<String> arr=new ArrayList<>();
		try {
			PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			
			while(rs.next()){
				arr.add(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
		
		
	
	}

}