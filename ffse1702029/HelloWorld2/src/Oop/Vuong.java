package Oop;

import java.util.Scanner;

public class Vuong extends ChuNhat {
	public Vuong(int canh) {
		super(canh, canh);
	}

	void xuat() {
		System.out.println("canh: " + super.getDai());
		System.out.println("dien tich: " + this.getDienTich());
		System.out.println("chu vi: " + this.getChuVi());
	}

	public static void main(String arg[]) {
		System.out.print("nhap chieu dai: ");
		Scanner scan = new Scanner(System.in);
		int dai = scan.nextInt();

		System.out.print("nhap chieu rong: ");
		int rong = scan.nextInt();

		ChuNhat cn = new ChuNhat(dai, rong);
		cn.xuat();

		System.out.print("---hinh vuong--- ");
		System.out.print("nhap canh hinh vuong ");
		int canh = scan.nextInt();

		Vuong vuong = new Vuong(canh);
		vuong.xuat();
	}
}
