package first_project;

import java.util.Scanner;

public class SanPham {
	String tenSp;
	double donGia;
	double giamGia;
	private Scanner nhap;

	public SanPham() {
	}

	public SanPham(String tenSp, double donGia, double giamGia) {
		this.tenSp = tenSp;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}

	public SanPham(String tenSp, double donGia) {
		this(tenSp, donGia, 0);
	}

	private double getThueNhapKhau() {
		double tnk = 0;
		// tính thuế nhập khẩu
		tnk = this.donGia * 10 / 100;
		return tnk;
	}

	public void nhap() {
		nhap = new Scanner(System.in);
		System.out.print("Nhập tên sản phẩm: ");
		String tenSp = nhap.nextLine();
		this.tenSp = tenSp;
		System.out.print("Nhập đơn giá: ");
		double donGia = nhap.nextDouble();
		this.donGia = donGia;
		System.out.print("Nhập % giảm giá: ");
		double giamGia = nhap.nextDouble();
		this.giamGia = giamGia;
		System.out.println("-------------------------------------- ");
	}

	public void xuat() {
		// xuất data
		System.out.println("Tên sản phẩm: " + this.tenSp);
		System.out.println("Đơn giá: " + this.donGia);
		System.out.println("Giảm giá: " + this.giamGia);
		System.out.println("Thuế nhập khẩu: " + getThueNhapKhau());
		System.out.println("-------------------------------------- ");
	}

	public static void main(String[] args) {
		SanPham sp1 = new SanPham("1", 1111, 11);
		SanPham sp2 = new SanPham("2", 2222);
		SanPham sp3 = new SanPham();

		sp3.nhap();

		sp1.xuat();
		sp2.xuat();
		sp3.xuat();
	}

}
