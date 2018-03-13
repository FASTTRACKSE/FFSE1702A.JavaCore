package com.Sanpham;
import java.util.*;
import java.text.NumberFormat;
public class Sanpham {
	String tensp;
	double dongia;
	double giamgia;
	
	public double getthuenhapkhau() {
		double tnk = 0;
		//tinh thue nhap khau
		tnk = this.dongia*10/100;
		return tnk;
	}
	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		System.out.print("Nhap ten san pham: ");
		String tensp = nhap.nextLine();
		this.tensp = tensp;
		
		System.out.print("Nhap don gia: ");
		double dongia = nhap.nextDouble();
		this.dongia = dongia;
		
		System.out.print("Nhap giam gia: ");
		double giamgia = nhap.nextDouble();
		this.giamgia = giamgia;
	}
	public void xuat() {
		System.out.println("Ten san pham: " + this.tensp);
		Sanpham gia = new Sanpham();
		double thuenk = gia.getthuenhapkhau();
		System.out.printf("Gia san pham: %,3f" , ((this.dongia + thuenk) - ((this.dongia + thuenk)*this.giamgia)));
	}
	
	public static void main(String[] args) {

		Sanpham sp1 = new Sanpham();
		Sanpham sp2 = new Sanpham();
		System.out.println("San pham thu 1");
		sp1.nhap();
		System.out.println("San pham thu 2");
		sp2.nhap();
		System.out.println("San pham thu 1");
		sp1.xuat();
		System.out.println("San pham thu 2");
		sp2.xuat();
	}
}
