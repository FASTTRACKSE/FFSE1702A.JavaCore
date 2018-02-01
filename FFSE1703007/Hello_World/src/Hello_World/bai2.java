package Hello_World;

import java.util.Scanner;

public class bai2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hãy nhập số: ");
		int number = scanner.nextInt();

		String[] spelling = { "không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín" };
		if (number >= 1000 && number <= 9999) {
			int number1 = number % 10;
			int number2 = (number / 10) % 10;
			int number3 = (number / 100) % 10;
			int number4 = number / 1000;
			
			if (number2 == 0) {
				System.out.println(spelling[number4] + " nghìn " + spelling[number3] + " trăm lẻ " + spelling[number1]);
			} else if(number2 == 1){
				System.out.println(spelling[number4] + " nghìn " + spelling[number3] + " trăm mười " + spelling[number1]);
			}
			else {
			System.out.println(spelling[number4] + " nghìn " + spelling[number3] + " trăm " + spelling[number2]
					+ " mươi " + spelling[number1]);
			}
		}
	}
}