package first_project;

import java.util.Scanner;

public class Assignment_5 {
	static Scanner input = new Scanner(System.in);
	static int n, tong;

	public static void main(String[] args) {
		int don_gia[] = { 0, 1549, 1600, 1858, 2340, 2615, 2701 };
		int bac[] = { 50, 50, 50, 100, 100, 100 };
		do {
			try {
				int tien, i = 1;
				tong = 0;
				System.out.print("Nhập số điện năng tiêu thụ (kWh): ");
				n = input.nextInt();
				int k = n;
				System.out.println("+-----+---------------+---------+---------------+");
				System.out.println("| STT | Điện tiêu thụ | Đơn giá |    Số tiền    |");
				System.out.println("|-----|---------------|---------|---------------|");
				while (k > 0) {
					if (i < 6) {
						k = k - bac[i];
						if (k > 0) {
							tien = bac[i] * don_gia[i];
							tong += tien;
							System.out.println("|  " + i + "  |     " + bac[i] + "\t      |   " + don_gia[i]
									+ "\t|     " + tien + "\t|");
						} else {
							tien = (k + bac[i]) * don_gia[i];
							tong += tien;
							System.out.println("|  " + i + "  |     " + (k + bac[i]) + "\t      |   " + don_gia[i]
									+ "\t|     " + tien + "\t|");
							print();
						}
						i++;
					} else {
						tien = k * don_gia[i];
						tong += tien;
						System.out.println(
								"|  " + i + "  |     " + k + "\t      |   " + don_gia[i] + "\t|     " + tien + "\t|");
						print();
						break;
					}

				}
				System.out.print("\nTiếp tục chứ? (Y/N) ");
				input.nextLine();
				String check = input.nextLine();
				if ("N".equals(check) || "n".equals(check)) {
					System.out.println("Exit!");
					break;
				}
				System.out.println("--------------------------------------------------------------");
			} catch (Exception ex) {
				System.out.print("Vui lòng nhập số hợp lệ!");
				break;
			}
		} while (true);
	}

	public static void print() {
		System.out.println("|-------------------------------|---------------|");
		System.out.println("| Tổng ĐNTT:  " + n + "\t\t|     " + tong + "\t|");
		System.out.println("|-------------------------------|---------------|");
		System.out.println("| Thuế VAT (10%)  " + "\t\t|     " + Math.round(tong * 0.1) + "\t|");
		System.out.println("|-------------------------------|---------------|");
		System.out.println("| Tổng tiền" + "\t\t\t|     " + Math.round(tong * 1.1) + "\t|");
		System.out.println("+-------------------------------+---------------+");
	}
}
