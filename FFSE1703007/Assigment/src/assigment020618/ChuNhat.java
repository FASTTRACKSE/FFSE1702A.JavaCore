package assigment020618;

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

	double getChuvi() {
		return 2 * (rong + dai);
	}

	double getDientich() {
		return rong * dai;
	}
	
	void xuat() {
		System.out.println("Chieu rong la: " + getRong());
		System.out.println("Chieu dai la: " + getDai());
		System.out.println("Chu vi la: " + getChuvi());
		System.out.println("Dien tich: " + getDientich());
	}
}
