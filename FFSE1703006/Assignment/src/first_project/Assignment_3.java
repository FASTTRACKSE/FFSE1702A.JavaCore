package first_project;

import java.util.Scanner;

public class Assignment_3 {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		do {
			try {
				System.out.print("Nhập hệ số a:\ta = ");
				float a = input.nextFloat();
				System.out.print("Nhập hệ số b:\tb = ");
				float b = input.nextFloat();
				System.out.print("Nhập hệ số c:\tc = ");
				float c = input.nextFloat();
				giaiPT(a, b, c);
				System.out.print("\nTiếp tục chứ? (Y/N) ");
				input.nextLine();
				String check = input.nextLine();
				if ("N".equals(check) || "n".equals(check)) {
					System.out.println("Exit!");
					break;
				}
				System.out.println("--------------------------------------------------------------");
			} catch (Exception ex) {
				System.out.print("Vui lòng nhập số hợp lệ!");
				break;
			}
		} while (true);

	}

	public static void giaiPT(float a, float b, float c) {
		if (a == 0) {
			if (b == 0) {
				System.out.println("\nPhương trình vô nghiệm!");
			} else {
				System.out.println("\nPhương trình có một nghiệm: " + "x = " + (-c / b));
			}
			return;
		}
		float delta = b * b - 4 * a * c;
		float x1;
		float x2;
		if (delta > 0) {
			x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
			x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
			System.out.println("\nPhương trình có 2 nghiệm là: " + "x1 = " + x1 + " và x2 = " + x2);
		} else if (delta == 0) {
			x1 = (-b / (2 * a));
			System.out.println("\nPhương trình có nghiệm kép: " + "x1 = x2 = " + x1);
		} else {
			System.out.println("\nPhương trình vô nghiệm!");
		}
	}

}
