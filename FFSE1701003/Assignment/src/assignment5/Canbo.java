package assignment5;

import java.util.Scanner;

public class Canbo extends CanBoException {

	private String Hoten;
	private int Phucap;
	private float Hesoluong;
	private float Luong;

	public Canbo() {
		// TODO Auto-generated constructor stub
	}

	public String getHoten() {
		return Hoten;
	}

	public void setHoten(String hoten) {
		Hoten = hoten;
	}

	public int getPhucap() {
		return Phucap;
	}

	public void setPhucap(int phucap) {
		Phucap = phucap;
	}

	public float getHesoluong() {
		return Hesoluong;
	}

	public void setHesoluong(float hesoluong) {
		Hesoluong = hesoluong;
	}

	public float getLuong() {
		return Luong;
	}

	public void setLuong(float luong) {
		Luong = luong;
	}

	public Canbo(String hoten, int phucap, float hesoluong, float luong) {
		super();
		Hoten = hoten;
		Phucap = phucap;
		Hesoluong = hesoluong;
		Luong = luong;
	}

	public void nhapHoTen(Scanner sc) {
		for (;;) {
			System.out.println("Nhap ho ten can bo (Giang vien hoac nhan vien):");
			String hoTen = sc.nextLine();
			try {
				CanBoException.chkHoten(hoTen);
				this.setHoten(hoTen);
				break;
			} catch (CanBoException e) {
				System.out.println(e);
			}
		}
	}

	public void nhapPhuCap(Scanner sc) {
		System.out.println("Nhap phu cap cua (Giang vien hoac nhan vien):");
		int Phucap = Integer.parseInt(sc.nextLine());
		this.setPhucap(Phucap);
	}

	public void nhapHeSoLuong(Scanner sc) {
		System.out.println("Nhap he so luong cua (Giang vien hoac nhan vien):");
		float heSoLuong = Float.parseFloat(sc.nextLine());
		this.setHesoluong(heSoLuong);
	}

	public void xuat() {
		System.out.println("Ho ten:" + this.Hoten);
		System.out.println("Phu cap:" + this.Phucap);
		System.out.println("He so luong:" + this.Hesoluong);
	}
}
