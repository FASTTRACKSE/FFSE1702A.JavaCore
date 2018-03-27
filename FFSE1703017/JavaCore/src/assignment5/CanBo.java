package assignment5;

import java.io.Serializable;
import java.util.Comparator;

public class CanBo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String hoTen;
	private int phuCap;
	private double heSoLuong, luong;
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}
	public double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	
	public void nhap() {
		System.out.print("Nhập họ tên: ");
		hoTen = Main.checkHoTen();
		System.out.print("Nhập hệ số lương: ");
		heSoLuong = Main.checkHeSoLuong();
	}
	
	public static Comparator<CanBo> sapXep = new Comparator<CanBo>() {
		public int compare(CanBo cb1, CanBo cb2) {
			if (cb1.luong == cb2.luong) {
				return cb1.hoTen.compareTo(cb2.hoTen);
			} else {
				return Double.compare(cb2.luong, cb1.luong);
			}
		}
	};
}
