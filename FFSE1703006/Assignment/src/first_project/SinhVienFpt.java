package first_project;

public abstract class SinhVienFpt {

	String hoTen;
	String nganh;

	public SinhVienFpt(String hoTen, String nganh) {
		this.hoTen = hoTen;
		this.nganh = nganh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	public abstract double getDiem();

	public String getHocLuc() {
		double diem = this.getDiem();
		if (diem < 5)
			return "Yếu";
		else if (diem < 6.5)
			return "Trung bình";
		else if (diem < 7.5)
			return "Khá";
		else if (diem < 9)
			return "Giỏi";
		else
			return "Xuất sắc";
	}

	public void xuat() {
		System.out.println("Họ tên\t:  " + this.getHoTen());
		System.out.println("Ngành\t:  " + this.getNganh());
		System.out.println("Điểm\t:  " + this.getDiem());
		System.out.println("Học lực\t:  " + this.getHocLuc());
	}

}
