import java.util.Scanner;

public class SanPham {
	String tensp;
	double dongia;
	double giamgia;

	public double getthuenhapkhau() {
		double tnk = 0; // tinh thue nhap khau
		tnk = this.dongia * 10 / 100;
		return tnk;
	}

	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		String tensp = "";
		System.out.println("nhap ten san pham: ");
		tensp = nhap.nextLine();
		this.tensp = tensp;
		
		System.out.println("nhap don gia san pham: ");
		dongia = nhap.nextDouble();
		this.dongia = dongia;
		
		System.out.println("nhap giam gia san pham: ");
		giamgia = nhap.nextDouble();
		this.giamgia = giamgia;
		
		// nhap thong tin ve don gia
	}

	public void xuat() {
		// xuat su dung println(this.tensp)
		System.out.println("ten san pham la: " +this.tensp);
		System.out.println("don gia san pham la: " +this.dongia);
		System.out.println("giam gia  la: " +this.giamgia);
		System.out.println("thue nhap khau la: " +this.dongia * 10 / 100);
	}

	public static void main(String arg[]) {
		SanPham sp1 = new SanPham();
		SanPham sp2 = new SanPham();
		sp1.nhap();
		sp2.nhap();
		sp1.xuat();
		sp2.xuat();

	}

}
