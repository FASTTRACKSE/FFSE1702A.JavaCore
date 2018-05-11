<<<<<<< HEAD:FFSE1702042/canBo/src/Quanlycanbo/NhanVien.java
package Quanlycanbo;
import java.util.Scanner;
=======
package Quanlycanbo.com;
>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing:FFSE1702011/Assignment 5/src/Quanlycanbo/com/NhanVien.java
import java.util.*;
import java.io.Serializable;
public class NhanVien extends CanBo {
	private String phongBan;
	private int ngayCong;
	private float phuCap;
	private String chucVu;
	
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
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhap phong ban: ");
		String phongBan = myInput.nextLine();
		this.setPhongBan(phongBan);
		
		System.out.print("Nhap ngay cong: ");
		int ngayCong = Integer.parseInt(myInput.nextLine());
		this.setNgayCong(ngayCong);
		
		for(;;) {
			System.out.println("Chon chuc vu");
			System.out.println("1. Nhan vien");
			System.out.println("2. Pho phong");
			System.out.println("3. Truong phong");
			String btn = myInput.nextLine();
			try {
				CanBoException.chkTrinhDo(btn);
				if(btn.equals("1")) {
					String chucVu = "Nhan vien";
					this.setChucVu(chucVu);;
					
					float phuCap = 500;
					this.setPhuCap(phuCap);
					System.out.println("Chuc vu nhan vien co phu cap la 500");
				} else if(btn.equals("2")) {
					String chucVu = "Pho phong";
					this.setChucVu(chucVu);;
					
					float phuCap = 1000;
					this.setPhuCap(phuCap);
					System.out.println("Chuc vu pho phong co phu cap la 1000");
				} else if(btn.equals("3")) {
					String chucVu = "Truong phong";
					this.setChucVu(chucVu);;
					
					float phuCap = 2000;
					this.setPhuCap(phuCap);
					System.out.println("Chuc vu truong phong co phu cap la 2000");
				}
				break;
			} catch (CanBoException e) {
				System.out.print(e);
			}
		}
	}
	public double tinhLuong() {
		double luong = getHeSoLuong() * 730 + getPhuCap() + getNgayCong() * 30;
		return luong;
	}
	public void xuatNhanVien() {
<<<<<<< HEAD
		System.out.println("Ma nhan vien: " + this.getMaCanBo() + " || Ten: " + this.getHoTen() + " || Phong ban: " + this.getPhongBan() + " || Chuc vu: " + this.getChucVu() + " || Phu cap: " + this.getPhuCap() + " || Ngay cong: " + this.getNgayCong() + " || He so luong: " + this.getHeSoLuong());
=======
		System.out.println("Ten: " + this.getHoTen() + " || Phong ban: " + this.getPhongBan() + " || Chuc vu: " + this.getChucVu() + " || Phu cap: " + this.getPhuCap() + " || Ngay cong: " + this.getNgayCong() + " || He so luong: " + this.getHeSoLuong());
		
>>>>>>> 45c6cc847d29ca7c683fcf8d24d00a1ee0c5e29f
	}
	
}
