package com.codepro.java.Assignment1;

import java.util.Scanner;

public class Assignment1 {

	private static Scanner input;

	public static void main(String[] args) {
		System.out.print("Nhap so: ");
		input = new Scanner(System.in);
		try {
			int a = input.nextInt();
			System.out.println("Ban da nhap dung!");
			
			int i,j,t;
			for(i=1;i<11;i++) {
				for(j=1;j<a+1;j++) {
					t=i*j;
					System.out.print(j+" * "+i+" = "+t+"\t");
				}
				System.out.println(" ");
			}
		}
		catch(Exception ex) {
			System.out.println("Vui long nhap so!");
		}
	}
}
