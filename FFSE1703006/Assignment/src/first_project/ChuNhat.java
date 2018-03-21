package first_project;

public class ChuNhat {

	private int rong;
	private int dai;

	public ChuNhat() {

	}

	public ChuNhat(int rong, int dai) {
		this.rong = rong;
		this.dai = dai;
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
		return (dai + rong) * 2;
	}

	double getDienTich() {
		return (dai * rong);
	}

	void xuat() {
		System.out.println("Chiều dài: " + this.getDai());
		System.out.println("Chiều rộng: " + this.getRong());
		System.out.println("Chu vi: " + this.getChuVi());
		System.out.println("Diện tích: " + this.getDienTich());
		System.out.println("-----------------------------------");
	}

	public static void main(String[] args) {

	}

}
