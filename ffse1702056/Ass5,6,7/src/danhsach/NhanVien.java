package danhsach;
import java.util.Scanner;
public class NhanVien extends CanBo {
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

	public NhanVien(String hoTen, int phuCap, Float heSoLuong, Float luong, String phongBan, int ngayCong,
			String chucVu) {
		super(hoTen, phuCap, heSoLuong, luong);
		this.phongBan = phongBan;
		this.ngayCong = ngayCong;
		this.chucVu = chucVu;
	}
	public void nhap() {
		super.nhap();
		Scanner scn=new Scanner(System.in);
		System.out.println("nhap phong ban:");
		String phongBan = scn.nextLine();
		setPhongBan(phongBan);
		
		System.out.println("nhap ngay cong:");
		int ngayCong = Integer.parseInt(scn.nextLine());
		setNgayCong(ngayCong);
		
		System.out.println("nhap chuc vu:1: truong phong ,2 pho phong ,3 nhan vien");
		
		int i =Integer.parseInt(scn.nextLine());
		if(i == 1) {
			chucVu="truong phong";
			this.setPhuCap(2000);
		}else if(i==2) {
			chucVu="pho phong";
			this.setPhuCap(1000);
		}else if(i==3) {
			chucVu="nhan vien";
			this.setPhuCap(500);
		}
	}
	public double tinhLuong() {
		double luong = getHeSoLuong()*730 + getPhuCap() + getNgayCong()*30; 
		return luong;
	}
	public void xuat() {
		super.xuat();
		System.out.println("Phong Ban:"+ phongBan);
		System.out.println("Chuc Vu:"+ chucVu);
		System.out.println("Ngay Cong:"+ ngayCong);
		System.out.println("luong:"+ this.tinhLuong());
		
	}
}
