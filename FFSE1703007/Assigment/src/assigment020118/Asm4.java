package assigment020118;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Asm4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số lượng phần tử");
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập phần tử thứ " + i);
			arr[i] = scanner.nextInt();
		}
		System.out.println("1.Sắp xếp mảng từ cao đến thấp");
		System.out.println("2.Sắp xếp mảng từ thấp đến cao");
		System.out.println("3.Nhập lại mảng");
		System.out.println("4.Thoát khỏi chương trình");
		int answer = scanner.nextInt();
		if (answer == 2) {
			Arrays.sort(arr);
			System.out.println("Dãy số được sắp xếp tăng dần " + Arrays.toString(arr));
		}
		if (answer == 4) {
			System.exit(0);
		}
		
	}
}
