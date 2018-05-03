package MODEL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class huyen {

	public static ArrayList<String> getList(String tinh) {
		Connection conn=(Connection) Connect.getConnect();
		String sql="select * from devvn_quanhuyen inner join devvn_tinhthanhpho where devvn_tinhthanhpho.matp=devvn_quanhuyen.matp and devvn_tinhthanhpho.name=?";
		ArrayList<String> arr=new ArrayList<>();
		try {
			PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1,tinh);
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
