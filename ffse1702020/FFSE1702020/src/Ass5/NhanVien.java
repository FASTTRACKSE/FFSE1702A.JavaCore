package Ass5;

import java.util.*;
public class NhanVien extends CanBo {
	private String phongBan;
	private int ngayCong;
	private float phuCap;
	private String chucVu;
	Scanner myInput = new Scanner(System.in);
	
	public NhanVien() {
		
	}
	
	public NhanVien(String hoTen, String phongBan, int ngayCong, float phuCap, String chucVu, float heSoLuong) {
		super(hoTen, heSoLuong);
		this.phongBan = phongBan;
		this.ngayCong = ngayCong;
		this.phuCap = phuCap;
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

	public float getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(float phuCap) {
		this.phuCap = phuCap;
	}

	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	
	public void nhapNhanVien() {
		System.out.print("Nhap phong ban: ");
		String phongBan = myInput.nextLine();
		this.setPhongBan(phongBan);
		
		System.out.print("Nhap ngay cong: ");
		int ngayCong = Integer.parseInt(myInput.nextLine());
		this.setNgayCong(ngayCong);
		
		System.out.println("Chon chuc vu");
		System.out.println("1. Nhan vien");
		System.out.println("2. Pho phong");
		System.out.println("3. Truong phong");
		int btn = Integer.parseInt(myInput.nextLine());
			if(btn == 1) {
				String chucVu = "Nhan vien";
				this.setChucVu(chucVu);;
				
				float phuCap = 500;
				this.setPhuCap(phuCap);
				System.out.println("Chuc vu nhan vien co phu cap la 500");
			} else if(btn == 2) {
				String chucVu = "Pho phong";
				this.setChucVu(chucVu);;
				
				float phuCap = 1000;
				this.setPhuCap(phuCap);
				System.out.println("Chuc vu pho phong co phu cap la 1000");
			} else if(btn == 3) {
				String chucVu = "Truong phong";
				this.setChucVu(chucVu);;
				
				float phuCap = 2000;
				this.setPhuCap(phuCap);
				System.out.println("Chuc vu truong phong co phu cap la 2000");
			}
	}
	
	public void xuatNhanVien() {
		System.out.println("Ten: " + this.getHoTen() + " || Phong ban: " + this.getPhongBan() + " || Chuc vu: " + this.getChucVu() + " || Phu cap: " + this.getPhuCap() + " || Ngay cong: " + this.getNgayCong() + " || He so luong: " + this.getHeSoLuong());
	}
	
}