package assignment5;

import java.util.Scanner;

public class NhanVien extends Canbo {
	private String phongBan;
	private int soNgayCong;
	private String chucVu;
	Canbo cb;

	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public NhanVien(String phongBan, int soNgayCong, String chucVu, Canbo cb) {
		super();
		this.phongBan = phongBan;
		this.soNgayCong = soNgayCong;
		this.chucVu = chucVu;
		this.cb = cb;
	}

	public void nhap(Scanner sc) {
		super.nhapHoTen(sc);
		super.nhapPhuCap(sc);
		super.nhapHeSoLuong(sc);

		System.out.println("Nhap phong ban cua nhan vien");
		this.phongBan = sc.nextLine();

		System.out.println("Nhap so ngay cong cua nhan vien");
		this.soNgayCong = Integer.parseInt(sc.nextLine());

		System.out.println("Nhap chuc vu cua nhan vien");
		String chucVu = sc.nextLine();
		this.setChucVu(chucVu);
		this.tinhLuong();
	}

	public void xuat() {
		super.xuat();
		System.out.println("Phong ban cua nhan vien la:" + this.phongBan);
		System.out.println("Chuc vu cua nhan vien la:" + this.chucVu);
		System.out.println("So ngay cong cua nhan vien la:" + this.soNgayCong);
	}

	public void tinhLuong() {
		float tongLuong = (this.getHesoluong() * 730) + this.getPhucap() + this.soNgayCong * 30;
		this.setLuong(tongLuong);
	}

}
