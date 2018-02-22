package first_project;

public class SinhVienBiz extends SinhVienFpt {
	double diemMarketing;
	double diemSales;

	public SinhVienBiz(String hoTen, double diemMarketing, double diemSales) {
		super(hoTen, "Biz");
		this.hoTen = hoTen;
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
		// TODO Auto-generated constructor stub
	}

	public double getDiem() {
		return (2 * this.diemMarketing + this.diemSales) / 3;
	}
}
