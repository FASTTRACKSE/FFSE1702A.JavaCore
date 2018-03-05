package assignment_8;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {
		BienLai bienLai;
		scanner = new Scanner(System.in);
		ArrayList<BienLai> arrBienLai = new ArrayList<>();

		System.out.print("Nhập số hộ sử dụng điện: ");
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			bienLai = new BienLai();
			System.out.println("Nhập thông tin hộ thứ " + (i + 1) + ": ");
			System.out.println("---------------------------------------------");
			bienLai.nhapBienLai();
			System.out.println("---------------------------------------------");
			arrBienLai.add(bienLai);
		}

		System.out.println("Thông tin biên lai đã nhập");
		for (int i = 0; i < arrBienLai.size(); i++) {
			System.out.println("+-------------------------------------------+");
			System.out.printf("| %25s %-15s |\n", "BIÊN LAI HỘ", (i + 1));
			System.out.println("+-------------------------------------------+");
			arrBienLai.get(i).xuatBienLai();
		}
	}

}