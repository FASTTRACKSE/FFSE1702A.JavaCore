package canBo;

import java.util.Scanner;

//import asd.CanBo;
//import asd.CanBoException;

public class NhanVien extends CanBo {
	// Họ tên, phòng ban, số ngày công, hệ số lương, phụ
	// cấp, chức vụ (trưởng phòng, phó phòng, nhân viên).
	private String phongBan;
	private int ngayCong;
	private String chucVu;

	public NhanVien() {

	}

	public NhanVien(String phongBan, int ngayCong, String chucVu) {
		super();
		this.phongBan = phongBan;
		this.ngayCong = ngayCong;
		this.chucVu = chucVu;
	}

	public NhanVien(String hoTen, int phuCap, float heSoLuong, double luong,String maCanBo) {
		super(hoTen, phuCap, heSoLuong, luong,maCanBo);
		this.phongBan = phongBan;
		this.ngayCong = ngayCong;
		this.chucVu = chucVu;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public int getNgayCong() {
		return ngayCong;
	}

	public void setNgayCong(int ngayCong) {
		this.ngayCong = ngayCong;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public void nhap() {
		super.nhap();
		Scanner scn = new Scanner(System.in);
		System.out.println("nhập phòng ban:");
		String phongBan = scn.nextLine();
		setPhongBan(phongBan);

		System.out.println("nhập ngày công:");
		int ngayCong = Integer.parseInt(scn.nextLine());
		setNgayCong(ngayCong);
		for(;;) {
		System.out.println("nhap chuc vu:1: truong phong ,2 pho phong ,3 nhan vien");
        chucVu = scn.nextLine();
        try {
			CanBoException.chkChucVu(chucVu);
			setChucVu(chucVu);
			break;
		}catch(CanBoException e ) {
			System.out.println(e);
		}
		if (chucVu.equals("truong phong")) {
			
			this.setPhuCap(2000);
		} else if (chucVu.equals("pho phong")) {
			
			this.setPhuCap(1000);
		} else if (chucVu.equals("nhan vien")) {
			
			this.setPhuCap(500);
		}
		}
	}

	public double tinhLuong() {
		double luong = getHeSoLuong() * 730 + getPhuCap() + getNgayCong() * 30;
		return luong;
	}

	public void xuat() {
		super.xuat();
		System.out.println("Phòng ban: " + phongBan);
		System.out.println("Chức vụ: " + chucVu);
		System.out.println("Ngày công: " + ngayCong);
		System.out.println("lương: " + this.tinhLuong());

	}

}
