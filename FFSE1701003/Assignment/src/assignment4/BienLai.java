package assignment4;

import java.util.Scanner;
import java.util.function.Supplier;

public class BienLai extends KhachHang {
	private int chiSoCu;
	private int chiSoMoi;
	private float soTienPhaiTra = 0;
	KhachHang khachhang;

	public int getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public int getchiSoMoi() {
		return chiSoMoi;
	}

	public void setchiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public float getSoTienPhaiTra() {
		return soTienPhaiTra;
	}

	public void setSoTienPhaiTra(float soTienPhaiTra) {
		this.soTienPhaiTra = soTienPhaiTra;
	}

	public BienLai() {
		// TODO Auto-generated constructor stub
	}

	public BienLai(int chiSoCu, int chiSoMoi, float soTienPhaiTra, KhachHang khachhang) {
		super();
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.soTienPhaiTra = soTienPhaiTra;
		this.khachhang = khachhang;
	}

	public void nhap(Scanner sc) {
		super.nhap(sc);
		System.out.println("Nhap chi so cu:");
		this.chiSoCu = sc.nextInt();

		System.out.println("Nhap chi so moi:");
		this.chiSoMoi = sc.nextInt();
	}

	public void tinhTienDien() {
		this.soTienPhaiTra = (this.getchiSoMoi() - this.chiSoCu) * 750;
	}

	public void xuat() {
		super.xuat();
		System.out.println("Chi so cu :" + this.chiSoCu);
		System.out.println("Chi so moi :" + this.chiSoMoi);
		System.out.println("So tien phai tra :" + this.soTienPhaiTra);
	}

}
