package Oop;

public class ChuNhat {
	private int rong;
	private int dai;

	public ChuNhat(int dai, int rong) {
		this.dai = dai;
		this.rong = rong;
	}

	public int getRong() {
		return rong;
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
		return 2 * (rong + dai);
	}

	double getDienTich() {
		return rong * dai;
	}

	void xuat() {
		System.out.println("chieu dai: " + this.dai);
		System.out.println("chieu rong: " + this.rong);
		System.out.println("chu vi: " + this.getChuVi());
		System.out.println("dien tich: " + this.getDienTich());
	}
}
