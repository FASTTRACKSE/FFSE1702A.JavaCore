package assignment_9;

public class GiangVien extends CanBo {
	private String khoa, trinhDo;
	private int soTiet, choose;

	public GiangVien() {
		super();
	}

	public GiangVien(String khoa, String trinhDo, int soTiet) {
		super();
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTiet = soTiet;
	}

	public GiangVien(String hoTen, String khoa, String trinhDo, int soTiet, double heSoLuong) {
		super();
		this.setHoTen(hoTen);
		this.setWhere(khoa);
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTiet = soTiet;
		this.setHeSoLuong(heSoLuong);
		if (trinhDo == "Cử nhân") {
			this.setPhuCap(300);
		} else if (trinhDo == "Thạc sĩ") {
			this.setPhuCap(500);
		} else if (trinhDo == "Tiến sĩ") {
			this.setPhuCap(1000);
		}
		this.setLuong(tinhLuong());
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public int getSoTiet() {
		return soTiet;
	}

	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}

	public void nhap() {
		super.nhap();
		System.out.print("Nhập khoa: ");
		khoa = scanner.nextLine();
		this.setWhere(khoa);
		do {
			System.out.print("Chọn trình độ (1 - Cử nhân, 2 - Thạc sĩ, 3 - Tiến sĩ): ");
			choose = checkInt();
			switch (choose) {
			case 1:
				trinhDo = "Cử nhân";
				this.setPhuCap(300);
				break;
			case 2:
				trinhDo = "Thạc sĩ";
				this.setPhuCap(500);
				break;
			case 3:
				trinhDo = "Tiến sĩ";
				this.setPhuCap(1000);
				break;
			default:
				System.out.println(" * Vui lòng nhập số từ 1-3!");
				break;
			}
		} while (choose > 3);
		System.out.print("Nhập số tiết dạy: ");
		soTiet = checkInt();
		this.setLuong(tinhLuong());
	}

	public double tinhLuong() {
		return (double) (this.getHeSoLuong() * 730 + this.getPhuCap() + soTiet * 45);
	}

	public void xuat() {
		System.out.printf(
				"| %-20s | Khoa     : %-15s | Trình độ: %-11s | Số tiết     : %2s | Hệ số lương: %3s | Phụ cấp: %4s | Lương: %8s |\n",
				this.getHoTen(), khoa, trinhDo, soTiet, this.getHeSoLuong(), this.getPhuCap(), this.getLuong());
	}
}
