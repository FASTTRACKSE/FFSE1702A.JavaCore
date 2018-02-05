package text;

import java.util.Scanner;

public class Sanpham {
	String tensp;
	double dongia;
	double giamgia;
	
	public double thue() {
		double thue = 0;
		// tinh thue
		thue = this.dongia/100 *10;
		return thue;
	}

	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		String tensp = "";
		double dongia = 0;
		double giamgia = 0;
		System.out.println("Nhập tên sản phẩm: ");
		tensp = nhap.nextLine();
		this.tensp = tensp;
		System.out.println("Nhập đơn giá sản phẩm: ");
		dongia = nhap.nextDouble();
		this.dongia = dongia;
		System.out.println("Nhập giảm giá sản phẩm: ");
		giamgia = nhap.nextDouble();
		this.giamgia = giamgia;
		
	}

	public void xuat() {
		System.out.print("Tên sản phẩm là: " + this.tensp + "\n");
		System.out.print("Thuế nhập khẩu: " + thue() + "%" + "\n");
		System.out.print("Giảm giá: " + this.giamgia + "\n");
		System.out.print("Đơn giá: " + (this.dongia - (this.dongia/100 * this.giamgia) + thue()) + " đồng"+ "\n");
		System.out.println("");
	}
	
	public static void main(String [] args) {
		Sanpham sp1 = new Sanpham();
		Sanpham sp2 = new Sanpham();
		sp1.nhap();		
		sp1.xuat();
		sp2.nhap();
		sp2.xuat();
	}
}
