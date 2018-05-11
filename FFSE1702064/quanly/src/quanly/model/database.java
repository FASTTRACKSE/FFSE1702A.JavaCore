package quanly.model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class database {
	public Connection connectSQL(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = new String("jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8");
            try {
                java.sql.Connection connect = DriverManager.getConnection(url, "manhdung", "12345678");
               // System.out.println("Connect DB OK!");
                return (Connection) connect;
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
         
    }
//	public static void main(String args[]) {
//		database db = new database();
//		db.connectSQL();
//	}
}
