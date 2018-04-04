package qlycanbo;

import java.util.Scanner;

public class NhanVien extends CanBo {
	private static final long serialVersionUID = 1L;
	private String phongBan, chucVu;
	private int soNgayCong, choose;

	public NhanVien() {
		super();
	}

	public NhanVien(String hoTen, String phongBan, String chucVu, int soNgayCong, double heSoLuong,String maCanBo) {
		super();
		this.setHoTen(hoTen);
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.maCanBo=maCanBo;
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
		Scanner scanner = new Scanner(System.in);
		super.nhap();
		System.out.print("Nhập phòng ban: ");
		phongBan = scanner.nextLine();
		System.out.print("Chọn chức vụ (1 - Trưởng phòng, 2 - Phó phòng, 3 - Nhân viên): ");
		do {
			choose = Main.myFunction.loopCheckInt();
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
				System.err.print(" * Vui lòng nhập số từ 1-3!\n Nhập lại: ");
				break;
			}
		} while (choose > 3);
		System.out.print("Nhập số ngày công: ");
		soNgayCong = Main.myFunction.loopCheckInt();
		this.setLuong(tinhLuong());
	}

	public double tinhLuong() {
		return (double) (this.getHeSoLuong() * 730 + this.getPhuCap() + soNgayCong * 30);
	}

	@Override
	public String toString() {
		return String.format(
				"| %-20s | Phòng ban: %-15s | Chức vụ: %-12s | Số ngày công: %2s | Hệ số lương: %3s | Phụ cấp: %4s | Lương: %8s |\n",
				this.getHoTen(), phongBan, chucVu, soNgayCong, this.getHeSoLuong(), this.getPhuCap(), this.getLuong());
	}
}
