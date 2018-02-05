package com.codepro.java.Assignment1;

import java.util.Scanner;

public class Assignment2 {
	private static Scanner input;
	
	public static void main(String[] args) {
		int i = 0;
		do {
		System.out.print("Nhap so tu 1 - 9999: ");
		input = new Scanner(System.in);
		try {
			i = input.nextInt();
			String[] so = { "khong","mot","hai","ba","bon","nam","sau","bay","tam","chin"};
			String[] don = { "khong.","mot.","hai.","ba.","bon.","lam.","sau.","bay.","tam.","chin."};
			int a,b,c,d;
			if(i>9999) {
				System.out.println("Vui long nhap dung so!");
			}else {
				if(i>999) {
					a=i/1000;
					b=(i-a*1000)/100;
					c=(i-a*1000-b*100)/10;
					d=i-a*1000-b*100-c*10;
					System.out.println(so[a]+" ngan "+so[b]+" tram "+so[c]+" muoi "+don[d]);
				}else if(i>99) {
					b=i/100;
					c=(i-b*100)/10;
					d=i-b*100-c*10;
					System.out.println(so[b]+" tram "+so[c]+" muoi "+don[d]);
				}else if(i>9) {
					c=i/10;
					d=i-c*10;
					System.out.println(so[c]+" muoi "+don[d]);
				}else {
					d=i;
					System.out.println(so[d]+".");
				}
			}
		}
		catch(Exception ex) {
			System.out.println("Vui long nhap so!");
		}
		}while(i>0);
	}
}
