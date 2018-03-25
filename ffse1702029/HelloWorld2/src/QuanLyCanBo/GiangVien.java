package QuanLyCanBo;

import java.util.Scanner;

public class GiangVien extends CanBo {
	String khoa;
	String trinhDo;
	int soTiet;

	public GiangVien(String hoTen, int phuCap, float luong, float heSoLuong) {
		super(hoTen, phuCap, luong, heSoLuong);
		// TODO Auto-generated constructor stub
	}

	public GiangVien() {
		super();
	}

	public GiangVien(String khoa, String trinhDo, int soTiet) {
		super();
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTiet = soTiet;
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

	@Override
	public String toString() {
		return "Giangvien [khoa=" + khoa + ", trinhDo=" + trinhDo + ", soTiet=" + soTiet + "] \r\n";
	}

	public void nhap() {
		String trinhdo;
		int sotietdaytrongthang = 0;
		String input;

		super.nhapHoTen();

		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tên khoa");
		String khoa = scan.nextLine();

		System.out.println("Nhập trình độ");
		while (true) {
			try {
				trinhdo = scan.nextLine();
				MyException.chkTrinhDo(trinhdo);
				break;
			} catch (MyException e) {
				// TODO: handle exception
				System.err.println(e);
			}
		}

		this.setTrinhDo(trinhdo);

		if (trinhdo.equals("cử nhân")) {
			this.setPhuCap(300);
		} else if (trinhdo.equals("thạc sĩ")) {
			this.setPhuCap(500);
		} else if (trinhdo.equals("tiến sĩ")) {
			this.setPhuCap(1000);
		}

		System.out.println("Nhập số tiết dạy trong tháng");

		while (true) {
			try {
				input = scan.nextLine();
				MyException.chkInt(input);
				sotietdaytrongthang = Integer.parseInt(input);
				break;
			} catch (MyException e) {
				System.err.println(e);
			}
		}

		super.nhapHeSoLuong();

		this.setKhoa(khoa);

		this.setSoTiet(sotietdaytrongthang);

		this.tinhluong();
	}

	public void xuat() {
		System.out.println("Tên giảng viên: " + this.getHoTen());
		System.out.println("Khoa: " + this.getKhoa());
		System.out.println("Trình độ: " + this.getTrinhDo());
		System.out.println("Số tiết dạy trong tháng: " + this.getSoTiet());
		System.out.println("Phụ cấp: " + this.getPhuCap());
		System.out.println("Lương: " + this.getLuong());
	}

	public void tinhluong() {
		float luong = this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSoTiet() * 45;
		this.setLuong(luong);
	}
}