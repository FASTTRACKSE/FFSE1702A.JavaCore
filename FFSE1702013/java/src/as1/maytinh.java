package as1;

import java.util.Scanner;

public class maytinh {

	private static Scanner input;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		do {
			try {
				System.out.println(">> MÃ�Y TÃ�NH CÃ� NHÃ‚N <<");
				System.out.println("+--------------------+");
				System.out.println("| 1. Cộng            |");
				System.out.println("| 2. Trừ             |");
				System.out.println("| 3. Kết thúc        |");
				System.out.println("+--------------------+");
				System.out.println(">>  Chá»�n chá»©c nÄƒng? <<");
				int answer = input.nextInt();
				input.nextLine();
				if (answer == 1) {
					thucHienPhepCong();
				} else if (answer == 2) {
					thucHienPhepTru();
				} else if (answer == 3) {
					System.out.println("Káº¿t thÃºc!");
					System.exit(0);
				} else {
					System.out.println("Chá»©c nÄƒng khÃ´ng tá»“n táº¡i. Vui lÃ²ng nháº­p Ä‘Ãºng sá»‘!");
				}
				System.out.print("\nBáº¡n cÃ³ muá»‘n tiáº¿p tá»¥c? (Y/N) ");
				String check = input.nextLine();

				if ("N".equals(check) || "n".equals(check)) {
					System.out.println("Káº¿t thÃºc!");
					break;
				}
				System.out.println("--------------------------------------------------------------");
			} catch (Exception ex) {
				System.out.print("Vui lÃ²ng nháº­p sá»‘!");
				break;
			}
		} while (true);
		input.close();
	}

	public static void thucHienPhepCong() {
		input = new Scanner(System.in);
		System.out.print("Vui lÃ²ng nháº­p sá»‘ thá»© nháº¥t: ");
		int num1 = input.nextInt();
		System.out.print("Vui lÃ²ng nháº­p sá»‘ thá»© hai: ");
		int num2 = input.nextInt();
		System.out.print("Tá»•ng lÃ : " + (num1 + num2));
	}

	public static void thucHienPhepTru() {
		input = new Scanner(System.in);
		System.out.print("Vui lÃ²ng nháº­p sá»‘ thá»© nháº¥t: ");
		int num1 = input.nextInt();
		System.out.print("Vui lÃ²ng nháº­p sá»‘ thá»© hai: ");
		int num2 = input.nextInt();
		System.out.print("Hiá»‡u lÃ : " + (num1 - num2));
	}
}