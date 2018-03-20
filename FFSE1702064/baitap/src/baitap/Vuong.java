package baitap;

import java.util.Scanner;

public class Vuong extends Chunhat {
 public Vuong(int canh) {
	 super (canh,canh);
 }
 void xuat() {
	 System.out.println("Canh:"+super.getDai());
		System.out.println("Chu vi:"+ this.getChuVi());
		System.out.println("Dien tich:"+ this.getDienTich());
 }
 public static void main(String arg[]) {
	 System.out.print("Nhap chieu dai: ");
	 Scanner scan = new Scanner(System.in);
	 int dai=scan.nextInt();
	 
	 System.out.println("Nhap chieu rong:");
	 int rong=scan.nextInt();
	 
	 Chunhat cn = new Chunhat();
	 cn.setDai(dai);
	 cn.setRong(rong);
	 
	 Chunhat cn2 = new Chunhat(5,7);
	 
	 cn.xuat();
	 System.out.println("-----Hinh Vuong-----");
		System.out.println("Nhap canh hinh vuong:");
		int canh = scan.nextInt();
		
		Vuong vuong = new Vuong(canh);
		vuong.xuat();
		
		
	}

}
 

