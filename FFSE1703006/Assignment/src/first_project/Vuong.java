package first_project;

import java.util.Scanner;

public class Vuong extends ChuNhat {
	private static Scanner nhap;

	public Vuong(int canh) {
		super(canh, canh);
	}

	void xuat() {
		System.out.println("Cạnh: " + super.getDai());
		System.out.println("Chu vi: " + this.getChuVi());
		System.out.println("Diện tích: " + this.getDienTich());
		System.out.println("-----------------------------------");
	}

	public static void main(String[] args) {
		ChuNhat cn = new ChuNhat(4, 3);
		ChuNhat vu = new Vuong(5);
		cn.xuat();
		vu.xuat();
		ChuNhat cn1 = new ChuNhat();
		nhap = new Scanner(System.in);
		System.out.print("Nhập chiều dài: ");
		int dai = nhap.nextInt();
		cn1.setDai(dai);
		System.out.print("Nhập chiều rộng: ");
		int rong = nhap.nextInt();
		cn1.setRong(rong);
		cn1.xuat();
		System.out.print("Nhập cạnh: ");
		int canh = nhap.nextInt();
		ChuNhat vu1 = new Vuong(canh);
		vu1.xuat();
	}

}
