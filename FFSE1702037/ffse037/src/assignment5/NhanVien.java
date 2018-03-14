package assignment5;

import java.util.Scanner;

public class NhanVien extends CanBo {
	private String phongban;
	private int songaycong;
	private String chucvu;

	public NhanVien() {
		super();
	}

	public NhanVien(String phongban, int songaycong, String chucvu) {
		super();
		this.phongban = phongban;
		this.songaycong = songaycong;
		this.chucvu = chucvu;
	}

	public String getPhongban() {
		return phongban;
	}

	public void setPhongban(String phongban) {
		this.phongban = phongban;
	}

	public int getSongaycong() {
		return songaycong;
	}

	public void setSongaycong(int songaycong) {
		this.songaycong = songaycong;
	}

	public String getChucvu() {
		return chucvu;
	}

	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public double tinhluong() {
		double luong = getHeSoLuong()*750+getPhuCap()+ getSongaycong()*30;
				return luong;
	}
	public void nhap() {
		super.nhap();
		Scanner scn = new Scanner(System.in);
		System.out.println("nhap phòng ban:");
		String phongban = scn.nextLine();
		setPhongban(phongban);

		System.out.println("nhập số ngày công :");
		int songaycong = scn.nextInt();
		setSongaycong(songaycong);
		scn.nextLine();
		System.out.println("nhập chức vụ :");
		String chucvu = scn.nextLine();
		setChucvu(chucvu);

	}

	public void xuat() {
		String chuoi1 = "trưởng phòng";
		String chuoi2 = "phó phòng";
		String chuoi3 = "nhân viên";
		if (chucvu.compareTo(chuoi1) == 0) {
			this.setPhuCap(2000);
		} else if (chucvu.compareTo(chuoi2) == 0) {
			this.setPhuCap(1000);
		} else if (chucvu.compareTo(chuoi3) == 0) {
			this.setPhuCap(500);
		} else {
			System.out.print("sai vật vã !!!");
		}
		super.xuat();
		System.out.print("phòng ban :" + phongban);
		System.out.print("số ngày công:" + songaycong);
		System.out.print("chức vụ:" + chucvu);
		System.out.print("| phụ cấp :" + getPhuCap());
	}
}
