package com.SinhvienFPT;

import java.util.*;

public class SinhvienIT extends SinhvienFPT {

	double diemJava;
	double diemCSS;
	double diemHTML;
	
	public SinhvienIT(String hoTen, double diemJava, double diemCSS, double diemHTML) {
		super(hoTen, "IT");
		this.diemJava = diemJava;
		this.diemCSS = diemCSS;
		this.diemHTML = diemHTML;
	}
	
	double getDiem() {
		// TODO Auto-generated method stub
		return (2*this.diemJava + this.diemCSS + this.diemHTML)/4;
	}
	public static void main(String[] args) {
		System.out.println("Nhap sinh vien");
		System.out.print("Nhap hoTen: ");
		Scanner nhaphoten = new Scanner(System.in);
		String hoTen = nhaphoten.nextLine();
		
		Scanner nhapdiem = new Scanner(System.in);
		System.out.print("Nhap diem Java: ");
		double diemJava = nhapdiem.nextDouble();
		
		System.out.print("Nhap diem CSS: ");
		double diemCSS = nhapdiem.nextDouble();
		
		System.out.print("Nhap diem HTML: ");
		double diemHTML = nhapdiem.nextDouble();
		
		SinhvienFPT sinhvien = new SinhvienIT(hoTen, diemJava, diemCSS, diemHTML);
		
		System.out.println("-----Xuat ra man hinh-----");
		sinhvien.xuat();
		
	}
}
