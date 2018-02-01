package BangCuuChuong.com;
import java.util.Scanner;
public class BangCuuChuong {
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhap vao 1 so: ");
		int number = myInput.nextInt();
		for(int i = 1; i <= number; i++) {
			System.out.println("Bang cuu chuong " + i);
			for(int j = 1; j <= 10; j++) {
				System.out.println(i + " x " + j + " = " + (i*j));
			}
			System.out.println();
		}
		
	}
}
