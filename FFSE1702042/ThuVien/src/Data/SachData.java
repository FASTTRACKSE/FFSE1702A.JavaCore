/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Object.Sach;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaara
 */
public class SachData {
    
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    public static ResultSet showTextfield(String sql) {
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
     public static void InsertSach(Sach s) {
        String sql = "insert into sach values(?,?,?,?,?,?,?)";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getTenTacGia());
            ps.setString(4, s.getNhaXB());
            ps.setString(5, s.getTheLoai());
            ps.setInt(6, s.getSoLuong());
            ps.setString(7, "Trần Thanh Tùng");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Thêm thành công!" , "Thông báo", 1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại" , "Thông báo", 1);
        }
    }
    
    public boolean UpdateSach(Sach s) {
        try {
            ps = Connect.getConnect().prepareStatement("UPDATE sach SET  Ten_Sach = ?, Ten_Tac_gia = ?,"
                    + "Nha_xb = ?, Gia_tien = ?, So_luong = ? where Ma_Sach = ?");
            ps.setString(6, s.getMaSach());
            ps.setString(1, s.getTenSach());
            ps.setString(2, s.getTenTacGia());
            ps.setString(3, s.getNhaXB());
            ps.setString(4, s.getTheLoai());
            ps.setInt(5, s.getSoLuong());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteSach(String ms) {
        try {
            ps = Connect.getConnect().prepareStatement("DELETE FROM sach WHERE Ma_Sach = ?");
            ps.setString(1, ms);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
}
