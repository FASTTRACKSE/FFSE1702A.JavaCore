package com.SinhvienFPT;

public abstract class SinhvienFPT {
	String hoTen;
	String nganh;
	
	public SinhvienFPT(String hoTen, String nganh) {
		this.hoTen = hoTen;
		this.nganh = nganh;
	}
	
	abstract double getDiem();
	
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	String getHocluc( ) {
		String hocLuc = "";
		if(getDiem() < 5) hocLuc = "Yeu";
		else if(getDiem() < 6.5) hocLuc = "Trung binh";
		else hocLuc = "Xuat sac";
		
		return hocLuc;
	}
	
	void xuat() {
		System.out.println("Ho ten: " + this.hoTen);
		System.out.println("Nganh: " + this.nganh);
		System.out.println("Diem: " + this.getDiem());
		System.out.println("Hoc Luc: " + this.getHocluc());
	}
}
