package model;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.gjt.mm.mysql.Driver;

public class KetNoiSQL {
	
	static String strServer;
	static String strDatabase;
	static String strUser;
	static String strPwd;
	
	public static Connection getConnect(String strServer,String strDatabase,String strUser,String strPwd) {
			
			Connection conn=null;
			String strConnect="jdbc:mysql://"+strServer+"/"+strDatabase +"?useUnicode=true&characterEncoding=utf-8";
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
	public static void main(String [] args ) {
		Connection conn= getConnect("localhost", "ffse1702029", "ffse1702029","12345");
		if(conn!=null)
		{
			 String mess = "thanh cong";
			 JOptionPane.showMessageDialog(null,mess);
		}
		else
		{
		System.out.println("Kết nối MYSQL thất bại");
		}
		
	}
	
	
}
