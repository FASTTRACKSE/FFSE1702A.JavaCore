/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Object.PhieuMuon;
import Object.Sach;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaara
 */
public class PhieuMuonData {
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
     public static void InsertPhieu(PhieuMuon p) {
        String sql = "insert into phieu_muon values(?,?,?,?,?,?,?,?)";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, p.getMaMuon());
            ps.setString(2, p.getMaKhach());
            ps.setString(3, p.getSach());
            ps.setDate(4, p.getNgayMuon());
            ps.setDate(5, p.getHanTra());
            ps.setString(6, "Trần Thanh Tùng");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Thêm thành công!" , "Thông báo", 1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại" , "Thông báo", 1);
        }
    }
    
    public boolean UpdatePhieu(PhieuMuon p) {
        try {
            ps = Connect.getConnect().prepareStatement("UPDATE phieu_muon SET  Ma_Khach_hang = ?, Ma_Sach = ?,"
                    + "Ngay_muon = ?, Han_tra = ? where Ma_Phieu_muon = ?");
            ps.setString(5, p.getMaMuon());
            ps.setString(1, p.getMaKhach());
            ps.setString(2, p.getSach());
            ps.setDate(3, p.getNgayMuon());
            ps.setDate(4, p.getHanTra());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeletePhieu(String ms) {
        try {
            ps = Connect.getConnect().prepareStatement("DELETE FROM phieu_muon WHERE Ma_Phieu_muon = ?");
            ps.setString(1, ms);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
}}
