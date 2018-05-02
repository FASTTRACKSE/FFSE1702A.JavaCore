package ffse1702029;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JFrame;

import org.gjt.mm.mysql.Driver;

public class KetNoiSQL {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KetNoiSQL window = new KetNoiSQL();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KetNoiSQL() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
	
	Connection conn= getConnect("localhost", "ffse1702029", "ffse1702029","12345");
			if(conn!=null)
			{
			
			}
			else
			{
			System.out.println("Kết nối MYSQL thất bại");
			}
	}
	public Connection getConnect(String strServer,String strDatabase,String strUser,String strPwd) {
			
			Connection conn=null;
			String strConnect="jdbc:mysql://"+strServer+"/"+strDatabase;
			Properties pro=new Properties();
			pro.put("user", strUser);
			pro.put("password", strPwd);
			try
			{
			com.mysql.jdbc.Driver driver=new Driver();
			conn=driver.connect(strConnect, pro);
			}
			catch(SQLException ex)
			{
			ex.printStackTrace();
			}
			return conn;
			
	}
	
}
