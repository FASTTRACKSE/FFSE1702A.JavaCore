package ks;
import java.util.Scanner;
import java.util.Date;
public class KhachSan {
	private int soNgayTro;
	private String loaiP;
	private double giaP;
	Nguoi nguoi;
	public KhachSan() {
		
	}
	public KhachSan(int soNgayTro, String loaiP, double giaP, Nguoi nguoi )
	{
		this.soNgayTro	=	soNgayTro;
		this.loaiP		=	loaiP;
		this.giaP		=	giaP;
		this.nguoi		= 	nguoi;
	}
	public void nhapThongTin(Scanner sc) {
		nguoi	=	new Nguoi();
		this.nguoi.nhapThongTin(sc);
		System.out.println("Nhập số ngày trọ:");
		this.soNgayTro	=	sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập loại phòng");
		this.loaiP		=	sc.nextLine();
		System.out.println("Nhập giá phòng");
		this.giaP		= 	sc.nextDouble();sc.nextLine();
	}
	public void hienThongTin() {
		nguoi.hienThongTin();
		System.out.println("Số ngày trọ: "+ this.soNgayTro);
		System.out.println("Loại phòng: "+ this.loaiP);
		System.out.println("Giá phòng: "+ this.giaP);
	}
	public double thanhTien() {
		return this.soNgayTro*this.giaP;
	}
	public Nguoi getKhach() {
		return this.nguoi;
	}
	public void xoa() {
		this.nguoi	=new Nguoi(); // xóa thông tin về người
		this.soNgayTro	= 0;
		this.loaiP		= null;
		this.giaP		=0;
	}
}
