package fasttrack.edu.vn.main;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

import fasttrack.edu.vn.ui.KhachHang;
import fasttrack.edu.vn.ui.Login;
import fasttrack.edu.vn.ui.Menu;
import fasttrack.edu.vn.ui.QuanLyBienLai;

public class GiaoDien {

	public static void main(String args[]) {

		Login myUI = new Login("My Application");
		myUI.showWindow();

	}

}