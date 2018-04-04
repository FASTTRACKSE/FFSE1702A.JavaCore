package assigment020518;

import java.util.Scanner;

public class Sanpham {
	String tensp;
	double dongia;
	double giamgia;
	
	public Sanpham() {
		
	}

	public Sanpham(String tensp, double dongia, double giamgia) {
		this.tensp = tensp;
		this.dongia = dongia;
		this.giamgia = giamgia;
	}

	public Sanpham(String tensp, double dongia) {
		this(tensp,dongia,0);
	}

	private double getthuenhapkhau() {
		double tnk = 0;
		tnk = this.dongia * 0.1;
		return tnk;
	}

	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhap ten sp");
		String tensp = nhap.nextLine();
		this.tensp = tensp;
		System.out.println("Nhap don gia");
		double dongia = nhap.nextDouble();
		this.dongia = dongia;
		System.out.println("Nhap giam gia");
		double giamgia = nhap.nextDouble();
		this.giamgia = giamgia;
	}

	public void xuat() {
		System.out.println("Ten san pham la: " + this.tensp);
		System.out.println("Don gia la: " + this.dongia);
		System.out.println("Giam gia la: " + this.giamgia);
		System.out.println("Thue nhap khau: " + getthuenhapkhau());
	}

	public static void main(String arg[]) {
		Sanpham sp1 = new Sanpham("dt", 5);
		Sanpham sp2 = new Sanpham("lap", 5, 5);

//		sp1.nhap();
//		sp2.nhap();

		sp1.xuat();
		sp2.xuat();
	}
}