package assignment4;

import java.util.Scanner;

public class BienLai {
	private KhachHang khachHang;
	private int soCu, soMoi;
	private double soTien;
	private Scanner input;
	
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public int getSoCu() {
		return soCu;
	}
	public void setSoCu(int soCu) {
		this.soCu = soCu;
	}
	public int getSoMoi() {
		return soMoi;
	}
	public void setSoMoi(int soMoi) {
		this.soMoi = soMoi;
	}
	public double getSoTien() {
		return soTien;
	}
	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}
	@Override
	public String toString() {
		return khachHang + "Số cũ:" + soCu + " |Số mới:" + soMoi + "|Tiền phải trả: " + soTien + " |";
	}
	
	public void nhapBienLai() {
		khachHang = new KhachHang();
		khachHang.nhapKhachHang();
		input = new Scanner(System.in);
		System.out.print("Nhập số cũ: ");
		soCu = Integer.parseInt(input.nextLine());
		System.out.print("Nhập số mới: ");
		soMoi = Integer.parseInt(input.nextLine());
		soTien = (soMoi - soCu) * 750;
	}
	

}
