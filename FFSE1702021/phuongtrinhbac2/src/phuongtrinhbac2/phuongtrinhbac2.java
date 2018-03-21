package phuongtrinhbac2;

import java.util.Scanner;

public class phuongtrinhbac2 {
	public static void main(String[] args) {
		String kt = "yes";
		while( kt == "yes") {
		System.out.print("Nhập 3 số a,b,c để giải phương trình bậc 2 có dang: ax^2 + bx + c = 0 ; a#0\n");
		System.out.print("nhập a\n");
		Scanner Soa=new Scanner(System.in);
		int a = Soa.nextInt();
		System.out.print("nhập b\n");
		Scanner Sob=new Scanner(System.in);
		int b = Sob.nextInt();
		System.out.print("nhập c\n");
		Scanner Soc=new Scanner(System.in);
		int c = Soc.nextInt();
		int denta = b*b - 4*a*c;
		if( a==0) { 
			System.out.print("Sai đề: a khác 0\n");
			kt = "yes";
			
		}else {
		if( denta <0 ) {
			System.out.print("Vô nghiệm");
		}
		if( denta == 0) {
			System.out.print("X1 = X2 ="+ (-b)/(2*a));
		}
		if( denta > 0) {
			System.out.print("X1 = "+ (-b + Math.sqrt(denta))/(2*a) +"\n");
			System.out.print("X1 = "+ (-b - Math.sqrt(denta))/(2*a));
		}
		Scanner myInput2 = new Scanner(System.in);
		System.out.println("\n Muốn dừng nhấn N không muốn dừng thì tùy thích mà nhấn nhé  ");
		kt = myInput2.nextLine();
		if (kt.equalsIgnoreCase("N") || kt.equalsIgnoreCase("No")) {
			break;
		} else {
			kt = "yes";
		}
		}
	  }
	}
}
