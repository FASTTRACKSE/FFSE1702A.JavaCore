package Hello_World;

import java.util.Scanner;

public class Bai2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hãy nhập số: ");
		int number = scanner.nextInt();

		String[] spelling = { "không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín" };
		String result = "không";
		int i = 1;

		while (number != 0) {
			int num_spell = number % 10;
			if (i == 1) {
				result = spelling[num_spell];
			}
			if (i == 2) {
				if (result == "một" && num_spell != 1) {
					result = "mốt";
				}
				if (result == "năm") {
					result = "lăm";
				}
				if (num_spell == 1) {
					if (result == "không") {
						result = "mười";
					} else {
						result = "mười " + result;
					}
				} else if (num_spell == 0) {
					result = "lẻ " + result;
				} else if (result == "không") {
					result = spelling[num_spell] + " mươi";
				} else {
					result = spelling[num_spell] + " mươi " + result;
				}
			}
			if (i == 3) {
				result = spelling[num_spell] + " trăm " + result;
			}
			if (i == 4) {
				result = spelling[num_spell] + " nghìn " + result;
			}
			number = number / 10;
			i++;
		}

		System.out.println(result);
	}
}