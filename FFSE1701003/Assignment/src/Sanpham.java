
import java.util.Scanner;

public class Sanpham {
	String tensp;
	double dongia;
	double giamgia;
	
	public double getthuenhapkhau() {
		double tnk = 0;
		tnk = this.dongia * 0.1;
		return tnk;
	}
	
	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		System.out.print("Nhap ten san pham: ");
		String tensp = nhap.nextLine();
		
		System.out.print("Nhap don gia san pham: ");
		Float dongia = nhap.nextFloat();
		
		this.tensp = tensp;
		this.dongia = dongia;
	}
	
	public void xuat() {
		System.out.println("Ten san pham la: "+ this.tensp);
		System.out.println("Ten san pham la: "+ this.dongia);
	}
	
	public static void main(String [] arg) {
		Sanpham sp1 = new Sanpham();
		Sanpham sp2 = new Sanpham();
		
		sp1.nhap();
		sp2.nhap();
		
		sp1.xuat();
		sp2.xuat();
	}
}
