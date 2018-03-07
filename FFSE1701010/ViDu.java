package com.codepro.java.Assignment1;
import java.util.Scanner;

public class ViDu {
	private static Scanner input;

	public static void main(String[] args) {
		int c,d;
		do {
			System.out.print("Nhap so a: ");
			input = new Scanner(System.in);
			int a = input.nextInt();
			System.out.print("Nhap so b: ");
			int b = input.nextInt();
			System.out.println(">>MAY TINH CA NHAN<<");
			System.out.println("+------------------+");
			System.out.println("| 1. Cong.         |");
			System.out.println("| 2. Tru.          |");
			System.out.println("| 3. Ket thuc.     |");
			System.out.println("+------------------+");
			System.out.print(">>Chon chuc nang: ");
			c = input.nextInt();
			switch(c) {
				case 1 :
					d=a+b;	
					System.out.println("Tong: "+d);
					break;
				case 2 :
					d=a-b;
					System.out.println("Hieu: "+d);
					break;
				case 3 :
					System.out.println("Ket thuc.");
					break;
			}
			System.out.println(" ");
		}while(c!=3);
	}
}
