package ql_khachsan;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Nguoi {
	private String hoTen;
	private Date ngaySinh;
	private String soCMND;
	

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public Nguoi(String hoTen, Date ngaySinh, String soCMND) {
		super();
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.soCMND = soCMND;
	}

	public Nguoi() {

	}


	public void nhapthongtin(Scanner sc) {
		System.out.print("Nhap ho va ten khach hang:");
		this.hoTen = sc.nextLine();
		System.out.print("Nhap ngay sinh (dd-mm-yyyy):");
		String ns = sc.nextLine();
		this.ngaySinh = chuyenStringDate(ns);
		System.out.print("Nhap so chung minh nhan dan:");
		this.soCMND = sc.nextLine();
	}
	
	public void hienthongtin() {
		System.out.println("Ho va ten : "+ this.hoTen);
		System.out.println("Ngay sinh : "+ this.ngaySinh);
		System.out.println("So CMND : "+ this.soCMND);
	}
	
	public Date chuyenStringDate(String str) {
		Date ns = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			ns = sdf.parse(str);
		}catch(Exception e){
			System.out.println("Loi dinh dang thoi gian");
		}
		return ns;
	}

}
