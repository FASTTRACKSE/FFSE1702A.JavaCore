package assigment020118;

import java.util.Scanner;

public class Bangcuuchuong {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hay nhap so: ");
		int number = scanner.nextInt();
		for (int b = 1; b < 10; b++) {
			for (int a = 1; a <= number; a++) {
				System.out.print(a + " * " + b + " = " + a*b + "\t");
			}
			System.out.println();
		}
	}
}
