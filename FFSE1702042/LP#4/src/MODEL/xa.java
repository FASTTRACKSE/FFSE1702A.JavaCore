package MODEL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class xa {
	public static ArrayList<String> getList(String quan) {
	Connection conn=(Connection) Connect.getConnect();
	String sql="select * from devvn_xaphuongthitran inner join devvn_quanhuyen where devvn_quanhuyen.maqh=devvn_xaphuongthitran.maqh and devvn_quanhuyen.name=?";
	ArrayList<String> arr=new ArrayList<>();
	try {
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		
		ptmt.setString(1,quan);
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
