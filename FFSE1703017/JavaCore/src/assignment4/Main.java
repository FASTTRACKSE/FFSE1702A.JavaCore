package assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner input;

	public static void main(String[] args) {
		ArrayList<BienLai> arrBienLai = new ArrayList<>();
		input = new Scanner(System.in);
		System.out.print("Nhập số lượng khách hàng: ");
		int n = input.nextInt();
		for(int i = 0; i < n; i++) {
			BienLai bienLai = new BienLai();
			System.out.println("Nhập thông tin khách hàng thứ " + (i + 1) + ": ");
			bienLai.nhapBienLai();
			arrBienLai.add(bienLai);
		}
		System.out.println("/***********************************************/");
		System.out.println("Thông tin các biên lai đã nhập: ");
		for(BienLai bl : arrBienLai) {
			System.out.println(bl);
		}
		System.out.println("/***********************************************/");
	}

}
