package assignment;

import java.util.Scanner;

public class KhachHang {
	private String ten;
	private String soNha;
	private String soCongTo;
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getSoNha() {
		return soNha;
	}
	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}
	public String getSoCongTo() {
		return soCongTo;
	}
	public void setSoCongTo(String soCongTo) {
		this.soCongTo = soCongTo;
	}
	public KhachHang() {}
	public KhachHang(String ten, String soNha, String soCongTo) {
		super();
		this.ten = ten;
		this.soNha = soNha;
		this.soCongTo = soCongTo;
	}
	public void nhap() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Nhap ten khach hang");
		ten= scanner.nextLine();
		System.out.println("Nhap dia chi");
		soNha=scanner.nextLine();
		System.out.println("Nhap so cong to");
		soCongTo=scanner.nextLine();
		
		
		
	}
	public void xuat() {
		System.out.println("Ho ten chu nha : "+ten);
		System.out.println("Dia chi : "+ soNha);
		System.out.println("So cong to: "+soCongTo);
	}
}
