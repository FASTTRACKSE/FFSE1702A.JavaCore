package assignment_8;

import java.util.Scanner;

public class BienLai {
	private double soCu;
	private double soMoi;
	private double soTienPhaiTra;
	private KhachHang khachHang;
	private Scanner scanner;

	public BienLai() {
		super();
	}

	public BienLai(double soCu, double soMoi, double soTienPhaiTra, KhachHang khachHang) {
		super();
		this.soCu = soCu;
		this.soMoi = soMoi;
		this.soTienPhaiTra = soTienPhaiTra;
		this.khachHang = khachHang;
	}

	public void nhapBienLai() {
		khachHang = new KhachHang();
		khachHang.nhapKhachHang();
		scanner = new Scanner(System.in);
		do {
			System.out.println("*** Lưu ý: Số mới > Số cũ ***");
			System.out.print("Nhập số cũ: ");
			soCu = scanner.nextDouble();
			System.out.print("Nhập số mới: ");
			soMoi = scanner.nextDouble();
		} while (soCu > soMoi);
		soTienPhaiTra = (double) (soMoi - soCu) * 750;
	}

	public void xuatBienLai() {
		khachHang.xuatKhachHang();
		System.out.printf("| %-18s:  %-20s |\n", "Chỉ số cũ", soCu);
		System.out.printf("| %-18s:  %-20s |\n", "Chỉ số mới", soMoi);
		System.out.printf("| %-18s:  %-20s |\n", "Số tiền phải trả", soTienPhaiTra);
		System.out.println("+-------------------------------------------+");
	}
}