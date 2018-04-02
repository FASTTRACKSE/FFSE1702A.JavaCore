package java1.desktopqlsv;

import java.io.Serializable;

public class SinhVien implements Serializable {
	private String Masv;
	private String hoten;
	private String tuoi;
	private String lop;
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SinhVien(String masv, String hoten, String tuoi, String lop) {
		super();
		Masv = masv;
		this.hoten = hoten;
		this.tuoi = tuoi;
		this.lop = lop;
	}
	public String getMasv() {
		return Masv;
	}
	public void setMasv(String masv) {
		Masv = masv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTuoi() {
		return tuoi;
	}
	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	
}
