package hellworld;

import java.util.*;

public class Multiplication_table {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hay nhap so dong: ");
		int row = scanner.nextInt();
		System.out.println("Hay nhap so cot: ");
		int col = scanner.nextInt();
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <=col; j++) {
				System.out.printf( i + " * " + j + " = " + i*j  + "\t");	
			}
			System.out.println();
		}
	}

}
