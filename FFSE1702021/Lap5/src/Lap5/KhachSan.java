package Lap5;

import java.util.Scanner;

public class KhachSan {
	private int soNgay;
	private String loaiP;
	private double giaP;
	private Nguoi nguoi;
	
	public KhachSan() {
        super();
    }
	public KhachSan(int soNgay,String loaiP,double giaP,Nguoi nguoi) {
		this.soNgay=soNgay;
		this.loaiP=loaiP;
		this.giaP=giaP;
		this.nguoi=nguoi;
	}
	public void nhapKS() {
		nguoi = new Nguoi();
		nguoi.nhapNguoi();
		
		Scanner input=new Scanner(System.in);
		 
		 System.out.println("Nhap so ngay o:");
		 soNgay=input.nextInt();
		 
		 System.out.println("Nhap loai phong:");
		 loaiP=input.next();
		 
		 System.out.println("Nhap gia phong:");
		 giaP=input.nextDouble();
		 
		
	}
	public void xuatKS() {
		nguoi.xuatNguoi();
		
		System.out.println(" so ngay o:" + soNgay);
		System.out.println("loai phong:"+loaiP);
		System.out.println("gia:"+giaP);
	}
	 public double thanhTien()
	 {
	 return this.soNgay*this.giaP;
	 }
	 public Nguoi getKhach()
	 {
	 return this.nguoi;
	 }

	 public void xoa()
	 {
	 
	 soNgay=0;
	 loaiP=null;
	 giaP=0;
	 }
}
  
