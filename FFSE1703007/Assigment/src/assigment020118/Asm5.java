package assigment020118;

import java.util.Scanner;

public class Asm5 {
	public static void main(String[] args) {
		int rate[] = { 0, 1549, 1600, 1858, 2340, 2615, 2701 };
		int step[] = { 0, 50, 50, 100, 100, 100 };
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số điện sử dụng");
		int input = scanner.nextInt();
		int i = 1;
		int k = input;
		int subtotal, total = 0;
		System.out.println("STT \t Điện tiêu thụ \t Đơn giá \t Số tiền");
		while (k > 0) {
			if (i < 6) {
				k = k - step[i];
				if (k > 0) {
					subtotal = step[i] * rate[i];
					total += subtotal;
					System.out.println(i + "\t" + step[i] + "\t \t" + rate[i] + "\t \t" + subtotal);
				} else {
					subtotal = (k + step[i]) * rate[i];
					total += subtotal;
					System.out.println(i + "\t" + (k + step[i]) + "\t \t" + rate[i] + "\t \t" + subtotal);
				}
				i++;
			} else {
				subtotal = k * rate[i];
				total += subtotal;
				System.out.println(i + "\t" + k + "\t \t" + rate[i] + "\t \t" + subtotal);
				break;
			}

		}
		System.out.println("Tổng ĐNTT: " + input + "\t\t\t\t" + total);
		System.out.println("Thuế VAT (10%): " + "\t\t\t" + (total * 0.1));
		System.out.println("Tổng tiền: " + "\t\t\t\t" + (total * 1.1));
	}
}
