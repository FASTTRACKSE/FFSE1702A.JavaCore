package assignment5;

import java.util.Scanner;

public class GiangVien extends CanBo {
	private String khoa;
	private String trinhdo;
	private int sotietday;
	private double phucap;

	public GiangVien(String khoa, String trinhdo, int sotietday) {
		super();
		this.khoa = khoa;
		this.trinhdo = trinhdo;
		this.sotietday = sotietday;

	}

	public GiangVien() {
		super();
	}

	public GiangVien(String hoTen, int phuCap, float heSoLuong, float luong) {
		super(hoTen, phuCap, heSoLuong, luong);
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getTrinhdo() {
		return trinhdo;
	}

	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}

	public int getSotietday() {
		return sotietday;
	}

	public void setSotietday(int sotietday) {
		this.sotietday = sotietday;
	}

	public double tinhluong() {
		double luong = getHeSoLuong() * 750 + getPhuCap() + getSotietday() * 45;
		return luong;
	}

	public void nhap() {
		super.nhap();
		Scanner scn = new Scanner(System.in);
		System.out.println("nhap khoa:");
		String khoa = scn.nextLine();
		setKhoa(khoa);

		System.out.println("nhập số tiết dạy :");
		int sotietday = scn.nextInt();
		setSotietday(sotietday);
		scn.nextLine();
		System.out.println("nhập trình độ :");
		String trinhdo = scn.nextLine();

		setTrinhdo(trinhdo);

	}

	public void xuat() {

		String chuoi1 = "cử nhân";
		String chuoi2 = "thạc sĩ";
		String chuoi3 = "tiến sĩ";
		if (trinhdo.compareTo(chuoi1) == 0) {
			this.setPhuCap(300);
		} else if (trinhdo.compareTo(chuoi2) == 0) {
			this.setPhuCap(500);
		} else if (trinhdo.compareTo(chuoi3) == 0) {
			this.setPhuCap(1000);
		} else {
			System.out.print("sai vật vã !!!");
		}
		super.xuat();
		System.out.print("khoa :" + khoa);
		System.out.print("| số tiết dạy :" + sotietday);
		System.out.print("| trình độ :" + trinhdo);
		System.out.print("| phụ cấp :" + getPhuCap());

	}
}
