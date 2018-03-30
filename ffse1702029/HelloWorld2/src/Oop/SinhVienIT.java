package Oop;

import java.util.Scanner;

public class SinhVienIT extends SinhVienFpt{
	double diemJava;
	double diemCSS;
	double diemHTML;
	
	public SinhVienIT (String hoTen, double diemJava, double diemCSS, double diemHTML) {
		super(hoTen, "IT");
		this.diemJava =diemJava;
		this.diemCSS =diemCSS;
		this.diemHTML =diemHTML;
		
	}
	double getDiem() {
		return(2*this.diemJava+this.diemCSS+this.diemHTML)/4;
	}
	public static void main(String arg[]) {
		
		System.out.print("nhap ho ten: ");
		Scanner nhapHoten = new Scanner(System.in);
		String hoTen = nhapHoten.nextLine();
		
		Scanner nhapDiem = new Scanner(System.in);
		System.out.print("nhap diem java: ");
		double diemJava = nhapDiem.nextDouble();
		
		System.out.print("nhap diem css: ");
		double diemCSS = nhapDiem.nextDouble();
		
		System.out.print("nhap diem html: ");
		double diemHTML = nhapDiem.nextDouble();
		
		SinhVienFpt sinhVien = new SinhVienIT(hoTen, diemJava, diemCSS, diemHTML);
		System.out.println("---Xuat ra man hinh---");
		sinhVien.xuat();
		
	}
}
