package assignment_9;

import java.util.Comparator;
import java.util.Scanner;

public class CanBo {
	private String hoTen, where;
	private int phuCap;
	private double heSoLuong, luong;
	Scanner scanner;

	public CanBo() {
		super();
	}

	public CanBo(String hoTen, int phuCap, double heSoLuong) {
		super();
		this.hoTen = hoTen;
		this.phuCap = phuCap;
		this.heSoLuong = heSoLuong;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public int getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public void nhap() {
		scanner = new Scanner(System.in);
		System.out.print("Nhập họ tên: ");
		hoTen = checkHoTen();
		System.out.print("Nhập hệ số lương: ");
		heSoLuong = checkDouble();
	}

	String checkHoTen() {
		do {
			hoTen = scanner.nextLine();
			if (hoTen.length() == 0 || hoTen.length() > 40)
				System.out.print(
						" * Họ tên không hợp lệ! (Họ tên không được rỗng và có độ dài không quá 40 ký tự) \n Nhập lại: ");
			else if (Menu.existHoTen(hoTen))
				System.out.print(" * Họ tên đã tồn tại! \n Nhập lại: ");
			else
				return hoTen;
		} while (true);
	}

	double checkDouble() {
		do {
			try {
				double n = Double.parseDouble(scanner.nextLine());
				if (n > 0)
					return n;
				else
					System.out.print(" * Vui lòng nhập số thực dương! \n Nhập lại: ");
			} catch (Exception e) {
				System.out.print(" * Vui lòng nhập định dạng số thực! \n Nhập lại: ");
			}
		} while (true);
	}

	static int checkInt() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				int n = Integer.parseInt(sc.nextLine());
				if (n > 0)
					return n;
				else
					System.out.print(" * Vui lòng nhập số nguyên dương! \n Nhập lại: ");
			} catch (Exception e) {
				System.out.print(" * Vui lòng nhập định dạng số nguyên! \n Nhập lại: ");
			}
		} while (true);
	}

	public void xuat() {
	}

	public static Comparator<CanBo> sortByLuong = new Comparator<CanBo>() {
		public int compare(CanBo cb1, CanBo cb2) {
			if (Double.compare(cb2.luong, cb1.luong) == 0) {
				return cb1.hoTen.compareTo(cb2.hoTen);
			} else {
				return Double.compare(cb2.luong, cb1.luong);
			}
		}
	};
}
