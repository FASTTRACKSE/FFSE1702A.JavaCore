package assignment7;

import java.util.Scanner;

public class ChuNhat {
	private int rong;
	private int dai;

	public int getRong() {
		return rong;
	}

	public ChuNhat(int rong, int dai) {
		this.rong = rong;
		this.dai = dai;
	}

	public void setRong(int rong) {
		this.rong = rong;
	}

	public int getDai() {
		return dai;
	}

	public void setDai(int dai) {
		this.dai = dai;
	}

	double getChuVi() {
		return (dai + rong) / 2;
	}

	double getDientich() {
		return (dai * rong);
	}

	void xuat() {
		System.out.println("Chieu dai: " + this.getDai());
		System.out.println("Chieu rong: " + this.getRong());
		System.out.println("Chu vi: " + this.getChuVi());
		System.out.println("Chieu dai: " + this.getDientich());
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap chieu dai: ");
		int dai = input.nextInt();
		System.out.println("Nhap chieu rong: ");
		int rong = input.nextInt();
		ChuNhat cn = new ChuNhat(dai, rong);
		cn.xuat();
	}

}
