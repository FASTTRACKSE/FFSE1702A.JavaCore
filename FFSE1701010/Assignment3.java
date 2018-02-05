package com.codepro.java.Assignment1;
import java.util.Scanner;

public class Assignment3 {
	private static Scanner input;

	public static void main(String[] args) {
		float x=0;
		do {
			System.out.println("Giai phuong trinh bac hai: a*x + b = c.");
			input = new Scanner(System.in);
			System.out.print("Nhap so a: ");
			float a = input.nextInt();
			System.out.print("Nhap so b: ");
			float b = input.nextInt();
			System.out.print("Nhap so c: ");
			float c = input.nextInt();
			x=(c-b)/a;
			System.out.println("x= "+x);
			System.out.println(" ");
		}while(x==0);
	}
}
