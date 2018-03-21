package com.codepro.java.Assignment1;
import java.util.Scanner;

public class Assignment5 {
	private static Scanner input;

	public static void main(String[] args) {
		int x=0;
		int b1=50*1549,b2=50*1600,b3=100*1858,b4=100*2340,b5=100*2615;
		do {
			System.out.print("Nhap muc tieu thu dien thang 1/2018: ");
			input = new Scanner(System.in);
			x = input.nextInt();
			if(x>400) {
				int a=(x-400)*2701;
				System.out.println("STT\tDien tieu thu\tDon gia\t\tSo tien");
				System.out.println("1\t50\t\t1,549\t\t"+b1);
				System.out.println("2\t50\t\t1,600\t\t"+b2);
				System.out.println("3\t100\t\t1,858\t\t"+b3);
				System.out.println("4\t100\t\t2,340\t\t"+b4);
				System.out.println("5\t100\t\t2,615\t\t"+b5);
				System.out.println("6\t"+(x-400)+"\t\t2,701\t\t"+a);
				System.out.println("Tong DNTT: "+x+"\t\t\t\t"+(b1+b2+b3+b4+b5+a));
				System.out.println("Thue VAT (10%):\t\t\t\t"+((b1+b2+b3+b4+b5+a)/10));
				System.out.println("Tong tien: \t\t\t\t"+((b1+b2+b3+b4+b5+a)*1.1));
				System.out.println(" ");
			}else if(x>300) {
				int a=(x-300)*2615;
				System.out.println("STT\tDien tieu thu\tDon gia\t\tSo tien");
				System.out.println("1\t50\t\t1,549\t\t"+b1);
				System.out.println("2\t50\t\t1,600\t\t"+b2);
				System.out.println("3\t100\t\t1,858\t\t"+b3);
				System.out.println("4\t100\t\t2,340\t\t"+b4);
				System.out.println("5\t"+(x-300)+"\t\t2,615\t\t"+a);
				System.out.println("Tong DNTT: "+x+"\t\t\t\t"+(b1+b2+b3+b4+a));
				System.out.println("Thue VAT (10%):\t\t\t\t"+((b1+b2+b3+b4+a)/10));
				System.out.println("Tong tien: \t\t\t\t"+((b1+b2+b3+b4+a)*1.1));
				System.out.println(" ");
			}else if(x>200) {
				int a=(x-200)*2340;
				System.out.println("STT\tDien tieu thu\tDon gia\t\tSo tien");
				System.out.println("1\t50\t\t1,549\t\t"+b1);
				System.out.println("2\t50\t\t1,600\t\t"+b2);
				System.out.println("3\t100\t\t1,858\t\t"+b3);
				System.out.println("4\t"+(x-200)+"\t\t2,340\t\t"+a);
				System.out.println("Tong DNTT: "+x+"\t\t\t\t"+(b1+b2+b3+a));
				System.out.println("Thue VAT (10%):\t\t\t\t"+((b1+b2+b3+a)/10));
				System.out.println("Tong tien: \t\t\t\t"+((b1+b2+b3+a)*1.1));
				System.out.println(" ");
			}else if(x>100) {
				int a=(x-100)*1858;
				System.out.println("STT\tDien tieu thu\tDon gia\t\tSo tien");
				System.out.println("1\t50\t\t1,549\t\t"+b1);
				System.out.println("2\t50\t\t1,600\t\t"+b2);
				System.out.println("3\t"+(x-100)+"\t\t1,858\t\t"+a);
				System.out.println("Tong DNTT: "+x+"\t\t\t\t"+(b1+b2+a));
				System.out.println("Thue VAT (10%):\t\t\t\t"+((b1+b2+a)/10));
				System.out.println("Tong tien: \t\t\t\t"+((b1+b2+a)*1.1));
				System.out.println(" ");
			}else if(x>50) {
				int a=(x-50)*1600;
				System.out.println("STT\tDien tieu thu\tDon gia\t\tSo tien");
				System.out.println("1\t50\t\t1,549\t\t"+b1);
				System.out.println("2\t"+(x-50)+"\t\t1,600\t\t"+a);
				System.out.println("Tong DNTT: "+x+"\t\t\t\t"+(b1+a));
				System.out.println("Thue VAT (10%):\t\t\t\t"+((b1+a)/10));
				System.out.println("Tong tien: \t\t\t\t"+((b1+a)*1.1));
				System.out.println(" ");
			}else {
				int a=x*1549;
				System.out.println("STT\tDien tieu thu\tDon gia\t\tSo tien");
				System.out.println("1\t"+x+"\t\t1,549\t\t"+a);
				System.out.println("Tong DNTT: "+x+"\t\t\t\t"+a);
				System.out.println("Thue VAT (10%):\t\t\t\t"+(a/10));
				System.out.println("Tong tien: \t\t\t\t"+(a*1.1));
				System.out.println(" ");
			}
		}while(x!=0);
	}
}
