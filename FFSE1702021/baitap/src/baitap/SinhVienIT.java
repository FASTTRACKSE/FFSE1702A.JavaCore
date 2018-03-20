package baitap;

import java.util.Scanner;

public class SinhVienIT extends SinhVienFpt {
	double diemJava;
	double diemCSS;
	double diemHTML;
    public SinhVienIT(String hoten,double diemJava, double diemCSS, double diemHTML) {
    	super(hoten,"IT");
    	this.diemJava=diemJava;
    	this.diemCSS=diemCSS;
    	this.diemHTML=diemHTML;
    }
	@Override
	double getDiem() {
		// TODO Auto-generated method stub
		return (2*this.diemJava + this.diemCSS + this.diemHTML)/4;
	}
	public static void main(String arg[]) {
		System.out.println("nhap sinh vien");
		System.out.println("nhap hoten:");
		Scanner nhapHoTen = new Scanner(System.in);
		String hoten = nhapHoTen.nextLine();
		
		System.out.println("nhap diem Java:");
		Scanner nhapDiem = new Scanner(System.in);
		double diemJava = nhapDiem.nextDouble();
		
		System.out.println("nhap diem CSS:");
		double diemCSS = nhapDiem.nextDouble();
		
		System.out.println("nhap diem HTML:");
		double diemHTML = nhapDiem.nextDouble();
		SinhVienFpt sinhvien = new SinhVienIT(hoten,diemJava,diemCSS,diemHTML);
		
		System.out.println("------Xuat ra man hinh-----");
		sinhvien.xuat();
	}
	

}
