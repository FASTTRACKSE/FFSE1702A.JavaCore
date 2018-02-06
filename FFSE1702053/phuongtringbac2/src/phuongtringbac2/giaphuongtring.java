package phuongtringbac2;

import java.util.Scanner;
public class giaphuongtring {


public static void main(String[] args) {
	String kt = "yes";
	while( kt == "yes") {
		System.out.println("Giải PT bậc 2 1 ẩn");
		System.out.println("PTB2 có dạng  ax2 + bx + c=0");
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
		System.out.print("a phải khác 0\n");
		kt = "yes";
		
	}else {
	if( denta <0 ) {
		System.out.print("Vô nghiệm");
	}
	if( denta == 0) {
		System.out.print("x1 = x2 ="+ (-b)/(2*a));
	}
	if( denta > 0) {
		System.out.print("X1 = "+ (-b + Math.sqrt(denta))/(2*a) +"\n");
		System.out.print("X1 = "+ (-b - Math.sqrt(denta))/(2*a));
	}
	Scanner myInput2 = new Scanner(System.in);
	
	
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