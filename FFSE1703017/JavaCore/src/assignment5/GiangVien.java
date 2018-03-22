package assignment5;

import java.util.Scanner;

public class GiangVien extends CanBo {
	
	private static final long serialVersionUID = 1L;
	private String khoa, trinhDo;
	private int soTiet;
	private Scanner input;
	
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
	public void nhap() {
		int chon;
		int[] pc = {500,1000,2000};
		String[] td = {"Cử nhân", "Thạc sĩ", "Tiến sĩ"};
		super.nhap();
		input = new Scanner(System.in);
		System.out.print("Nhập khoa: ");
		khoa = input.nextLine();
		do {
			System.out.print("Chọn trình độ (1 - Cử nhân, 2 - Thạc sĩ, 3 - Tiến sĩ): ");
			chon = Main.checkInt();
		} while (chon > 3 || chon == 0);
		trinhDo = td[(chon - 1)];
		this.setPhuCap(pc[(chon - 1)]);
		System.out.print("Nhập số tiết: ");
		soTiet = Main.checkInt();
		this.setLuong(getHeSoLuong() * 730 + getPhuCap() + soTiet * 45);
	}
	@Override
	public String toString() {
		return "|Họ tên: " + getHoTen() + " |Phòng ban: " + khoa + " |Chức vụ: " + trinhDo
				+ " |Số tiết: " + getSoTiet() + " |Phụ cấp: " + getPhuCap()
				+ " |Hệ số lương: "	+ getHeSoLuong() + " |Lương: " + getLuong() + " |";
	}
	
	
	
	
}
