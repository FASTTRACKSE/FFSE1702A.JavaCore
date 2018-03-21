package chap1.basic;
import java.util.Scanner;
public class p5_loop {
	public static void main(String[] args) {
		Scanner input	=	new Scanner(System.in);
		System.out.println(" Bạn chưa thuộc bản cửu chương nào");
		int n 		= input.nextInt();
		do {
		for(int i = 1; i<=10; i++) {
			for(int j=1; j <= n; j++) {
			System.out.print(j + " x " + i + " = " + (i*j));
			System.out.print("	");
		}
			System.out.println();
		}
		System.out.println("Bạn có muốn tiếp tục?");
		String check
	}
	}
}
