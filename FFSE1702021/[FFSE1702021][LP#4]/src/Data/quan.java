package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class quan {

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
//if (conn != null) {
//	String sql1 = "SELECT * FROM BanDoc WHERE   Matv=?";
//	PreparedStatement ptmt1;
//	try {
//		ptmt1 = (PreparedStatement) conn.prepareStatement(sql1);
//		ptmt1.setString(1, txtMTV.getText());
//		ResultSet rs = ptmt1.executeQuery();
//		while(rs.next()) {
//			String SL =rs.getString("so_sach_muon") ;
//			
//			if(SL.equals("3")) {
//			String sql = "INSERT INTO `Phieu_Muon`( `ma_gd`,`ngay_muon`,`ma_tv`,`ma_s`) VALUES (?,?,?,?)";
//			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			try {
//				String dateAdd = format.format(txtNM.getDate());
//
//				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
//				ptmt.setString(1, txtMGD.getText());
//				ptmt.setString(2, dateAdd);
//				ptmt.setString(3, txtMTV.getText());
//				ptmt.setString(4, masach);
//
//				int k = ptmt.executeUpdate();
//				
//					String[] row = { masach, ten_s, ten_tg };
//					mdTableSachMuon.addRow(row);
//					
//
//				
//			} catch (SQLException e) {
//				System.out.println("loi  " + e.getMessage());
//
//			}
//	}else {
//		JOptionPane.showMessageDialog(null, "Hết lượt mượn");
//	}
//			}} catch (SQLException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//	
//	
//	} else {
//		System.out.println("Kết nối MYSQL thất bại");
//	 }
