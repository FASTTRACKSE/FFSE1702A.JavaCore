package assigment020618;

import java.util.Scanner;

public class SinhvienIT extends Sinhvienfpt{
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
		return (2*this.diemJava + this.diemHTML+ this.diemCSS)/4;
	}
	
	public static void main(String[] args) {
		System.out.println("Nhap sinh vien");
		System.out.println("Nhap ho ten");
		Scanner scan = new Scanner(System.in);
		String hoTen = scan.nextLine();
		
		System.out.println("Nhap diem java");
		double diemJava = scan.nextDouble();
		
		System.out.println("Nhap diem css");
		double diemCSS = scan.nextDouble();
		
		System.out.println("Nhap diem html");
		double diemHTML = scan.nextDouble();
		
		Sinhvienfpt sv = new SinhvienIT(hoTen, diemJava, diemCSS, diemHTML);
		sv.xuat();
	}
}
