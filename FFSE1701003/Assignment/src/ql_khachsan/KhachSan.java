package ql_khachsan;
import java.util.Scanner;
import java.util.Date;

public class KhachSan {
	private int soNgayTro;
	private String loaiP;
	private double giaP;
	Nguoi nguoi;
	
	
	public int getSoNgayTro() {
		return soNgayTro;
	}


	public void setSoNgayTro(int soNgayTro) {
		this.soNgayTro = soNgayTro;
	}


	public String getLoaiP() {
		return loaiP;
	}


	public void setLoaiP(String loaiP) {
		this.loaiP = loaiP;
	}


	public double getGiaP() {
		return giaP;
	}


	public void setGiaP(double giaP) {
		this.giaP = giaP;
	}


	public KhachSan() {
		// TODO Auto-generated constructor stub
	}


	public KhachSan(int soNgayTro, String loaiP, double giaP, ql_khachsan.Nguoi nguoi) {
		super();
		this.soNgayTro = soNgayTro;
		this.loaiP = loaiP;
		this.giaP = giaP;
		this.nguoi = nguoi;
	}
	
	public void nhapThongTin(Scanner sc) {
		nguoi = new Nguoi();
		this.nguoi.nhapthongtin(sc);
		System.out.print("Nhap so ngay tro :");
		this.soNgayTro = sc.nextInt();
		System.out.print("Nhap loai phong tro :");
		this.loaiP = sc.nextLine();
		System.out.print("Nhap gia phong :");
		this.giaP = sc.nextDouble();
		sc.nextLine();
	}
	
	public void hienThongTin() {
		nguoi.hienthongtin();
		System.out.println("So ngay tro: "+this.soNgayTro);
		System.out.println("Loai phong: "+this.loaiP);
		System.out.println("Gia phong: "+this.giaP);
	}
	
	public Double thanhTien() {
		return this.soNgayTro * this.giaP;
	}
	
	public Nguoi getNguoi() {
		return this.nguoi;
	}
	
	public void xoa() {
		this.nguoi = new Nguoi();
		this.soNgayTro = 0;
		this.loaiP = null;
		this.giaP = 0;
	}

}
