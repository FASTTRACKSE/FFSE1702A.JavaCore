package readnumber;

import java.util.Scanner;

public class readnuber {
	public static void main(String args[]) {

		String text = "yes";
		while (text == "yes") {
			int a, b, c, d, n;

			Scanner myInput = new Scanner(System.in);
			System.out.print("nhập số từ 1 đến 9999 : ");
			n = myInput.nextInt();
			a = Math.round(n / 1000);
			if (n < 1 || n > 9999) {
				System.out.println("vui lòng nhập số từ 1 đến 999 ");
				text = "yes";
			} else {

				switch (a) {

				case 1:
					System.out.print("một nghìn ");
					;
					break;
				case 2:
					System.out.print("hai nghìn ");
					break;
				case 3:
					System.out.print("ba nghìn ");
					break;
				case 4:
					System.out.print("bốn nghìn ");
					break;
				case 5:
					System.out.print("năm nghìn ");
					break;
				case 6:
					System.out.print("sáu nghìn ");
					break;
				case 7:
					System.out.print("bảy nghìn ");
					break;
				case 8:
					System.out.print("tám nghìn ");
					break;
				case 9:
					System.out.print("chín nghìn ");
					break;
				}

				b = (n - a * 1000) / 100;
				switch (b) {
				case 0:
					if (a != 0) {
						System.out.print("không trăm ");

					}
					break;
				case 1:
					System.out.print("một trăm ");
					break;
				case 2:
					System.out.print("hai trăm ");
					break;
				case 3:
					System.out.print("ba trăm ");
					break;
				case 4:
					System.out.print("bốn trăm ");
					break;
				case 5:
					System.out.print("năm trăm ");
					break;
				case 6:
					System.out.print("sáu trăm ");
					break;
				case 7:
					System.out.print("bảy trăm ");
					break;
				case 8:
					System.out.print("tám trăm ");
					break;
				case 9:
					System.out.print("chín trăm ");
					break;
				}
				c = (n - a * 1000 - b * 100) / 10;
				switch (c) {
				case 0:
					if (a != 0 || b != 0) {
						System.out.print("lẽ ");
					}
					break;
				case 1:
					System.out.print("mười ");
					;
					break;
				case 2:
					System.out.print("hai mươi ");
					break;
				case 3:
					System.out.print("ba mươi ");
					break;
				case 4:
					System.out.print("bốn mươi ");
					break;
				case 5:
					System.out.print("năm mươi ");
					break;
				case 6:
					System.out.print("sáu mươi ");
					break;
				case 7:
					System.out.print("bảy mươi ");
					break;
				case 8:
					System.out.print("tám mươi ");
					break;
				case 9:
					System.out.print("chín mươi ");
					break;
				}
				d = (n - a * 1000 - b * 100 - c*10);
				switch (d) {

				case 1:
					if (a == 1||a==0) {
						System.out.println("một ");
						break;
					} else {
						System.out.println("mốt ");
						break;
					}
				case 2:
					System.out.println("hai ");
					break;
				case 3:
					System.out.println("ba ");
					break;
				case 4:
					System.out.println("bốn");
					break;
				case 5:
					if (c == 0) {
						System.out.println("năm ");
						
					} else {
						System.out.println("lăm ");
						
					}
					break;
				case 6:
					System.out.println("sáu");
					break;
				case 7:
					System.out.println("bảy");
					break;
				case 8:
					System.out.println("tám");
					break;
				case 9:
					System.out.println("chín");
					break;
				}
				Scanner myInput2 = new Scanner(System.in);
				System.out.println("Bạn có muốn tiếp tục không  ");
				text = myInput2.nextLine();
				if (text.equalsIgnoreCase("N") || text.equalsIgnoreCase("No")) {
					text = "No";
				} else {
					text = "yes";
				}
			}
		}
	}
}
