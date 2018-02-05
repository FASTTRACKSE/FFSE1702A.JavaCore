package assigment020118;

import java.util.Scanner;

public class Asm3 {
	public static void main(String[] args) {
		System.out.println("Giải phương trình bậc 2 ax^2 + bx + c = 0");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số a");
		float a = scanner.nextInt();
		System.out.println("Nhập số b");
		float b = scanner.nextInt();
		System.out.println("Nhập số c");
		float c = scanner.nextInt();
		float x;

		if (a == 0) {
			if (b == 0 && c != 0) {
				System.out.println("Phương trình vô nghiệm");
			} else if (b == 0 && c == 0) {
				System.out.println("Phương trình vô số nghiệm");
			} else {
				x = -c / b;
				System.out.println("x = " + x);
			}
		} else {
			float delta = (b * b) - (4 * a * c);
			if (delta > 0) {
				float x1 = (float) (-b + Math.sqrt(delta)) / (2 * a);
				float x2 = (float) (-b - Math.sqrt(delta)) / (2 * a);
				System.out.println("Phương trình có 2 nghiệm x1 =" + x1 + " và " + " x2 = " + x2);
			} else if (delta == 0) {
				x = -b / (2 * a);
				System.out.println("Phương trình có nghiệm kép x1 = x2 =" + x);
			} else {
				System.out.println("Phương trình vô nghiệm");
			}
		}
	}
}
