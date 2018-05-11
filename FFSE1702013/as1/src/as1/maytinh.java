package as1;

import java.util.Scanner;

public class maytinh {

	private static Scanner input;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		do {
			try {
				System.out.println(">> MÁY TÍNH CÁ NHÂN <<");
				System.out.println("+--------------------+");
				System.out.println("| 1. Cộng            |");
				System.out.println("| 2. Trừ             |");
				System.out.println("| 3. Kết thúc        |");
				System.out.println("+--------------------+");
				System.out.println(">>  Chọn chức năng? <<");
				int answer = input.nextInt();
				input.nextLine();
				if (answer == 1) {
					thucHienPhepCong();
				} else if (answer == 2) {
					thucHienPhepTru();
				} else if (answer == 3) {
					System.out.println("Kết thúc!");
					System.exit(0);
				} else {
					System.out.println("Chức năng không tồn tại. Vui lòng nhập đúng số!");
				}
				System.out.print("\nBạn có muốn tiếp tục? (Y/N) ");
				String check = input.nextLine();

				if ("N".equals(check) || "n".equals(check)) {
					System.out.println("Kết thúc!");
					break;
				}
				System.out.println("--------------------------------------------------------------");
			} catch (Exception ex) {
				System.out.print("Vui lòng nhập số!");
				break;
			}
		} while (true);
		input.close();
	}

	public static void thucHienPhepCong() {
		input = new Scanner(System.in);
		System.out.print("Vui lòng nhập số thứ nhất: ");
		int num1 = input.nextInt();
		System.out.print("Vui lòng nhập số thứ hai: ");
		int num2 = input.nextInt();
		System.out.print("Tổng là: " + (num1 + num2));
	}

	public static void thucHienPhepTru() {
		input = new Scanner(System.in);
		System.out.print("Vui lòng nhập số thứ nhất: ");
		int num1 = input.nextInt();
		System.out.print("Vui lòng nhập số thứ hai: ");
		int num2 = input.nextInt();
		System.out.print("Hiệu là: " + (num1 - num2));
	}
}