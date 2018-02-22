package first_project;

import java.util.Scanner;

public class SinhVienIT extends SinhVienFpt {

	double diemJava;
	double diemCss;
	double diemHtml;

	public SinhVienIT(String hoTen, double diemJava, double diemCss, double diemHtml) {
		super(hoTen, "IT");
		this.hoTen = hoTen;
		this.diemJava = diemJava;
		this.diemCss = diemCss;
		this.diemHtml = diemHtml;
		// TODO Auto-generated constructor stub
	}

	public double getDiem() {
		return (2 * this.diemJava + this.diemCss + this.diemHtml) / 4;
	}

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		System.out.print("Nhập họ tên: ");
		String hoTen = nhap.nextLine();
		System.out.print("Nhập điểm Java: ");
		double diemJava = nhap.nextDouble();
		System.out.print("Nhập điểm CSS: ");
		double diemCss = nhap.nextDouble();
		System.out.print("Nhập điểm HTML: ");
		double diemHtml = nhap.nextDouble();
		SinhVienFpt sv1 = new SinhVienIT(hoTen, diemJava, diemCss, diemHtml);
		sv1.xuat();
	}
}
