package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.KhachHang;

public class KhachHangController {
	
	public static void timKiemKhachHang(KhachHang khTim, JTable jt) {
		ArrayList<KhachHang> dsKh = KhachHang.timKh(khTim);
		DefaultTableModel dfm = (DefaultTableModel) jt.getModel();
		int numRows = dfm.getRowCount();
		if(numRows > 0) {
			for(int i = 0; i < numRows; i++) {
				dfm.removeRow(0);
			}
		}
		for(KhachHang kh : dsKh) {
			String[] dataRow = {String.valueOf(kh.getMaKhachHang()), 
					kh.getHoTen(), kh.getSoDienThoai(), kh.getDiaChi(),
					kh.getQuan().getTenQuan(), kh.getPhuong().getTenPhuong(),
					kh.getEmail(), kh.getMaCongTo()};
			dfm.addRow(dataRow);
		}
	}

	public static boolean themKhachHang(KhachHang informations) {
		// TODO Auto-generated method stub
		return KhachHang.themMoi(informations);
	}
	public static boolean suaKh(KhachHang informations) {
		// TODO Auto-generated method stub
		return KhachHang.suaKh(informations);
}
}
