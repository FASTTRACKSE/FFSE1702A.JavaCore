package Assignment5;

import java.util.Scanner;

public class GiangVien extends CanBo {
	// Với giảng viên cần quản lý các thông tin: Họ tên, khoa, trình độ (cử nhân,
	// thạc sĩ, tiến sĩ), phụ
	// cấp, số tiết dạy trong tháng ,hệ số lương
	private String khoa;
	private String trinhDo;
	private int tiecDay;

	public GiangVien() {

	}

	public GiangVien(String hoTen, int phuCap, float heSoLuong, float luong,String maCanBo) {
		super(hoTen, phuCap, heSoLuong, luong,maCanBo);

	}

	public GiangVien(String khoa, String trinhDo, int tiecDay) {
		super();
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.tiecDay = tiecDay;
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

	public int getTiecDay() {
		return tiecDay;
	}

	public void setTiecDay(int tiecDay) {
		this.tiecDay = tiecDay;
	}

	public void nhap() {
		super.nhap();
		Scanner scn = new Scanner(System.in);

		System.out.println("Nhap khoa:");
		khoa = scn.nextLine();
		setKhoa(khoa);
     for(;;) {
		System.out.println("Nhap trinh do:1: cu nhan; 2: thac si; 3: tien si");
		trinhDo = scn.nextLine();
		try {
			CanBoException.chkTrinhDo(trinhDo);
			setTrinhDo(trinhDo);
			break;
		}catch(CanBoException e ) {
			System.out.println(e);
		}
		
		if (trinhDo.equals("cu nhan")) {
			
			this.setPhuCap(300);
		} else if (trinhDo.equals("thac si")) {
			
			this.setPhuCap(500);
		} else if (trinhDo.equals("tien si")) {
			
			this.setPhuCap(1000);
		}
       }
     
     for(;;) {
		System.out.println("Nhap tiec day:");
		int tiecDay = Integer.parseInt(scn.nextLine());
		try {
			CanBoException.chkSoNguyen(tiecDay);
			setTiecDay(tiecDay);
			break;
		}catch(CanBoException e ) {
			System.out.println(e);
		}
		
     }

	}

	public double tinhLuong() {

		double luong = getHeSoLuong() * 750 + getPhuCap() + getTiecDay() * 45;
		return luong;
	}

	public void xuat() {
		super.xuat();
		System.out.println("Khoa:" + khoa);
		System.out.println("trinh do:" + trinhDo);
		System.out.println("tiec day:" + tiecDay);
		System.out.println("luong:" + this.tinhLuong());
	}
}
