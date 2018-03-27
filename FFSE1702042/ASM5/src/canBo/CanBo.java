package canBo;
import java.io.Serializable;
import java.util.Scanner;

public class CanBo implements Serializable {
	private String hoTen;
	private int phuCap;
	private float heSoLuong;
	private double luong;
	private String maCanBo;

	public CanBo() {

	}

	public CanBo(String hoTen, int phuCap, float heSoLuong, double luong, String maCanBo) {
		super();
		this.hoTen = hoTen;
		this.phuCap = phuCap;
		this.heSoLuong = heSoLuong;
		this.luong = luong;
		this.maCanBo = maCanBo;
	}

	public String getMaCanBo() {
		return maCanBo;
	}

	public void setMaCanBo(String maCanBo) {
		this.maCanBo = maCanBo;
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

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public void nhap() {
		Scanner scn = new Scanner(System.in);
		for (;;) {

			System.out.println("nhập họ tên:");
			String hoTen = scn.nextLine();
			try {
				CanBoException.chkHoTen(hoTen);
				setHoTen(hoTen);
				break;
			} catch (CanBoException e) {
				System.out.println(e);

			}

		}

		for (;;) {
			System.out.println("nhập hệ số lương:");
			float heSoLuong = scn.nextFloat();
			try {
				CanBoException.chkSoThuc(heSoLuong);
				setHeSoLuong(heSoLuong);
				break;
			} catch (CanBoException e) {
				System.out.println(e);

			}

		}

	}

	public double tinhLuong() {
		return 0;
	}

	public void xuat() {

		System.out.println("Tên: " + hoTen);
		System.out.println("Hệ số lương: " + heSoLuong);
	}

}