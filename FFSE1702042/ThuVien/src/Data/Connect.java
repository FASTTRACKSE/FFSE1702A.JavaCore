 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gaara
 */
public class Connect {
    private  static Connection con;
    
    public static Connection getConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("\"jdbc:mysql://localhost:3306/student\", \"tungtt\", \"12345\"");
            
        } catch (Exception e) {
           //System.out.println("Kết nối thành công");
        }
        return con;
    }
    public static String testConnect() {
        try{
            con = Connect.getConnect();
            return "Kết nối thành công";
        }
        catch(Exception e) {
            return "Kết nối thất bại";
        }
    } 
}
