package first_project;

import java.util.*;

public class bangcuuchuong {

	public static void main(String[] args) {
		Scanner scanIn = new Scanner(System.in);
		int cot, hang;
		System.out.print("So cot: ");
		cot = scanIn.nextInt();
		System.out.print("So hang: ");
		hang = scanIn.nextInt();
		for (int i = 1; i <= hang; i++) {
			for (int j = 1; j <= cot; j++) {
				System.out.print(j + " x " + i + " = " + i * j + "\t");
			}
			System.out.println();
		}
	}

}
