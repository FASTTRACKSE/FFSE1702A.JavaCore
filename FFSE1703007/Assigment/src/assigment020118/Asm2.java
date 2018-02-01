package assigment020118;

import java.util.Scanner;

public class Asm2 {
	public static void main(String[] args) {
		System.out.println(">> MÁY TÍNH CÁ NHÂN <<");
		System.out.println("+--------------------+");
		System.out.println("|1.Cộng              |");
		System.out.println("|2.Trừ               |");
		System.out.println("|3.Kết thúc          |");
		System.out.println("+--------------------+");
		System.out.println(">> Chọn chức năng? <<");

		Scanner scanner = new Scanner(System.in);
		int answer = scanner.nextInt();

		if (answer == 1) {
			System.out.println(">> Nhập số thứ nhất <<");
			int number1 = scanner.nextInt();
			System.out.println(">> Nhập số thứ hai <<");
			int number2 = scanner.nextInt();
			int result = number1 + number2;
			System.out.println("Kết quả: " + result);
		} else if (answer == 2) {
			System.out.println(">> Nhập số thứ nhất <<");
			int number1 = scanner.nextInt();
			System.out.println(">> Nhập số thứ hai <<");
			int number2 = scanner.nextInt();
			int result = number1 - number2;
			System.out.println("Kết quả: " + result);
		} else if (answer == 3) {
			System.exit(0);
		}
	}
}
