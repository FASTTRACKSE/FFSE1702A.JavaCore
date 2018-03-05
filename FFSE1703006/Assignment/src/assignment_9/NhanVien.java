package assignment_9;

public class NhanVien extends CanBo {
	private String phongBan, chucVu;
	private int soNgayCong, choose;

	public NhanVien() {
		super();
	}

	public NhanVien(String phongBan, String chucVu, int soNgayCong) {
		super();
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
	}

	public NhanVien(String hoTen, String phongBan, String chucVu, int soNgayCong, double heSoLuong) {
		super();
		this.setHoTen(hoTen);
		this.setWhere(phongBan);
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
		this.setHeSoLuong(heSoLuong);
		if (chucVu == "Trưởng phòng") {
			this.setPhuCap(2000);
		} else if (chucVu == "Phó phòng") {
			this.setPhuCap(1000);
		} else if (chucVu == "Nhân viên") {
			this.setPhuCap(500);
		}
		this.setLuong(tinhLuong());
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public void nhap() {
		super.nhap();
		System.out.print("Nhập phòng ban: ");
		phongBan = scanner.nextLine();
		this.setWhere(phongBan);
		do {
			System.out.print("Chọn chức vụ (1 - Trưởng phòng, 2 - Phó phòng, 3 - Nhân viên): ");
			choose = Integer.parseInt(scanner.nextLine());
			switch (choose) {
			case 1:
				chucVu = "Trưởng phòng";
				this.setPhuCap(2000);
				break;
			case 2:
				chucVu = "Phó phòng";
				this.setPhuCap(1000);
				break;
			case 3:
				chucVu = "Nhân viên";
				this.setPhuCap(500);
				break;
			default:
				System.out.println("Chọn không đúng!");
				break;
			}
		} while (choose < 1 || choose > 3);
		System.out.print("Nhập số ngày công: ");
		soNgayCong = Integer.parseInt(scanner.nextLine());
		this.setLuong(tinhLuong());
	}

	public double tinhLuong() {
		return (double) (this.getHeSoLuong() * 730 + this.getPhuCap() + soNgayCong * 30);
	}

	public void xuat() {
		System.out.printf(
				"| %-20s | Phòng ban: %-15s | Chức vụ: %-12s | Số ngày công: %2s | Hệ số lương: %3s | Phụ cấp: %4s | Lương: %8s |\n",
				this.getHoTen(), phongBan, chucVu, soNgayCong, this.getHeSoLuong(), this.getPhuCap(), this.getLuong());
	}
}
