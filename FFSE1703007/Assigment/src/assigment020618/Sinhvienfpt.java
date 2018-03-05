package assigment020618;

public abstract class Sinhvienfpt {
	String hoTen;
	String nganh;

	public Sinhvienfpt(String hoTen, String nganh) {
		this.hoTen = hoTen;
		this.nganh = nganh;
	}

	abstract double getDiem();

	String getHocluc() {
		double diem = getDiem();
		String hocLuc = "";
		if (diem < 5) {
			hocLuc = "yeu";
		} else if (diem >= 5 && diem < 6.5) {
			hocLuc = "trung binh";
		} else if (diem >= 6.5 && diem < 7.5) {
			hocLuc = "kha";
		} else if (diem >= 7.5 && diem < 9) {
			hocLuc = "gioi";
		} else {
			hocLuc = "xuat sac";
		}
		return hocLuc;
	}
	void xuat() {
		System.out.println("Ho ten: " + this.hoTen);
		System.out.println("Nganh: " + this.nganh);
		System.out.println("Diem: " + this.getDiem());
		System.out.println("Hoc luc: " + this.getHocluc());
	}
}
