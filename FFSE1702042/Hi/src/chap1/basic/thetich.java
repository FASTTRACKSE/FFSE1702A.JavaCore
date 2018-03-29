package chap1.basic;
//import chap1.basic.dientich;
public class thetich extends dientich {
	int cc = 2;
	public thetich() {}
	public thetich(int cd, int cr,int cc) {
		super(cd, cr);
		this.cc= cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public double getTheTich() {
		return cd*cr*cc;
	}

	/*public double thetich() {
		return this.getDienTich()*cc;

	}*/
}
