package DAL;

import DAL.DataAcsHelper;
import Entity.ThiSinh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThiSinhDAL extends DataAcsHelper {
    private final String GET_ALL = " SELECT * FROM THISINH";
    private final String ADD_DATA = " INSERT INTO THISINH( MaTS , Name , MaTinh,NgaySinh,GioiTinh,DiemToan,DiemHoa,DiemLi) VALUES(?,?,?,?,?,?,?,?) ";
    private final String REMOVE_DATA = " DELETE FROM THISINH WHERE MaTS = ? ";
    private final String UPDATE_DATA = " UPDATE  THISINH SET Name = ? , MaTinh = ? , NgaySinh = ? , GioiTinh = ? , DiemToan = ? , DiemHoa = ? , DiemLi = ? WHERE MaTS = ? ";
    
    private final String SEARCH_DATA = " SELECT * FROM THISINH WHERE MaTS = ?  " ;
    private final String GET_BY_ID = "SELECT * FROM TINHTHANH WHERE MaTinh = ? " ;
    private final String GET_LOGIN = " SELECT * FROM THISINH WHERE MaTS = ? AND Name = ? " ;
    
    public boolean getLogin(int mts , String name )
    {
    
        boolean check = false ;
        try {
            getConnect() ;
            PreparedStatement ps = con.prepareStatement(GET_LOGIN) ;
            ps.setInt(1,mts) ;
            ps.setString(2, name);
            ResultSet rs = ps.executeQuery() ;
            
            while(rs != null && rs.next() )
            {
                check = true ;
            }
            getClose() ;
            
        } catch (Exception e) {
            e.printStackTrace(); 
            
        }
        return check ;
        
    }
    
    
    
    public ArrayList<ThiSinh> getAll() {
        ArrayList<ThiSinh> objs = new ArrayList<ThiSinh>();
        try {
            this.getConnect();
            PreparedStatement ps = this.con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ThiSinh item = new ThiSinh();
                    item.setMaTS(rs.getInt("MaTS"));
                    item.setName(rs.getString("Name"));
                    item.setMaTinh(rs.getInt("MaTinh"));
                    item.setNgaySinh(rs.getString("NgaySinh"));
                    item.setGioiTinh(rs.getInt("GioiTinh"));
                    item.setDiemToan(rs.getFloat("DiemToan"));
                    item.setDiemHoa(rs.getFloat("DiemHoa"));
                    item.setDiemLi(rs.getFloat("DiemLi"));
                    
                    objs.add(item);
                }
            }
            this.getClose();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    
    public ArrayList<ThiSinh> getByID(int MaTinh )
    {
        ArrayList<ThiSinh> objs = new ArrayList<ThiSinh>() ;
        
        try {
            this.getConnect();
            PreparedStatement ps = con.prepareStatement(" SELECT * FROM THISINH  WHERE MaTinh = ?  ") ;
            
            
            ps.setInt(1, MaTinh);
            
            ResultSet rs = ps.executeQuery() ;
            if( rs != null)
            {
                while( rs.next())
                {
                    ThiSinh item = new ThiSinh();
                    
                    item.setMaTinh(rs.getInt("MaTinh"));
                    item.setMaTS(rs.getInt("MaTS"));
                    item.setName(rs.getString("Name"));
                    item.setNgaySinh(rs.getString("NgaySinh"));
                    item.setGioiTinh(rs.getInt("GioiTinh"));
                    item.setDiemToan(rs.getFloat("DiemToan"));
                    item.setDiemHoa(rs.getFloat("DiemHoa"));
                    item.setDiemLi(rs.getFloat("DiemLi"));
                    
                    objs.add(item) ;
                
                }  
                   
            
            }
            this.getClose();
        } catch (Exception e ) {
            e.printStackTrace();
           
        }
        
    
    
        return objs ;
    
    
    }
    public ArrayList<ThiSinh> Search(int MaTS )
    {
        ArrayList<ThiSinh> objs = new ArrayList<ThiSinh>() ;
        
        try {
            this.getConnect();
            PreparedStatement ps = con.prepareStatement(" SELECT * FROM THISINH  WHERE MaTS = ?  ") ;
            
            
            ps.setInt(1, MaTS );
            
            ResultSet rs = ps.executeQuery() ;
            if( rs != null)
            {
                while( rs.next())
                {
                    ThiSinh item = new ThiSinh();
                    item.setMaTS(rs.getInt("MaTS"));
                    item.setName(rs.getString("Name"));
                    item.setMaTinh(rs.getInt("MaTinh"));
                    item.setNgaySinh(rs.getString("NgaySinh"));
                    item.setGioiTinh(rs.getInt("GioiTinh"));
                    item.setDiemToan(rs.getFloat("DiemToan"));
                    item.setDiemHoa(rs.getFloat("DiemHoa"));
                    item.setDiemLi(rs.getFloat("DiemLi"));
                    
                    objs.add(item) ;
                
                }  
                   
            
            }
            this.getClose();
        } catch (Exception e ) {
            e.printStackTrace();
           
        }
        
    
    
        return objs ;
    
    
    }
    
    
    public boolean AddData(ThiSinh emp) {
        boolean check = false;
        try {
            this.getConnect();
            PreparedStatement ps = this.con.prepareStatement(ADD_DATA);
            ps.setInt(1, emp.getMaTS());
            ps.setString(2, emp.getName());
            ps.setInt(3, emp.getMaTinh());
            ps.setString(4, emp.getNgaySinh());
            ps.setInt(5, emp.getGioiTinh());
            ps.setFloat(6, emp.getDiemToan());
            ps.setFloat(7, emp.getDiemHoa());
            ps.setFloat(8, emp.getDiemLi());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            this.getClose();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean DeleteData(int u) {
        boolean check = false;
        try {
            this.getConnect();
            PreparedStatement ps = this.con.prepareStatement(REMOVE_DATA);
            ps.setInt(1, u);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            this.getClose();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean UpdateData(ThiSinh emp) {
        boolean check = false;
        try {
            this.getConnect();
            PreparedStatement ps = this.con.prepareStatement(UPDATE_DATA);
            ps.setString(1, emp.getName());
            ps.setInt(2, emp.getMaTinh());
            ps.setString(3, emp.getNgaySinh());
            ps.setInt(4, emp.getGioiTinh());
            ps.setFloat(5, emp.getDiemToan());
            ps.setFloat(6, emp.getDiemHoa());
            ps.setFloat(7, emp.getDiemLi());
            ps.setInt(8, emp.getMaTS());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            this.getClose();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}