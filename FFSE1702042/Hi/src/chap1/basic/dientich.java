package chap1.basic;
//import chap1.basic.thetich;
public class dientich {
	int cd,cr;
	public dientich() {};
	public dientich(int cd,int cr) {
		this.cd=cd;
		this.cr=cr;
	}
	public int getCd() {
		return cd;
	}

	public void setCd(int chieudai) {
		cd = chieudai;
	}

	public int getCr() {
		return cr;
	}

	public void setCr(int cr) {
		this.cr = cr;
	}
	public double getDienTich() {
		return cd*cr;
	}
	public static void main(String[] args) {
		dientich hinh1 = new dientich(10,10);

		System.out.println("Dien tich la:" +hinh1.getDienTich());
		thetich hinh2 = new thetich();
		hinh2.setCd(10);
		hinh2.setCr(10);
		hinh2.setCc(2);
		System.out.println("The tich la:" +hinh2.getTheTich());
		
	}
}
