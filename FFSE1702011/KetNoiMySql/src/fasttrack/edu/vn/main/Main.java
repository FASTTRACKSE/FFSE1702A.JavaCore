package fasttrack.edu.vn.main;
import fasttrack.edu.vn.ui.*;
import java.sql.*;
import com.mysql.*;
import java.io.*;
import fasttrack.edu.vn.connection.ConnectSql;
import java.util.*;
public class Main {
	static Connection conn = ConnectSql.getConnect("localhost", "FFSE", "FFSE", "123456");
	public static void main(String[] args) {
		UIMyWindow giaodien = new UIMyWindow("Chương trình quản lý sinh viên");
		giaodien.showWindow();
	}
}

