//package Tinhtiendien;
import java.util.Scanner;
public class Tinhtiendien {
	public static void main(String[] args) {
		System.out.print("Nhập số chữ điện");
		Scanner myInput= new Scanner(System.in);
		int chudien =myInput.nextInt();
		int a = 50*1549;
		int b = 50*1600;
		int c = 100*1858;
		int d = 100*2340;
		int e = 100*2615;
		
		if(chudien <= 50) {
			System.out.print("Tiền điện"+ (chudien*1549));
		}
		else if(chudien <= 100 ) {
			System.out.print("Tiền điện"+ (a + (chudien-50*1600)));
		}
		else if(chudien <= 200 ) {
			System.out.print("Tiền điện"+ (a + b + (chudien-100*1858)));
		}
		else if(chudien <= 300 ) {
			System.out.print("Tiền điện"+ (a + b + c + (chudien-200*2340)));
		}
		else if(chudien <= 400 ) {
			System.out.print("Tiền điện"+ (a + b + c + d + (chudien-200*2615)));
		}
		else if(chudien > 400) {
			System.out.print("Tiền điện"+ (a + b + c + d + e + (chudien*2701)));
		}
	}

}



