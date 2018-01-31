package first_project;

import java.util.Scanner;

public class Assignment_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Input number: ");
			// num = Integer.parseInt(scanner.nextLine());
			int num = input.nextInt();
			input.nextLine();
			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= num; j++) {
					System.out.print(j + " x " + i + " = " + i * j + "\t");
				}
				System.out.println();
			}
			System.out.print("\nDo you want to continue? (Y/N) ");
			String check = input.nextLine();

			if ("N".equals(check) || "n".equals(check)) {
				System.out.println("Exit!");
				break;
			}
			System.out.println("--------------------------------------------------------------");
		} while (true);
		input.close();
	}
}
