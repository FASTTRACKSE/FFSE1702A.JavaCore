package assignment4;

import java.util.Scanner;

public class KhachHang {
	private String hoTen, soNha, maSoCongTo;
	private Scanner input;
	
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
	@Override
	public String toString() {
		return "|Họ tên: " + hoTen + " |Số nhà: " + soNha + " |Mã số côngtơ: " + maSoCongTo + " |";
	}
	
	public void nhapKhachHang() {
		input = new Scanner(System.in);
		System.out.print("Nhập họ tên: ");
		hoTen = input.nextLine();
		System.out.print("Nhập số nhà: ");
		soNha = input.nextLine();
		System.out.print("Nhập mã số côngtơ: ");
		maSoCongTo = input.nextLine();
	}
	
	
}
