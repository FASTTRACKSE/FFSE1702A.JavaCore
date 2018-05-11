package com.codepro.java.Assignment1;
import java.util.Scanner;

public class QuanLySV {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		int x,d1,d2,a;
		double d3,d4,dtb;
		String ten,tuoi,tin,anh,diem,loai;
		System.out.print("Nhap vao so luong sinh vien: ");
		x = input.nextInt();
		input.nextLine();
		String[][] SV = new String[x][6];
		for(int i=0; i<x; i++) {
			System.out.print("Nhap Ten sinh vien thu "+(i+1)+": ");
			SV[i][0]=input.nextLine();
			System.out.print("Nhap Tuoi sinh vien: ");
			SV[i][1]=input.nextLine();
			System.out.print("Nhap diem Tin: ");
			SV[i][2]=input.nextLine();
			System.out.print("Nhap diem Anh: ");
			SV[i][3]=input.nextLine();
			d1= Integer.parseInt(SV[i][2]);
			d2= Integer.parseInt(SV[i][3]);
			dtb=(d1+d2)/2;
			SV[i][4]=Double.toString(dtb);
			if(dtb<50) {
				SV[i][5]="D";
			}else if(dtb<70) {
				SV[i][5]="C";
			}else if(dtb<85) {
				SV[i][5]="B";
			}else {
				SV[i][5]="A";
			}
		}
		System.out.println(" ");
		do {
	    	System.out.println("+-------------------------------+");
	    	System.out.println("1. In ra danh sach SV.");
	    	System.out.println("2. Sap xep theo DTB(cao-thap).");
	    	System.out.println("3. Sap xep theo ten(A-Z).");
	    	System.out.println("4. Thoat khoi chuong trinh.");
	    	System.out.println("+-------------------------------+");
	    	System.out.print(">>Nhap yeu cau: ");
	    	a= input.nextInt();
	    	switch(a) {
			case 1 :
				System.out.println("STT\tTen\tTuoi\tTin\tAnh\tDTB\tLoai");
				for(int i=0; i<x; i++) {
					System.out.println((i+1)+"\t"+SV[i][0]+"\t"+SV[i][1]+"\t"+SV[i][2]+"\t"+SV[i][3]+"\t"+SV[i][4]+"\t"+SV[i][5]);
				}
				System.out.println(" ");
				break;
			case 2 :
				System.out.println("STT\tTen\tTuoi\tTin\tAnh\tDTB\tLoai");
				for(int i=0; i<x-1; i++) {
					for(int j=i+1; j<x; j++) {
						d3 = Double.parseDouble(SV[i][4]);
						d4 = Double.parseDouble(SV[j][4]);
						if(d3<d4) {
							ten=SV[i][0];
							tuoi=SV[i][1];
							tin=SV[i][2];
							anh=SV[i][3];
							diem=SV[i][4];
							loai=SV[i][5];
							SV[i][0]=SV[j][0];
							SV[i][1]=SV[j][1];
							SV[i][2]=SV[j][2];
							SV[i][3]=SV[j][3];
							SV[i][4]=SV[j][4];
							SV[i][5]=SV[j][5];
							SV[j][0]=ten;
							SV[j][1]=tuoi;
							SV[j][2]=tin;
							SV[j][3]=anh;
							SV[j][4]=diem;
							SV[j][5]=loai;
						}
					}
				}
				for(int i=0; i<x; i++) {
					System.out.println((i+1)+"\t"+SV[i][0]+"\t"+SV[i][1]+"\t"+SV[i][2]+"\t"+SV[i][3]+"\t"+SV[i][4]+"\t"+SV[i][5]);
				}
				System.out.println(" ");
				break;
			case 3 :
				System.out.println("STT\tTen\tTuoi\tTin\tAnh\tDTB\tLoai");
				for(int i=0; i<x-1; i++) {
					for(int j=i+1; j<x; j++) {
						int result = SV[i][0].compareTo(SV[j][0]);
						if (result > 0) {
							ten=SV[i][0];
							tuoi=SV[i][1];
							tin=SV[i][2];
							anh=SV[i][3];
							diem=SV[i][4];
							loai=SV[i][5];
							SV[i][0]=SV[j][0];
							SV[i][1]=SV[j][1];
							SV[i][2]=SV[j][2];
							SV[i][3]=SV[j][3];
							SV[i][4]=SV[j][4];
							SV[i][5]=SV[j][5];
							SV[j][0]=ten;
							SV[j][1]=tuoi;
							SV[j][2]=tin;
							SV[j][3]=anh;
							SV[j][4]=diem;
							SV[j][5]=loai;
						}
					}
				}
				for(int i=0; i<x; i++) {
					System.out.println((i+1)+"\t"+SV[i][0]+"\t"+SV[i][1]+"\t"+SV[i][2]+"\t"+SV[i][3]+"\t"+SV[i][4]+"\t"+SV[i][5]);
				}
				System.out.println(" ");
				break;
			case 4 :
				System.out.println("Da thoat khoi chuong trinh!");
				break;
	    	}
		}while(a!=4);
	}
}
