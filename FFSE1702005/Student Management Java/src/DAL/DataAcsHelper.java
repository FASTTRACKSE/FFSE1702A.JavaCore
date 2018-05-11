package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAcsHelper {
    protected Connection con;
    String Hostname = "localhost";
    String port = "1433";
    String dbName = "SINHVIEN";
    String use = "sa";
    String pass = "12345";
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String URL = "jdbc:sqlserver://" + this.Hostname + ":" + this.port + ";database=" + this.dbName;

    public void getConnect() {
        try {
            Class.forName(this.driver);
            try {
                this.con = DriverManager.getConnection(this.URL, this.use, this.pass);
            }
            catch (SQLException ex) {
                Logger.getLogger(DataAcsHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAcsHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getClose() {
        try {
            this.con.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(DataAcsHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}