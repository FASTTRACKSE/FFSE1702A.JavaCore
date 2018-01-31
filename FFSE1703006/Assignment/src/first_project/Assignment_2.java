package first_project;

import java.util.Scanner;

public class Assignment_2 {

	public static void main(String[] args) {
		int num, num_read, i;
		String result;
		String read[] = { "khong", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin" };
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Input number: ");
			num = input.nextInt();
			input.nextLine();
			result = "";
			i = 1;
			if (num == 0) {
				result = "khong";
			}
			while (num != 0) {
				num_read = num % 10;
				if (i == 1) {
					result = read[num_read];
				}
				if (i == 2) {
					if (result == "khong" && num_read == 1) {
						result = "muoi";
					} else if (result == "khong" && num_read == 0) {
						result = "";
					} else if (result == "khong") {
						result = read[num_read] + " muoi";
					} else if (num_read == 1) {
						result = "muoi " + result;
					} else if (num_read == 0) {
						result = "linh " + result;
					} else {
						result = read[num_read] + " muoi " + result;
					}
				}
				if (i == 3) {
					if (result == "" && num_read == 0) {
					} else {
						result = read[num_read] + " tram " + result;
					}
				}
				if (i == 4) {
					result = read[num_read] + " ngan " + result;
				}
				num = num / 10;
				i++;
			}
			System.out.println("\n" + result);
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
