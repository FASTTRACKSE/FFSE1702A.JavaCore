package assignment5;

import java.util.ArrayList;
import java.util.Scanner;

public class CanBo {
	private String maCanBo;

	public String getMaCanBo() {
		return maCanBo;
	}

	public void setMaCanBo(String maCanBo) {
		this.maCanBo = maCanBo;
	}

	private String hoTen;
	private int phuCap;
	private float heSoLuong;
	private float luong;

	public CanBo() {

	}

	public CanBo(String hoTen, int phuCap, float heSoLuong, float luong) {
		super();
		this.hoTen = hoTen;
		this.phuCap = phuCap;
		this.heSoLuong = heSoLuong;
		this.luong = luong;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}

	public float getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	public double tinhluong() {
		return 0;
	}

	public void nhap() {
		Scanner scn = new Scanner(System.in);
		for (;;) {

			setHoTen(hoTen);
			System.out.println("nhap ho ten:");
			String hoTen = scn.nextLine();
			try {
				Qll.chkHoTen(hoTen);
				this.setHoTen(hoTen);
				break;
			} catch (Qll e) {
				System.out.println(e);

			}
		}
		setHoTen(hoTen);
		for (;;) {

			setHeSoLuong(heSoLuong);
			System.out.println("nhap he so luong:");
			float heSoLuong = scn.nextFloat();
			try {
				Qll.chkHeSoLuong(heSoLuong);
				this.setHeSoLuong(heSoLuong);
				break;
			} catch (Qll e) {
				System.out.println(e);

			}
		}

	}

	public void macanbo(CanBo cb, ArrayList<CanBo> list) {
		Scanner scn = new Scanner(System.in);

		for (;;) {
			System.out.println("nhap ma can bo:");
			String maCanBo = scn.nextLine();

			try {
				Qll.chkMaCanBo(maCanBo, list);
				cb.setMaCanBo(maCanBo);
				break;
			} catch (Qll e) {
				System.out.println(e);

			}
		}
	}

	public void xuat() {

		System.out.print("Ten:" + hoTen);
		System.out.print("He So Luong:" + heSoLuong);
	}
}