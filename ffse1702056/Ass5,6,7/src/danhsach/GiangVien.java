package danhsach;
import java.util.Scanner;
public class GiangVien extends CanBo {
	private String khoa;
	private String trinhDo;
	private int tietDay;
	public GiangVien() {
		
	}
	public GiangVien(String khoa, String trinhDo, int tietDay) {
		super();
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.tietDay = tietDay;
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
	public int getTietDay() {
		return tietDay;
	}
	public void setTietDay(int tietDay) {
		this.tietDay = tietDay;
	}
	
	public void nhap() {
		super.nhap();
		Scanner scn=new Scanner(System.in);
		
		System.out.println("Nhap khoa:");
		String khoa = scn.nextLine();
		setKhoa(khoa);
		
		System.out.println("Nhap trinh do:1: cu nhan; 2: thac si; 3: tien si");
		int i =Integer.parseInt(scn.nextLine());
		if(i==1) {
			trinhDo="cu nhan";
			this.setPhuCap(300);
		}else if(i==2) {
			trinhDo="thac si";
			this.setPhuCap(500);
		}else if(i==3) {
			trinhDo="tien si";
			this.setPhuCap(1000);
		}
		
		System.out.println("Nhap tiet day:");
		int tietDay= Integer.parseInt(scn.nextLine());
		setTietDay(tietDay);
		
	}
	public double tinhLuong() {
		
		double luong = getHeSoLuong()*750+getPhuCap()+ getTietDay()*45;
		return luong;
	}
	public void xuat() {
		super.xuat();
		System.out.println("Khoa:"+ khoa);
		System.out.println("trinh do:"+ trinhDo);
		System.out.println("tiet day:"+ tietDay);
		System.out.println("luong:"+ this.tinhLuong());
	}
}
