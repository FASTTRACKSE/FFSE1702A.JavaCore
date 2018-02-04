package text;

import java.text.DecimalFormat;
import java.util.Scanner;

public class tinh_diem_tb {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Số học sinh cần nhập: ");
		int n = scanner.nextInt();
	
		for (int i = 1; i < n+1; i++) {

		System.out.println("Nhập họ tên của học sinh: ");
		String name = scanner.nextLine();

		System.out.println("Nhập ngày sinh của học sinh: ");
		int date = scanner.nextInt();

		System.out.println("Nhập tháng sinh của học sinh: ");
		int month = scanner.nextInt();

		System.out.println("Nhập năm sinh của học sinh: ");
		int year = scanner.nextInt();

		System.out.println("Nhập điểm 1 của học sinh: ");
		Double point1 = scanner.nextDouble();

		System.out.println("Nhập điểm 2 của học sinh: ");
		Double point2 = scanner.nextDouble();

		System.out.println("STT: " + i);
		System.out.println("Họ tên: " + name);
		System.out.println("Ngày sinh: " + date + "/" + month + "/" + year);
		System.out.println("Điểm #1: " + point1);
		System.out.println("Điểm #2: " + point2);
		Double TB = (point1 + point2) / 2;
		System.out.println("Điểm TB: " + TB);

		if (TB <= 49) {
			System.out.println("Loại D");
		} else if (TB >= 50 && TB <= 69) {
			System.out.println("Loại C");
		} else if (TB >= 70 && TB <= 84) {
			System.out.println("Loại B");
		} else if (TB >= 85 && TB <= 100) {
			System.out.println("Loại A");
		}
	}
	}
}
