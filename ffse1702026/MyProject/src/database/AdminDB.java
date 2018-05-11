package database;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import object.Admin;


public class AdminDB {
	public static ArrayList<Admin> getInfor(String sql) throws SQLException{
		ArrayList<Admin> ad=new ArrayList<Admin>();
		Connection conn= connectdb.getConnect();
		if (conn!=null) {
			Statement statement =(Statement) conn.createStatement();
			ResultSet result =statement.executeQuery(sql);
			while(result.next()) {
				Admin add=new Admin(result.getString(2),result.getString(3));
				ad.add(add);
			}
		}
		else {
			System.exit(0);
		}
		
		return ad;
	}
	
}
