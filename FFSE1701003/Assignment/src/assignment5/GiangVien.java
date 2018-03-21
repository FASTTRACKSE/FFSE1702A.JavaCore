package assignment5;

import java.util.Scanner;

public class GiangVien extends Canbo {
	private String khoa;
	private String trinhDo;
	private int soTietDayTrongThang;

	public GiangVien() {
		// TODO Auto-generated constructor stub
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public int getSoTietDayTrongThang() {
		return soTietDayTrongThang;
	}

	public void setSoTietDayTrongThang(int soTietDayTrongThang) {
		this.soTietDayTrongThang = soTietDayTrongThang;
	}

	/**
	 * @param khoa
	 * @param trinhDo
	 * @param soTietDayTrongThang
	 * @param cb
	 */
	public GiangVien(String khoa, String trinhDo, int soTietDayTrongThang) {
		super();
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietDayTrongThang = soTietDayTrongThang;
	}

	public void nhap(Scanner sc) {
		super.nhapHoTen(sc);
		super.nhapPhuCap(sc);
		super.nhapHeSoLuong(sc);

		System.out.println("Nhap khoa cua giang vien:");
		this.khoa = sc.nextLine();

		System.out.println("Trinh do cua giang vien:");
		String trinhDo = sc.nextLine();
		this.setTrinhDo(trinhDo);

		System.out.println("So tiet day trong thang cua giang vien:");
		this.soTietDayTrongThang = Integer.parseInt(sc.nextLine());
		this.tinhLuong();
	}

	public void xuat() {
		super.xuat();
		System.out.println("Giang vien khoa : " + this.khoa);
		System.out.println("Trinh do : " + this.trinhDo);
		System.out.println("So tiet day trong thang : " + this.soTietDayTrongThang);
	}

	public void tinhLuong() {
		float tongLuong = (this.getHesoluong() * 730) + this.getPhucap() + this.soTietDayTrongThang * 45;
		this.setLuong(tongLuong);
	}
}
