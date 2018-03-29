package assignment7;

public class Vuong extends ChuNhat {
	
	public Vuong (int canh) {
		super(canh, canh);
	}
	
	void xuat() {
		System.out.println("Canh :" + super.getDai());
		System.out.println("Chu vi :" + this.getChuVi());
		System.out.println("Canh :" + this.getDientich());
	}
}
