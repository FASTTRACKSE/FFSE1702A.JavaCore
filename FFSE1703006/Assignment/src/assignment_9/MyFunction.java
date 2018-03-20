package assignment_9;

import java.util.Scanner;

public class MyFunction {
	private Scanner scanner;

	int loopCheckInt() {
		String str;
		scanner = new Scanner(System.in);
		do {
			try {
				str = scanner.nextLine();
				MyException.checkInt(str);
				break;
			} catch (MyException e) {
				System.err.print(e);
			}
		} while (true);
		return Integer.parseInt(str);
	}

	double loopCheckDouble() {
		String str;
		scanner = new Scanner(System.in);
		do {
			try {
				str = scanner.nextLine();
				MyException.checkDouble(str);
				break;
			} catch (MyException e) {
				System.err.print(e);
			}
		} while (true);
		return Double.parseDouble(str);
	}

}
