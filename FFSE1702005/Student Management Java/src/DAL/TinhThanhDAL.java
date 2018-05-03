package DAL;

import Entity.TinhThanh;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Little Princess
 */
public class TinhThanhDAL extends DataAcsHelper{
    
    private final String GET_BY_ID = "SELECT * FROM TINHTHANH WHERE MaTinh = ? " ;
    private final String GET_ALL = " SELECT * FROM TINHTHANH " ;
    private final String GET_BY_NAME = "SELECT * FROM TINHTHANH WHERE TenTinh = ? " ;
    
    public ArrayList<TinhThanh> GetByName(String TenTinh)
    {
        ArrayList<TinhThanh> objs = new ArrayList<>() ;
        try {
            getConnect() ;
            PreparedStatement ps = con.prepareStatement(GET_BY_NAME) ;
            ps.setString(1, TenTinh);
            ResultSet rs = ps.executeQuery() ;
            if( rs != null && rs.next())
            {
                TinhThanh item = new TinhThanh() ;
                item.setMaTinh(rs.getInt("MaTinh"));
                item.setTenTinh(rs.getString("TenTinh"));
                objs.add(item) ;
           
            }
           
            getClose() ;
           
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        
        return objs ;
    }
    
    public ArrayList<TinhThanh> GetByID(int MaTinh)
    {
        ArrayList<TinhThanh> objs = new ArrayList<>() ;
        try {
            getConnect() ;
            PreparedStatement ps = con.prepareStatement(GET_BY_ID) ;
            ps.setInt(1, MaTinh);
            ResultSet rs = ps.executeQuery() ;
            if( rs != null && rs.next())
            {
                TinhThanh item = new TinhThanh() ;
                item.setMaTinh(rs.getInt("MaTinh"));
                item.setTenTinh(rs.getString("TenTinh"));
                objs.add(item) ;
           
            }
           
            getClose() ;
           
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        
        return objs ;
    }
    
    public ArrayList<TinhThanh> getAll()
    {
        ArrayList<TinhThanh> objs = new ArrayList<>() ;
        try {
            getConnect(); 
            PreparedStatement ps = con.prepareStatement(GET_ALL) ;
            
            ResultSet rs = ps.executeQuery() ;
            if( rs != null )
            {
                while( rs.next() )
                {
                    TinhThanh item = new TinhThanh() ;
                    item.setMaTinh(rs.getInt("MaTinh"));
                    item.setTenTinh((rs.getString("TenTinh")));
                    objs.add(item) ;
                }   
            }
            getClose();
          
        } catch (Exception e) {
            
            e.printStackTrace();
        }
  
        return objs ;
    }
    
}

