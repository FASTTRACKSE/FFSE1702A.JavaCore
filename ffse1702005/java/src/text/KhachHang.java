package text;

import java.util.Scanner;

public class KhachHang {
	 String hoTen;
	 String soNha;
	 String maSoCongTo;

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

	public KhachHang() {}
	public KhachHang(String hoTen, String soNha, String maSoCongTo) {
		super();
		this.hoTen = hoTen;
		this.soNha = soNha;
		this.maSoCongTo = maSoCongTo;
	}

	public void nhap() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập họ tên khách hàng: ");
		String hoTen = scanner.nextLine();
		this.setHoTen(hoTen);

		System.out.print("Nhập số nhà khách hàng: ");
		String soNha = scanner.nextLine();
		this.setSoNha(soNha);

		System.out.print("Nhập mã số công tơ khách hàng: ");
		String maSoCongTo = scanner.nextLine();
		this.setMaSoCongTo(maSoCongTo);
	}

	public void xuat() {
		System.out.println("Tên khách hàng: " + this.getHoTen() + "\n" + "Số nhà: " + this.getSoNha() + "\n" + "Mã số công tơ: " + this.getMaSoCongTo());
	}
}
