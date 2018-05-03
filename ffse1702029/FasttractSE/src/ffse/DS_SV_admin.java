package ffse;


import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.KetNoiSQL;

public class DS_SV_admin  extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel lbtieude;


	public DS_SV_admin() {
		addPanels();
		addEvents();
	
	}

	private void addPanels() {
	
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		lbtieude = new JLabel("Danh Sách Lớp Bạn");
		lbtieude.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.add(lbtieude);
		
		JTable table = new JTable();
		String[] col = { "Mã số sinh viên", "Họ & Tên", "Lớp", "Ngày sinh","xã, phường", "quận, huyện","tỉnh, Tp",  "Số điện thoại", "Email" };
		Connection conn = KetNoiSQL.getConnect("localhost", "ffse1702029", "ffse1702029","12345");
		String sql = "SELECT * FROM `admin` WHERE Lop ='" + LoginHS.lop + "'";
		 ResultSet rs = null; 
		 java.sql.Statement st = null;
		 try { 
		        st = conn.createStatement(); 
		        rs = st.executeQuery(sql); 
		        DefaultTableModel model = new DefaultTableModel(col, 0);         
		        
				while(rs.next()){ 
		            Vector v = new Vector(); 
		            v.add(rs.getString("Masv")); 
		            v.add(rs.getString("Name")); 
		            v.add(rs.getString("Lop"));
		            v.add(rs.getString("Ngaysinh"));
		            v.add(rs.getString("xa"));
		            v.add(rs.getString("Huyen"));
		            v.add(rs.getString("Tinh"));
		            v.add(rs.getString("Phone"));
		            v.add(rs.getString("Email"));
		            model.addRow(v); 
		        } 
		        table.setModel(model);  
				
		    } catch (Exception ex) { 
		             
		    } finally { 
		        try { 
		            rs.close(); 
		            st.close(); 
		            conn.close(); 
		        } catch (SQLException ex) { 
		                 
		        } 
		    } 
		JScrollPane sp = new JScrollPane(table);
		this.add(sp);

	
		
	}
	private void addEvents() {
		// TODO Auto-generated method stub
		
	}
}