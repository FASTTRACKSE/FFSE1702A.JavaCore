package assignment_8;

import java.util.Scanner;

public class KhachHang {
	private String hoTenChuHo;
	private String soNha;
	private String maSoCongTo;
	private Scanner scanner;

	public KhachHang() {
		super();
	}

	public KhachHang(String hoTenChuHo, String soNha, String maSoCongTo) {
		super();
		this.hoTenChuHo = hoTenChuHo;
		this.soNha = soNha;
		this.maSoCongTo = maSoCongTo;
	}

	public void nhapKhachHang() {
		scanner = new Scanner(System.in);
		System.out.print("Nhập họ tên chủ hộ: ");
		hoTenChuHo = scanner.nextLine();
		System.out.print("Nhập số nhà: ");
		soNha = scanner.nextLine();
		System.out.print("Nhập mã số công tơ: ");
		maSoCongTo = scanner.nextLine();
	}

	public void xuatKhachHang() {
		System.out.printf("| %-18s:  %-20s |\n", "Họ tên chủ hộ", hoTenChuHo);
		System.out.printf("| %-18s:  %-20s |\n", "Số nhà", soNha);
		System.out.printf("| %-18s:  %-20s |\n", "Mã số công tơ", maSoCongTo);
	}
}
