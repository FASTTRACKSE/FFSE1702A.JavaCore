package assigment020618;

import java.util.Scanner;

public class Vuong extends ChuNhat {
	public Vuong(int canh) {
		super(canh, canh);
	}
	void xuat() {
		System.out.println("Canh la: " + getDai());
		System.out.println("Chu vi la: " + getChuvi());
		System.out.println("Dien tich: " + getDientich());
	}
	public static void main(String[] args) {
		System.out.println("Nhap chieu dai:");
		Scanner scan = new Scanner(System.in);
		int dai = scan.nextInt();
		
		System.out.println("Nhap chieu rong: ");
		int rong = scan.nextInt();
		
		ChuNhat cn = new ChuNhat(dai, rong);
		cn.xuat();
		
		System.out.println("Hinh vuong");
		System.out.println("Nhap canh hinh vuong:");
		int canh = scan.nextInt();
		Vuong vuong = new Vuong(canh);
		
		vuong.xuat();
	}
}
