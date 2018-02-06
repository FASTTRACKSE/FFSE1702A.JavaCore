package baitap;

public class Chunhat {
	private int rong;
	private int dai;

	public Chunhat() {}
	
	public Chunhat(int dai, int rong) {
		this.dai=dai;
		this.rong=rong;
	}
	
	
	public int getRong() {
		return rong;
	}
	public void setRong(int rong) {
		this.rong=rong;
	}
	public int getDai() {
		return dai;
	}
	public void setDai(int dai) {
		this.dai=dai;
	}
	double getChuVi() {
		double chuvi = 2*(rong + dai);
		return chuvi;
	}
	double getDienTich() {
		return rong + dai;
	}
	void xuat() {
		System.out.println("Chieu dai:"+ this.dai);
		System.out.println("Chieu ronhg:"+ this.rong);
		System.out.println("Chu vi:"+ this.getChuVi());
		System.out.println("Dien tich:"+ this.getDienTich());
	}

}
