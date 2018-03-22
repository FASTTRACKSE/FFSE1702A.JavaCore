package text;

import java.util.Scanner;

public class KhachHang {
	private String hoTen;
	private String soNha;
	private String maSoCongTo;
	
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public String getMaSoCongTo() {
		return maSoCongTo;
	}

	public void setMaSoCongTo(String maSoCongTo) {
		this.maSoCongTo = maSoCongTo;
	}

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String hoTen, String soNha, String maSoCongTo) {
		super();
		this.hoTen = hoTen;
		this.soNha = soNha;
		this.maSoCongTo = maSoCongTo;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ho ten chu ho: ");
		this.hoTen = sc.nextLine();

		System.out.println("So nha: ");
		this.soNha = sc.nextLine();

		System.out.println("Ma so cong to: ");
		this.maSoCongTo = sc.nextLine();
	}
	
	public void xuat() {
		System.out.println("Ten khach hang: "+ this.hoTen);
		System.out.println("So nha : "+ this.soNha);
		System.out.println("Ma so cong to: "+ this.maSoCongTo);
	}

}
